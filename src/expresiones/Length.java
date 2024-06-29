/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author Kenny Salazar
 */
public class Length extends Instruccion {

    private Instruccion expresion;

    public Length(Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.ENTERO), linea, col);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var resultado = this.expresion.interpretar(arbol, tabla);
        if (resultado instanceof Errores) {
            return resultado;
        }
        if (resultado instanceof LinkedList) {
            LinkedList<?> lista = (LinkedList<?>) resultado;
            return lista.size();
        } else if (resultado instanceof String) {
            String cadena = (String) resultado;
            return cadena.length();
        } else if (resultado.getClass().isArray()) {
            if (resultado instanceof Object[][]) {  
                return ((Object[][]) resultado).length;
            }
            return java.lang.reflect.Array.getLength(resultado);
        }
        return new Errores("SEMANTICO", "El parametro de la funcion length no es un vector, una lista o una cadena", this.linea, this.col);
    }
}
