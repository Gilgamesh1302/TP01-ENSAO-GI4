package com.ensa.gi4.service.api;

public interface GestionChaiseService {

    void listerChaise();
    void ajouterNouveauChaise();
    boolean modifierChaise(int id, String name);
    boolean supprimerChaise(int id);
    boolean chercherChaise(int id);

}
