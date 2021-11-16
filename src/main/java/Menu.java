

import java.util.Scanner;


public class Menu {

    
    public static Scanner sc = new Scanner (System.in);
    public static void main(String[] args) {
        
        Integer Opcion = 0;
        
        do{  
        System.out.println("Menu");
        System.out.println("================================================");
        System.out.println("1. Lista Catedraticos ");
        System.out.println("2. Lista Alumnos");
        System.out.println("3. Salir");
        
        System.out.println("Seleccione una opcion");
        
        Opcion = sc.nextInt();
        
        switch (Opcion){
            case 1:
            {
               Catedratico catedratico = new Catedratico ();
               catedratico.MostrarDatos();  
            }
                break;

            case 2:
            {
                Alumno alumno = new Alumno();
                alumno.MostrarDatos();
            }
                break;

            case 3:
                
                break;  
                
       }   
    }  while (Opcion != 3);        
  }  
}
