/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import static expresiones.OperadoresAritmeticos.DIVISION;
import static expresiones.OperadoresAritmeticos.MULTIPLICACION;
import static expresiones.OperadoresAritmeticos.NEGACION;
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
            case RESTA ->
                this.resta(opIzq, opDer);
            case MULTIPLICACION ->
                this.multiplicacion(opIzq, opDer);
            case DIVISION ->
                this.division(opIzq, opDer);
            case POTENCIA->
                this.potencia(opIzq, opDer);
            case MODULO ->
                this.modulo(opIzq, opDer);
            default ->
                new Errores("SEMANTICO", "Operador invalido", this.linea, this.col);
        };
    }

    //OPERACION DE SUMA
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
                        return new Errores("SEMANTICO", "Suma erronea con tipo no soportado: " + tipo2, this.linea, this.col);
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
                        return new Errores("SEMANTICO", "Suma erronea con tipo no soportado: " + tipo2, this.linea, this.col);
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
                        return new Errores("SEMANTICO", "Suma erronea con tipo no soportado: " + tipo2, this.linea, this.col);
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
                        return new Errores("SEMANTICO", "Suma erronea con tipo no soportado: " + tipo2, this.linea, this.col);
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
                        return new Errores("SEMANTICO", "Suma erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            default -> {
                return new Errores("SEMANTICO", "Suma erronea", this.linea, this.col);

            }

        }
    }

    //OPERACIÓN RESTA
    public Object resta(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    //ENTERO - ENTERO = ENTERO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        return (int) op1 - (int) op2;
                    }
                    //ENTERO - DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) op1 - (double) op2;
                    }
                    // ENTERO - CARACTER = ENTER0
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.ENTERO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (int) op1 - new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Resta erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    //DECIMAL - ENTERO = DECIMAL
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 - (int) op2;
                    }
                    //DECIMAL - DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 - (double) op2;
                    }
                    //DECIMAL - CARACTER = DECIMAL
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (double) op1 - new Double(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Resta erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            case CARACTER -> {
                switch (tipo2) {
                    //CARACTER - ENTERO = DECIMAL
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) - (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) - (double) op2;
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Resta erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            default -> {
                return new Errores("SEMANTICO", "Resta erronea", this.linea, this.col);

            }

        }
    }

    //OPERACIÓN MULTIPLICACION
    public Object multiplicacion(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    //ENTERO * ENTERO = ENTERO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        return (int) op1 * (int) op2;
                    }
                    //ENTERO * DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) op1 * (double) op2;
                    }
                    // ENTERO * CARACTER = ENTER0
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.ENTERO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (int) op1 * new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Multiplicacion erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    //DECIMAL * ENTERO = DECIMAL
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 * (int) op2;
                    }
                    //DECIMAL * DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 * (double) op2;
                    }
                    //DECIMAL * CARACTER = DECIMAL
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (double) op1 * new Double(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Multiplicacion erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            case CARACTER -> {
                switch (tipo2) {
                    //CARACTER * ENTERO = DECIMAL
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) * (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) * (double) op2;
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Multiplicacion erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            default -> {
                return new Errores("SEMANTICO", "Multiplicacion erronea", this.linea, this.col);

            }

        }
    }

    //OPERACIÓN DIVISION
    public Object division(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        // Validar que no venga op1/0, 0/op2, 0/0
        if ((tipo1 == tipoDato.ENTERO && (int) op1 == 0 && (tipo2 == tipoDato.ENTERO || tipo2 == tipoDato.DECIMAL))
                || (tipo1 == tipoDato.DECIMAL && (double) op1 == 0.0 && (tipo2 == tipoDato.ENTERO || tipo2 == tipoDato.DECIMAL))
                || (tipo1 == tipoDato.CARACTER && op1.toString().charAt(0) == '0' && (tipo2 == tipoDato.ENTERO || tipo2 == tipoDato.DECIMAL || tipo2 == tipoDato.CARACTER))
                || (tipo2 == tipoDato.ENTERO && (int) op2 == 0)
                || (tipo2 == tipoDato.DECIMAL && (double) op2 == 0.0)
                || (tipo2 == tipoDato.CARACTER && op2.toString().charAt(0) == '0')) {
            return new Errores("SEMANTICO", "No se puede realizar la operacion division", this.linea, this.col);
        }

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    //ENTERO / ENTERO = DECIMAL
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return ((double) (int) op1) / (int) op2;
                    }
                    //ENTERO / DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) op1 / (double) op2;
                    }
                    // ENTERO / CARACTER = DECIMAL
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (int) op1 / (double) num2;

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Division erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    //DECIMAL / ENTERO = DECIMAL
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 / (int) op2;
                    }
                    //DECIMAL / DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 / (double) op2;
                    }
                    //DECIMAL / CARACTER = DECIMAL
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (double) op1 / new Double(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Division erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            case CARACTER -> {
                switch (tipo2) {
                    //CARACTER / ENTERO = DECIMAL
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return (double) num1 / (int) op2;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) / (double) op2;
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Division erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            default -> {
                return new Errores("SEMANTICO", "Division erronea", this.linea, this.col);

            }

        }
    }

    //OPERACIÓN POTENCIA
    public Object potencia(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    //ENTERO ** ENTERO = ENTERO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) Math.pow((int) op1, (int) op2);
                    }
                    //ENTERO ** DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return Math.pow((int) op1, (double) op2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Potencia erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    //DECIMAL ** ENTERO = DECIMAL
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return Math.pow((double) op1, (int) op2);
                    }
                    //DECIMAL ** DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return Math.pow((double) op1, (double) op2);
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Potencia erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            default -> {
                return new Errores("SEMANTICO", "Potencia erronea", this.linea, this.col);

            }

        }
    }

    // OPERACIÓN MODULO
    public Object modulo(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        // Validar que no se realice módulo por cero
        if ((tipo2 == tipoDato.ENTERO && (int) op2 == 0)
                || (tipo2 == tipoDato.DECIMAL && (double) op2 == 0.0)
                || (tipo2 == tipoDato.CARACTER && op2.toString().charAt(0) == '0')) {
            return new Errores("SEMANTICO", "No se puede realizar la operación", this.linea, this.col);
        }

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    // ENTERO % ENTERO = ENTERO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return ((double) (int) op1) % (int) op2;
                    }
                    // ENTERO % DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) op1 % (double) op2;
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Modulo erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    // DECIMAL % ENTERO = DECIMAL
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 % (int) op2;
                    }
                    // DECIMAL % DECIMAL = DECIMAL
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) op1 % (double) op2;
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Modulo erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            default -> {
                return new Errores("SEMANTICO", "Modulo erroneo", this.linea, this.col);
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
