/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Simbolo;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author Kenny Salazar
 */
public class AsignacionVector extends Instruccion {

    private String id;
    private Instruccion indice1;
    private Instruccion indice2;
    private Instruccion exp;

    public AsignacionVector(String id, Instruccion indice1, Instruccion exp, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.indice1 = indice1;
        this.exp = exp;
        this.indice2 = null;
    }

    public AsignacionVector(String id, Instruccion indice1, Instruccion indice2, Instruccion exp, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.indice1 = indice1;
        this.indice2 = indice2;
        this.exp = exp;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Simbolo vector = tabla.obtenerVariable(id);
        if (vector == null) {
            return new Errores("SEMANTICO", "El vector o lista " + id + " no existe para la modificacion", this.linea, this.col);
        }

        if (!vector.isMutable()) {
            return new Errores("SEMANTICO", "No se puede modificar el vector o lista " + id + " porque es de tipo CONSTANTE", this.linea, this.col);
        }

        // Interpretar los índices
        Object indiceValor1 = this.indice1.interpretar(arbol, tabla);
        Object indiceValor2 = this.indice2 != null ? this.indice2.interpretar(arbol, tabla) : null;

        if (!(indiceValor1 instanceof Integer)) {
            return new Errores("SEMANTICO", "El indice 1 del vector o lista " + id + " debe ser de tipo entero", this.linea, this.col);
        }

        int indiceEntero1 = (int) indiceValor1;
        int indiceEntero2 = -1;

        if (indiceValor2 != null && !(indiceValor2 instanceof Integer)) {
            return new Errores("SEMANTICO", "El indice 2 del vector " + id + " debe ser de tipo entero", this.linea, this.col);
        }

        if (indiceValor2 != null) {
            indiceEntero2 = (int) indiceValor2;
        }

        if (!isValidIndex(vector.getValor(), indiceEntero1, indiceEntero2)) {
            return new Errores("SEMANTICO", "Indices fuera de los limites del vector o lista " + id, this.linea, this.col);
        }

        // Interpretar el nuevo valor a asignar
        Object nuevoValor = this.exp.interpretar(arbol, tabla);
        if (nuevoValor instanceof Errores) {
            return nuevoValor;
        }

        if (!esCompatible(vector.getTipo().getTipo(), nuevoValor)) {
            return new Errores("SEMANTICO", "Tipo incorrecto en la modificacion del vector o lista " + id, this.linea, this.col);
        }

        // Asignar el nuevo valor en la posición indicada
        try {
            if (vector.getValor() instanceof LinkedList) {
                // Si es una lista
                LinkedList<Object> lista = (LinkedList<Object>) vector.getValor();
                lista.set(indiceEntero1, nuevoValor);
            } else if (vector.getValor() instanceof Object[]) {
                // Si es un vector unidimensional
                ((Object[]) vector.getValor())[indiceEntero1] = nuevoValor;
            } else if (vector.getValor() instanceof Object[][]) {
                // Si es un vector bidimensional
                ((Object[][]) vector.getValor())[indiceEntero1][indiceEntero2] = nuevoValor;
            } else {
                return new Errores("SEMANTICO", id + " no es un vector o lista valida", this.linea, this.col);
            }
        } catch (ArrayStoreException e) {
            return new Errores("SEMANTICO", "Tipo incompatible en la asignacion del vector o lista " + id, this.linea, this.col);
        }

        return null;
    }

    private boolean isValidIndex(Object vector, int index1, int index2) {
        if (vector instanceof Object[]) {
            return index1 >= 0 && index1 < ((Object[]) vector).length;
        } else if (vector instanceof Object[][]) {
            return index1 >= 0 && index1 < ((Object[][]) vector).length
                    && (index2 == -1 || (index2 >= 0 && index2 < ((Object[][]) vector)[index1].length));
        } else if (vector instanceof LinkedList) {
            return index1 >= 0 && index1 < ((LinkedList) vector).size();
        }
        return false;
    }

    private boolean esCompatible(tipoDato vectorTipo, Object newValue) {
        switch (vectorTipo) {
            case ENTERO:
                return newValue instanceof Integer;
            case CADENA:
                return newValue instanceof String;
            case BOOLEANO:
                return newValue instanceof Boolean;
            case CARACTER:
                return newValue instanceof Character;
            case DECIMAL:
                return newValue instanceof Double;
            default:
                return false;
        }
    }
}
