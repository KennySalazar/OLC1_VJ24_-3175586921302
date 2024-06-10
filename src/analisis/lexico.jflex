package analisis;

//importaciones
import java_cup.runtime.Symbol;

%%

//definicion de variables
%{

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }

  public void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);

  }
    String cadena = "";
%}

// Definiciones iniciales
%init{
    yyline = 1;
    yycolumn = 1;
%init}

//declaraciones de caracteristicas de jflex
%cup
%class scanner //nombre de la clase
%public //acceso de la clase
%line //conteo de lineas
%column //conteo de columnas
%char //conteo de caracteres
%full //reconocimiento de caracteres
%ignorecase //quitar la distincion entre mayusculas y minusculas (case insensitive)


// definir los simbolos del sistema
BLANCOS = [\ \r\t\n\f]+
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+
//CADENA = \"[^\"]*\"
CADENA = \"([^\"\\]|\\[tnr'\"\\])*\"
//ID = [a-zA-Z]+[0-9]*
COMENTARIO1 =  [\/][\/][^\n]*
COMENTARIO2 = [/*]([^*]|\*+[^*/])*\*+[/]
CARACTER = \'([^\'\\]|\\[ntr'\"\\])\'


%%

// PALABRAS RESERVADAS


    //"imprimir"          {return new Symbol(sym.IMPRIMIR, yyline, yycolumn, yytext());}
   // "var"               {return new Symbol(sym.VAR, yyline, yycolumn, yytext());}
   // "int"               {return new Symbol(sym.INT, yyline, yycolumn, yytext());}
   // "string"            {return new Symbol(sym.STRING, yyline, yycolumn, yytext());}
   // "const"             {return new Symbol(sym.CONST, yyline, yycolumn, yytext());}
   // "double"            {return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());}
   // "char"              {return new Symbol(sym.CHAR, yyline, yycolumn, yytext());}
    //"if"                {return new Symbol(sym.IF, yyline, yycolumn, yytext());}
    //"else"              {return new Symbol(sym.ELSE, yyline, yycolumn, yytext());}
    //"match"             {return new Symbol(sym.MATCH, yyline, yycolumn, yytext());}
    //"while"             {return new Symbol(sym.WHILE, yyline, yycolumn, yytext());}
    //"for"               {return new Symbol(sym.FOR, yyline, yycolumn, yytext());}
    //"do"                {return new Symbol(sym.DO, yyline, yycolumn, yytext());}
    //"break"             {return new Symbol(sym.BREAK, yyline, yycolumn, yytext());}
    "println"           {return new Symbol(sym.PRINTLN, yyline, yycolumn, yytext());}
    //"continue"          {return new Symbol(sym.CONTINUE, yyline, yycolumn, yytext());}
    "true"              {return new Symbol(sym.BOOLEANO, yyline, yycolumn, yytext());}
    "false"              {return new Symbol(sym.BOOLEANO, yyline, yycolumn, yytext());}



    {DECIMAL}           {return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());} 
    {ENTERO}            {return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());}
    //{ID}                {return new Symbol(sym.ID, yyline, yycolumn, yytext());}
    {COMENTARIO1}           {}
    {COMENTARIO2}           {}
    //true {return new Symbol(sym.true, yychar, yyline,yytext());}
    //false {return new Symbol(sym.false, yychar, yyline,yytext());}
    

       

    ";"                 {return new Symbol(sym.FINCADENA, yyline, yycolumn, yytext());}
    "+"                 {return new Symbol(sym.MAS, yyline, yycolumn, yytext());}
    "-"                 {return new Symbol(sym.MENOS, yyline, yycolumn, yytext());}
    "*"                 {return new Symbol(sym.MULTIPLICACION, yyline, yycolumn, yytext());}
    "/"                 {return new Symbol(sym.DIVISION, yyline, yycolumn, yytext());}
    "("                 {return new Symbol(sym.PAR1, yyline, yycolumn, yytext());}
    ")"                 {return new Symbol(sym.PAR2, yyline, yycolumn, yytext());}
    "**"                {return new Symbol(sym.POTENCIA, yyline, yycolumn, yytext());}
    "%"                 {return new Symbol(sym.MODULO, yyline, yycolumn, yytext());}
    //":"                 {return new Symbol(sym.DOSPUNTOS, yyline, yycolumn, yytext());}
   // ";"                 {return new Symbol(sym.PCOMA, yyline, yycolumn, yytext());}
    "=="                {return new Symbol(sym.COMPARACIONIGUALIGUAL, yyline, yycolumn, yytext());}
    //"="                {return new Symbol(sym.ASIGNACION, yyline, yycolumn, yytext());}
    "!="                {return new Symbol(sym.NEGACION, yyline, yycolumn, yytext());}
    "<"                 {return new Symbol(sym.MENORQUE, yyline, yycolumn, yytext());}
    "<="                {return new Symbol(sym.MENORIGUALQUE, yyline, yycolumn, yytext());}
    ">"                 {return new Symbol(sym.MAYORQUE, yyline, yycolumn, yytext());}
    ">="                {return new Symbol(sym.MAYORIGUALQUE, yyline, yycolumn, yytext());}
    //"||"                {return new Symbol(sym.OR, yyline, yycolumn, yytext());}
    //"&&"                {return new Symbol(sym.AND, yyline, yycolumn, yytext());}
    //"^"                 {return new Symbol(sym.XOR, yyline, yycolumn, yytext());}
    //"!"                 {return new Symbol(sym.NOT, yyline, yycolumn, yytext());}
    //"{"                 {return new Symbol(sym.LLAVEA, yyline, yycolumn, yytext());}
    //"}"                 {return new Symbol(sym.LLAVEC, yyline, yycolumn, yytext());}
    //"++"                {return new Symbol(sym.INCREMENTO, yyline, yycolumn, yytext());}
    //"--"                {return new Symbol(sym.DECREMENTO, yyline, yycolumn, yytext());}
    



    {CADENA} {
    String cadena = yytext();
    cadena = cadena.substring(1, cadena.length()-1);
    return new Symbol(sym.CADENA, yyline, yycolumn,cadena);
    }
    {CARACTER} {
    String caracter = yytext();
    caracter = caracter.substring(1, caracter.length()-1);
    return new Symbol(sym.CARACTER, yyline, yycolumn,caracter);
    }

   
 {BLANCOS}   {}





/* cualquier simbolo que no este declarado sera un error*/
[^]                           
			{  throw new
                            Error("Simbolo ilegal <"+ yytext()+">");
                                
                        }
<<EOF>>                 { return symbol(sym.EOF); }


