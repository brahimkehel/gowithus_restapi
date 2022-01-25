package com.emsi.gowithus.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import com.emsi.gowithus.dao.ConducteurRepository;
import com.emsi.gowithus.dao.PassagerRepository;
import com.emsi.gowithus.model.Conducteur;
import com.emsi.gowithus.model.Passager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.emsi.gowithus.dao.RoleRepository;
import com.emsi.gowithus.dao.UtilisateurRepository;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Role;

@Transactional
@Service
public class UtilisateurServiceImpl implements IUtilisateurService {
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

    @Override
    public AppUser saveUser(AppUser u) {
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

}
