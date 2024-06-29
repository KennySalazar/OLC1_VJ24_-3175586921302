/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import java.util.HashMap;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;

/**
 *
 * @author Kenny Salazar
 */
public class Funcion extends Instruccion {

    public String id;
    public LinkedList<HashMap> parametros;
    public LinkedList<Instruccion> instrucciones;

    public Funcion(String id, LinkedList<HashMap> parametros, LinkedList<Instruccion> instrucciones, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
        this.parametros = parametros;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object resultado = null;
        for (Instruccion instruccion : this.instrucciones) {
            resultado = instruccion.interpretar(arbol, tabla);
            // Manejar casos como errores, break, continue si es necesario
        }
        return resultado; 
    }
}
