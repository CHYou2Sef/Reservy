package com.example.reservy.models;

import java.io.Serializable;
public class CartItem implements Serializable {
    private int idSpec;
    private int idBillet;
    private String titre;
    private String categorie;
    private double prix;
    private int quantite;
    private String img;

    // Constructors
    public CartItem() {}

    public CartItem(int idSpec, int idBillet, String titre, String categorie,
                    double prix, int quantite, String img) {
        this.idSpec = idSpec;
        this.idBillet = idBillet;
        this.titre = titre;
        this.categorie = categorie;
        this.prix = prix;
        this.quantite = quantite;
        this.img = img;
    }

    // Getters and Setters
    public int getIdSpec() { return idSpec; }
    public void setIdSpec(int idSpec) { this.idSpec = idSpec; }

    public int getIdBillet() { return idBillet; }
    public void setIdBillet(int idBillet) { this.idBillet = idBillet; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    public double getTotal() {
        return prix * quantite;
    }
}
