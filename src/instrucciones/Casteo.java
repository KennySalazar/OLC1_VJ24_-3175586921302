/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author Kenny Salazar
 */
public class Casteo extends Instruccion {
    
    private Instruccion expresion;
    private Tipo tipoDestino;

    public Casteo(Instruccion expresion, Tipo tipoDestino, int linea, int col) {
        super(tipoDestino, linea, col);
        this.expresion = expresion;
        this.tipoDestino = tipoDestino;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object valorInterpretado = this.expresion.interpretar(arbol, tabla);
        if (valorInterpretado instanceof Errores) {
            return valorInterpretado;
        }

        Tipo tipoOrigen = this.expresion.tipo;

        try {
            switch (tipoOrigen.getTipo()) {
                case ENTERO:
                    if (tipoDestino.getTipo() == tipoDato.DECIMAL) {
                        return ((Integer) valorInterpretado).doubleValue();
                    } else if (tipoDestino.getTipo() == tipoDato.CARACTER) {
                        return (char) ((Integer) valorInterpretado).intValue();
                    }
                    break;

                case DECIMAL:
                    if (tipoDestino.getTipo() == tipoDato.ENTERO) {
                        return ((Double) valorInterpretado).intValue();
                    }
                    break;

                case CARACTER:
                    if (tipoDestino.getTipo() == tipoDato.ENTERO) {
                        return (int) ((Character) valorInterpretado).charValue();
                    } else if (tipoDestino.getTipo() == tipoDato.DECIMAL) {
                        return (double) ((Character) valorInterpretado).charValue();
                    }
                    break;

                default:
                    return new Errores("SEMANTICO", "Tipo de casteo no soportado", this.linea, this.col);
            }
        } catch (Exception e) {
            return new Errores("SEMANTICO", "Error en el casteo: " + e.getMessage(), this.linea, this.col);
        }

        return new Errores("SEMANTICO", "Casteo inválido desde " + tipoOrigen.getTipo() + " a " + tipoDestino.getTipo(), this.linea, this.col);
    }
}