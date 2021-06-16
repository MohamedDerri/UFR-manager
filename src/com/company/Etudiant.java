package com.company;

import java.util.ArrayList;

public class Etudiant extends APersonne {
//    private String nom;
    private int numEtudiant;//id
//    private String email;
    private  String role;
    ArrayList<Module> modules;

    public Etudiant() {
        super();
//        this.setNom("");
        this.setNumEtudiant(0);
//        this.setEmail("etudiant@gmail.com");
    }
    public Etudiant(String n, int id, String password, String em, ArrayList<Module> modules) {
        super(n, em, password);
//        this.setNom(n);
        this.setNumEtudiant(id);
//        this.setEmail(em);
        this.modules = modules;
    }

    public Etudiant(int id, String nom, String email, String password) {
        super(nom, email, password);
        this.setNumEtudiant(id);
    }

    public Etudiant(int id, String nom, String email, String password, String role) {
        super(nom, email, password);
        this.setNumEtudiant(id);
        this.setRole(role);
    }

    private void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void affiche() {
        System.out.println("nom : " + this.getNom());
        System.out.println("nbrEtudiant : " + this.numEtudiant);
        System.out.println("email : " + this.getEmail());
    }
    public String getNom() {
        return super.getNom();
    }
    public boolean addModule(Module module) {
        if (this.modules.size() % 7 == 0)
            return false;
        return this.modules.add(module);
    }
    public void setNom(String nom) {
        super.setNom(nom);
    }

    public int getNumEtudiant() {
        return numEtudiant;
    }

    public void setNumEtudiant(int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }
}
