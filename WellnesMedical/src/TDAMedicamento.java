
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nando
 */
public class TDAMedicamento {
    private String nombre, descripcion, tipo, presentacion;
    

    public TDAMedicamento(String nombre, String descr, String tipo, String pres){
    
        setNombre(nombre);
        setDescripcion(descr);
        setTipo(tipo);
        setPresentacion(pres);
        
    }
    public TDAMedicamento(){
    }
    
   
    
    public void setNombre(String nombre){

        this.nombre=nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    private void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    private void setTipo(String tipo){
        this.tipo=tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    private void setPresentacion(String presentacion){
        this.presentacion=presentacion;
    }
    
    public String getPresentacion(){
        return presentacion;
    }
    public boolean guardar(){
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
             
               stmt.executeUpdate("INSERT INTO MEDICAMENTO " +
                  "VALUES ('"+nombre+"','"+descripcion+"','"+tipo+"','"+presentacion+"')"); 
                
                //JOptionPane.showMessageDialog(null,"Registro Exitoso, Medicamento Agregado a Inventario");
                miCon.close();
                return true;
                
            }
            catch(Exception e){
                return false;
                //JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return true;
    }
    public String buscar(String buscar){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "SELECT * FROM MEDICAMENTO WHERE NOMBRE ='"+buscar+"'";
        ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    miCon.close();
                   return(
                   "Nombre: "+r.getString("NOMBRE")+"\n"+
                   "Descripción: "+r.getString("DESCRIPCION")+"\n"+
                   "Tipo: "+r.getString("TIPO")+"\n"+
                   "Presentación: "+r.getString("PRESENTACION")
                   );
                   
                }
                else {
                    //JOptionPane.showMessageDialog(null,"No existe el medicamento buscado","No Encontrado",JOptionPane.WARNING_MESSAGE);
                    miCon.close();
                    return(null);
                     }
                
            }
            catch(Exception e){
                return null;
                //JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
}
