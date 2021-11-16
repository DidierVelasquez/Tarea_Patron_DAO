
import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Alumno extends Registro {
    
    public static Scanner sc = new Scanner (System.in);
   
    public static void ListarAlumno() throws SQLException{
        
         Connection conectar = 
         DriverManager.getConnection("jdbc:mysql://localhost/mensajes_bdd?serverTimezone=UTC","root","123456789");
         System.out.println("Conexion exitosa");
        
         String SQL = "SELECT*FROM Base_De_Datos_Menu.Alumno;";
         PreparedStatement ps = conectar.prepareStatement(SQL);
         ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
        
        int ID = rs.getInt("ID_Alumno");
        String Nombre = rs.getString("Nombre");
        String Apellido = rs.getString("Apellido");
        int Carnet = rs.getInt("Carnet");
        String Fecha = rs.getString("Fecha");
            
        System.out.printf("%d %s %s %d %s\n", ID, Nombre, Apellido, Carnet, Fecha);
            
    }
        rs.close();
        ps.close();
        conectar.close();
    }
    
    public static void InsertarAlumno(String Nombre, String Apellido, Integer Carnet) throws SQLException{
        
        Connection conectar = 
        DriverManager.getConnection("jdbc:mysql://localhost/mensajes_bdd?serverTimezone=UTC","root","123456789");
        
        String SQL = "INSERT INTO  Base_De_Datos_Menu.Alumno(Nombre,Apellido,Carnet,Fecha) VALUES (?,?,?, CURRENT_TIME ())";
        PreparedStatement ps = conectar.prepareStatement(SQL);
        ps.setString(1, Nombre);
        ps.setString(2, Apellido);
        ps.setInt(3, Carnet);
        
        ps.executeUpdate();
        ps.close();
        conectar.close();
        
    }
    
    public static void EditarAlumno( String Nombre, String Apellido, Integer Carnet,Integer ID) throws SQLException{
    Connection conectar =
    DriverManager.getConnection("jdbc:mysql://localhost/mensajes_bdd?serverTimezone=UTC","root","123456789");
        
        String SQL = "UPDATE  Base_De_Datos_Menu.Alumno SET Nombre = ?, Apellido = ?, Carnet = ? WHERE ID_Alumno = ?";
        PreparedStatement ps = conectar.prepareStatement(SQL);
        ps.setString(1, Nombre);
        ps.setString(2, Apellido);
        ps.setInt(3, Carnet);
        ps.setInt(4, ID);
        ps.executeUpdate();
        
        ps.close();
        conectar.close();
    
    }
    
    public static void EliminarAlumno(Integer ID) throws SQLException{
    
    Connection conectar = 
    DriverManager.getConnection("jdbc:mysql://localhost/mensajes_bdd?serverTimezone=UTC", "root","123456789");
        
    String SQL = "DELETE FROM Base_De_Datos_Menu.Alumno WHERE ID_Alumno = ?";
    PreparedStatement ps = conectar.prepareStatement(SQL);
        
    ps.setInt(1, ID);
    ps.executeUpdate();
        
        ps.close();
        conectar.close();
    }
    
    @Override
    public void MostrarDatos (){
        
      Integer Opcion = 0;
        do{  
        System.out.println("Registrar Alumno");
        System.out.println("================================================");
        System.out.println("1. Listar Alumno");
        System.out.println("2. Agregar Alumno");
        System.out.println("3. Editar Alumno");
        System.out.println("4. Eliminar Alumno");
        System.out.println("5. Salir");
        
        System.out.println("Seleccione una opcion");
        
        Opcion = sc.nextInt();
        
        switch (Opcion){
            case 1:
            {
                try {
                    ListarAlumno();
                } catch (SQLException ex) {
                    Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case 2:
            {
                try {
                    InsertarAlumno("Eleanor", "Garcia", 2100122);
                } catch (SQLException ex) {
                    Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case 3:
            {
                try {
                    EditarAlumno("Alexis", "Velasqiez",2100123,1);
                } catch (SQLException ex) {
                    Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break; 
 
            case 4: 
            {
                try {
                    EliminarAlumno(5);
                } catch (SQLException ex) {
                    Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case 5:
                break;
        }  
      }  while (Opcion != 5);    
        
    }
    
}
