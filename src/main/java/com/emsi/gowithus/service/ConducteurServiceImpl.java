package com.emsi.gowithus.service;

import com.emsi.gowithus.dao.ConducteurRepository;
import com.emsi.gowithus.model.Conducteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ConducteurServiceImpl implements IConducteurService {
    @Autowired
    private ConducteurRepository conducteurRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public List<Conducteur> getAllAprrouved() {
        List<Conducteur> approuvedUsers = conducteurRepository.findByApprouvedTrue();
        return approuvedUsers;
    }

    @Override
    public List<Conducteur> getAllNonApprouved() {
        List<Conducteur> approuvedUsers = conducteurRepository.findByApprouvedFalse();
        return approuvedUsers;
    }

    @Override
    public Conducteur setApprouvedUser(Long id) {
        SimpleMailMessage msg = new SimpleMailMessage();
        Conducteur conducteur = conducteurRepository.findById(id).get();
        conducteur.setApprouved(true);
        conducteurRepository.save(conducteur);
        msg.setTo(conducteur.getEmail());
        msg.setSubject("Félicitation vous êtes approuvés");
        msg.setText("Bonjour " + conducteur.getNom() + " " + conducteur.getPrenom() + "\n Vous êtes maintenant approuvés, vous pouvez maintenant se connecter à votre compte.\n Merci\n L'équipe GOWITHUS");
        javaMailSender.send(msg);
        return conducteur;
    }
}
