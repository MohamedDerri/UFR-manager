package com.company;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;

public class Doctorant extends Etudiant implements Enseignent {
    private String sujetThese;
    private ArrayList<Professeur> encadrant;//1 2 de grade PES OR PH
    private ArrayList<Module> cours;//2
    private Date dateInscription;

    public Doctorant() {
        super();
        this.sujetThese = "no subject";
        this.encadrant = null;
        this.cours = new ArrayList<Module>(2);
    }

    public Doctorant(String n, int id, String em, String password, String sujectThese, ArrayList<Professeur> encad, ArrayList<Module> mod, Date dateInscription) {
        super(n, id, password, em, mod);
        this.dateInscription = dateInscription;
        this.sujetThese = sujectThese;
        if (encad.size() > 2 || encad.size() == 0 || (encad.get(0).getGrade().compareTo("PA") == 0) || (encad.size() == 2 && encad.get(1).getGrade().compareTo("PA") == 0)) {
            System.out.println("erreur en encadrants, soit le nombre est depassé soit les encadrants sont de grade PA");
            this.encadrant = null;
        }
        else
            this.encadrant = encad;
        if (mod.size() > 2 || mod.size() == 0)
        {
            System.out.println("nombre limite de module est deux");
            this.cours = null;
        }
        else
            this.cours = mod;
        Date now = new Date(System.currentTimeMillis());
        long diff = now.getTime() - dateInscription.getTime();
        int nbrannee = (int)(diff/(1000*60*60*24*30*12));
        if (this.cours.size() != 0 && nbrannee < 2) {
            System.out.println("n'est pas encore capable d'enseigner");
        }
        else
            System.out.println("doctorant est capable d'enseigner");
    }
    @Override
    public double getChargeHoraire() {
        int nbrWork = 0;
        for (int i = 0; i < this.cours.size(); i++) {
            nbrWork += (this.cours.get(i).getNbrHeuresTD() + this.cours.get(i).getNbrHeuresTP());
        }
        if (nbrWork <= 32) {
            double reward =  (double)nbrWork * 400.;
            return (reward - reward * 34./100.);
        }
        else {
            double rewardSup = (double)((nbrWork - 32.) * 600.);
            rewardSup -= rewardSup * 17. / 100.;
            double rewardNormal = (double) (32. * 400.);
            rewardNormal -= rewardNormal * 34. / 100.;
            return rewardSup + rewardNormal;
        }
    }
    @Override
    public double getVactions() {
        return 0;
    }
    public String getNom() {
        return this.getNom();
    }
    public String getEmail() {
        return this.getEmail();
    }
    public int    getNumberetudiant() { return this.getNumberetudiant();}
    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }
    @Override
    public void setNumEtudiant(int numberetudiant) {
        super.setNumEtudiant(numberetudiant);
    }
    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    public String getSujetThese() {
        return sujetThese;
    }
    public void setSujetThese(String sujetThese) {
        this.sujetThese = sujetThese;
    }
    public ArrayList<Professeur> getEncadrant() {
        return encadrant;
    }
    public void setEncadrant(ArrayList<Professeur> encadrant) {
        this.encadrant = encadrant;
    }
    public ArrayList<Module> getCours() {
        return cours;
    }
    public void setCours(ArrayList<Module> cours) {
        this.cours = cours;
    }
}
