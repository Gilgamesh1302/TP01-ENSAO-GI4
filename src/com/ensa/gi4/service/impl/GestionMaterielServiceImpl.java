package com.ensa.gi4.service.impl;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.Scanner;

public class GestionMaterielServiceImpl implements GestionMaterielService {
    // bd goes here
    private GestionChaiseServiceImpl gestionChaiseService;
    private GestionLivreServiceImpl gestionLivreService;

    public GestionMaterielServiceImpl(GestionChaiseServiceImpl gestionChaiseService, GestionLivreServiceImpl gestionLivreService) {
        this.gestionChaiseService = gestionChaiseService;
        this.gestionLivreService = gestionLivreService;
    }

    @Override
    public void init() {

    }

    @Override
    public void listerMateriel() {
        System.out.println("listes des materiels : \n");
        gestionChaiseService.listerChaise();
        gestionLivreService.listerLivre();
    }

    @Override
    public void ajouterNouveauMateriel() {
        System.out.println("2.1 - pour ajouter une chaise, entrer 1");
        System.out.println("2.2- pour ajouter un livre, entrer 2");
        System.out.println("0 pour retourner au menu precedent");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        switch(next) {
            case "0":
                break;
            case "1":
                gestionChaiseService.ajouterNouveauChaise();
                break;
            case "2":
                gestionLivreService.ajouterNouveauLivre();
            default:
                System.out.println("choix invalide");
                break;
        }
    }

    @Override
    public void modifierMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("entrer l'id de materiel a modifier");
        int id = scanner.nextInt();
        System.out.println("entrer le nouveau nom");
        String name = scanner.next();
        if (!(gestionChaiseService.modifierChaise(id, name) || gestionLivreService.modifierLivre(id, name)))
            System.out.println("Materiel introuvable");
    }

    @Override
    public void supprimerMateriel() {
        System.out.println("entrer l'id de materiel a supprimer :");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        if(!(gestionLivreService.supprimerLivre(id) || gestionChaiseService.supprimerChaise(id)))
            System.out.println("Materiel introuvable");
    }

    @Override
    public void chercherMateriel() {
        System.out.println("Entrer l'id du materiel recherche : ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        if (!(gestionLivreService.chercherLivre(id) || gestionChaiseService.chercherChaise(id)))
            System.out.println("Materiel introuvable");
    }
}
