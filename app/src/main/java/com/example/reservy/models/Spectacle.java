package com.example.reservy.models;

import java.io.Serializable;
import java.util.Date;
import org.json.JSONObject;
import org.json.JSONException;

public class Spectacle implements Serializable {
    private int idSpec;
    private String titre;
    private String dateS;
    private String H_DebutS;
    private String duree;
    private int nbrSpectateur;
    private String description;
    private String site_web;
    private int idLieu;
    private String img;
    private String nomLieu;
    private String ville;

    // Constructors
    public Spectacle() {}

    public Spectacle(int idSpec, String titre, String dateS, String H_DebutS, String duree,
                     int nbrSpectateur, String description, String site_web, int idLieu, String img) {
        this.idSpec = idSpec;
        this.titre = titre;
        this.dateS = dateS;
        this.H_DebutS = H_DebutS;
        this.duree = duree;
        this.nbrSpectateur = nbrSpectateur;
        this.description = description;
        this.site_web = site_web;
        this.idLieu = idLieu;
        this.img = img;
    }

    // Getters and Setters
    public int getIdSpec() { return idSpec; }
    public void setIdSpec(int idSpec) { this.idSpec = idSpec; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDateS() { return dateS; }
    public void setDateS(String dateS) { this.dateS = dateS; }

    public String getH_DebutS() { return H_DebutS; }
    public void setH_DebutS(String h_DebutS) { H_DebutS = h_DebutS; }

    public String getDuree() { return duree; }
    public void setDuree(String duree) { this.duree = duree; }

    public int getNbrSpectateur() { return nbrSpectateur; }
    public void setNbrSpectateur(int nbrSpectateur) { this.nbrSpectateur = nbrSpectateur; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSite_web() { return site_web; }
    public void setSite_web(String site_web) { this.site_web = site_web; }

    public int getIdLieu() { return idLieu; }
    public void setIdLieu(int idLieu) { this.idLieu = idLieu; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    public String getNomLieu() { return nomLieu; }
    public void setNomLieu(String nomLieu) { this.nomLieu = nomLieu; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    // Static method to parse from JSONObject (used by ApiHelper)
    public static Spectacle fromJson(JSONObject jsonObject) throws JSONException {
        Spectacle spectacle = new Spectacle();
        spectacle.setIdSpec(jsonObject.getInt("idSpec"));
        spectacle.setTitre(jsonObject.getString("titre"));
        spectacle.setDateS(jsonObject.getString("dateS")); // Format later
        spectacle.setH_DebutS(jsonObject.getString("H_DebutS")); // Format later
        spectacle.setDuree(jsonObject.optString("duree", null)); // Optional field
        spectacle.setDescription(jsonObject.optString("description", ""));
        spectacle.setSite_web(jsonObject.optString("site_web", null));
        spectacle.setIdLieu(jsonObject.getInt("idLieu")); // Assuming idLieu is always present
        spectacle.setImg(jsonObject.optString("img", null));

        // Example if Lieu details are directly included in spectacle list API
        spectacle.setNomLieu(jsonObject.optString("nomLieu", "")); // Comes from JOIN in PHP
        spectacle.setVille(jsonObject.optString("ville", "")); // Comes from JOIN in PHP

        return spectacle;
    }


}
