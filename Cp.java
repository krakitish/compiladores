
package cp;

import java.util.Arrays;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Cp {
    
    
    
    static int palabra=0;
    static int nEntero=0;
    static int compuesto=0;
    static int car=0;
    
    static void tp(char[] c){
        
        int letra=0;
        int numero=0;
        int espacio=0;
        int signo=0;
        
        for (char ch :c) {
            car++;
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
        String texto=" ";
        try {
            
            Path filePath = Paths.get("C:\\Users\\juanj\\Documents\\texto.txt");

           
            texto = Files.readString(filePath);

           
            //System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
      // Scanner entrada=new Scanner(System.in);
       //String texto=entrada.nextLine();
       String[] plabras=texto.split(" ");
       
        for (String s:plabras) {
            tp(s.toCharArray());
        }
       System.out .println("\nTotal de caracteres (con espacios): "+(car+plabras.length-1)+"\nTotal de caracteres (sin espacios): "+car+"\nTotal de lexemas: "+(palabra+nEntero+compuesto)+"\nTotal de palabras:"+palabra+ "\nTotal de numeros: "+nEntero+"\nTotal de combinadas: "+compuesto);
       
    }
    
    
    
}

