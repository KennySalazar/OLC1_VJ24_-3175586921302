/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import Reportes.TablaSimbolosReporte;
import abstracto.Instruccion;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Simbolo;
import simbolo.Tipo;
import simbolo.tablaSimbolos;

/**
 *
 * @author Kenny Salazar
 */
public class DeclaracionLista extends Instruccion {

    private String identificador;

    public DeclaracionLista(String identificador, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.identificador = identificador;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        
        Simbolo s = new Simbolo(this.tipo, this.identificador, new LinkedList<>(), true);

      
        boolean creacion = tabla.crearArreglo(s);
        if (!creacion) {
            return new Errores("SEMANTICO", "La lista " + identificador + " ya existe", this.linea, this.col);
        } else {
            if (!arbol.isVariableReported(s.getId(), tabla.getNombre(), "" + this.linea, "" + this.col)) {
                arbol.getListaReportes().add(new TablaSimbolosReporte(s.getId(), "variable", s.getTipo().getTipo().toString(), tabla.getNombre(), s.getValor().toString(), "" + this.linea, "" + this.col));
            }
        }

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
