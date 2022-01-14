package com.emsi.gowithus.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emsi.gowithus.dao.UtilisateurRepository;
import com.emsi.gowithus.model.Role;
import com.emsi.gowithus.model.Utilisateur;

@Transactional
@Service
public class UtilisateurServiceImpl implements IUtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepo;

    @Override
    public void saveUser(Utilisateur u) {
        utilisateurRepo.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Utilisateur user = utilisateurRepo.findbyUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found with username: " + username);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities((List)user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        List<GrantedAuthority> springSecurityAuthorities = new ArrayList<>();
        for (Role r : roles) {
            springSecurityAuthorities.add(new SimpleGrantedAuthority(r.getName()));
        }
        return springSecurityAuthorities;
    }

}