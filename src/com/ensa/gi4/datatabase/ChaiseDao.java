package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;

import java.util.ArrayList;
import java.util.List;

public class ChaiseDao {
    private List<Chaise> chaises = new ArrayList<>();

    public List<Chaise> getChaise() {
        return chaises;
    }

    public void ajouterChaise(Chaise chaise) {
        chaises.add(chaise);
        System.out.println("chaise" + chaise.getName() + "ajoute avec succee");
    }

    public Chaise chercherChaise(int id) {
        Chaise or = chaises.stream().filter(chaise -> chaise.getId() == id).findFirst().orElse(null);
        return or;
    }

    public boolean supprimerChaise(int id) {
        return chaises.removeIf(chaise -> chaise.getId() == id);
    }

    public boolean modifierChaise(int id, String name) {
        Chaise chaise1 = chaises.stream().filter(chaise -> chaise.getId() == id).findFirst().orElse(null);
        if (chaise1 == null) return false;
        chaise1.setName(name);
        System.out.println("chaise a ete modifier avec succee \n");
        return true;
    }
}
