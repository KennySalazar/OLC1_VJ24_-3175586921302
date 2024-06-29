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
public class Return extends Instruccion {

    private Instruccion expresionRetorno;

  
    public Return(Instruccion expresionRetorno, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresionRetorno = expresionRetorno;
        if (expresionRetorno != null) {
            this.tipo.setTipo(expresionRetorno.tipo.getTipo());
        }
    }

    public Return(int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresionRetorno = null;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        if (this.expresionRetorno != null) {
            return expresionRetorno.interpretar(arbol, tabla);
        }
        return null; 
    }
}
