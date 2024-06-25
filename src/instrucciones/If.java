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
// IF (EXP) {<LISTA_INSTRUCCIONES>}
public class If extends Instruccion {

    private Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;
    private LinkedList<Instruccion> instruccionesElse;
    private Instruccion elseIf;

    // Constructor para if simple
    public If(Instruccion condicion, LinkedList<Instruccion> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this.instruccionesElse = null;
        this.elseIf = null;
    }

    // Constructor para if con else
    public If(Instruccion condicion, LinkedList<Instruccion> instrucciones, LinkedList<Instruccion> instruccionesElse, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this.instruccionesElse = instruccionesElse;
        this.elseIf = null;
    }

    // Constructor para if con else if
    public If(Instruccion condicion, LinkedList<Instruccion> instrucciones, Instruccion elseIf, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this.instruccionesElse = null;
        this.elseIf = elseIf;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var cond = this.condicion.interpretar(arbol, tabla);
        if (cond instanceof Errores) {
            return cond;
        }

        // Verifica si la condición es una cadena y la convierte a boolean
        if (cond instanceof String) {
            String condString = (String) cond;
            if (condString.equals("true")) {
                cond = true;
            } else if (condString.equals("false")) {
                cond = false;
            } else {
                return new Errores("SEMANTICO", "Expresion invalida: no es un valor booleano",
                        this.linea, this.col);
            }
        }

        // Verifica que la condición sea booleano
        if (!(cond instanceof Boolean)) {
            return new Errores("SEMANTICO", "Expresion invalida: se esperaba un booleano",
                    this.linea, this.col);
        }

        var newTabla = new tablaSimbolos(tabla);
        newTabla.setNombre("If");
        if ((boolean) cond) {
            for (var i : this.instrucciones) {
                if (i instanceof Break) {
                    return i;
                }

                if (i instanceof Continue) {
                    return i;
                }
                var resultado = i.interpretar(arbol, newTabla);

                if (i instanceof Break) {
                    return i;
                }
                if (i instanceof Continue) {
                    return i;
                }
                if (resultado instanceof Errores) {
                    return resultado;
                }
            }
        } else {
            // Maneja el else if
            if (this.elseIf != null) {
                return this.elseIf.interpretar(arbol, tabla);
            }
            // Maneja solo el else
            if (this.instruccionesElse != null) {
                for (var i : this.instruccionesElse) {
                    if (i instanceof Break) {
                        return i;
                    }
                    if (i instanceof Continue) {
                        return i;
                    }
                    var resultado = i.interpretar(arbol, newTabla);
                    if (i instanceof Break) {
                        return i;
                    }
                    if (i instanceof Continue) {
                        return i;
                    }
                    if (resultado instanceof Errores) {
                        return resultado;
                    }
                }
            }
        }
        return null;
    }
}
