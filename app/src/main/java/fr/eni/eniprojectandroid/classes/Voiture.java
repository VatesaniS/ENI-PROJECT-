package fr.eni.eniprojectandroid.classes;

/**
 * Created by Administrateur on 03/05/2017.
 */

public class Voiture {

    private String id;
    private String modele;
    private String marque;
    private int prix;
    private String plaque;
    private String[] urlPhotos;
    private boolean isLoue;
    private String agenceId;

    public Voiture(String id, String modele, String marque, int prix, String plaque) {
        this.id = id;
        this.modele = modele;
        this.marque = marque;
        this.prix = prix;
        this.plaque = plaque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String[] getUrlPhotos() {
        return urlPhotos;
    }

    public void setUrlPhotos(String[] urlPhotos) {
        this.urlPhotos = urlPhotos;
    }

    public boolean isLoue() {
        return isLoue;
    }

    public void setLoue(boolean loue) {
        isLoue = loue;
    }

    public String getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(String agenceId) {
        this.agenceId = agenceId;
    }
}
