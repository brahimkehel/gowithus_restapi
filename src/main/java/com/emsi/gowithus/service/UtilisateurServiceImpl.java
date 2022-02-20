package com.emsi.gowithus.service;

import com.emsi.gowithus.dao.ConducteurRepository;
import com.emsi.gowithus.dao.PassagerRepository;
import com.emsi.gowithus.dao.RoleRepository;
import com.emsi.gowithus.dao.UtilisateurRepository;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Conducteur;
import com.emsi.gowithus.model.Passager;
import com.emsi.gowithus.model.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class UtilisateurServiceImpl implements IUtilisateurService {
    @Autowired
    private ServletContext context;
    @Autowired
    private UtilisateurRepository utilisateurRepo;
    @Autowired
    private PassagerRepository passagerRepository;
    @Autowired
    private ConducteurRepository conducteurRepository;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JavaMailSender javaMailSender;
    private static final String DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/images";

    @Override
    public AppUser saveUser(AppUser u, MultipartFile photoProfil, MultipartFile photoCin, MultipartFile photoCarteGrise) throws IOException {

        if (photoProfil != null && photoCin != null) {
            boolean isExist = new File(DIRECTORY + u.getUsername()).exists();
            if (!isExist) new File("images/" + u.getUsername()).mkdir();
            String newFilenamePicPro = "photoProfile_" + u.getUsername() + "." + FilenameUtils.getExtension(photoProfil.getOriginalFilename());
            String newFilenamePicCin = "photoCin_" + u.getUsername() + "." + FilenameUtils.getExtension(photoCin.getOriginalFilename());
            File serverFileProfil = new File(DIRECTORY + u.getUsername() + "/" + File.separator + newFilenamePicPro);
            File serverFileCin = new File(DIRECTORY + u.getUsername() + "/" + File.separator + newFilenamePicCin);
            FileUtils.writeByteArrayToFile(serverFileProfil, photoProfil.getBytes());
            FileUtils.writeByteArrayToFile(serverFileCin, photoCin.getBytes());
            u.setPhotoCin(newFilenamePicCin);
            u.setPhotoProfile(newFilenamePicPro);
            if(photoCarteGrise!=null){
                String newFilenamePicCarteG = "photoCarteGrise_" + u.getUsername() + "." + FilenameUtils.getExtension(photoCarteGrise.getOriginalFilename());
                File serverFileCarte = new File(DIRECTORY + u.getUsername() + "/" + File.separator + newFilenamePicCarteG);
                FileUtils.writeByteArrayToFile(serverFileCarte, photoCarteGrise.getBytes());
                ((Conducteur) u).setCarteGrise(newFilenamePicCarteG);
            }
        }
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        utilisateurRepo.save(u);
        if (u instanceof Passager) addRoleToUser(u.getUsername(), "ROLE_Passager");
        else if (u instanceof Conducteur) addRoleToUser(u.getUsername(), "ROLE_Conducteur");
        return u;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = utilisateurRepo.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found with username: " + username);
        if (user instanceof Conducteur && !((Conducteur) user).isApprouved())
            throw new UsernameNotFoundException("User not Approuved yet : " + username);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities((List<Role>) user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        List<GrantedAuthority> springSecurityAuthorities = new ArrayList<>();
        for (Role r : roles) {
            springSecurityAuthorities.add(new SimpleGrantedAuthority(r.getName()));
        }
        return springSecurityAuthorities;
    }

    @Override
    public Role saveRole(Role role) {
        roleRepo.save(role);
        return role;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = utilisateurRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public List<AppUser> getAllApprouved() {
        List<AppUser> approuvedUsers = conducteurRepository.findByApprouvedIsTrue();
        approuvedUsers.addAll(passagerRepository.findAll());
        return approuvedUsers;
    }

    @Override
    public void deleteUser(Long id) {
        utilisateurRepo.deleteById(id);
    }

    @Override
    public void sendMail(List<String> usersEmail, String objet, String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(usersEmail.toArray(String[]::new));
        msg.setSubject(objet);
        msg.setText(content);
        javaMailSender.send(msg);
    }

}
