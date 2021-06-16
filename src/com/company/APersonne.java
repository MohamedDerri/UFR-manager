package com.company;

public abstract class APersonne {
    private String nom;
    private String email;
    private String password;

    public APersonne() {
        this.nom = "unknown";
        this.email = "unknown@gmail.com";
        this.password = "root";
    }

    public APersonne(String nom, String email, String password) {
        this.nom = nom;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
