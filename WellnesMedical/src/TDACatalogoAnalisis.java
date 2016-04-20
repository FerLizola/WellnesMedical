
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nando Lizola
 */
public class TDACatalogoAnalisis {
    
    private String nombre, descripcion;
    
    TDACatalogoAnalisis(String nombre, String descripcion){
        
        setNombre(nombre);
        setDescripcion(descripcion);
        
    }
    
    public boolean guardar(){
        
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        
                stmt.executeUpdate("INSERT INTO ANALISIS " +
                "VALUES ('"+nombre+"','"+descripcion+"')"); 
                miCon.close();
                return true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    public boolean valores(){
        
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        
                stmt.executeUpdate("INSERT INTO ANALISIS " +
                "VALUES ('"+nombre+"','"+descripcion+"')"); 
                miCon.close();
                return true;
            }
            catch(Exception e){
                //JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private void setNombre(String nombre) {
        this.nombre=nombre;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }
}
