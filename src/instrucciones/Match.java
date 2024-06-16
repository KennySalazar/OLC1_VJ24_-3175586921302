/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

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
public class Match extends Instruccion {

    private Instruccion expresion;
    private LinkedList<Caso> casos;
    private Caso defaultCaso; // null si no hay caso default

    // Constructor para match con casos y default
    public Match(Instruccion expresion, LinkedList<Caso> casos, Caso defaultCaso, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresion = expresion;
        this.casos = casos;
        this.defaultCaso = defaultCaso;
    }

    // Constructor para match solo con casos
    public Match(Instruccion expresion, LinkedList<Caso> casos, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresion = expresion;
        this.casos = casos;
        this.defaultCaso = null;
    }

    // Constructor para match solo con default
    public Match(Instruccion expresion, Caso defaultCaso, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresion = expresion;
        this.casos = new LinkedList<>();
        this.defaultCaso = defaultCaso;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object valorExpresion = expresion.interpretar(arbol, tabla);
        if (valorExpresion instanceof Errores) {
            return valorExpresion;
        }

          var newTabla = new tablaSimbolos(tabla); // nuevo enterno
          

        // recorre los casos  y ejecuta el que coincida
        for (Caso caso : casos) {
            Object valorCaso = caso.getExpresion().interpretar(arbol, tabla);
            if (valorCaso instanceof Errores) {
                return valorCaso;
            }

            var newTabla2 = new tablaSimbolos(newTabla);
              newTabla2.setNombre("Match");
            // Si los valores de la expresión y del caso coinciden, interpreta el caso
            if (valorExpresion.equals(valorCaso)) {
                Object resultado = caso.interpretar(arbol, newTabla2);
                if (resultado instanceof Errores) {
                    return resultado;
                }
                return resultado; 
            }
        }

        // Si no se encontro un caso coincidente, ejecuta el caso default si existe
        if (defaultCaso != null) {
            return defaultCaso.interpretar(arbol, tabla);
        }

        // Devuelve null si ningun caso coincide y no hay caso default
        return null;
    }
}
