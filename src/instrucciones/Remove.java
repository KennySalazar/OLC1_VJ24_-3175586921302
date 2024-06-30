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

    public Remove(String identificador, Instruccion indice, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
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

        
        Object valorEliminado = lista.remove(index);

       
        s.setValor(lista);

        
        if (valorEliminado instanceof Integer) {
            this.tipo.setTipo(tipoDato.ENTERO);
        } else if (valorEliminado instanceof Double) {
            this.tipo.setTipo(tipoDato.DECIMAL);
        } else if (valorEliminado instanceof Character) {
            this.tipo.setTipo(tipoDato.CARACTER);
        } else if (valorEliminado instanceof String) {
            this.tipo.setTipo(tipoDato.CADENA);
        } else if (valorEliminado instanceof Boolean) {
            this.tipo.setTipo(tipoDato.BOOLEANO);
        } else {
            return new Errores("SEMANTICO", "Tipo de dato no soportado", this.linea, this.col);
        }

        return valorEliminado;
    }
}
