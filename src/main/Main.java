/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import abstracto.Instruccion;
import analisis.parser;
import analisis.scanner;
import com.mycompany.proyecto_compi1.vista.EditorPrincipal;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.tablaSimbolos;

/**
 *
 * @author Kenny Salazar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EditorPrincipal vista = new EditorPrincipal();
        vista.setVisible(true);
        vista.setEnabled(true);
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);
        vista.setTitle("JAVACRAFT");


    }

}
