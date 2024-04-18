package com.example.gestion_user.controllers;

import com.example.gestion_user.entities.Affaire;
import com.example.gestion_user.models.request.cases.NewCaseDto;
import com.example.gestion_user.services.AffaireService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/cases")
public class AffaireController {

    @Autowired
    AffaireService affaireService;

    @PostMapping("/")
    public Affaire addAffaire(@RequestBody @Valid NewCaseDto newCaseDto) {
        return affaireService.addAffaire(newCaseDto);

    }

    @PutMapping("/{id}")
    public Affaire updateAffaire(@PathVariable Long id ,@RequestBody Affaire a) {
        Affaire affaire = affaireService.updateAffaire(a);
        return affaire;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeAffaire(@PathVariable("id") Integer id) {
        affaireService.removeAffaire(id);
    }

    @GetMapping("/{id}")
    public Affaire retrieveAffaire(@PathVariable("id") Integer id) {
        return affaireService.retrieveAffaire(id);
    }

    @GetMapping("/")
    public List<Affaire> getAffaire() {
        List<Affaire> listAffaires = affaireService.retrieveAllAffaires();
        return listAffaires;
    }

    @GetMapping("search-affaire-by-titre/{titreAffaire}")
    public ResponseEntity<List<Affaire>> searchAffaireByTitre(@PathVariable String titreAffaire) {
        List<Affaire> affaires = affaireService.searchAffaireByTitre(titreAffaire);
        return ResponseEntity.ok().body(affaires);
    }

}
