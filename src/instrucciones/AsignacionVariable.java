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
//MODIFICAR LA VARIABLE
public class AsignacionVariable extends Instruccion {

    private String id;
    private Instruccion exp;

    public AsignacionVariable(String id, Instruccion exp, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.exp = exp;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // Verificar si la variable existe
        var variable = tabla.obtenerVariable(id);
        if (variable == null) {
            return new Errores("SEMANTICO", "La Variable " + id + " no existe para la modificacion", this.linea, this.col);
        }

        // Verificar si la variable es mutable
        if (!variable.isMutable()) {
            return new Errores("SEMANTICO", "No se puede modificar la variable " + id + " porque es de tipo CONSTANTE", this.linea, this.col);
        }

        // Interpretar el nuevo valor a asignar
        var newValor = this.exp.interpretar(arbol, tabla);
        if (newValor instanceof Errores) {
            return newValor;
        }

        // Validar tipos
        if (variable.getTipo().getTipo() != this.exp.tipo.getTipo()) {
            return new Errores("SEMANTICO", "Tipos erroneos en la modificacion de la varible", this.linea, this.col);
        }

        this.tipo.setTipo(variable.getTipo().getTipo());
        variable.setValor(newValor);
        return null;
    }
}
