package com.company;

import com.sun.org.apache.xerces.internal.impl.xs.XSMessageFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Professeur extends APersonne implements Enseignent{
    private Integer  nummerSomme;
    private String grade;
    private HashMap<String, ArrayList<Module>> cours;//
    ///doctorant
    private ArrayList<Doctorant> doctorants;///

    public Professeur() {
        super();
        this.grade = "";
        this.nummerSomme = 0;
        this.cours = new HashMap<String, ArrayList<Module>>(4);
    }
    public Professeur(String n, String em, int nbr, String grd, HashMap<String, ArrayList<Module>> c, ArrayList<Doctorant> docs) {
        super(n, em);
        if (grd.compareTo("PA") != 0 && grd.compareTo("PH") != 0 && grd.compareTo("PES") != 0)
            System.out.println("eroor name of grade");
        else
            this.grade = grd;
        this.nummerSomme = nbr;//
        if (c.size() == 4)
            this.cours = c;
        else
            System.out.println("Error nbr du cours pour prof ne depasse pas 4");
        this.doctorants = docs;
    }
    public void affiche() {
        System.out.println("nom : " + super.getNom());
        System.out.println("nummerSomme : " + this.nummerSomme);
        System.out.println("email : " + super.getEmail());
        System.out.println("grade : " + this.grade);
        if (cours.size() == 0)
        {
            System.out.println("size cours = 0 ");
            return ;
        }
//        for (int i = 0; i < cours.size(); i++) {
//            if (cours.get(i) != null)
//            {
//                cours.get(i).affiche();
//            }
//            else
//            {
//                System.out.println("les module encore vide " + i);
//                return ;
//            }
//        }
        for (Map.Entry<String, ArrayList<Module>> e: this.cours.entrySet()) {
            System.out.printf("Pour annee = " + e.getKey());
            for (int i = 0; i < e.getValue().size(); i++) {
                e.getValue().get(i).affiche();
            }
        }
    }
    public ArrayList<Module> getChargeAnnuelle(String date) {
        return this.cours.get(date);
    }
    public double getVacationAnnuelle(String date) {
        double tot = 0.0;
        ArrayList<Module> vacAnn = this.cours.get(date);
        for (int i = 0; i < vacAnn.size(); i++) {
            tot += vacAnn.get(i).getChargeHoraireModule();
        }
        return tot;
    }
    public boolean addChargeHoraire(String date, ArrayList<Module> modules) {
        if (!this.cours.containsKey(date)) {
            this.cours.put(date, modules);
            return true;
        }
        else
            return false;//existe deja
    }
    public boolean updatechargeHoraire(String date, ArrayList<Module> modules) {
        if (this.cours.containsKey(date)) {
            this.cours.replace(date, modules);
            return true;
        }
        else
            return false;
    }
    public ArrayList<Doctorant> getDoctorants() {
        return doctorants;
    }
    public void setDoctorants(ArrayList<Doctorant> doctorants) {
        this.doctorants = doctorants;
    }
    public String getNom() {
        return super.getNom();
    }
    public void setNom(String nom) {
        super.setNom(nom);
    }
    public String getEmail() {
        return super.getEmail();
    }
    public void setEmail(String email) {
        super.setEmail(email);
    }

    public Integer getNummerSomme() {
        return this.nummerSomme;
    }
    public void setNummerSomme(Integer nummerSomme) {
        this.nummerSomme = nummerSomme;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public HashMap<String, ArrayList<Module>> getCours() {
        return cours;
    }
    public void setCours(HashMap<String, ArrayList<Module>> cours) {
        this.cours = cours;
    }
    @Override
    public double getChargeHoraire() {//rett ch7al aytkheless //+ work with get vacations
        int nbrWork = 0;
//        for (int i = 0; i < this.cours.size(); i++) {
//            nbrWork += (this.cours.get(i).getNbrHeuresTD() + this.cours.get(i).getNbrHeuresTP());
//        }
        for (Map.Entry<String, ArrayList<Module>> e : this.cours.entrySet()) {
            System.out.println("pour annee = " + e.getKey());
            for (int i = 0; i < e.getValue().size(); i++) {
                nbrWork += (e.getValue().get(i).getChargeHoraireModule());
            }
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
            return rewardSup + rewardNormal + this.doctorants.size() * 5000;
        }
    }
    @Override
    public double getVactions() {
        int chargeMinimale = 0;
        double chargeHoraire = 0.;
        if (this.grade.compareTo("PA") == 0) {
            chargeMinimale = 320;
        }
        else if (this.grade.compareTo("PH") == 0) {
            chargeMinimale = 300;
        }
        else if (this.grade.compareTo("PES") == 0) {
            chargeMinimale = 280;
        }
//        for (int i = 0; i < this.cours.size(); i++) {
//            chargeHoraire += this.cours.get(i).getChargeHoraireModule();
//        }
        for (Map.Entry<String, ArrayList<Module>> e : this.cours.entrySet()) {
            System.out.println("pour annee = " + e.getKey());
            for (int i = 0; i < e.getValue().size(); i++) {
                chargeHoraire += (e.getValue().get(i).getChargeHoraireModule());
            }
        }
        return chargeHoraire - chargeMinimale;
    }

//    @Override
//    public String toString() {
//        return "Professeur{" +
//                "nummerSomme=" + nummerSomme +
//                ", grade='" + grade + '\'' +
////                ", cours=" + cours +
//                '}';
//    }
}
