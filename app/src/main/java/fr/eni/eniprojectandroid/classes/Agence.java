package fr.eni.eniprojectandroid.classes;

import java.util.ArrayList;

/**
 * Created by Administrateur on 03/05/2017.
 */

public class Agence {
    private String id;
    private String nom;
    private String adresse;
    private String nomDirigeant;

    public Agence(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
