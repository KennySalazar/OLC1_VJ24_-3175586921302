/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

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
public class Find extends Instruccion {

    private String identificador;
    private Instruccion expresion;

    public Find(String identificador, Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.BOOLEANO), linea, col);
        this.identificador = identificador;
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Simbolo simbolo = tabla.obtenerVector(this.identificador);
        if (simbolo == null) {
            return new Errores("SEMANTICO", "El identificador " + this.identificador + " no existe", this.linea, this.col);
        }

        Object elemento = simbolo.getValor();
        if (!(elemento instanceof LinkedList || elemento.getClass().isArray())) {
            return new Errores("SEMANTICO", "El identificador " + this.identificador + " no es un vector o lista", this.linea, this.col);
        }

        Object valorBuscar = this.expresion.interpretar(arbol, tabla);
        if (valorBuscar instanceof Errores) {
            return valorBuscar;
        }

        if (elemento instanceof LinkedList) {
            LinkedList<?> lista = (LinkedList<?>) elemento;
            for (Object item : lista) {
                if (item.equals(valorBuscar)) {
                    return true;
                }
            }
        } else if (elemento.getClass().isArray()) {
            if (elemento instanceof Object[][]) {  
                Object[][] arrayBidimensional = (Object[][]) elemento;
                for (Object[] fila : arrayBidimensional) {
                    for (Object item : fila) {
                        if (item.equals(valorBuscar)) {
                            return true;
                        }
                    }
                }
            } else {
                int length = java.lang.reflect.Array.getLength(elemento);
                for (int i = 0; i < length; i++) {
                    Object item = java.lang.reflect.Array.get(elemento, i);
                    if (item.equals(valorBuscar)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
