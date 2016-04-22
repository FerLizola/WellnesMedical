
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    private String nombre, descripcion, valRef;
    int x;
    TDACatalogoAnalisis(String nombre, String descripcion,String valRef){
        
        setNombre(nombre);
        setDescripcion(descripcion);
        this.valRef=valRef;
    }
    TDACatalogoAnalisis(){
    }
    
    public boolean guardar(){
        
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        
                stmt.executeUpdate("INSERT INTO ANALISIS " +
                "VALUES ('"+nombre+"','"+descripcion+"','"+valRef+"')"); 
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
    public Object[] valores(){
        
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
                Object o[]=new Object[4];
                String sql = "SELECT * FROM ANALISIS";
                ResultSet r = stmt.executeQuery(sql);
                while(r.next()){
                    
                    
                   
                }
                
                miCon.close();
                return null;
            }
            catch(Exception e){
                //JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return null;
    }

    public Object[] getDatos(DefaultTableModel modelo){
        Connection miCon=(new Conexion()).conectar();
        x=0;//Obtención de registros existentes
        try{
            Statement stmt=miCon.createStatement();
            //stmt.executeQuery("SELECT COUNT(1) AS TOTAL FROM ANALISIS");
            ResultSet res= stmt.executeQuery("SELECT COUNT(1) AS TOTAL FROM ANALISIS");
            res.next();
            x=res.getInt("TOTAL");
            //JOptionPane.showMessageDialog(null,x);
            res.close();
        }
        
        catch(Exception e){
            return null;
        }
        
        Object[]s= new String[4];
        
        try{
            Statement stmt=miCon.createStatement();
            ResultSet res= stmt.executeQuery("SELECT * FROM ANALISIS");
            
            
            while(res.next()){
                String id=res.getString("ID_ANALISIS");
                String nom=res.getString("NOMBRE");
                String des=res.getString("DESCRIPCION");
                String val=res.getString("REFERENCIA");
                //Object a=""+0;
                
                s[0]=id;
                s[1]=nom;
                s[2]=des;
                s[3]=val;
                
                modelo.addRow(s);
                
            }
            
            res.close();
            return s;
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        
    }
    
    private void setNombre(String nombre) {
        this.nombre=nombre;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }
    
    public boolean eliminar(JTable tabla){
        int i=tabla.getSelectedRow();
        if(i==-1){
            return false;
        }
        else {
            long cod=Long.parseLong(tabla.getValueAt(i, 0).toString());
            Connection miCon = (new Conexion()).conectar();
            if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        
            String sql= "DELETE FROM ANALISIS WHERE ID_ANALISIS="+cod+"";
            int a=stmt.executeUpdate(sql);
            
            if(a>0){
                return true;
            }
            else
                return false;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return true;
        }
    }
}
