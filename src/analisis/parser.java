
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analisis;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import abstracto.Instruccion;
import simbolo.Tipo;
import simbolo.tipoDato;
import instrucciones.Print;
import expresiones.Nativo;
import expresiones.Aritmeticas;
import expresiones.Relacionales;
import expresiones.Logicos;
import expresiones.OperadoresAritmeticos;
import expresiones.OperadoresRelacionales;
import expresiones.OperadoresLogicos;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\034\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\003\000\002\004\007\000\002\005\004" +
    "\000\002\005\005\000\002\005\005\000\002\005\005\000" +
    "\002\005\005\000\002\005\005\000\002\005\005\000\002" +
    "\005\005\000\002\005\005\000\002\005\005\000\002\005" +
    "\005\000\002\005\005\000\002\005\005\000\002\005\004" +
    "\000\002\005\005\000\002\005\005\000\002\005\005\000" +
    "\002\005\003\000\002\005\003\000\002\005\003\000\002" +
    "\005\003\000\002\005\003\000\002\005\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\065\000\004\012\007\001\002\000\006\002\ufffe\012" +
    "\ufffe\001\002\000\006\002\000\012\007\001\002\000\004" +
    "\002\066\001\002\000\004\013\010\001\002\000\022\004" +
    "\011\005\015\006\012\007\021\010\014\013\016\016\013" +
    "\035\017\001\002\000\042\014\uffe9\015\uffe9\016\uffe9\020" +
    "\uffe9\021\uffe9\022\uffe9\023\uffe9\024\uffe9\025\uffe9\026\uffe9" +
    "\027\uffe9\030\uffe9\031\uffe9\032\uffe9\033\uffe9\034\uffe9\001" +
    "\002\000\042\014\uffea\015\uffea\016\uffea\020\uffea\021\uffea" +
    "\022\uffea\023\uffea\024\uffea\025\uffea\026\uffea\027\uffea\030" +
    "\uffea\031\uffea\032\uffea\033\uffea\034\uffea\001\002\000\022" +
    "\004\011\005\015\006\012\007\021\010\014\013\016\016" +
    "\013\035\017\001\002\000\042\014\uffe7\015\uffe7\016\uffe7" +
    "\020\uffe7\021\uffe7\022\uffe7\023\uffe7\024\uffe7\025\uffe7\026" +
    "\uffe7\027\uffe7\030\uffe7\031\uffe7\032\uffe7\033\uffe7\034\uffe7" +
    "\001\002\000\042\014\uffeb\015\uffeb\016\uffeb\020\uffeb\021" +
    "\uffeb\022\uffeb\023\uffeb\024\uffeb\025\uffeb\026\uffeb\027\uffeb" +
    "\030\uffeb\031\uffeb\032\uffeb\033\uffeb\034\uffeb\001\002\000" +
    "\022\004\011\005\015\006\012\007\021\010\014\013\016" +
    "\016\013\035\017\001\002\000\022\004\011\005\015\006" +
    "\012\007\021\010\014\013\016\016\013\035\017\001\002" +
    "\000\042\014\034\015\033\016\025\020\031\021\037\022" +
    "\026\023\036\024\023\025\041\026\030\027\035\030\032" +
    "\031\027\032\040\033\022\034\024\001\002\000\042\014" +
    "\uffe8\015\uffe8\016\uffe8\020\uffe8\021\uffe8\022\uffe8\023\uffe8" +
    "\024\uffe8\025\uffe8\026\uffe8\027\uffe8\030\uffe8\031\uffe8\032" +
    "\uffe8\033\uffe8\034\uffe8\001\002\000\022\004\011\005\015" +
    "\006\012\007\021\010\014\013\016\016\013\035\017\001" +
    "\002\000\022\004\011\005\015\006\012\007\021\010\014" +
    "\013\016\016\013\035\017\001\002\000\022\004\011\005" +
    "\015\006\012\007\021\010\014\013\016\016\013\035\017" +
    "\001\002\000\022\004\011\005\015\006\012\007\021\010" +
    "\014\013\016\016\013\035\017\001\002\000\022\004\011" +
    "\005\015\006\012\007\021\010\014\013\016\016\013\035" +
    "\017\001\002\000\022\004\011\005\015\006\012\007\021" +
    "\010\014\013\016\016\013\035\017\001\002\000\022\004" +
    "\011\005\015\006\012\007\021\010\014\013\016\016\013" +
    "\035\017\001\002\000\022\004\011\005\015\006\012\007" +
    "\021\010\014\013\016\016\013\035\017\001\002\000\022" +
    "\004\011\005\015\006\012\007\021\010\014\013\016\016" +
    "\013\035\017\001\002\000\022\004\011\005\015\006\012" +
    "\007\021\010\014\013\016\016\013\035\017\001\002\000" +
    "\004\011\047\001\002\000\022\004\011\005\015\006\012" +
    "\007\021\010\014\013\016\016\013\035\017\001\002\000" +
    "\022\004\011\005\015\006\012\007\021\010\014\013\016" +
    "\016\013\035\017\001\002\000\022\004\011\005\015\006" +
    "\012\007\021\010\014\013\016\016\013\035\017\001\002" +
    "\000\022\004\011\005\015\006\012\007\021\010\014\013" +
    "\016\016\013\035\017\001\002\000\022\004\011\005\015" +
    "\006\012\007\021\010\014\013\016\016\013\035\017\001" +
    "\002\000\042\014\ufff4\015\033\016\025\020\031\021\037" +
    "\022\026\023\036\024\ufff4\025\ufff4\026\ufff4\027\ufff4\030" +
    "\ufff4\031\ufff4\032\ufff4\033\ufff4\034\ufff4\001\002\000\042" +
    "\014\uffec\015\033\016\025\020\031\021\037\022\026\023" +
    "\036\024\023\025\041\026\030\027\035\030\032\031\027" +
    "\032\uffec\033\022\034\024\001\002\000\042\014\ufff8\015" +
    "\ufff8\016\ufff8\020\ufff8\021\ufff8\022\026\023\ufff8\024\ufff8" +
    "\025\ufff8\026\ufff8\027\ufff8\030\ufff8\031\ufff8\032\ufff8\033" +
    "\ufff8\034\ufff8\001\002\000\042\014\ufff6\015\ufff6\016\ufff6" +
    "\020\ufff6\021\ufff6\022\026\023\ufff6\024\ufff6\025\ufff6\026" +
    "\ufff6\027\ufff6\030\ufff6\031\ufff6\032\ufff6\033\ufff6\034\ufff6" +
    "\001\002\000\042\014\ufff2\015\033\016\025\020\031\021" +
    "\037\022\026\023\036\024\ufff2\025\ufff2\026\ufff2\027\ufff2" +
    "\030\ufff2\031\ufff2\032\ufff2\033\ufff2\034\ufff2\001\002\000" +
    "\006\002\ufffd\012\ufffd\001\002\000\042\014\ufffb\015\ufffb" +
    "\016\ufffb\020\031\021\037\022\026\023\036\024\ufffb\025" +
    "\ufffb\026\ufffb\027\ufffb\030\ufffb\031\ufffb\032\ufffb\033\ufffb" +
    "\034\ufffb\001\002\000\042\014\ufff1\015\033\016\025\020" +
    "\031\021\037\022\026\023\036\024\ufff1\025\ufff1\026\ufff1" +
    "\027\ufff1\030\ufff1\031\ufff1\032\ufff1\033\ufff1\034\ufff1\001" +
    "\002\000\042\014\ufff9\015\ufff9\016\ufff9\020\ufff9\021\ufff9" +
    "\022\026\023\ufff9\024\ufff9\025\ufff9\026\ufff9\027\ufff9\030" +
    "\ufff9\031\ufff9\032\ufff9\033\ufff9\034\ufff9\001\002\000\042" +
    "\014\ufff3\015\033\016\025\020\031\021\037\022\026\023" +
    "\036\024\ufff3\025\ufff3\026\ufff3\027\ufff3\030\ufff3\031\ufff3" +
    "\032\ufff3\033\ufff3\034\ufff3\001\002\000\042\014\ufff0\015" +
    "\033\016\025\020\031\021\037\022\026\023\036\024\ufff0" +
    "\025\ufff0\026\ufff0\027\ufff0\030\ufff0\031\ufff0\032\ufff0\033" +
    "\ufff0\034\ufff0\001\002\000\040\014\ufff7\015\ufff7\016\ufff7" +
    "\020\ufff7\021\ufff7\023\ufff7\024\ufff7\025\ufff7\026\ufff7\027" +
    "\ufff7\030\ufff7\031\ufff7\032\ufff7\033\ufff7\034\ufff7\001\002" +
    "\000\042\014\ufffa\015\ufffa\016\ufffa\020\031\021\037\022" +
    "\026\023\036\024\ufffa\025\ufffa\026\ufffa\027\ufffa\030\ufffa" +
    "\031\ufffa\032\ufffa\033\ufffa\034\ufffa\001\002\000\042\014" +
    "\uffee\015\033\016\025\020\031\021\037\022\026\023\036" +
    "\024\023\025\041\026\030\027\035\030\032\031\027\032" +
    "\uffee\033\uffee\034\uffee\001\002\000\042\014\ufff5\015\033" +
    "\016\025\020\031\021\037\022\026\023\036\024\ufff5\025" +
    "\ufff5\026\ufff5\027\ufff5\030\ufff5\031\ufff5\032\ufff5\033\ufff5" +
    "\034\ufff5\001\002\000\042\014\uffed\015\033\016\025\020" +
    "\031\021\037\022\026\023\036\024\023\025\041\026\030" +
    "\027\035\030\032\031\027\032\uffed\033\uffed\034\024\001" +
    "\002\000\042\014\uffef\015\033\016\025\020\031\021\037" +
    "\022\026\023\036\024\023\025\041\026\030\027\035\030" +
    "\032\031\027\032\uffef\033\uffef\034\uffef\001\002\000\042" +
    "\014\064\015\033\016\025\020\031\021\037\022\026\023" +
    "\036\024\023\025\041\026\030\027\035\030\032\031\027" +
    "\032\040\033\022\034\024\001\002\000\042\014\uffe6\015" +
    "\uffe6\016\uffe6\020\uffe6\021\uffe6\022\uffe6\023\uffe6\024\uffe6" +
    "\025\uffe6\026\uffe6\027\uffe6\030\uffe6\031\uffe6\032\uffe6\033" +
    "\uffe6\034\uffe6\001\002\000\042\014\ufffc\015\ufffc\016\ufffc" +
    "\020\ufffc\021\ufffc\022\ufffc\023\ufffc\024\ufffc\025\ufffc\026" +
    "\ufffc\027\ufffc\030\ufffc\031\ufffc\032\ufffc\033\ufffc\034\ufffc" +
    "\001\002\000\004\002\001\001\002\000\006\002\uffff\012" +
    "\uffff\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\065\000\010\002\005\003\004\004\003\001\001\000" +
    "\002\001\001\000\004\004\066\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\005\017\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\005\064\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\005\062\001\001\000" +
    "\004\005\061\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\005\060\001\001\000\004\005\057\001\001\000" +
    "\004\005\056\001\001\000\004\005\055\001\001\000\004" +
    "\005\054\001\001\000\004\005\053\001\001\000\004\005" +
    "\052\001\001\000\004\005\051\001\001\000\004\005\050" +
    "\001\001\000\004\005\047\001\001\000\002\001\001\000" +
    "\004\005\045\001\001\000\004\005\044\001\001\000\004" +
    "\005\043\001\001\000\004\005\042\001\001\000\004\005" +
    "\041\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    scanner s;
    parser(scanner s){this.s = s;}
    
    public void syntax_error(Symbol s){
        System.out.println("Error Sintactico en la linea " +
        (s.left) + " y columna " + (s.right) +
        ". No se esperaba el componente: " + (s.value) + ".");
    }

    public void unrecovered_syntax_error (Symbol s){
        System.out.println("Error Sintactico no recuperable en la linea" +
        (s.left) + " y columna " + (s.right) +
        ". No se esperaba el componente: " + (s.value) + ".");
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {



  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		LinkedList<Instruccion> start_val = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= INSTRUCCIONES 
            {
              LinkedList<Instruccion> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		LinkedList<Instruccion> a = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = a;   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INSTRUCCIONES ::= INSTRUCCIONES INSTRUCCION 
            {
              LinkedList<Instruccion> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		LinkedList<Instruccion> a = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = a; RESULT.add(b); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // INSTRUCCIONES ::= INSTRUCCION 
            {
              LinkedList<Instruccion> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new LinkedList<>(); RESULT.add(a); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INSTRUCCION ::= PRINTLN PAR1 EXPRESION PAR2 FINCADENA 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		   RESULT = new Print(a, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // EXPRESION ::= MENOS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, OperadoresAritmeticos.NEGACION, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // EXPRESION ::= EXPRESION MAS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.SUMA, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // EXPRESION ::= EXPRESION MENOS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.RESTA, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // EXPRESION ::= EXPRESION MULTIPLICACION EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.MULTIPLICACION, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // EXPRESION ::= EXPRESION DIVISION EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.DIVISION, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EXPRESION ::= EXPRESION POTENCIA EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.POTENCIA, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EXPRESION ::= EXPRESION MODULO EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Aritmeticas(a, b, OperadoresAritmeticos.MODULO, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EXPRESION ::= EXPRESION COMPARACIONIGUALIGUAL EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Relacionales(a, b, OperadoresRelacionales.IGUALACION, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXPRESION ::= EXPRESION NEGACION EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Relacionales(a, b, OperadoresRelacionales.DIFERENCIACION, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXPRESION ::= EXPRESION MENORQUE EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Relacionales(a, b, OperadoresRelacionales.MENOR_QUE, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXPRESION ::= EXPRESION MENORIGUALQUE EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Relacionales(a, b, OperadoresRelacionales.MENOR_IGUAL_QUE, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EXPRESION ::= EXPRESION MAYORQUE EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Relacionales(a, b, OperadoresRelacionales.MAYOR_QUE, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // EXPRESION ::= EXPRESION MAYORIGUALQUE EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Relacionales(a, b, OperadoresRelacionales.MAYOR_IGUAL_QUE, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EXPRESION ::= NOT EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Logicos(a, OperadoresLogicos.NOT, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EXPRESION ::= EXPRESION XOR EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Logicos(a, b, OperadoresLogicos.XOR, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EXPRESION ::= EXPRESION AND EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Logicos(a, b, OperadoresLogicos.AND, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // EXPRESION ::= EXPRESION OR EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Logicos(a, b, OperadoresLogicos.OR, aleft, aright);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // EXPRESION ::= ENTERO 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Nativo(Integer.parseInt(a), new Tipo(tipoDato.ENTERO), aleft, aright );   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // EXPRESION ::= DECIMAL 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Nativo(new Double(a), new Tipo(tipoDato.DECIMAL), aleft, aright );   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // EXPRESION ::= CADENA 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Nativo(a, new Tipo(tipoDato.CADENA), aleft, aright );   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // EXPRESION ::= CARACTER 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Nativo(a, new Tipo(tipoDato.CARACTER), aleft, aright );   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // EXPRESION ::= BOOLEANO 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		   RESULT = new Nativo(a, new Tipo(tipoDato.BOOLEANO), aleft, aright );   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // EXPRESION ::= PAR1 EXPRESION PAR2 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		   RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
