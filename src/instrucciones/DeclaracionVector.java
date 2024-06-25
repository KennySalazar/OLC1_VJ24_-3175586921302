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
public class DeclaracionVector extends Instruccion {

    private String identificador;
    private LinkedList<Instruccion> valores;
    private LinkedList<LinkedList<Instruccion>> valores2D;
    private boolean mutabilidad;
    private boolean esBidimensional;

    // VECTOR UNI
    public DeclaracionVector(String identificador, Tipo tipo, LinkedList<Instruccion> valoresUni, boolean mutabilidad, int linea, int col) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.valores = valoresUni;
        this.mutabilidad = mutabilidad;
        this.esBidimensional = false;
    }
    
    //VECTOR BI
    public DeclaracionVector(String identificador, Tipo tipo, LinkedList<LinkedList<Instruccion>> valoresBi, boolean mutabilidad, int linea, int col, boolean esBidimensional) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.valores2D = valoresBi;
        this.mutabilidad = mutabilidad;
        this.esBidimensional = true;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        Object vectorInterpretado;

        if (esBidimensional) {
            vectorInterpretado = new Object[valores2D.size()][];
            for (int i = 0; i < valores2D.size(); i++) {
                LinkedList<Instruccion> fila = valores2D.get(i);
                Object[] filaInterpretada = new Object[fila.size()];
                for (int j = 0; j < fila.size(); j++) {
                    Object valorInterpretado = fila.get(j).interpretar(arbol, tabla);
                    if (valorInterpretado instanceof Errores) {
                        return valorInterpretado;
                    }
                    
                    if (!verificarTipo(valorInterpretado, this.tipo)) {
                        return new Errores("SEMANTICA", "Tipo de dato incorrecto en la declaracion del vector", this.linea, this.col);
                    }
                    filaInterpretada[j] = valorInterpretado;
                }
                ((Object[][]) vectorInterpretado)[i] = filaInterpretada;
            }
        } else {
            vectorInterpretado = new Object[valores.size()];
            for (int i = 0; i < valores.size(); i++) {
                Object valorInterpretado = valores.get(i).interpretar(arbol, tabla);
                if (valorInterpretado instanceof Errores) {
                    return valorInterpretado;
                }
                
                if (!verificarTipo(valorInterpretado, this.tipo)) {
                    return new Errores("SEMANTICA", "Tipo de dato incorrecto en la declaracion del vector", this.linea, this.col);
                }
                ((Object[]) vectorInterpretado)[i] = valorInterpretado;
            }
        }

        Simbolo s = new Simbolo(this.tipo, this.identificador, vectorInterpretado, this.mutabilidad);

        boolean creacion = tabla.crearArreglo(s);
        if (!creacion) {
            return new Errores("SEMANTICO", "El vector " + identificador + " ya existe", this.linea, this.col);
        } else {
            if (!arbol.isVariableReported(s.getId(), tabla.getNombre(), "" + this.linea, "" + this.col)) {
                String tipo1 = s.isMutable() ? "variable" : "constante";
                arbol.getListaReportes().add(new TablaSimbolosReporte(s.getId(), tipo1, s.getTipo().getTipo().toString(), tabla.getNombre(), s.getValor().toString(), "" + this.linea, "" + this.col));
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