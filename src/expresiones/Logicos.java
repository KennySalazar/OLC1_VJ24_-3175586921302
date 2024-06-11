/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import static expresiones.OperadoresRelacionales.DIFERENCIACION;
import static expresiones.OperadoresRelacionales.IGUALACION;
import static expresiones.OperadoresRelacionales.MAYOR_IGUAL_QUE;
import static expresiones.OperadoresRelacionales.MAYOR_QUE;
import static expresiones.OperadoresRelacionales.MENOR_IGUAL_QUE;
import static expresiones.OperadoresRelacionales.MENOR_QUE;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;
import static simbolo.tipoDato.BOOLEANO;
import static simbolo.tipoDato.CADENA;
import static simbolo.tipoDato.CARACTER;
import static simbolo.tipoDato.DECIMAL;
import static simbolo.tipoDato.ENTERO;

/**
 *
 * @author Kenny Salazar
 */
public class Logicos extends Instruccion {

    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresLogicos operacion;
    //private Instruccion operandoUnico;

    //negacion 
    /* public Relacionales (Instruccion operandoUnico, OperadoresAritmeticos operacion, int linea, int col) {
    super(new Tipo(tipoDato.ENTERO), linea, col);
    this.operacion = operacion;
    this.operandoUnico = operandoUnico;
    }*/
    //cualquier operacion menos negacion
    public Logicos(Instruccion operando1, Instruccion operando2, OperadoresLogicos operacion, int linea, int col) {
        super(new Tipo(tipoDato.ENTERO), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object opIzq = null, opDer = null, Unico = null;

        opIzq = this.operando1.interpretar(arbol, tabla);
        if (opIzq instanceof Errores) {
            return opIzq;
        }
        opDer = this.operando2.interpretar(arbol, tabla);
        if (opDer instanceof Errores) {
            return opDer;
        }

        return switch (operacion) {
            case OR ->
                this.or(opIzq, opDer);

            default ->
                new Errores("SEMANTICO", "Operador invalido", this.linea, this.col);
        };
    }

    //LOGICO OR
    public Object or(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {

                    default -> {
                        return new Errores("SEMANTICO", "Igualación erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            default -> {
                return new Errores("SEMANTICO", "IGUALACION TIPO 1 erronea", this.linea, this.col);
            }
        }

    }

}
