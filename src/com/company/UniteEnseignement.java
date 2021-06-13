package com.company;

public class UniteEnseignement {
    private Module module;
    private String annee;//(1 2) 3  4 5
    private double note;

    public UniteEnseignement() {
        this.module = null;
        this.annee = "";
        this.note = 0.0;
    }
    public UniteEnseignement(Module module, String annee, double note) {
        this.module = module;
        this.annee = annee;
        this.note = note;
    }
    public boolean isValide() {
        if (this.annee.compareTo("1") == 0 || this.annee.compareTo("2") == 0) {
            if (this.note >= 10) {
                System.out.println("le module " + this.module.getLibellé() + " est valide");
                return true;
            }
            else
            {
                System.out.println("le module " + this.module.getLibellé() + " est Nonvalide");
                return false;
            }
        }
        else {
            if (this.note >= 12) {
                System.out.println("le module " + this.module.getLibellé() + " est valide");
                return true;
            }
            else
            {
                System.out.println("le module " + this.module.getLibellé() + " est Nonvalide");
                return false;
            }
        }
    }
    public Module getModule() {
        return module;
    }
    public void setModule(Module module) {
        this.module = module;
    }
    public String getAnnee() {
        return annee;
    }
    public void setAnnee(String annee) {
        this.annee = annee;
    }
    public double getNote() {
        return note;
    }
    public void setNote(double note) {
        this.note = note;
    }
}
