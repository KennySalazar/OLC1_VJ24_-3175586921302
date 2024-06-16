/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

import Reportes.TablaSimbolosReporte;
import abstracto.Instruccion;
import excepciones.Errores;
import java.util.LinkedList;

/**
 *
 * @author Kenny Salazar
 */
public class Arbol {

    private LinkedList<Instruccion> instrucciones;
    private String consola;
    private tablaSimbolos tablaGlobal;
    private LinkedList<Errores> errores;
     private LinkedList<TablaSimbolosReporte> listaReportes;

    public Arbol(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
        this.consola = "";
        this.tablaGlobal = new tablaSimbolos();
        this.errores = new LinkedList<>();
        this.listaReportes = new LinkedList<>();
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public tablaSimbolos getTablaGlobal() {
        return tablaGlobal;
    }

    public void setTablaGlobal(tablaSimbolos tablaGlobal) {
        this.tablaGlobal = tablaGlobal;
    }

    public LinkedList<Errores> getErrores() {
        return errores;
    }

    public void setErrores(LinkedList<Errores> errores) {
        this.errores = errores;
    }

    public void Print(String valor) {
        this.consola += valor + "\n";
    }

    public LinkedList<TablaSimbolosReporte> getListaReportes() {
        return listaReportes;
    }

    public void setListaReportes(LinkedList<TablaSimbolosReporte> listaReportes) {
        this.listaReportes = listaReportes;
    }
    
    public boolean isVariableReported(String id, String entorno, String linea, String columna) {
    for (TablaSimbolosReporte reporte : this.getListaReportes()) {
        if (reporte.getId().equals(id) && reporte.getEntorno().equals(entorno)
                && reporte.getLinea().equals(linea) && reporte.getColumna().equals(columna)) {
            return true;
        }
    }
    return false;
}

}
