/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

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
public class Round extends Instruccion {

    private Instruccion expresion;

    public Round(Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.ENTERO), linea, col); 
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var resultado = this.expresion.interpretar(arbol, tabla);
        if (resultado instanceof Errores) {
            return resultado;
        }
        if (resultado instanceof Double) {
            double valor = (Double) resultado;
            int redondeado = (int) Math.round(valor);
            return redondeado;
        }
        return new Errores("SEMANTICO", "La expresion a redondear no es un numero decimal", this.linea, this.col);
    }
}
