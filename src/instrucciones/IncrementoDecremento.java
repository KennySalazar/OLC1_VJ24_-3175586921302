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
public class IncrementoDecremento extends Instruccion {

    private String id;
    private boolean incremento; // true para incremento, false para decremento

    public IncrementoDecremento(String id, boolean incremento, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.incremento = incremento;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Simbolo variable = tabla.obtenerVariable(this.id);
        if (variable == null) {
            return new Errores("SEMANTICO", "La variable " + id + " no existe", this.linea, this.col);
        }

        if (!variable.isMutable()) {
            return new Errores("SEMANTICO", "La variable " + id + " es constante y no puede ser modificada", this.linea, this.col);
        }

        Object valor = variable.getValor();
        if (valor instanceof Integer) {
            int nuevoValor = (Integer) valor + (incremento ? 1 : -1);
            variable.setValor(nuevoValor);
        } else if (valor instanceof Double) {
            double nuevoValor = (Double) valor + (incremento ? 1.0 : -1.0);
            variable.setValor(nuevoValor);
        } else {
            return new Errores("SEMANTICO", "La variable " + id + " no es de tipo numérico", this.linea, this.col);
        }

        return null;
    }
}
