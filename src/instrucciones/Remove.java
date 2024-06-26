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
public class Remove extends Instruccion {

    private String identificador;
    private Instruccion indice;

    /**
     * Constructor para la instrucción de eliminar elemento de una lista.
     *
     * @param identificador Identificador de la lista.
     * @param indice Expresión que representa el índice del elemento a eliminar.
     * @param linea Línea donde se realiza la operación.
     * @param col Columna donde se realiza la operación.
     */
    public Remove(String identificador, Instruccion indice, int linea, int col) {
        super(null, linea, col); // No devuelve ningún valor específico
        this.identificador = identificador;
        this.indice = indice;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Simbolo s = tabla.obtenerVariable(identificador);

        if (s == null) {
            return new Errores("SEMANTICO", "La lista " + identificador + " no existe", this.linea, this.col);
        }

        Object indiceValor = indice.interpretar(arbol, tabla);
        if (!(indiceValor instanceof Integer)) {
            return new Errores("SEMANTICO", "El indice debe ser de tipo entero", this.linea, this.col);
        }

        int index = (int) indiceValor;
        LinkedList<Object> lista = (LinkedList<Object>) s.getValor();

        if (index < 0 || index >= lista.size()) {
            return new Errores("SEMANTICO", "El indice esta fuera de los limites de la lista " + identificador, this.linea, this.col);
        }

        // Eliminar el elemento de la lista
        lista.remove(index);

        // Actualizar el valor en la tabla de símbolos
        s.setValor(lista);

        return null;
    }
}
