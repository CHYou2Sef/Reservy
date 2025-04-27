package com.example.reservy.models;

public class Client {

    private int idCat;
    private String nomCat;
    private String prenomCat;
    private String tel;
    private String email;

    public Client(int idCat, String nomCat, String prenomCat, String tel, String email) {
        this.idCat = idCat;
        this.nomCat = nomCat;
        this.prenomCat = prenomCat;
        this.tel = tel;
        this.email = email;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public String getPrenomCat() {
        return prenomCat;
    }

    public void setPrenomCat(String prenomCat) {
        this.prenomCat = prenomCat;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
