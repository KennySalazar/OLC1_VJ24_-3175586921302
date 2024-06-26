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
public class Append extends Instruccion {

    private String identificador;
    private Instruccion elemento;

    public Append(String identificador, Instruccion elemento, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.identificador = identificador;
        this.elemento = elemento;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Simbolo s = tabla.obtenerVariable(identificador);

        if (s == null) {
            return new Errores("SEMANTICO", "La lista " + identificador + " no existe", this.linea, this.col);
        }

        Object valorInterpretado = elemento.interpretar(arbol, tabla);
        if (valorInterpretado instanceof Errores) {
            return valorInterpretado;
        }

        if (!verificarTipo(valorInterpretado, s.getTipo())) {
            return new Errores("SEMANTICA", "Tipo de dato incorrecto al agregar elemento a la lista", this.linea, this.col);
        }

        ((LinkedList<Object>) s.getValor()).add(valorInterpretado);
        return null;
    }

    private boolean verificarTipo(Object valor, Tipo tipo) {
        switch (tipo.getTipo()) {
            case ENTERO:
                return valor instanceof Integer;
            case DECIMAL:
                return valor instanceof Double;
            case CADENA:
                return valor instanceof String;
            case BOOLEANO:
                return valor instanceof Boolean;
            case CARACTER:
                return valor instanceof Character;
            default:
                return false;
        }
    }
}
