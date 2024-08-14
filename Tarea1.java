
package com.mycompany.tarea1;


import java.util.Scanner;


public class Tarea1 {

    public static void main(String[] args) {
        
        Scanner myObj=new Scanner(System.in);
        String cadena=myObj.nextLine();
        int letra=0;
        int numero=0;
        int espacio=0;
        int signo=0;
        
        char[] c=cadena.toCharArray()  ;
        for (int i = 0; i<c.length ; i++) {
            if(Character.isLetter(c[i]))
            {letra++;
            }else if(Character.isSpaceChar(c[i])){
            espacio++;
            }else if(Character.isDigit(c[i])){
            numero++;
            }else{
            signo++;
            }
        }
        System.out.println("letra="+letra +" numero="+numero+" espacio="+espacio+" signo="+signo);
    }
}
