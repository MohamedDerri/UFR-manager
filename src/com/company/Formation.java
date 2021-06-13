package com.company;

import java.util.*;

public class Formation {
    private String libelle;
    private Professeur responsable;
    private String description;
    private Semestre[] semestres;
    private Set<Etudiant> etudiants = new TreeSet<>();

    public Formation(String libelle, Professeur responsable, String description, Semestre[] semestres) {
        this.libelle = libelle;
        this.responsable = responsable;
        this.semestres = semestres;
        this.description = description;
    }
    public Formation() {
        this.libelle = "intitule";
        this.responsable = new Professeur();//normalent khase ikoun parahit khasana Grade
        this.semestres = new Semestre[9];
    }
    public boolean addEtudiant(Etudiant et) {
        return this.etudiants.add(et);
    }
    public boolean removeEtudiant(Etudiant et) {
        return this.etudiants.remove(et);
    }
//    public Etudiant getEtudiants(int numeroEtudiant) {
//        this.etudiants.
//    }
    public void afficheEtudiantParOrdre() {
        Iterator<Etudiant> i = this.etudiants.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
    public Semestre get(int i) {
        if (i >= 0 && i <= 8)//i - 1 >= 0 7ite 3enda s1, s2 ....
            return this.semestres[i];
        System.out.println("index out table");
        return null;
    }
    public void set(Semestre s, int i) {
        if (i >= 0 && i <= 8)
            this.semestres[i] = s;
        else
            System.out.println("index out table");
    }
    public void affiche() {
        System.out.println("intitule : " + this.libelle);
        this.responsable.affiche();
        for (int i = 0; i < this.semestres.length; i++) {
            this.semestres[i].affiche();
        }
    }
    public double getChargeHoraireFormation() {
        double hf = 0.0;
        for (int i = 0; i < this.semestres.length; i++) {
            hf += this.semestres[i].getChargeHoraireSemestre();
        }
        return hf;
    }
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Professeur getResponsable() {
        return responsable;
    }

    public void setResponsable(Professeur responsable) {
        this.responsable = responsable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Semestre[] getSemestres() {
        return semestres;
    }

    public void setSemestres(Semestre[] semestres) {
        this.semestres = semestres;
    }

}
