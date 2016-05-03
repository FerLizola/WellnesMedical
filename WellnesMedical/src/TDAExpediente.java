
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
 * @author Bryan
 */
public class TDAExpediente {
    private String nss, analisis;
    
    public boolean ordenarAnalisis(){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
             
               stmt.executeUpdate("INSERT INTO EXPEDIENTE (NSS, ANALISIS)"
                       + "VALUES ('"+nss+"','"+analisis+"')"); 
                miCon.close();
                return true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }
    
    public boolean buscarNSS(String buscar){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "SELECT NSS,ANALISIS FROM EXPEDIENTE WHERE NSS ='"+buscar+"'";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    nss = r.getString("NSS");
                    analisis = r.getString("ANALISIS");
                    return true;
                }
                else{
                    miCon.close();
                    return false;
                }
                
            }
            catch(Exception e){
                return false;
            }
        }
        return false;
    }
    
    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getAnalisis() {
        return analisis;
    }

    public void setAnalisis(String analisis) {
        this.analisis = analisis;
    }
}
