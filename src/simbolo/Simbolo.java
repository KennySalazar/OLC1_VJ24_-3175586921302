/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

import static simbolo.tipoDato.BOOLEANO;
import static simbolo.tipoDato.CADENA;
import static simbolo.tipoDato.CARACTER;
import static simbolo.tipoDato.DECIMAL;
import static simbolo.tipoDato.ENTERO;

/**
 *
 * @author Kenny Salazar
 */
public class Simbolo {

    private Tipo tipo;
    private String id;
    private Object valor;
    private boolean mutabilidad;

    // Constructor con tipo e id, establece el valor por defecto
    public Simbolo(Tipo tipo, String id, boolean mutabilidad) {
        this.tipo = tipo;
        this.id = id;
        this.mutabilidad = mutabilidad;
        this.valor = getDefaultValor(tipo); 
    }

    // Constructor con tipo, id y valor
    public Simbolo(Tipo tipo, String id, Object valor, boolean mutabilidad) {
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
        this.mutabilidad = mutabilidad;
    }

    public static Object getDefaultValor(Tipo tipo) {
        switch (tipo.getTipo()) {
            case ENTERO:
                return 0;
            case CADENA:
                return "";
            case BOOLEANO:
                return true;
            case CARACTER:
                return '\u0000';
            case DECIMAL:
                return 0.0;
            default:
                return null;
        }
    }

   
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        if (mutabilidad) {
            this.valor = valor;
        } else {
            throw new UnsupportedOperationException("No se puede modificar una variable const");
        }
    }

    public boolean isMutable() {
        return mutabilidad;
    }

    public void setMutabilidad(boolean mutabilidad) {
        this.mutabilidad = mutabilidad;
    }
    
 

    public tipoDato getElementType() {
      
        return this.tipo.getTipo();
    }


}
