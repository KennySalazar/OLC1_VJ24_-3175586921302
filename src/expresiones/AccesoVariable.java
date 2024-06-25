/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import instrucciones.Casteo;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author Kenny Salazar
 */
public class AccesoVariable extends Instruccion {

    private String id;
    private Tipo tipoDestino;

    
    public AccesoVariable(String id, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.tipoDestino = null;
    }

    
    public AccesoVariable(String id, Tipo tipoDestino, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.tipoDestino = tipoDestino;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var valor = tabla.obtenerVariable(this.id);
        if (valor == null) {
            return new Errores("SEMANTICA", "La variable " + id + " no existe para tener su valor",
                    this.linea, this.col);
        }
        this.tipo.setTipo(valor.getTipo().getTipo());
        Object valorInterpretado = valor.getValor();

        if (this.tipoDestino != null) {
            // Realizar casteo si el tipoDestino no es nulo
            Casteo casteo = new Casteo(new Convertidor(valor.getTipo(), valorInterpretado, this.linea, this.col), this.tipoDestino, this.linea, this.col);
            valorInterpretado = casteo.interpretar(arbol, tabla);
            if (valorInterpretado instanceof Errores) {
                return valorInterpretado;
            }
            this.tipo.setTipo(this.tipoDestino.getTipo());
        }

        return valorInterpretado;
    }
}
