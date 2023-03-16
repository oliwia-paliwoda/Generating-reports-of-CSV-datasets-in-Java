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

public class Magazyn {
    
    private final String NrKarty;
    private final String DataD;
    private final float Masa;
    private final String Jedn;
    private final String Firma;
    private final String Nr_Mag;
    private final String Nr_Odpadu;
    private final String Nr_Klienta;
    
    public Magazyn(String NrKarty, String DataD, float Masa, String Jedn, String Firma, String Nr_Mag, String Nr_Odpadu, String Nr_Klienta)
    {

    this.NrKarty = NrKarty;
    this.DataD = DataD;
    this.Masa = Masa;
    this.Jedn = Jedn;
    this.Firma = Firma;
    this.Nr_Mag = Nr_Mag;
    this.Nr_Odpadu = Nr_Odpadu;
    this.Nr_Klienta = Nr_Klienta;
        
    }
    
    String getNr_Karty(){
        return NrKarty;
    }
    
    String getDataD(){
        return DataD;
    }
    
    float getMasa(){
        return Masa;
    }
    
    String getJedn(){
        return Jedn;
    }
    
    String getFirma(){
        return Firma;
    }
    
    String getNr_Mag(){
        return Nr_Mag;
    }
    
    String getNr_Odpadu(){
        return Nr_Odpadu;
    }
    
    String getNr_Klienta(){
        return Nr_Klienta;
    }
    
       static ArrayList<Magazyn> toArrayList() throws IOException {
       BufferedReader br = new BufferedReader(new FileReader("Magazynp.csv")); 
       ArrayList<Magazyn> magazyn = new ArrayList<>();
        String currentLine;
        while((currentLine = br.readLine()) != null)
        {   
            String[] data = currentLine.split(";");
            if(data[0].equals("NRKARTY")) continue; //ignorowac naglowek
            String Nr_Karty = data[0];
            String DataD = data[1];
            float Masa = Float.parseFloat(data[2]);
            String Jedn = data[3];
            String Firma = data[4];
            String Nr_Mag = data[5];
            String Nr_Odpadu = data[6];
            String Nr_Klienta = data[7];
            magazyn.add(new Magazyn(Nr_Karty, DataD, Masa, Jedn, Firma, Nr_Mag, Nr_Odpadu, Nr_Klienta));
        }
        return magazyn;
    }
    
}
