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
public class ToString extends Instruccion {

    private Instruccion expresion;

    public ToString(Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.CADENA), linea, col);
        this.expresion = expresion;
    }

 
    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var resultado = this.expresion.interpretar(arbol, tabla);
        if (resultado instanceof Errores) {
            return resultado;
        }

        // Imprimir el tipo y valor del resultado para depuración
        System.out.println("Resultado: " + resultado + " Tipo: " + resultado.getClass().getSimpleName());

        // Simplemente devolver el valor convertido a String
        return resultado.toString();
    }
}