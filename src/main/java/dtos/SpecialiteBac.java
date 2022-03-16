package dtos;

import java.util.UUID;

public class SpecialiteBac {

    private String nom;

    public SpecialiteBac(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
