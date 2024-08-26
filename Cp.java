
package cp;

import java.util.Arrays;
import java.util.Scanner;

public class Cp {
    
    static int palabra=0;
    static int nEntero=0;
    static int compuesto=0;
    
    static void tp(char[] c){
        
        int letra=0;
        int numero=0;
        int espacio=0;
        int signo=0;
        
        for (char ch :c) {
            if(Character.isLetter(ch))
            {letra++;
            }else if(Character.isSpaceChar(ch)){
            espacio++;
            }else if(Character.isDigit(ch)){
            numero++;
            }else{
            signo++;
            }
            }
        
        System.out.print(c);
        
        if (letra>0&&numero==0) {
                 System.out.print("(Palabra) ");
                 palabra++;
            } else if (letra==0&&numero>0) {
                 System.out.print("(Numero entero) ");
                 nEntero++;
            }
             else  {
                System.out.print("(Compuesto) ");
                compuesto++;
            }
        
    }
    
  
    public static void main(String[] args) {
       Scanner entrada=new Scanner(System.in);
       String texto=entrada.nextLine();
       String[] palabras=texto.split(" ");
       
        for (String s:palabras) {
            tp(s.toCharArray());
        }
       System.out .println("\nNo. Total:"+(palabra+nEntero+compuesto)+" Palabras:"+palabra+" No. Enteros:"+nEntero+" Palabras compuestas:"+compuesto);
       
    }
    
    
    
}

