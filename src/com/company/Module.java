package com.company;

public class Module {
    private String libellé;
    private Integer coefficient;
    private Integer  nbrHeuresCours;
    private Integer  nbrHeuresTD;
    private Integer  nbrHeuresTP;
    private Professeur enseignent;

    public Module() {
        this.libellé = "";
        this.coefficient = 0;
        this.nbrHeuresCours = 0;
        this.nbrHeuresTP = 0;
        this.nbrHeuresTD = 0;
        this.enseignent = new Professeur();//normalent khase ikoun parahit khasana Grade
    }

    public Module(
            String libellé,
            Integer coefficient,
            Integer nbrHeuresCours,
            Integer nbrHeuresTD,
            Integer nbrHeuresTP,
            Professeur enseignent) {
        this.libellé = libellé;
        this.coefficient = coefficient;
        this.nbrHeuresCours = nbrHeuresCours;
        this.nbrHeuresTD = nbrHeuresTD;
        this.nbrHeuresTP = nbrHeuresTP;
        this.enseignent = enseignent;
    }
    public void affiche() {
        System.out.println("libelle : " + this.libellé);
        System.out.println("coefficient : " + this.coefficient);
        System.out.println("nbrheuresCours : " + this.nbrHeuresCours);
        System.out.println("nbrheuresTD : " + this.nbrHeuresTD);
        System.out.println("nbrheuresTp : " + this.nbrHeuresTP);
//        this.enseignent.affiche();///if
    }
    public double getChargeHoraireModule() {
        double ch = this.nbrHeuresCours * 1.5 + this.nbrHeuresTD + this.nbrHeuresTP * 0.75;
        return ch;
    }
    public String getLibellé() {
        return libellé;
    }
    public void setLibellé(String libellé) {
        this.libellé = libellé;
    }
    public Integer getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }
    public Integer getNbrHeuresCours() {
        return nbrHeuresCours;
    }
    public void setNbrHeuresCours(Integer nbrHeuresCours) {
        this.nbrHeuresCours = nbrHeuresCours;
    }
    public Integer getNbrHeuresTD() {
        return nbrHeuresTD;
    }
    public void setNbrHeuresTD(Integer nbrHeuresTD) {
        this.nbrHeuresTD = nbrHeuresTD;
    }
    public Integer getNbrHeuresTP() {
        return nbrHeuresTP;
    }
    public void setNbrHeuresTP(Integer nbrHeuresTP) {
        this.nbrHeuresTP = nbrHeuresTP;
    }
    public Professeur getEnseignent() {
        return enseignent;
    }
    public void setEnseignent(Professeur enseignent) {
        this.enseignent = enseignent;
    }

//    @Override
//    public String toString() {
//        return "Module{" +
//                "libellé='" + libellé + '\'' +
//                ", coefficient=" + coefficient +
//                ", nbrHeuresCours=" + nbrHeuresCours +
//                ", nbrHeuresTD=" + nbrHeuresTD +
//                ", nbrHeuresTP=" + nbrHeuresTP +
//                ", enseignent=" + enseignent.toString() +
//                '}';
//    }
}
