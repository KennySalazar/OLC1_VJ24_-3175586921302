// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: src/analisis/lexico.jflex

package analisis;

//importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import excepciones.Errores;

@SuppressWarnings("fallthrough")
public class scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  2,  3,  1,  1,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     4,  5,  6,  0,  0,  7,  8,  9, 10, 11, 12, 13, 14, 15, 16, 17, 
    18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 20, 21, 22, 23,  0, 
     0, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
    39, 33, 40, 41, 42, 43, 44, 45, 33, 33, 33, 46, 47, 48, 49, 50, 
     0, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 51, 38, 
    39, 33, 52, 41, 53, 43, 44, 45, 33, 33, 33, 54, 55, 56,  0,  0, 
     0,  0,  0,  0,  0,  3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\2\1\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\21\23\1\24\1\25"+
    "\1\26\1\1\1\27\1\1\1\30\1\31\1\0\1\32"+
    "\1\0\1\33\2\0\1\34\1\35\1\36\1\0\1\2"+
    "\1\0\1\37\1\40\1\41\1\42\5\23\1\43\4\23"+
    "\1\44\16\23\1\0\1\45\2\46\1\0\1\47\11\23"+
    "\1\50\1\51\3\23\1\52\10\23\1\53\2\23\1\0"+
    "\1\2\1\23\1\54\1\23\1\55\3\23\1\56\1\57"+
    "\1\23\1\60\10\23\1\61\1\62\1\23\1\63\1\23"+
    "\1\64\1\65\3\23\1\66\3\23\1\67\3\23\1\70"+
    "\1\71\1\23\1\72\1\73\1\23\1\74\1\75\1\23"+
    "\1\76\2\23\1\77\2\23\1\100\1\23\1\101\1\23"+
    "\1\102";

  private static int [] zzUnpackAction() {
    int [] result = new int[179];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\71\0\162\0\253\0\344\0\71\0\u011d\0\u0156"+
    "\0\71\0\71\0\u018f\0\u01c8\0\71\0\u0201\0\71\0\u023a"+
    "\0\u0273\0\71\0\71\0\u02ac\0\u02e5\0\u031e\0\u0357\0\u0390"+
    "\0\u03c9\0\u0402\0\u043b\0\u0474\0\u04ad\0\u04e6\0\u051f\0\u0558"+
    "\0\u0591\0\u05ca\0\u0603\0\u063c\0\u0675\0\u06ae\0\u06e7\0\71"+
    "\0\71\0\71\0\u0720\0\71\0\u0759\0\71\0\71\0\344"+
    "\0\71\0\u0792\0\71\0\u07cb\0\u0804\0\71\0\71\0\71"+
    "\0\u083d\0\u0876\0\u08af\0\71\0\71\0\71\0\71\0\u08e8"+
    "\0\u0921\0\u095a\0\u0993\0\u09cc\0\u0a05\0\u0a3e\0\u0a77\0\u0ab0"+
    "\0\u0ae9\0\u04ad\0\u0b22\0\u0b5b\0\u0b94\0\u0bcd\0\u0c06\0\u0c3f"+
    "\0\u0c78\0\u0cb1\0\u0cea\0\u0d23\0\u0d5c\0\u0d95\0\u0dce\0\u0e07"+
    "\0\u0e40\0\71\0\71\0\u07cb\0\u0e79\0\u08af\0\u0eb2\0\u0eeb"+
    "\0\u0f24\0\u0f5d\0\u0f96\0\u0fcf\0\u1008\0\u1041\0\u107a\0\u04ad"+
    "\0\u04ad\0\u10b3\0\u10ec\0\u1125\0\u04ad\0\u115e\0\u1197\0\u11d0"+
    "\0\u1209\0\u1242\0\u127b\0\u12b4\0\u12ed\0\u04ad\0\u1326\0\u135f"+
    "\0\u1398\0\u083d\0\u13d1\0\u04ad\0\u140a\0\u04ad\0\u1443\0\u147c"+
    "\0\u14b5\0\u04ad\0\u04ad\0\u14ee\0\u04ad\0\u1527\0\u1560\0\u1599"+
    "\0\u15d2\0\u160b\0\u1644\0\u167d\0\u16b6\0\u04ad\0\u04ad\0\u16ef"+
    "\0\71\0\u1728\0\u04ad\0\u04ad\0\u1761\0\u179a\0\u17d3\0\u04ad"+
    "\0\u180c\0\u1845\0\u187e\0\u04ad\0\u18b7\0\u18f0\0\u1929\0\u04ad"+
    "\0\u04ad\0\u1962\0\u04ad\0\u04ad\0\u199b\0\u04ad\0\u04ad\0\u19d4"+
    "\0\u04ad\0\u1a0d\0\u1a46\0\u04ad\0\u1a7f\0\u1ab8\0\u04ad\0\u1af1"+
    "\0\u04ad\0\u1b2a\0\u04ad";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[179];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\0\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\2\35\1\36\2\35"+
    "\1\37\1\40\1\41\1\35\1\42\1\43\1\44\1\45"+
    "\1\35\1\46\1\47\1\50\1\2\1\51\1\52\1\53"+
    "\1\41\1\43\1\45\1\54\1\55\1\56\72\0\2\3"+
    "\1\0\1\3\112\0\1\57\42\0\6\60\1\61\50\60"+
    "\1\62\11\60\10\0\1\63\60\0\11\64\1\0\45\64"+
    "\1\65\11\64\14\0\1\66\71\0\1\67\72\0\1\70"+
    "\65\0\1\71\4\0\1\72\67\0\1\73\1\0\1\21"+
    "\74\0\1\74\70\0\1\75\1\76\67\0\1\77\64\0"+
    "\1\35\5\0\17\35\1\100\6\35\4\0\4\35\25\0"+
    "\1\35\5\0\16\35\1\101\1\35\1\102\5\35\4\0"+
    "\2\35\1\102\1\35\25\0\1\35\5\0\7\35\1\103"+
    "\6\35\1\104\7\35\4\0\4\35\25\0\1\35\5\0"+
    "\16\35\1\105\7\35\4\0\4\35\25\0\1\35\5\0"+
    "\13\35\1\106\12\35\4\0\4\35\25\0\1\35\5\0"+
    "\1\107\7\35\1\110\5\35\1\111\7\35\4\0\4\35"+
    "\25\0\1\35\5\0\26\35\4\0\4\35\25\0\1\35"+
    "\5\0\5\35\1\112\7\35\1\113\10\35\4\0\1\35"+
    "\1\113\2\35\25\0\1\35\5\0\4\35\1\114\3\35"+
    "\1\115\15\35\4\0\4\35\25\0\1\35\5\0\1\116"+
    "\25\35\4\0\4\35\25\0\1\35\5\0\4\35\1\117"+
    "\21\35\4\0\4\35\25\0\1\35\5\0\20\35\1\120"+
    "\5\35\4\0\2\35\1\120\1\35\25\0\1\35\5\0"+
    "\4\35\1\121\11\35\1\122\7\35\4\0\4\35\25\0"+
    "\1\35\5\0\22\35\1\123\3\35\4\0\3\35\1\123"+
    "\25\0\1\35\5\0\16\35\1\124\1\35\1\125\5\35"+
    "\4\0\2\35\1\125\1\35\25\0\1\35\5\0\1\126"+
    "\15\35\1\127\7\35\4\0\4\35\25\0\1\35\5\0"+
    "\7\35\1\130\16\35\4\0\4\35\7\0\1\131\153\0"+
    "\1\132\7\0\1\60\2\0\1\60\45\0\1\60\3\0"+
    "\3\60\14\0\1\133\70\0\1\134\33\0\1\64\2\0"+
    "\1\64\1\0\1\64\4\0\1\64\3\0\3\64\3\0"+
    "\14\71\1\135\54\71\2\72\1\0\66\72\22\0\1\136"+
    "\70\0\1\35\5\0\17\35\1\137\6\35\4\0\4\35"+
    "\25\0\1\35\5\0\16\35\1\140\7\35\4\0\4\35"+
    "\25\0\1\35\5\0\4\35\1\141\21\35\4\0\4\35"+
    "\25\0\1\35\5\0\1\142\25\35\4\0\4\35\25\0"+
    "\1\35\5\0\15\35\1\143\10\35\4\0\1\35\1\143"+
    "\2\35\25\0\1\35\5\0\23\35\1\144\2\35\4\0"+
    "\4\35\25\0\1\35\5\0\21\35\1\145\4\35\4\0"+
    "\4\35\25\0\1\35\5\0\13\35\1\146\12\35\4\0"+
    "\4\35\25\0\1\35\5\0\15\35\1\147\10\35\4\0"+
    "\1\35\1\147\2\35\25\0\1\35\5\0\20\35\1\150"+
    "\5\35\4\0\2\35\1\150\1\35\25\0\1\35\5\0"+
    "\22\35\1\151\3\35\4\0\3\35\1\151\25\0\1\35"+
    "\5\0\15\35\1\152\10\35\4\0\1\35\1\152\2\35"+
    "\25\0\1\35\5\0\21\35\1\153\4\35\4\0\4\35"+
    "\25\0\1\35\5\0\22\35\1\154\3\35\4\0\3\35"+
    "\1\154\25\0\1\35\5\0\25\35\1\155\4\0\4\35"+
    "\25\0\1\35\5\0\10\35\1\156\15\35\4\0\4\35"+
    "\25\0\1\35\5\0\14\35\1\157\5\35\1\160\3\35"+
    "\4\0\3\35\1\160\25\0\1\35\5\0\23\35\1\161"+
    "\2\35\4\0\4\35\25\0\1\35\5\0\1\162\17\35"+
    "\1\163\5\35\4\0\2\35\1\163\1\35\25\0\1\35"+
    "\5\0\21\35\1\164\4\35\4\0\4\35\25\0\1\35"+
    "\5\0\23\35\1\165\2\35\4\0\4\35\25\0\1\35"+
    "\5\0\20\35\1\166\5\35\4\0\2\35\1\166\1\35"+
    "\25\0\1\35\5\0\10\35\1\167\15\35\4\0\4\35"+
    "\25\0\1\35\5\0\10\35\1\170\15\35\4\0\4\35"+
    "\31\0\1\171\42\0\14\71\1\135\4\71\1\172\47\71"+
    "\22\0\1\35\5\0\4\35\1\173\21\35\4\0\4\35"+
    "\25\0\1\35\5\0\13\35\1\174\12\35\4\0\4\35"+
    "\25\0\1\35\5\0\1\175\25\35\4\0\4\35\25\0"+
    "\1\35\5\0\20\35\1\176\5\35\4\0\2\35\1\176"+
    "\1\35\25\0\1\35\5\0\21\35\1\177\1\200\3\35"+
    "\4\0\3\35\1\200\25\0\1\35\5\0\1\35\1\201"+
    "\24\35\4\0\4\35\25\0\1\35\5\0\4\35\1\202"+
    "\21\35\4\0\4\35\25\0\1\35\5\0\21\35\1\165"+
    "\4\35\4\0\4\35\25\0\1\35\5\0\3\35\1\203"+
    "\22\35\4\0\4\35\25\0\1\35\5\0\6\35\1\204"+
    "\17\35\4\0\4\35\25\0\1\35\5\0\22\35\1\205"+
    "\3\35\4\0\3\35\1\205\25\0\1\35\5\0\2\35"+
    "\1\206\23\35\4\0\4\35\25\0\1\35\5\0\15\35"+
    "\1\207\10\35\4\0\1\35\1\207\2\35\25\0\1\35"+
    "\5\0\16\35\1\210\7\35\4\0\4\35\25\0\1\35"+
    "\5\0\23\35\1\211\2\35\4\0\4\35\25\0\1\35"+
    "\5\0\15\35\1\212\10\35\4\0\1\35\1\212\2\35"+
    "\25\0\1\35\5\0\20\35\1\213\5\35\4\0\2\35"+
    "\1\213\1\35\25\0\1\35\5\0\10\35\1\214\15\35"+
    "\4\0\4\35\25\0\1\35\5\0\22\35\1\215\3\35"+
    "\4\0\3\35\1\215\25\0\1\35\5\0\4\35\1\216"+
    "\21\35\4\0\4\35\25\0\1\35\5\0\3\35\1\217"+
    "\22\35\4\0\4\35\25\0\1\35\5\0\13\35\1\220"+
    "\12\35\4\0\4\35\32\0\1\221\63\0\1\35\5\0"+
    "\15\35\1\222\10\35\4\0\1\35\1\222\2\35\25\0"+
    "\1\35\5\0\12\35\1\223\13\35\4\0\4\35\25\0"+
    "\1\35\5\0\22\35\1\224\3\35\4\0\3\35\1\224"+
    "\25\0\1\35\5\0\10\35\1\225\15\35\4\0\4\35"+
    "\25\0\1\35\5\0\13\35\1\226\12\35\4\0\4\35"+
    "\25\0\1\35\5\0\22\35\1\227\3\35\4\0\3\35"+
    "\1\227\25\0\1\35\5\0\7\35\1\230\16\35\4\0"+
    "\4\35\25\0\1\35\5\0\22\35\1\231\3\35\4\0"+
    "\3\35\1\231\25\0\1\35\5\0\24\35\1\232\1\35"+
    "\4\0\4\35\25\0\1\35\5\0\20\35\1\233\5\35"+
    "\4\0\2\35\1\233\1\35\25\0\1\35\5\0\3\35"+
    "\1\234\22\35\4\0\4\35\25\0\1\35\5\0\22\35"+
    "\1\235\3\35\4\0\3\35\1\235\25\0\1\35\5\0"+
    "\15\35\1\236\10\35\4\0\1\35\1\236\2\35\25\0"+
    "\1\35\5\0\20\35\1\237\5\35\4\0\2\35\1\237"+
    "\1\35\25\0\1\35\5\0\4\35\1\240\21\35\4\0"+
    "\4\35\25\0\1\35\5\0\3\35\1\241\22\35\4\0"+
    "\4\35\25\0\1\35\5\0\15\35\1\242\10\35\4\0"+
    "\1\35\1\242\2\35\25\0\1\35\5\0\4\35\1\243"+
    "\21\35\4\0\4\35\25\0\1\35\5\0\7\35\1\244"+
    "\16\35\4\0\4\35\25\0\1\35\5\0\13\35\1\245"+
    "\12\35\4\0\4\35\25\0\1\35\5\0\4\35\1\246"+
    "\21\35\4\0\4\35\25\0\1\35\5\0\15\35\1\247"+
    "\10\35\4\0\1\35\1\247\2\35\25\0\1\35\5\0"+
    "\26\35\4\0\1\250\3\35\25\0\1\35\5\0\6\35"+
    "\1\251\17\35\4\0\4\35\25\0\1\35\5\0\10\35"+
    "\1\252\15\35\4\0\4\35\25\0\1\35\5\0\23\35"+
    "\1\253\2\35\4\0\4\35\25\0\1\35\5\0\15\35"+
    "\1\254\10\35\4\0\1\35\1\254\2\35\25\0\1\35"+
    "\5\0\25\35\1\255\4\0\4\35\25\0\1\35\5\0"+
    "\15\35\1\256\10\35\4\0\1\35\1\256\2\35\25\0"+
    "\1\35\5\0\4\35\1\257\21\35\4\0\4\35\25\0"+
    "\1\35\5\0\10\35\1\260\15\35\4\0\4\35\25\0"+
    "\1\35\5\0\6\35\1\261\17\35\4\0\4\35\25\0"+
    "\1\35\5\0\22\35\1\262\3\35\4\0\3\35\1\262"+
    "\25\0\1\35\5\0\7\35\1\263\16\35\4\0\4\35"+
    "\3\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[7011];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\2\1\2\11\2\1\1\11"+
    "\1\1\1\11\2\1\2\11\24\1\3\11\1\1\1\11"+
    "\1\1\2\11\1\0\1\11\1\0\1\11\2\0\3\11"+
    "\1\0\1\1\1\0\4\11\31\1\1\0\2\11\1\1"+
    "\1\0\33\1\1\0\27\1\1\11\42\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[179];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */

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



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public scanner(java.io.Reader in) {
      yyline = 1;
    yycolumn = 1;
    listaErrores = new LinkedList<>();
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    return ZZ_CMAP[input];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return symbol(sym.EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { listaErrores.add(new Errores("LEXICO","El caracter "+
                yytext()+" NO pertenece al lenguaje", yyline, yycolumn));
            }
          // fall through
          case 67: break;
          case 2:
            { 
            }
          // fall through
          case 68: break;
          case 3:
            { return new Symbol(sym.NOT, yyline, yycolumn, yytext());
            }
          // fall through
          case 69: break;
          case 4:
            { return new Symbol(sym.MODULO, yyline, yycolumn, yytext());
            }
          // fall through
          case 70: break;
          case 5:
            { return new Symbol(sym.PAR1, yyline, yycolumn, yytext());
            }
          // fall through
          case 71: break;
          case 6:
            { return new Symbol(sym.PAR2, yyline, yycolumn, yytext());
            }
          // fall through
          case 72: break;
          case 7:
            { return new Symbol(sym.MULTIPLICACION, yyline, yycolumn, yytext());
            }
          // fall through
          case 73: break;
          case 8:
            { return new Symbol(sym.MAS, yyline, yycolumn, yytext());
            }
          // fall through
          case 74: break;
          case 9:
            { return new Symbol(sym.COMA, yyline, yycolumn, yytext());
            }
          // fall through
          case 75: break;
          case 10:
            { return new Symbol(sym.MENOS, yyline, yycolumn, yytext());
            }
          // fall through
          case 76: break;
          case 11:
            { return new Symbol(sym.PUNTO, yyline, yycolumn, yytext());
            }
          // fall through
          case 77: break;
          case 12:
            { return new Symbol(sym.DIVISION, yyline, yycolumn, yytext());
            }
          // fall through
          case 78: break;
          case 13:
            { return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());
            }
          // fall through
          case 79: break;
          case 14:
            { return new Symbol(sym.DOSPUNTOS, yyline, yycolumn, yytext());
            }
          // fall through
          case 80: break;
          case 15:
            { return new Symbol(sym.FINCADENA, yyline, yycolumn, yytext());
            }
          // fall through
          case 81: break;
          case 16:
            { return new Symbol(sym.MENORQUE, yyline, yycolumn, yytext());
            }
          // fall through
          case 82: break;
          case 17:
            { return new Symbol(sym.IGUAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 83: break;
          case 18:
            { return new Symbol(sym.MAYORQUE, yyline, yycolumn, yytext());
            }
          // fall through
          case 84: break;
          case 19:
            { return new Symbol(sym.ID, yyline, yycolumn, yytext());
            }
          // fall through
          case 85: break;
          case 20:
            { return new Symbol(sym.CORCHETEA, yyline, yycolumn, yytext());
            }
          // fall through
          case 86: break;
          case 21:
            { return new Symbol(sym.CORCHETEC, yyline, yycolumn, yytext());
            }
          // fall through
          case 87: break;
          case 22:
            { return new Symbol(sym.XOR, yyline, yycolumn, yytext());
            }
          // fall through
          case 88: break;
          case 23:
            { return new Symbol(sym.LLAVEA, yyline, yycolumn, yytext());
            }
          // fall through
          case 89: break;
          case 24:
            { return new Symbol(sym.LLAVEC, yyline, yycolumn, yytext());
            }
          // fall through
          case 90: break;
          case 25:
            { return new Symbol(sym.NEGACION, yyline, yycolumn, yytext());
            }
          // fall through
          case 91: break;
          case 26:
            { String cadena = yytext();
    cadena = cadena.substring(1, cadena.length()-1);
    

    cadena = cadena.replaceAll("\\\\n", "\n"); 
    cadena = cadena.replaceAll("\\\\t", "\t"); 
    cadena = cadena.replaceAll("\\\\r", "\r"); 
    cadena = cadena.replaceAll("\\\\'", "\'"); 
    cadena = cadena.replaceAll("\\\\\"", "\""); 
    cadena = cadena.replaceAll("\\\\\\\\", "\\\\"); 

    return new Symbol(sym.CADENA, yyline, yycolumn,cadena);
            }
          // fall through
          case 92: break;
          case 27:
            { return new Symbol(sym.AND, yyline, yycolumn, yytext());
            }
          // fall through
          case 93: break;
          case 28:
            { return new Symbol(sym.POTENCIA, yyline, yycolumn, yytext());
            }
          // fall through
          case 94: break;
          case 29:
            { return new Symbol(sym.INCREMENTO, yyline, yycolumn, yytext());
            }
          // fall through
          case 95: break;
          case 30:
            { return new Symbol(sym.DECREMENTO, yyline, yycolumn, yytext());
            }
          // fall through
          case 96: break;
          case 31:
            { return new Symbol(sym.MENORIGUALQUE, yyline, yycolumn, yytext());
            }
          // fall through
          case 97: break;
          case 32:
            { return new Symbol(sym.COMPARACIONIGUALIGUAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 98: break;
          case 33:
            { return new Symbol(sym.SIGNOCASOMATCH, yyline, yycolumn, yytext());
            }
          // fall through
          case 99: break;
          case 34:
            { return new Symbol(sym.MAYORIGUALQUE, yyline, yycolumn, yytext());
            }
          // fall through
          case 100: break;
          case 35:
            { return new Symbol(sym.DO, yyline, yycolumn, yytext());
            }
          // fall through
          case 101: break;
          case 36:
            { return new Symbol(sym.IF, yyline, yycolumn, yytext());
            }
          // fall through
          case 102: break;
          case 37:
            { return new Symbol(sym.OR, yyline, yycolumn, yytext());
            }
          // fall through
          case 103: break;
          case 38:
            { String caracter = yytext();
    caracter = caracter.substring(1, caracter.length()-1);
    return new Symbol(sym.CARACTER, yyline, yycolumn,caracter);
            }
          // fall through
          case 104: break;
          case 39:
            { return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 105: break;
          case 40:
            { return new Symbol(sym.FOR, yyline, yycolumn, yytext());
            }
          // fall through
          case 106: break;
          case 41:
            { return new Symbol(sym.INT, yyline, yycolumn, yytext());
            }
          // fall through
          case 107: break;
          case 42:
            { return new Symbol(sym.NEW, yyline, yycolumn, yytext());
            }
          // fall through
          case 108: break;
          case 43:
            { return new Symbol(sym.VAR, yyline, yycolumn, yytext());
            }
          // fall through
          case 109: break;
          case 44:
            { return new Symbol(sym.BOOL, yyline, yycolumn, yytext());
            }
          // fall through
          case 110: break;
          case 45:
            { return new Symbol(sym.CHAR, yyline, yycolumn, yytext());
            }
          // fall through
          case 111: break;
          case 46:
            { return new Symbol(sym.ELSE, yyline, yycolumn, yytext());
            }
          // fall through
          case 112: break;
          case 47:
            { return new Symbol(sym.FIND, yyline, yycolumn, yytext());
            }
          // fall through
          case 113: break;
          case 48:
            { return new Symbol(sym.LISTA, yyline, yycolumn, yytext());
            }
          // fall through
          case 114: break;
          case 49:
            { return new Symbol(sym.BOOLEANO, yyline, yycolumn, yytext());
            }
          // fall through
          case 115: break;
          case 50:
            { return new Symbol(sym.VOID, yyline, yycolumn, yytext());
            }
          // fall through
          case 116: break;
          case 51:
            { return new Symbol(sym.SIGNODEFAULTMATCH, yyline, yycolumn, yytext());
            }
          // fall through
          case 117: break;
          case 52:
            { return new Symbol(sym.BREAK, yyline, yycolumn, yytext());
            }
          // fall through
          case 118: break;
          case 53:
            { return new Symbol(sym.CONST, yyline, yycolumn, yytext());
            }
          // fall through
          case 119: break;
          case 54:
            { return new Symbol(sym.MATCH, yyline, yycolumn, yytext());
            }
          // fall through
          case 120: break;
          case 55:
            { return new Symbol(sym.ROUND, yyline, yycolumn, yytext());
            }
          // fall through
          case 121: break;
          case 56:
            { return new Symbol(sym.WHILE, yyline, yycolumn, yytext());
            }
          // fall through
          case 122: break;
          case 57:
            { return new Symbol(sym.APPEND, yyline, yycolumn, yytext());
            }
          // fall through
          case 123: break;
          case 58:
            { return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());
            }
          // fall through
          case 124: break;
          case 59:
            { return new Symbol(sym.LENGTH, yyline, yycolumn, yytext());
            }
          // fall through
          case 125: break;
          case 60:
            { return new Symbol(sym.REMOVE, yyline, yycolumn, yytext());
            }
          // fall through
          case 126: break;
          case 61:
            { return new Symbol(sym.RETURN, yyline, yycolumn, yytext());
            }
          // fall through
          case 127: break;
          case 62:
            { return new Symbol(sym.STRING, yyline, yycolumn, yytext());
            }
          // fall through
          case 128: break;
          case 63:
            { return new Symbol(sym.PRINTLN, yyline, yycolumn, yytext());
            }
          // fall through
          case 129: break;
          case 64:
            { return new Symbol(sym.CONTINUE, yyline, yycolumn, yytext());
            }
          // fall through
          case 130: break;
          case 65:
            { return new Symbol(sym.TOSTRING, yyline, yycolumn, yytext());
            }
          // fall through
          case 131: break;
          case 66:
            { return new Symbol(sym.START_WITH, yyline, yycolumn, yytext());
            }
          // fall through
          case 132: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
