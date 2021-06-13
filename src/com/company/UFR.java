package com.company;

import java.util.ArrayList;

public class UFR {
    private ArrayList<Formation> formations;
    private ArrayList<Enseignent> enseignents;//tout les prof qui travaille dans cette formation
//    private ArrayList<Module> modules ra kaynin west fomation -> semestre
    private ArrayList<Module> allModules;

    public UFR(ArrayList<Formation> formations, ArrayList<Enseignent> enseignents, ArrayList<Module> allModules) {
        this.formations = formations;
        this.enseignents = enseignents;
        this.allModules = allModules;
    }

    public void affiche() {
        for (int i = 0; i < this.enseignents.size(); i++) {
            System.out.println("charge horaire de l'enseignent " + i + this.enseignents.get(i).getChargeHoraire());
        }
    }
    public double getVacation() {
        double ret = 0.0;
        for (int i = 0; i < this.enseignents.size(); i++) {
            ret += this.enseignents.get(i).getVactions();
        }
        return ret;
    }
    public ArrayList<Formation> getFormations() {
        return formations;
    }
    public void setFormations(ArrayList<Formation> formations) {
        this.formations = formations;
    }
    public ArrayList<Enseignent> getEnseignents() {
        return enseignents;
    }
    public void setEnseignents(ArrayList<Enseignent> enseignents) {
        this.enseignents = enseignents;
    }
}
