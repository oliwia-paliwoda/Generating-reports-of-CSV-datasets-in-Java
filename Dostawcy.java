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

public class Dostawcy {
 
    private final String Nr_Klienta;
    private final String Miejscowosc;
    private final String Ulica;
    private final String Nazwa_Skrocona;
    
    public Dostawcy(String Nr_klienta, String Miejscowosc, String Ulica, String Nazwa_Skrocona){
        
        this.Nr_Klienta = Nr_klienta;
        this.Miejscowosc = Miejscowosc;
        this.Ulica = Ulica;
        this.Nazwa_Skrocona = Nazwa_Skrocona;
    }
    
    String getNr_Klienta(){
        return Nr_Klienta;
    }
    
    String getMiejscowosc(){
        return Miejscowosc;
    }
    
    String getUlica(){
        return Ulica;
    }
    
    String getNazwa_Skrocona(){
        return Nazwa_Skrocona;
    }
    
    static ArrayList<Dostawcy> toArrayList() throws IOException {
       BufferedReader br = new BufferedReader(new FileReader("Dostawcy.csv")); 
       ArrayList<Dostawcy> dostawcy = new ArrayList<>();
        String currentLine;
        while((currentLine = br.readLine()) != null)
        {   
            String[] data = currentLine.split(";");
            if(data[0].equals("NRKLIENTA")) continue; //ignorowac naglowek
            String Nr_klienta=data[0];
            String Miejscowosc=data[1];
            String Ulica=data[2];
            String Nazwa_Skrocona=data[3];
            dostawcy.add(new Dostawcy(Nr_klienta,Miejscowosc,Ulica,Nazwa_Skrocona));
        }
        return dostawcy;
    }
    
    @Override
    public String toString(){
        return "\nNR KLIENTA: "+Nr_Klienta + " MIEJSCOWOSC:"+Miejscowosc+" ULICA:"+ Ulica+ " NAZWA SKROCONA: "+ Nazwa_Skrocona;
    }
    
   
}
