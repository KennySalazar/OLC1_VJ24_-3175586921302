/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author Kenny Salazar
 */

/*
DO {
    INSTRUCCIONES
} while( CONDICION -> expresion);
 */
public class DoWhile extends Instruccion {

    private Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;

    public DoWhile(Instruccion condicion, LinkedList<Instruccion> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // Nuevo entorno
        var newTabla = new tablaSimbolos(tabla);

        // Validar la condición -> Booleano
        var cond = this.condicion.interpretar(arbol, newTabla);
        if (cond instanceof Errores) {
            return cond;
        }

        if (this.condicion.tipo.getTipo() != tipoDato.BOOLEANO) {
            return new Errores("SEMANTICO", "La condicion debe ser bool", this.linea, this.col);
        }

        do {
            // Nuevo entorno
            var newTabla2 = new tablaSimbolos(newTabla);
            newTabla2.setNombre("DoWhile");
            for (var i : this.instrucciones) {
                if (i instanceof Break) {
                    return null;
                }
                if (i instanceof Continue) {
                    break;
                }
                  if (i instanceof Return) {
                     return i;
                }
                var resIns = i.interpretar(arbol, newTabla2);
                if (resIns instanceof Break) {
                    return null;
                }
                if (resIns instanceof Continue) {
                    break;
                }
                if (resIns instanceof Return) {
                    return resIns;
                }
                if (resIns instanceof Errores) {
                    return resIns;
                }
            }

            // vuelve a evaluar la condición para el proximo ciclo
            cond = this.condicion.interpretar(arbol, newTabla);
            if (cond instanceof Errores) {
                return cond;
            }

            if (this.condicion.tipo.getTipo() != tipoDato.BOOLEANO) {
                return new Errores("SEMANTICO", "La condicion debe ser bool", this.linea, this.col);
            }
        } while ((boolean) cond);

        return null;
    }
}
