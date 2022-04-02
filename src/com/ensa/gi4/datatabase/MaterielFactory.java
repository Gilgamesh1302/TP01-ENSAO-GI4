package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;

public class MaterielFactory {
    public static int id = 0;

    public Chaise createChaise(String name) {
        return new Chaise(this.id++, name);
    }

    public Livre createLivre(String name) {
        return new Livre(this.id++, name);
    }

}
