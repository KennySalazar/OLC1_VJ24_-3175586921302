/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

/**
 *
 * @author Kenny Salazar
 */


public class TablaSimbolosReporte {
    String id;
    String tipo1; 
    String tipo2;
    String entorno;
    String valor;
    String linea;
    String columna;

    public TablaSimbolosReporte(String id, String tipo1, String tipo2, String entorno, String valor, String linea, String columna) {
        this.id = id;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.entorno = entorno;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }

    public TablaSimbolosReporte() {
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public String getEntorno() {
        return entorno;
    }

    public void setEntorno(String entorno) {
        this.entorno = entorno;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }
    
    
    
}
