/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import abstracto.Instruccion;
import analisis.parser;
import analisis.scanner;
import com.mycompany.proyecto_compi1.vista.EditorPrincipal;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.tablaSimbolos;

/**
 *
 * @author Kenny Salazar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* EditorPrincipal vista = new EditorPrincipal();
        vista.setVisible(true);
        vista.setEnabled(true);
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);
        vista.setTitle("JAVACRAFT");*/
        try {
            /*            String texto = "println(1+\"Mi cadena\");" + "println(1.1+'@');" + "println(true + \"HOLA BOOLEANO V\");" + "println(false + \"HOLA BOOLEANO F\");"
            + "println(1.1+\"ESTO ES UN DECIMAL\"); println(-1.33+3.33); println(\"Mi cadena\"+55);"
            + "println('@' + 4);" + "println('@' + 4.4);" + "println('@' + 'A');" + "println('@' + \"ESTO ES UN CARACATER CON UNA CADENA\");"
            + "println(\"Esto es una cadena con un entero \" + 45);" + "println(\"Esto es una cadena con un DECIMAL \" + 45.9);"
            + "println(\"Esto es una cadena con un BOOLEAN \" + true);" + "println(\"Esto es una cadena con un char \" + '@');"
            + "println(\"Esto es una cadena con un cadena \" + \"Esto es una cadena con un cadena2 \");"
            + "println(-5-4);" + "println(5-4.3);" + "println(66-'@');"
            + "println(5.5-2);" + "println(5.5 - 2.5);" + "println(2.5-'@');"
            + "println('@' - 2);" + "println('@'-2.5);" + "println('@' - '@');"
            + "println(1 + true);"
            + "println(-1 * 3);" + "println(2*9.5 );" + "println(2 * '@');"
            + "println(1.5 * 3);" + "println(2.5*9.5 );" + "println(2.5 * '@');"
            + "println('@' * 3);" + "println('A'*3.5);"
            + "println(1 / 3);" + "println(2/9.5 );" + "println(2 / '@');"
            + "println(1.5 / 3);" + "println(2.5/9.5 );" + "println(2.5 / '@');"
            + "println('@' / 3);" + "println('A'/3.5);"
            + "println(-3 ** 3);" + "println(3**3.9);"
            + "println(3.3 ** 3);" + "println(3.3**3.9);"
            + "println(3.3 ** 3);" + "println(3.3**3.9);"
            + "println(5 % 3);" + "println(3 % 3.9);"
            + "println(3.3 % 3);" + "println(3.3%3.9);" + "println(true%3.9);" ;*/

            String texto = "println(4>=4);" + "println(4>=4.0);" + "println(63 >= '@');"
                    + "println(4.1>=4);" + "println(4.1>=4.0);" + "println(64.0>='@');"
                    + "println('@'>=5);" + "println('D'>=5.5);" + "println('A'>='A');"
                    + "println(\"hola\">=\"hola\");"
                    + "println(\"hola\">=5);";

            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            parser p = new parser(s);
            var resultado = p.parse();
            var ast = new Arbol((LinkedList<Instruccion>) resultado.value);
            var tabla = new tablaSimbolos();
            tabla.setNombre("GLOBAL");
            ast.setConsola("");
            for (var a : ast.getInstrucciones()) {
                var res = a.interpretar(ast, tabla);
            }
            System.out.println(ast.getConsola());
        } catch (Exception ex) {
            System.out.println("Algo salio mal");
            System.out.println(ex);
        }

    }

}
