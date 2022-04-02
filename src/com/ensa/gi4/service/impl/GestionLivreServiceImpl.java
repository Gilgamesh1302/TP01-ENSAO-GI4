package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.LivreDao;
import com.ensa.gi4.datatabase.MaterielFactory;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.service.api.GestionLivreService;

import java.util.Scanner;

public class GestionLivreServiceImpl implements GestionLivreService {

    private LivreDao livreDao;
    private MaterielFactory factory;

    public GestionLivreServiceImpl(LivreDao livreDao, MaterielFactory factory) {
        this.factory = factory;
        this.livreDao = livreDao;
    }

    @Override
    public void listerLivre() {
        System.out.println("listes des livres : ");
        for (Livre livre : livreDao.getLivres()) {
            System.out.println(livre.getId() + ": "+ livre.getName());
        }
        System.out.println();
    }

    @Override
    public void ajouterNouveauLivre() {
        System.out.println("entrer le nom du livre : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        livreDao.ajouterLivre(factory.createLivre(name));
    }

    @Override
    public boolean modifierLivre(int id, String name) {
        return livreDao.modifierLivre(id,name);
    }

    @Override
    public boolean supprimerLivre(int id) {
        if (livreDao.supprimerLivre(id)) {
            System.out.println("Materiel(Livre) supprimer avec succee");
            return true;
        }
        return false;
    }

    @Override
    public boolean chercherLivre(int id) {
        Livre livre = livreDao.chercherLivre(id);
        if (livre == null) return false;
        System.out.println("Materiel trouve : livre " + livre.getName());
        return true;
    }
}
