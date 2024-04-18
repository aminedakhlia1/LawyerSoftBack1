package com.example.gestion_user.services;

import com.example.gestion_user.entities.Affaire;
import com.example.gestion_user.models.request.cases.NewCaseDto;

import java.util.List;

public interface AffaireService {

    Affaire addAffaire(NewCaseDto newCaseDto);

    Affaire updateAffaire(Affaire affaire);

    void removeAffaire(Integer idAffaire);

    Affaire retrieveAffaire(Integer idAffaire);

    //public Affaire addAffaire(Affaire affaire, Integer idTribunal);

    List<Affaire> retrieveAllAffaires();

    public List<Affaire> searchAffaireByTitre(String titreAffaire);

}
