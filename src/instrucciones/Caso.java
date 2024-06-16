/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author Kenny Salazar
 */
public class Caso extends Instruccion {

    private Instruccion expresion;
    private LinkedList<Instruccion> listaInstrucciones;
    private boolean esDefault;

    public Caso(Instruccion expresion, LinkedList<Instruccion> listaInstrucciones, boolean esDefault, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresion = expresion;
        this.listaInstrucciones = listaInstrucciones;
        this.esDefault = esDefault;
    }

    public Instruccion getExpresion() {
        return expresion;
    }

    public LinkedList<Instruccion> getListaInstrucciones() {
        return listaInstrucciones;
    }

    public boolean isDefault() {
        return esDefault;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        if (listaInstrucciones != null && !listaInstrucciones.isEmpty()) {
            // recorre todas las instrucciones y las ejecuta
            for (Instruccion instruccion : listaInstrucciones) {
                
                Object result = instruccion.interpretar(arbol, tabla);
                if (result instanceof Errores) {
                    return result;
                }
            }
        }
        return null;
    }
}
