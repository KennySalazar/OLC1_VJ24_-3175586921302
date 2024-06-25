/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.Simbolo;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author Kenny Salazar
 */
public class AccesoVector extends Instruccion {

    private String id;
    private Instruccion expresion;
    private Instruccion expresionBi;

    // Constructor para acceso unidimensional
    public AccesoVector(String id, Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expresion = expresion;
        this.expresionBi = null;
    }

    // Constructor para acceso bidimensional
    public AccesoVector(String id, Instruccion expresion, Instruccion expresionBi, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.expresion = expresion;
        this.expresionBi = expresionBi;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Simbolo simbolo = tabla.obtenerVariable(this.id);
        if (simbolo == null) {
            return new Errores("SEMANTICA", "El vector " + id + " no existe", this.linea, this.col);
        }

        if (!(simbolo.getValor() instanceof Object[])) {
            return new Errores("SEMANTICA", id + " no es un vector", this.linea, this.col);
        }

        // INTERPRETA EL PRIMER INDICE
        Object indice1 = expresion.interpretar(arbol, tabla);
        if (!(indice1 instanceof Integer)) {
            return new Errores("SEMANTICA", "El indice de acceso debe ser de tipo entero", this.linea, this.col);
        }

        int indice1Int = (Integer) indice1;
        Object[] vector = (Object[]) simbolo.getValor();

        if (indice1Int < 0 || indice1Int >= vector.length) {
            return new Errores("SEMANTICA", "Indice fuera de los limites del vector", this.linea, this.col);
        }

        Object valor = vector[indice1Int];

        //SI HAY UN SEGUNDO INDICE, ES UN VECTOR BI
        if (expresionBi != null) {
            if (!(valor instanceof Object[])) {
                return new Errores("SEMANTICA", "El elemento accedido no es un vector", this.linea, this.col);
            }

            Object indice2 = expresionBi.interpretar(arbol, tabla);
            if (!(indice2 instanceof Integer)) {
                return new Errores("SEMANTICA", "El indice de acceso debe ser de tipo entero", this.linea, this.col);
            }

            int indice2Int = (Integer) indice2;
            Object[] subVector = (Object[]) valor;

            if (indice2Int < 0 || indice2Int >= subVector.length) {
                return new Errores("SEMANTICA", "Indice fuera de los limites del vector", this.linea, this.col);
            }

            valor = subVector[indice2Int];
        }

        this.tipo = new Tipo(simbolo.getElementType());
        return valor;
    }
}
