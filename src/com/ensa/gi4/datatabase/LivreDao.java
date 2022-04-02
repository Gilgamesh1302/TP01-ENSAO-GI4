package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;

import java.util.ArrayList;
import java.util.List;

public class LivreDao {
    private List<Livre> livres = new ArrayList<>();

    public List<Livre> getLivres() {
        return livres;
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
        System.out.println("livre" + livre.getName() + "ajoute avec succee");
    }

    public Livre chercherLivre(int id) {
        Livre livre = livres.stream().filter(livre1 -> livre1.getId() == id).findFirst().orElse(null);
        return livre;
    }

    public boolean supprimerLivre(int id) {
        return livres.removeIf(livre -> livre.getId() == id);
    }

    public boolean modifierLivre(int id, String name) {
        Livre livre1 = livres.stream().filter(livre -> livre.getId() == id).findFirst().orElse(null);
        if (livre1 == null) return false;
        livre1.setName(name);
        System.out.println("livre a ete modifier avec succee \n");
        return true;
    }
}
