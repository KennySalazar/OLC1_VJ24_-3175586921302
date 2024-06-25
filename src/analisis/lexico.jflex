package analisis;

//importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import excepciones.Errores;
%%

//cogido en el que se puede acceder, si es publico
//Codigo de usuario
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

  public LinkedList<Errores> listaErrores = new LinkedList<>();

%}

// Definiciones iniciales
%init{
    yyline = 1;
    yycolumn = 1;
    listaErrores = new LinkedList<>();
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
ID = [a-zA-Z]+[a-zA-Z0-9_]*
COMENTARIO1 =  [\/][\/][^\n]*
COMENTARIO2 = "/*" [^]* "*/"
CARACTER = \'([^\'\\]|\\[ntr\'\"\\])\'


%%

// PALABRAS RESERVADAS


    //"imprimir"          {return new Symbol(sym.IMPRIMIR, yyline, yycolumn, yytext());}
<YYINITIAL>   "var"               {return new Symbol(sym.VAR, yyline, yycolumn, yytext());}
<YYINITIAL>   "const"             {return new Symbol(sym.CONST, yyline, yycolumn, yytext());}
<YYINITIAL>   "int"               {return new Symbol(sym.INT, yyline, yycolumn, yytext());}
<YYINITIAL>   "string"            {return new Symbol(sym.STRING, yyline, yycolumn, yytext());}
<YYINITIAL>   "double"            {return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());}
<YYINITIAL>   "char"              {return new Symbol(sym.CHAR, yyline, yycolumn, yytext());}
<YYINITIAL>   "bool"              {return new Symbol(sym.BOOL, yyline, yycolumn, yytext());}
<YYINITIAL>   "if"                {return new Symbol(sym.IF, yyline, yycolumn, yytext());}
<YYINITIAL>   "else"              {return new Symbol(sym.ELSE, yyline, yycolumn, yytext());}
<YYINITIAL>   "match"             {return new Symbol(sym.MATCH, yyline, yycolumn, yytext());}
<YYINITIAL>   "while"             {return new Symbol(sym.WHILE, yyline, yycolumn, yytext());}
<YYINITIAL>   "for"               {return new Symbol(sym.FOR, yyline, yycolumn, yytext());}
<YYINITIAL>   "do"                {return new Symbol(sym.DO, yyline, yycolumn, yytext());}
<YYINITIAL>   "break"             {return new Symbol(sym.BREAK, yyline, yycolumn, yytext());}
<YYINITIAL>   "println"           {return new Symbol(sym.PRINTLN, yyline, yycolumn, yytext());}
<YYINITIAL>   "continue"          {return new Symbol(sym.CONTINUE, yyline, yycolumn, yytext());}
<YYINITIAL>   "true"              {return new Symbol(sym.BOOLEANO, yyline, yycolumn, yytext());}
<YYINITIAL>   "false"             {return new Symbol(sym.BOOLEANO, yyline, yycolumn, yytext());}
<YYINITIAL>   "void"              {return new Symbol(sym.VOID, yyline, yycolumn, yytext());}
<YYINITIAL>   "START_WITH"              {return new Symbol(sym.START_WITH, yyline, yycolumn, yytext());}


<YYINITIAL>    {ID}                {return new Symbol(sym.ID, yyline, yycolumn, yytext());}
<YYINITIAL>    {DECIMAL}           {return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());} 
<YYINITIAL>    {ENTERO}            {return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());}
    
<YYINITIAL>    {COMENTARIO1}           {}
<YYINITIAL>    {COMENTARIO2}           {}
    //true {return new Symbol(sym.true, yychar, yyline,yytext());}
    //false {return new Symbol(sym.false, yychar, yyline,yytext());}
    

       
<YYINITIAL>    "++"                {return new Symbol(sym.INCREMENTO, yyline, yycolumn, yytext());}
<YYINITIAL>    "--"                {return new Symbol(sym.DECREMENTO, yyline, yycolumn, yytext());}
<YYINITIAL>    "=>"                {return new Symbol(sym.SIGNOCASOMATCH, yyline, yycolumn, yytext());}
<YYINITIAL>     "_ =>"               {return new Symbol(sym.SIGNODEFAULTMATCH, yyline, yycolumn, yytext());}
    

<YYINITIAL>    ","                 {return new Symbol(sym.COMA, yyline, yycolumn, yytext());}
<YYINITIAL>    ";"                 {return new Symbol(sym.FINCADENA, yyline, yycolumn, yytext());}
<YYINITIAL>    "+"                 {return new Symbol(sym.MAS, yyline, yycolumn, yytext());}
<YYINITIAL>    "-"                 {return new Symbol(sym.MENOS, yyline, yycolumn, yytext());}
<YYINITIAL>    "*"                 {return new Symbol(sym.MULTIPLICACION, yyline, yycolumn, yytext());}
<YYINITIAL>    "/"                 {return new Symbol(sym.DIVISION, yyline, yycolumn, yytext());}
<YYINITIAL>    "("                 {return new Symbol(sym.PAR1, yyline, yycolumn, yytext());}
<YYINITIAL>    ")"                 {return new Symbol(sym.PAR2, yyline, yycolumn, yytext());}
<YYINITIAL>    "**"                {return new Symbol(sym.POTENCIA, yyline, yycolumn, yytext());}
<YYINITIAL>    "%"                 {return new Symbol(sym.MODULO, yyline, yycolumn, yytext());}
<YYINITIAL>   ":"                 {return new Symbol(sym.DOSPUNTOS, yyline, yycolumn, yytext());}
<YYINITIAL>    "=="                {return new Symbol(sym.COMPARACIONIGUALIGUAL, yyline, yycolumn, yytext());}
<YYINITIAL>    "="                 {return new Symbol(sym.IGUAL, yyline, yycolumn, yytext());}
<YYINITIAL>    "!="                {return new Symbol(sym.NEGACION, yyline, yycolumn, yytext());}
<YYINITIAL>    "<"                 {return new Symbol(sym.MENORQUE, yyline, yycolumn, yytext());}
<YYINITIAL>    "<="                {return new Symbol(sym.MENORIGUALQUE, yyline, yycolumn, yytext());}
<YYINITIAL>    ">"                 {return new Symbol(sym.MAYORQUE, yyline, yycolumn, yytext());}
<YYINITIAL>    ">="                {return new Symbol(sym.MAYORIGUALQUE, yyline, yycolumn, yytext());}
<YYINITIAL>    "||"                 {return new Symbol(sym.OR, yyline, yycolumn, yytext());}
<YYINITIAL>    "&&"                {return new Symbol(sym.AND, yyline, yycolumn, yytext());}
<YYINITIAL>    "^"                 {return new Symbol(sym.XOR, yyline, yycolumn, yytext());}
<YYINITIAL>    "!"                 {return new Symbol(sym.NOT, yyline, yycolumn, yytext());}
<YYINITIAL>    "{"                 {return new Symbol(sym.LLAVEA, yyline, yycolumn, yytext());}
<YYINITIAL>    "}"                 {return new Symbol(sym.LLAVEC, yyline, yycolumn, yytext());}
<YYINITIAL>    "["                 {return new Symbol(sym.CORCHETEA, yyline, yycolumn, yytext());}
<YYINITIAL>    "]"                 {return new Symbol(sym.CORCHETEC, yyline, yycolumn, yytext());}
   



<YYINITIAL>    {CADENA} {
    String cadena = yytext();
    cadena = cadena.substring(1, cadena.length()-1);
    

    cadena = cadena.replaceAll("\\\\n", "\n"); 
    cadena = cadena.replaceAll("\\\\t", "\t"); 
    cadena = cadena.replaceAll("\\\\r", "\r"); 
    cadena = cadena.replaceAll("\\\\'", "\'"); 
    cadena = cadena.replaceAll("\\\\\"", "\""); 
    cadena = cadena.replaceAll("\\\\\\\\", "\\\\"); 

    return new Symbol(sym.CADENA, yyline, yycolumn,cadena);
    }


<YYINITIAL>    {CARACTER} {
    String caracter = yytext();
    caracter = caracter.substring(1, caracter.length()-1);
    return new Symbol(sym.CARACTER, yyline, yycolumn,caracter);
    }

   
<YYINITIAL> {BLANCOS}   {}





/* cualquier simbolo que no este declarado sera un error*/
<YYINITIAL> . {
                listaErrores.add(new Errores("LEXICO","El caracter "+
                yytext()+" NO pertenece al lenguaje", yyline, yycolumn));
}

<<EOF>>                 { return symbol(sym.EOF); }


