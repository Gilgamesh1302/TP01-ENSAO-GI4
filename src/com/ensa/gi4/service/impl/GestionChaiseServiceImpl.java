package com.ensa.gi4.service.impl;

import com.ensa.gi4.controller.GestionMaterielController;
import com.ensa.gi4.datatabase.ChaiseDao;
import com.ensa.gi4.datatabase.MaterielFactory;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.service.api.GestionChaiseService;

import java.util.Scanner;

public class GestionChaiseServiceImpl implements GestionChaiseService {

    private ChaiseDao chaiseDao;
    private MaterielFactory factory;

    public GestionChaiseServiceImpl(ChaiseDao chaiseDao, MaterielFactory factory) {
        this.factory = factory;
        this.chaiseDao = chaiseDao;
    }

    @Override
    public void listerChaise() {
        System.out.println("listes des chaises : ");
        for (Chaise chaise : chaiseDao.getChaise()) {
            System.out.println(chaise.getId() + ": "+ chaise.getName());
        }
        System.out.println();
    }

    @Override
    public void ajouterNouveauChaise() {
        System.out.println("entrer le nom du chaise : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        chaiseDao.ajouterChaise(factory.createChaise(name));
    }

    @Override
    public boolean modifierChaise(int id, String name) {
        return chaiseDao.modifierChaise(id, name);
    }

    @Override
    public boolean supprimerChaise(int id) {
        if (chaiseDao.supprimerChaise(id)){
            System.out.println("Materiel supprimer avec succee");
            return true;
        }
        return false;
    }

    @Override
    public boolean chercherChaise(int id) {
        Chaise chaise = chaiseDao.chercherChaise(id);
        if (chaise == null) return false;
        System.out.println("Materiel trouve : chaise " + chaise.getName());
        return true;
    }
}
