package com.ensa.gi4.service.api;

public interface GestionLivreService {

    void listerLivre();
    void ajouterNouveauLivre();
    boolean modifierLivre(int id, String name);
    boolean supprimerLivre(int id);
    boolean chercherLivre(int id);

}
