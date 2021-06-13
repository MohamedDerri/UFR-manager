package com.company;

public abstract class APersonne {
    private String nom;
    private String email;

    public APersonne() {
        this.nom = "unknown";
        this.email = "unknown@gmail.com";
    }

    public APersonne(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
