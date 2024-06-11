/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import static expresiones.OperadoresAritmeticos.DIVISION;
import static expresiones.OperadoresAritmeticos.MODULO;
import static expresiones.OperadoresAritmeticos.MULTIPLICACION;
import static expresiones.OperadoresAritmeticos.NEGACION;
import static expresiones.OperadoresAritmeticos.POTENCIA;
import static expresiones.OperadoresAritmeticos.RESTA;
import static expresiones.OperadoresAritmeticos.SUMA;
import static expresiones.OperadoresRelacionales.DIFERENCIACION;
import static expresiones.OperadoresRelacionales.IGUALACION;
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
public class Relacionales extends Instruccion {

    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresRelacionales operacion;
    //private Instruccion operandoUnico;

    //negacion 
    /* public Relacionales (Instruccion operandoUnico, OperadoresAritmeticos operacion, int linea, int col) {
    super(new Tipo(tipoDato.ENTERO), linea, col);
    this.operacion = operacion;
    this.operandoUnico = operandoUnico;
    }*/
    //cualquier operacion menos negacion
    public Relacionales(Instruccion operando1, Instruccion operando2, OperadoresRelacionales operacion, int linea, int col) {
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
            case IGUALACION ->
                this.igualacion(opIzq, opDer);
            case DIFERENCIACION ->
                this.diferenciacion(opIzq, opDer);
            case MENOR_QUE ->
                this.menorQue(opIzq, opDer);
            case MENOR_IGUAL_QUE ->
                this.menorIgualQue(opIzq, opDer);
            case MAYOR_QUE ->
                this.mayorQue(opIzq, opDer);
            case MAYOR_IGUAL_QUE ->
                this.mayorIgualQue(opIzq, opDer);
            default ->
                new Errores("SEMANTICO", "Operador invalido", this.linea, this.col);
        };
    }

    //RELACIONAL DE COMPARACION
    public Object igualacion(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    //ENTERO == ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 == (int) op2;
                    }
                    //ENTERO == DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 == (double) op2;
                    }
                    // ENTERO == CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (int) op1 == new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Igualación erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    //DECIMAL == ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 == (int) op2;
                    }
                    //DECIMAL == DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 == (double) op2;
                    }
                    //DECIMAL == CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (double) op1 == new Double(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Igualacion erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }
            case BOOLEANO -> {
                switch (tipo2) {
                    //BOOLEANO == BOOLEANO = BOOLEANO
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return Boolean.parseBoolean(op1.toString()) == Boolean.parseBoolean(op2.toString());
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Igualacion erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }
            case CARACTER -> {
                switch (tipo2) {
                    //CARACTER == ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) == (int) op2;
                    }
                    //CARACTER == DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) == (double) op2;
                    }
                    //CARACTER == CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return op1.toString().equalsIgnoreCase(op2.toString());

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Igualacion erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch (tipo2) {
                    //CADENA == CADENA = BOOLEANO
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return op1.toString().equalsIgnoreCase(op2.toString());
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Igualacion erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }
            default -> {
                return new Errores("SEMANTICO", "IGUALACION TIPO 1 erronea", this.linea, this.col);
            }
        }

    }

    //RELACIONAL DE DIFERENCIACION
    public Object diferenciacion(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    //ENTERO != ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 != (int) op2;
                    }
                    //ENTERO != DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 != (double) op2;
                    }
                    // ENTERO != CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (int) op1 != new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "DIFERENCIACION erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    //DECIMAL != ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 != (int) op2;
                    }
                    //DECIMAL != DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 != (double) op2;
                    }
                    //DECIMAL != CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (double) op1 != new Double(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "DIFERENCIACION erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }
            case BOOLEANO -> {
                switch (tipo2) {
                    //BOOLEANO != BOOLEANO = BOOLEANO
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return Boolean.parseBoolean(op1.toString()) != Boolean.parseBoolean(op2.toString());
                    }

                    default -> {
                        return new Errores("SEMANTICO", "DIFERENCIACION erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }
            case CARACTER -> {
                switch (tipo2) {
                    //CARACTER != ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) != (int) op2;
                    }
                    //CARACTER != DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) != (double) op2;
                    }
                    //CARACTER != CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return !op1.toString().equalsIgnoreCase(op2.toString());

                    }

                    default -> {
                        return new Errores("SEMANTICO", "DIFERENCIACION erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch (tipo2) {
                    //CADENA != CADENA = BOOLEANO
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return !op1.toString().equalsIgnoreCase(op2.toString());
                    }

                    default -> {
                        return new Errores("SEMANTICO", "DIFERENCIACION erronea con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }
            default -> {
                return new Errores("SEMANTICO", "DIFERENCIACION TIPO 1 erronea", this.linea, this.col);
            }
        }

    }

    //RELACIONAL DE MENOR QUE
    public Object menorQue(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    //ENTERO < ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 < (int) op2;
                    }
                    //ENTERO < DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 < (double) op2;
                    }
                    // ENTERO < CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (int) op1 < new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Menor que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    //DECIMAL < ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 < (int) op2;
                    }
                    //DECIMAL < DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 < (double) op2;
                    }
                    //DECIMAL < CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (double) op1 < new Double(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Menor que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }

            case BOOLEANO -> {
                switch (tipo2) {
                    // BOOLEANO < BOOLEANO = BOOLEANO
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        // Convertir booleanos a enteros
                        int valorOp1 = Boolean.parseBoolean(op1.toString()) ? 1 : 0;
                        int valorOp2 = Boolean.parseBoolean(op2.toString()) ? 1 : 0;

                        return valorOp1 < valorOp2;

                    }
                    default -> {
                        return new Errores("SEMANTICO", "Menor que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            case CARACTER -> {
                switch (tipo2) {
                    //CARACTER < ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) < (int) op2;
                    }
                    //CARACTER < DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) < (double) op2;
                    }
                    //CARACTER < CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return new Integer(num1) < new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Menor o igual que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch (tipo2) {
                    //CADENA < CADENA = BOOLEANO
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return op1.toString().compareTo(op2.toString()) < 0;
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Menor que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }
            default -> {
                return new Errores("SEMANTICO", "MENOR QUE  erroneo", this.linea, this.col);
            }
        }

    }

    //RELACIONAL DE MENOR O IGUAL QUE
    public Object menorIgualQue(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    //ENTERO <= ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 <= (int) op2;
                    }
                    //ENTERO <= DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 <= (double) op2;
                    }
                    // ENTERO <= CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (int) op1 <= new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Menor o igual que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    //DECIMAL <= ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 <= (int) op2;
                    }
                    //DECIMAL < DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 <= (double) op2;
                    }
                    //DECIMAL < CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (double) op1 <= new Double(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Menor o igual  que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }

            case BOOLEANO -> {
                switch (tipo2) {
                    //DECIMAL <= ENTERO = BOOLEANO
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        // Convertir booleanos a enteros
                        int valorOp1 = Boolean.parseBoolean(op1.toString()) ? 1 : 0;
                        int valorOp2 = Boolean.parseBoolean(op2.toString()) ? 1 : 0;
                        return valorOp1 <= valorOp2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Menor o igual que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            case CARACTER -> {
                switch (tipo2) {
                    //CARACTER < ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) <= (int) op2;
                    }
                    //CARACTER < DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) <= (double) op2;
                    }
                    //CARACTER < CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return new Integer(num1) <= new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Menor o igual que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch (tipo2) {
                    //CADENA <= CADENA = BOOLEANO
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return op1.toString().compareTo(op2.toString()) <= 0;
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Menor o igual que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }
            default -> {
                return new Errores("SEMANTICO", "MENOR O IGUAL QUE  erroneo", this.linea, this.col);
            }
        }

    }

    //RELACIONAL DE MAYOR QUE
    public Object mayorQue(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    //ENTERO > ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 > (int) op2;
                    }
                    //ENTERO > DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 > (double) op2;
                    }
                    // ENTERO > CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (int) op1 > new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Mayor que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    //DECIMAL > ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 > (int) op2;
                    }
                    //DECIMAL > DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 > (double) op2;
                    }
                    //DECIMAL > CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (double) op1 > new Double(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Mayor que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }

            case BOOLEANO -> {
                switch (tipo2) {
                    //DECIMAL > ENTERO = BOOLEANO
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        // Convertir booleanos a enteros
                        int valorOp1 = Boolean.parseBoolean(op1.toString()) ? 1 : 0;
                        int valorOp2 = Boolean.parseBoolean(op2.toString()) ? 1 : 0;
                        return valorOp1 > valorOp2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Mayor  que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            case CARACTER -> {
                switch (tipo2) {
                    //CARACTER > ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) > (int) op2;
                    }
                    //CARACTER > DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) > (double) op2;
                    }
                    //CARACTER > CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return new Integer(num1) > new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Mayor o igual que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch (tipo2) {
                    //CADENA < CADENA = BOOLEANO
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return op1.toString().compareTo(op2.toString()) > 0;
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Mayor que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }
            default -> {
                return new Errores("SEMANTICO", "MAYOR QUE  erroneo", this.linea, this.col);
            }
        }

    }

    //RELACIONAL DE MAYOR O IGUAL QUE
    public Object mayorIgualQue(Object op1, Object op2) {
        var tipo1 = this.operando1.tipo.getTipo();
        var tipo2 = this.operando2.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                switch (tipo2) {
                    //ENTERO >= ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 >= (int) op2;
                    }
                    //ENTERO >= DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (int) op1 >= (double) op2;
                    }
                    // ENTERO >= CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (int) op1 >= new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Mayor o igual que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case DECIMAL -> {
                switch (tipo2) {
                    //DECIMAL >= ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 >= (int) op2;
                    }
                    //DECIMAL >= DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return (double) op1 >= (double) op2;
                    }
                    //DECIMAL >= CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);

                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return (double) op1 >= new Double(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Mayor o igual que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }

            case BOOLEANO -> {
                switch (tipo2) {
                    //DECIMAL >= ENTERO = BOOLEANO
                    case BOOLEANO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                     // Convertir booleanos a enteros
                        int valorOp1 = Boolean.parseBoolean(op1.toString()) ? 1 : 0;
                        int valorOp2 = Boolean.parseBoolean(op2.toString()) ? 1 : 0;
                        return valorOp1 >= valorOp2;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "Mayor o igual  que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }

            case CARACTER -> {
                switch (tipo2) {
                    //CARACTER >= ENTERO = BOOLEANO
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) >= (int) op2;
                    }
                    //CARACTER >= DECIMAL = BOOLEANO
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        return new Integer(num1) >= (double) op2;
                    }
                    //CARACTER >= CARACTER = BOOLEANO
                    case CARACTER -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        char operador1 = op1.toString().charAt(0);
                        int num1 = operador1;
                        char operador2 = op2.toString().charAt(0);
                        int num2 = operador2;
                        return new Integer(num1) >= new Integer(num2);

                    }

                    default -> {
                        return new Errores("SEMANTICO", "Mayor o igual que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }
            }
            case CADENA -> {
                switch (tipo2) {
                    //CADENA < CADENA = BOOLEANO
                    case CADENA -> {
                        this.tipo.setTipo(tipoDato.BOOLEANO);
                        return op1.toString().compareTo(op2.toString()) >= 0;
                    }

                    default -> {
                        return new Errores("SEMANTICO", "Mayor o igual que erroneo con tipo no soportado: " + tipo2, this.linea, this.col);
                    }
                }

            }
            default -> {
                return new Errores("SEMANTICO", "MAYOR O IGUAL QUE  erroneo", this.linea, this.col);
            }
        }

    }
}
