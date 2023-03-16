/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_projekt_2;

/**
 *
 * @author oliwia
 */

import java.util.*;
import java.io.*;

public class Zestawienie {
    
    private final String NrKarty;
    private final String DataD;
    private final String Kod;
    private final float Masa;
    private final String Jedn;
    private final String Firma;
    private final String Typ;
    private final String Nazwa_Skrocona;
    private final String Nr_Mag;
    private final String Opis;
    
    public Zestawienie(String NrKarty, String DataD, String Kod, float Masa, String Jedn, String Firma, String Typ, String Nazwa_Skrocona, String Nr_Mag, String Opis){
       
        this.NrKarty = NrKarty;
        this.DataD = DataD;
        this.Kod = Kod;
        this.Masa = Masa;
        this.Jedn = Jedn;
        this.Firma = Firma;
        this.Typ = Typ;
        this.Nazwa_Skrocona = Nazwa_Skrocona;
        this.Nr_Mag = Nr_Mag;
        this.Opis = Opis;
    }
     
    float getMasa(){
        return Masa;
    }
    
     String getKod(){
        return Kod;
    }
     
     String getFirma(){
        return Firma;
    }
    
    
    
   public static ArrayList<Zestawienie> generateZestawienie() throws IOException {
     
       ArrayList<Zestawienie> zestawienie = new ArrayList<>(); 
       ArrayList<Dostawcy> dostawcy = Dostawcy.toArrayList();
        ArrayList<Magazyn> magazyn = Magazyn.toArrayList();
        ArrayList<Słownik> slownik = Słownik.toArrayList();
        String Nazwa_Skro = "";

        for (Magazyn m : magazyn) {
            String Nr_Karty = m.getNr_Karty();
            String DataD = m.getDataD();
            float Masa = m.getMasa();
            String Jedn = m.getJedn();
            String Firma = m.getFirma();
            String Nr_Mag = m.getNr_Mag();
            String Nr_Odpadu = m.getNr_Odpadu();
            
            for (Dostawcy d : dostawcy) {
                if (d.getNr_Klienta().equals(Nr_Odpadu)) {
                     Nazwa_Skro = d.getNazwa_Skrocona();
                    break;
                }
            }
            
            for (Słownik s : slownik) {
                if (s.getNr_Odpadu().equals(Nr_Odpadu)) {
                    String Gr = s.getGr();
                    String Podgr = s.getPodgr();
                    String Rodz = s.getRodz();
                    String Typ = s.getTyp();
                    String Opis = s.getOpis();
                    String Kod = Gr+Podgr+Rodz;
                    zestawienie.add(new Zestawienie(Nr_Karty, DataD, Kod, Masa, Jedn, Firma, Typ, Nazwa_Skro, Nr_Mag, Opis));
                }
            }
        }
        return zestawienie;
    }   
   
    public static ArrayList<Zestawienie> SortByNr_Karty (ArrayList<Zestawienie> zestawienie){
        
        Collections.sort(zestawienie, (Zestawienie z1, Zestawienie z2) -> z1.NrKarty.compareTo(z2.NrKarty));
        return zestawienie;
       
    }
    
     
    public static ArrayList<Zestawienie> SortByKod (ArrayList<Zestawienie> zestawienie){
        
        Collections.sort(zestawienie, (Zestawienie z1, Zestawienie z2) -> z1.Kod.compareTo(z2.Kod));
        return zestawienie;
       
    }
    
    public static ArrayList<Zestawienie> SortByFirma (ArrayList<Zestawienie> zestawienie){
        
        Collections.sort(zestawienie, (Zestawienie z1, Zestawienie z2) -> z1.Firma.compareTo(z2.Firma));
        return zestawienie;
       
    }
    
    public static void DisplayToConsole (ArrayList<Zestawienie> zestawienie){
        System.out.format("%-13s %-13s %-7s %-7s %-7s %-7s %-7s %-13s %-13s %-17s\n", "NRKARTY", "DATAD", "KOD", "MASA", "JEDN", "FIRMA", "TYP", "NAZWA_SKROCONA", "NR_MAG", "OPIS");
        for (Zestawienie z : zestawienie){
             System.out.format("%-13s %-13s %-7s %-7s %-7s %-7s %-7s %-13s %-13s %-17s\n", z.NrKarty, z.DataD, z.Kod, z.Masa, z.Jedn, z.Firma, z.Typ, z.Nazwa_Skrocona, z.Nr_Mag, z.Opis);
         }
    }

       
    @Override
    public String toString(){
        return "\nNR_KARTY: "+NrKarty + " DATAD: "+DataD+" KOD: "+Kod+" MASA: "+Masa+ " JEDN: "+ Jedn+" FIRMA: "+Firma+" TYP: "+Typ+" NAZWA_SKROCONA: "+Nazwa_Skrocona+" NR_MAG: "+Nr_Mag+" OPIS: "+Opis;
    }


   
    
}
