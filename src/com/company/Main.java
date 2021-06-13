package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Module> modshafidi = new ArrayList<>(4);
        HashMap<String, ArrayList<Module>> hashHafidi = new HashMap<>();
        ArrayList<Doctorant> docs = new ArrayList<>();
//        ArrayList<Module> modsdergham = new ArrayList<>(4);
//        ArrayList<Module> modssaadi = new ArrayList<>(4);
//
        Professeur hafidi = new Professeur("hafidi", "hafidi@gmail.cm", 1000,"PES", hashHafidi, docs);
//        Professeur dargham = new Professeur("dergham", "dergham@gmail.cm", 1000,"PH", modsdergham);
//        Professeur saadi = new Professeur("saadi", "saadi@gmail.cm", 1000,"PA", modssaadi);
//
        Module m1 = new Module("java",2,18,4,8, hafidi);
        Module m2 = new Module("meta",2,1,4,8, hafidi);
//        Module m3 = new Module("tcc",2,19,4,8, dargham);
//        Module m4 = new Module("sockets",2,20,4,8, saadi);
        modshafidi.add(m1);
        modshafidi.add(m2);
//        modsdergham.add(m3);
//        modssaadi.add(m4);
//
//        hafidi.affiche();
//        System.out.println("=================");
//        dargham.affiche();
//        System.out.println("=================");
//        saadi.affiche();
        ArrayList<Professeur> encad = new ArrayList<>();
        encad.add(hafidi);
        Date inscDate = new Date(2019 - 1900, 1, 1);
        Doctorant doc = new Doctorant("yass", 10, "hdjbdjc", "bbd", encad, modshafidi, inscDate);

    }
}
