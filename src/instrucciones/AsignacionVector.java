/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

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
            return new Errores("SEMANTICO", "El vector " + id + " no existe para la modificacion", this.linea, this.col);
        }

        
        if (!vector.isMutable()) {
            return new Errores("SEMANTICO", "No se puede modificar el vector " + id + " porque es de tipo CONSTANTE", this.linea, this.col);
        }

        //INTERPRETA LOS INDICES
        Object indiceValor1 = this.indice1.interpretar(arbol, tabla);
        Object indiceValor2 = this.indice2 != null ? this.indice2.interpretar(arbol, tabla) : null;

        
        if (!(indiceValor1 instanceof Integer)) {
            return new Errores("SEMANTICO", "El indice 1 del vector " + id + " debe ser de tipo entero", this.linea, this.col);
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
            return new Errores("SEMANTICO", "Índices fuera de los límites del vector " + id, this.linea, this.col);
        }

        // INTERPRETA EL NUEVO VALOR A ASIGNAR 
        Object nuevoValor = this.exp.interpretar(arbol, tabla);
        if (nuevoValor instanceof Errores) {
            return nuevoValor;
        }

        
        if (!esCompatible(vector.getTipo().getTipo(), nuevoValor)) {
            return new Errores("SEMANTICO", "Tipo incorrecto en la modificación del vector " + id, this.linea, this.col);
        }

        //ASIGNA EL NUEVO VALOR DEL VECTOR EN LA PISICION INDICADA
        try {
            if (indiceEntero2 == -1) {
                //SI TRAE -UNO, ES PORQUE ES UN VECTOR UNI
                ((Object[]) vector.getValor())[indiceEntero1] = nuevoValor;
            } else {
                
                ((Object[][]) vector.getValor())[indiceEntero1][indiceEntero2] = nuevoValor;
            }
        } catch (ArrayStoreException e) {
            return new Errores("SEMANTICO", "Tipo incompatible en la asignación del vector " + id, this.linea, this.col);
        }

        return null;
    }

   
    private boolean isValidIndex(Object vector, int index1, int index2) {
        if (vector instanceof Object[]) {
            
            return index1 >= 0 && index1 < ((Object[]) vector).length;
        } else if (vector instanceof Object[][]) {
            
            return index1 >= 0 && index1 < ((Object[][]) vector).length
                    && (index2 == -1 || (index2 >= 0 && index2 < ((Object[][]) vector)[index1].length));
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
