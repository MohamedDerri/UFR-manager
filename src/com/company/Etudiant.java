package com.company;

import java.util.ArrayList;

public class Etudiant extends APersonne {
//    private String nom;
    private int numberetudiant;//id
//    private String email;
    ArrayList<Module> modules;

    public Etudiant() {
        super();
//        this.setNom("");
        this.setNumberetudiant(0);
//        this.setEmail("etudiant@gmail.com");
    }
    public Etudiant(String n, int id, String em, ArrayList<Module> modules) {
        super(n, em);
//        this.setNom(n);
        this.setNumberetudiant(id);
//        this.setEmail(em);
        this.modules = modules;
    }
    public void affiche() {
        System.out.println("nom : " + this.getNom());
        System.out.println("nbrEtudiant : " + this.numberetudiant);
        System.out.println("email : " + this.getEmail());
    }
    public String getNom() {
        return super.getNom();
    }
    public boolean addModule(Module module) {
//        if (this.modules.size() % 7 == 0)
        return this.modules.add(module);
    }
    public void setNom(String nom) {
        super.setNom(nom);
    }

    public int getNumberetudiant() {
        return numberetudiant;
    }

    public void setNumberetudiant(int numberetudiant) {
        this.numberetudiant = numberetudiant;
    }

    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }
}
