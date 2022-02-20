package com.emsi.gowithus.controller;

import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Conducteur;
import com.emsi.gowithus.model.Passager;
import com.emsi.gowithus.service.IUtilisateurService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Utilisateurs")
public class UtilisateurController {

    @Autowired
    private IUtilisateurService utilisateurService;
    final String chemin = System.getProperty("user.dir") + "/src/main/resources/images/";


    @GetMapping("/approuved")
    public ResponseEntity<List<AppUser>> getAllApprouved() {
        try {
            List<AppUser> approuvedUsers = utilisateurService.getAllApprouved();
            return ResponseEntity.ok().body(approuvedUsers);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/saveConducteur")
    public ResponseEntity<AppUser> saveConducteur(@RequestParam("conducteur") String conducteur,
                                                  @RequestParam MultipartFile photoProfil,
                                                  @RequestParam MultipartFile photoCin,
                                                  @RequestParam MultipartFile photoCarteGrise) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Conducteur c = mapper.readValue(conducteur, Conducteur.class);
        try {
            AppUser user = utilisateurService.saveUser(c, photoProfil, photoCin, photoCarteGrise);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/savePassager")
    public ResponseEntity<AppUser> savePassager(@RequestParam String passager, @RequestParam MultipartFile photoProfil, @RequestParam MultipartFile photoCin) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Passager p = mapper.readValue(passager, Passager.class);
        AppUser user = utilisateurService.saveUser(p, photoProfil, photoCin, null);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/sendmail")
    public ResponseEntity<String> sendMail(@RequestBody Map<String, Object> email) {
        try {
            utilisateurService.sendMail((List<String>) email.get("emails"), (String) email.get("objet"), (String) email.get("content"));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Les informations  semblent incorrectes :" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            utilisateurService.deleteUser(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
