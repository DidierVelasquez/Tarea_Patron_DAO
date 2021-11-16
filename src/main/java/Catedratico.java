

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author casa vb
 */
public class Catedratico extends Registro {
    
     public static Scanner sc = new Scanner (System.in);
     
     @Override
     public void MostrarDatos (){
       
        Integer Opcion = 0;
        
        do{  
        System.out.println("Registrar Catedratico");
        System.out.println("================================================");
        System.out.println("1. Lista Catedraticos");
        System.out.println("2. Agregar Catedratico");
        System.out.println("3. Editar Catedratico");
        System.out.println("4. Eliminar Catedratico");
        System.out.println("5. Salir");
        
        System.out.println("Seleccione una opcion");
        
        Opcion = sc.nextInt();
        
        switch (Opcion){
            case 1:
            {
                try {
                    ListaCatedraticos();
                } catch (SQLException ex) {
                    Logger.getLogger(Catedratico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case 2:
            {
                try {
                    RegistrarCatedratico ("Lilian", "Sucelí", "Introduccion a la ingenieria");
                } catch (SQLException ex) {
                    Logger.getLogger(Catedratico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case 3:
            {
                try {
                    EditarCatedratico("Lilian", "Suceli","Introduccion a la ingenieria",2);
                } catch (SQLException ex) {
                    Logger.getLogger(Catedratico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break; 
 
            case 4: 
            {
                try {
                    Eliminaratedratico(1);
                } catch (SQLException ex) {
                    Logger.getLogger(Catedratico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case 5:
                break;
       }  
     }  while (Opcion != 5);  
         
     }
    
     public static void ListaCatedraticos() throws SQLException{
         
         Connection conectar = 
         DriverManager.getConnection("jdbc:mysql://localhost/mensajes_bdd?serverTimezone=UTC","root","123456789");
         System.out.println("Conexion exitosa");
        
         String SQL = "SELECT*FROM Base_De_Datos_Menu.Catedratico;";
         PreparedStatement ps = conectar.prepareStatement(SQL);
         ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
        
        int ID = rs.getInt("ID_Catedratico");
        String Nombre = rs.getString("Nombre");
        String Apellido = rs.getString("Apellido");
        String Curso = rs.getString("Curso");
        String Fecha = rs.getString("Fecha");
            
        System.out.printf("%d %s %s %s %s\n", ID, Nombre, Apellido, Curso, Fecha);
            
    }
        rs.close();
        ps.close();
        conectar.close();
     }
     
     public static void RegistrarCatedratico (String Nombre, String Apellido, String Curso) throws SQLException{
         
        Connection conectar = 
        DriverManager.getConnection("jdbc:mysql://localhost/mensajes_bdd?serverTimezone=UTC","root","123456789");
        
        String SQL = "INSERT INTO  Base_De_Datos_Menu.Catedratico(Nombre,Apellido,Curso,Fecha) VALUES (?,?,?, CURRENT_TIME ())";
        PreparedStatement ps = conectar.prepareStatement(SQL);
        ps.setString(1, Nombre);
        ps.setString(2, Apellido);
        ps.setString(3, Curso);
        
        ps.executeUpdate();
        ps.close();
        conectar.close();
     } 

     public static void EditarCatedratico( String Nombre, String Apellido, String Curso, Integer ID) throws SQLException{
         
        Connection conectar =
        DriverManager.getConnection("jdbc:mysql://localhost/mensajes_bdd?serverTimezone=UTC","root","123456789");
        
        String SQL = "UPDATE  Base_De_Datos_Menu.Catedratico\n SET Nombre = ?, Apellido = ?, Curso = ? WHERE ID_Catedratico = ?";
        PreparedStatement ps = conectar.prepareStatement(SQL);
        
        ps.setString(1, Nombre);
        ps.setString(2, Apellido);
        ps.setString(3, Curso);
        ps.setInt(4, ID);
        ps.executeUpdate();
        
        ps.close();
        conectar.close();
        
     }
     
     public static void Eliminaratedratico( Integer ID) throws SQLException{
         
        Connection conectar = 
        DriverManager.getConnection("jdbc:mysql://localhost/mensajes_bdd?serverTimezone=UTC", "root","123456789");
        
        String SQL = "DELETE FROM Base_De_Datos_Menu.Catedratico WHERE ID_Catedratico = ?";
        PreparedStatement ps = conectar.prepareStatement(SQL);
        
        ps.setInt(1, ID);
        ps.executeUpdate();
     }
}

