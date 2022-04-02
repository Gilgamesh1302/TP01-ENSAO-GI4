package com.ensa.gi4.controller;

import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.Scanner;

public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;

    public void afficherMenu() {
        System.out.println("1- pour lister le matériel, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("3- pour modifier un materiel existant, entrer 3");
        System.out.println("4- pour supprimer un materiel, entrer 4");
        System.out.println("5- pour chercher un materiel, entrer 5");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        switch (next) {
            case "0":
                sortirDeLApplication();
                break;
            case "1":
                gestionMaterielService.listerMateriel();
                break;
            case "2":
                gestionMaterielService.ajouterNouveauMateriel();
                break;
            case "3":
                gestionMaterielService.modifierMateriel();
                break;
            case "4":
                gestionMaterielService.supprimerMateriel();
                break;
            case "5":
                gestionMaterielService.chercherMateriel();
                break;
            default:
                System.out.println("choix invalide");
                break;
        }
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }

    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur
        this.gestionMaterielService = gestionMaterielService;
    }
}
