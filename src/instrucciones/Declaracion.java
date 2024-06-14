/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.Simbolo;
import static simbolo.Simbolo.getDefaultValor;
import simbolo.Tipo;
import simbolo.tablaSimbolos;

/**
 *
 * @author Kenny Salazar
 */
public class Declaracion extends Instruccion {

    private String identificador;
    private Instruccion valor;
    private boolean mutabilidad;
   

    // Constructor con mutabilidad, identificador y tipo
    public Declaracion(String identificador, Tipo tipo, boolean mutabilidad, int linea, int col) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.mutabilidad = mutabilidad;
    }

    // Constructor con mutabilidad, identificador, tipo e instrucción
    public Declaracion(String identificador, Instruccion valor, Tipo tipo, boolean mutabilidad, int linea, int col) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.valor = valor;
        this.mutabilidad = mutabilidad;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // Interpretar la expresión si se proporciona
        Object valorInterpretado = valor != null ? this.valor.interpretar(arbol, tabla) : getDefaultValor(this.tipo);
        

        // Validar errores
        if (valorInterpretado instanceof Errores) {
            return valorInterpretado;
        }

        // Validar tipos si se proporciona valor
        if (valor != null && this.valor.tipo.getTipo() != this.tipo.getTipo()) {
            return new Errores("SEMANTICO", "El valor " + this.valor.tipo.getTipo()
                    + " y el tipo " + this.tipo.getTipo() + " no son compatibles", this.linea, this.col);
        }

        Simbolo s = new Simbolo(this.tipo, this.identificador, valorInterpretado, this.mutabilidad);

        boolean creacion = tabla.crearVariable(s);
        if (!creacion) {
            return new Errores("SEMANTICO", "La variable " + identificador + " ya existe ", this.linea, this.col);
        }

        return null;
    }
}
