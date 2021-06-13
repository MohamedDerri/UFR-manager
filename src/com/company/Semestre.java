package com.company;

public class Semestre {
    private int numéro;
    private Module [] modules;

    public Semestre() {
        this.numéro = 0;
        this.modules = new Module[6];
    }
    public Semestre(int numéro) {
        this.numéro = numéro;
        this.modules = new Module[6];
    }
    public int getNumero() {
        return this.numéro;
    }
    public void setNumero(int n) {
        this.numéro = n;
    }
    public void affiche() {
        System.out.println("numero du semestre : " + this.numéro);
        for (int i = 0; i < this.modules.length; i++) {
            this.modules[i].affiche();
        }
    }
    public double getChargeHoraireSemestre() {
        double hs = 0.0;
        for (int i = 0; i < this.modules.length; i++) {
            hs += this.modules[i].getChargeHoraireModule();
        }
        return hs;
    }
    public Module get(int i) {
        if (i >= 0 && i <= 5)
            return this.modules[i];
        System.out.println("index out table");
        return null;
    }
    public void set(Module module, int i) {
        if (i >= 0 && i <= 5)
            this.modules[i] = module;
        else
            System.out.println("index out table");
    }
}
