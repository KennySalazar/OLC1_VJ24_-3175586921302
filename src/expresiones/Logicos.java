package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

public class Logicos extends Instruccion {

    private Instruccion operando1;
    private Instruccion operando2;
    private OperadoresLogicos operacion;

    // Constructor para operaciones binarias
    public Logicos(Instruccion operando1, Instruccion operando2, OperadoresLogicos operacion, int linea, int col) {
        super(new Tipo(tipoDato.BOOLEANO), linea, col);
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    // Constructor para operación NOT
    public Logicos(Instruccion operando, OperadoresLogicos operacion, int linea, int col) {
        super(new Tipo(tipoDato.BOOLEANO), linea, col);
        this.operando1 = operando;
        this.operando2 = null;
        this.operacion = operacion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object opIzq = this.operando1 != null ? this.operando1.interpretar(arbol, tabla) : null;
        if (opIzq instanceof Errores) {
            return opIzq;
        }

        if (operacion == OperadoresLogicos.NOT) {
            return this.NOT(opIzq, arbol, tabla);
        } else {
            Object opDer = this.operando2 != null ? this.operando2.interpretar(arbol, tabla) : null;
            if (opDer instanceof Errores) {
                return opDer;
            }

            return switch (operacion) {
                case OR ->
                    this.OR(opIzq, opDer, arbol, tabla);
                case AND ->
                    this.AND(opIzq, opDer, arbol, tabla);
                case XOR ->
                    this.XOR(opIzq, opDer, arbol, tabla);
                case NOT ->
                    this.NOT(opIzq,  arbol, tabla);
                default ->
                    new Errores("SEMANTICO", "Operador invalido", this.linea, this.col);
            };
        }
    }

    //LOGICOS OR
    public Object OR(Object op1, Object op2, Arbol arbol, tablaSimbolos tabla) {
        Object valor1 = obtenerValorBooleano(op1, arbol, tabla);
        if (valor1 instanceof Errores) {
            return valor1;
        }
        Object valor2 = obtenerValorBooleano(op2, arbol, tabla);
        if (valor2 instanceof Errores) {
            return valor2;
        }
        //BOOLEANO || BOOLEANO = BOOLEANO
        return (boolean) valor1 || (boolean) valor2;
    }

    //LOGICOS AND
    public Object AND(Object op1, Object op2, Arbol arbol, tablaSimbolos tabla) {
        Object valor1 = obtenerValorBooleano(op1, arbol, tabla);
        if (valor1 instanceof Errores) {
            return valor1;
        }
        Object valor2 = obtenerValorBooleano(op2, arbol, tabla);
        if (valor2 instanceof Errores) {
            return valor2;
        }

        return (boolean) valor1 && (boolean) valor2;
    }

    //LOGICOS XOR
    public Object XOR(Object op1, Object op2, Arbol arbol, tablaSimbolos tabla) {
        Object valor1 = obtenerValorBooleano(op1, arbol, tabla);
        if (valor1 instanceof Errores) {
            return valor1;
        }
        Object valor2 = obtenerValorBooleano(op2, arbol, tabla);
        if (valor2 instanceof Errores) {
            return valor2;
        }

        return (boolean) valor1 ^ (boolean) valor2;
    }

    // LOGICOS NOT
    public Object NOT(Object op, Arbol arbol, tablaSimbolos tabla) {
        Object valor = obtenerValorBooleano(op, arbol, tabla);
        if (valor instanceof Errores) {
            return valor;
        }

        if (valor instanceof Boolean) {
            return !(Boolean) valor;
        } else {
            return new Errores("SEMANTICO", "El valor no es un booleano", this.linea, this.col);
        }
    }

    private Object obtenerValorBooleano(Object operando, Arbol arbol, tablaSimbolos tabla) {
        if (operando == null) {
            return new Errores("SEMANTICO", "El operando es nulo", this.linea, this.col);
        }
        if (operando instanceof String) {
            String operandoStr = (String) operando;
            if (operandoStr.equals("true")) {
                return true;
            } else if (operandoStr.equals("false")) {
                return false;
            } else {
                return new Errores("SEMANTICO", "El operando no es de tipo booleano", this.linea, this.col);
            }
        } else if (operando instanceof Instruccion) {
            Instruccion instruccion = (Instruccion) operando;
            if (!instruccion.tipo.getTipo().equals(tipoDato.BOOLEANO)) {
                return new Errores("SEMANTICO", "El operando no es de tipo booleano", this.linea, this.col);
            }
            Object resultado = instruccion.interpretar(arbol, tabla);
            if (resultado == null) {
                return new Errores("SEMANTICO", "El resultado del operando es nulo", this.linea, this.col);
            }
            if (resultado instanceof Errores) {
                return resultado;
            }
            if (resultado instanceof Boolean) {
                return resultado;
            } else {
                return new Errores("SEMANTICO", "El resultado del operando no es de tipo booleano", this.linea, this.col);
            }
        } else if (operando instanceof Boolean) {
            return operando;
        } else {
            return new Errores("SEMANTICO", "El operando no es una instancia de Instruccion o Boolean", this.linea, this.col);
        }
    }

}
