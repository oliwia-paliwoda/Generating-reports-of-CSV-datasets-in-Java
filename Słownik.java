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

public class Słownik {
    
    private final String Gr;
    private final String Podgr;
    private final String Rodz;
    private final String Typ;
    private final String Opis;
    private final String Nr_Odpadu;

    public Słownik(String Gr, String Podgr, String Rodz, String Typ, String Opis, String Nr_Odpadu) {
  
        this.Gr = Gr;
        this.Podgr = Podgr;
        this.Rodz = Rodz;
        this.Typ = Typ;
        this.Opis = Opis;
        this.Nr_Odpadu = Nr_Odpadu;
}
     String getGr(){
        return Gr;
    }
     
      String getPodgr(){
        return Podgr;
    }
      
       String getRodz(){
        return Rodz;
    }
       
        String getTyp(){
        return Typ;
    }
        
         String getOpis(){
        return Opis;
    }
         
          String getNr_Odpadu(){
        return Nr_Odpadu;
    }
    
     static ArrayList<Słownik> toArrayList() throws IOException {
       BufferedReader br = new BufferedReader(new FileReader("Slownik.csv")); 
       ArrayList<Słownik> słownik = new ArrayList<>();
        String currentLine;
        while((currentLine = br.readLine()) != null)
        {   
            String[] data = currentLine.split(";");
            if(data[0].equals("GR")) continue; //ignorowac naglowek
            String Gr=data[0];
            String Podgr=data[1];
            String Rodz=data[2];
            String Typ=data[3];
            String Opis=data[4];
            String Nr_Odpadu=data[5];
            słownik.add(new Słownik(Gr, Podgr, Rodz, Typ, Opis, Nr_Odpadu));
        }
        return słownik;
    }
    
}

