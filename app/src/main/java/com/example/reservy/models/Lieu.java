package com.example.reservy.models;

public class Lieu {

    private int idLieu;
    private String nomLieu, adresse, ville;
    private int capacite;

    public Lieu(int idLieu, String nomLieu, String adresse, String ville, int capacite) {
        this.idLieu = idLieu;
        this.nomLieu = nomLieu;
        this.adresse = adresse;
        this.ville = ville;
        this.capacite = capacite;
    }

    // Getters et Setters

    public int getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public String getNomLieu() {
        return nomLieu;
    }

    public void setNomLieu(String nomLieu) {
        this.nomLieu = nomLieu;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
