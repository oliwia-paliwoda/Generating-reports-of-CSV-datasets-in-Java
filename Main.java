/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.java_projekt_2;

/**
 *
 * @author oliwia
 */

import java.io.*;
import java.util.*;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    
    public static void main(String[] args) throws IOException {
        
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Prosze wybrac metode sortowania: \n1 - po Nr Karty \n2- po Kodzie \n3- po Firmie \n4 - Bez sortowania");
        while (true) {
        n = sc.nextInt();
        if(n < 1 || n > 5) {
        System.out.println("Zla opcja, prosze podac poprawna");
        continue;
        }
        break;
        }
            ArrayList<Zestawienie> zestawienie = Zestawienie.generateZestawienie();
            switch(n){
                case 1:
                    Zestawienie.SortByNr_Karty(zestawienie);
                    Zestawienie.DisplayToConsole(zestawienie);
                    break;
                case 2:
                    Zestawienie.SortByKod(zestawienie);
                    Zestawienie.DisplayToConsole(zestawienie);
                    break;
                case 3:
                    Zestawienie.SortByFirma(zestawienie);
                    Zestawienie.DisplayToConsole(zestawienie);
                    break;
                case 4:
                    Zestawienie.DisplayToConsole(zestawienie);
            }
        
        
        sc.close();
    }
}
    
 

    

