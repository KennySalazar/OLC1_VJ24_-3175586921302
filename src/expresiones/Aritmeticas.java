/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.*;
import static simbolo.tipoDato.BOOLEANO;
import static simbolo.tipoDato.CADENA;
import static simbolo.tipoDato.CARACTER;
import static simbolo.tipoDato.DECIMAL;
import static simbolo.tipoDato.ENTERO;

/**
 *
 * @author Kenny Salazar
 */
/*
- E
E + E
E - E
 */
public class Aritmeticas extends Instruccion {

    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresAritmeticos operacion;
    private Instruccion operandoUnico;

    //negacion 
    public Aritmeticas(Instruccion operandoUnico, OperadoresAritmeticos operacion, int linea, int col) {
        super(new Tipo(tipoDato.ENTERO), linea, col);
        this.operacion = operacion;
        this.operandoUnico = operandoUnico;
    }

    //cualquier operacion menos negacion
    public Aritmeticas(Instruccion operando1, Instruccion operando2, OperadoresAritmeticos operacion, int linea, int col) {
        super(new Tipo(tipoDato.ENTERO), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object opIzq = null, opDer = null, Unico = null;
        if (this.operandoUnico != null) {
            Unico = this.operandoUnico.interpretar(arbol, tabla);
            if (Unico instanceof Errores) {
                return Unico;
            }
        } else {
            opIzq = this.operando1.interpretar(arbol, tabla);
            if (opIzq instanceof Errores) {
                return opIzq;
            }
            opDer = this.operando2.interpretar(arbol, tabla);
            if (opDer instanceof Errores) {
                return opDer;
            }
        }

        return switch (operacion) {
            case SUMA ->
                this.suma(opIzq, opDer);
            case NEGACION ->
                this.negacion(Unico);
            default ->
                new Errores("SEMANTICO", "Operador invalido", this.linea, this.col);
        };
    }

    public Object suma(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    //ENTERO + ENTERO = ENTERO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        return (int) op1 + (int) op2;
                    }
                    //ENTERO + DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) op1 + (double) op2;
                    }
                    // ENTERO + CARACTER = ENTER0
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.ENTERO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (int) op1 + new Integer(num2);

                    }
                    //ENTERO + CADENA = CADENA
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    //DECIMAL + ENTERO = DECIMAL
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 + (int) op2;
                    }
                    //DECIMAL + DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 + (double) op2;
                    }
                    //DECIMAL + CARACTER = DECIMAL
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (double) op1 + new Double(num2);

                    }
                    //DECIMAL + CADENA = CADENA
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);
                    }
                }
            }
            case BOOLEANO -> {
                switch (tipo2) {
                    //BOOLEAN + CADENA = CADENA
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);
                    }
                }
            }
            case CARACTER -> {
                switch (tipo2) {
                    //CARACTER + ENTERO = DECIMAL
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) + (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) + (double) op2;
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();

                    }
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();

                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch (tipo2) {
                    
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                     case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();
                    }
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();

                    }
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.CADENA);
                        return op1.toString() + op2.toString();

                    }
                    default -> {
                        return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);

            }

        }
    }

    public Object negacion(Object op1) {
        var opU = this.operandoUnico.tipo.getTipo();
        switch (opU) {
            case ENTERO -> {
                this.tipo.setTipo(tipoDato.ENTERO);
                return (int) op1 * -1;
            }
            case DECIMAL -> {
                this.tipo.setTipo(tipoDato.DECIMAL);
                return (double) op1 * -1;
            }
            default -> {
                return new Errores("SEMANTICO", "Negacion erronea", this.linea, this.col);
            }
        }
    }

}
