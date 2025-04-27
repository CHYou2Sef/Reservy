package com.example.reservy.models;

public class Reservation {
    private int idReservation, idClt, idBillet;
    private String dateReservation;

    public Reservation(int idReservation, int idClt, int idBillet, String dateReservation) {
        this.idReservation = idReservation;
        this.idClt = idClt;
        this.idBillet = idBillet;
        this.dateReservation = dateReservation;
    }

    // Getters et Setters

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdClt() {
        return idClt;
    }

    public void setIdClt(int idClt) {
        this.idClt = idClt;
    }

    public int getIdBillet() {
        return idBillet;
    }

    public void setIdBillet(int idBillet) {
        this.idBillet = idBillet;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }
}
