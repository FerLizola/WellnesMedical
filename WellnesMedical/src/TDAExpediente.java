
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
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
    private String nss, analisis,rfc;
    TDAExpediente(String nss,String analisis){
        setNss(nss);
        setAnalisis(analisis);
    }
    TDAExpediente(){
    }
    public boolean ordenarAnalisis(){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
             
               stmt.executeUpdate("UPDATE EXPEDIENTE SET NSS='"+nss+"', ANALISIS='" 
                       +analisis+"' WHERE NSS='"+nss+"'"); 
               stmt.executeUpdate("INSERT INTO RESULTADO_ANALISIS (PACIENTE, MEDICO, ANALISIS)"
                     +"VALUES ('"+nss+"','"+rfc+"','"+analisis+"')"); 
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
                
                ResultSet r = miCon.createStatement().executeQuery("SELECT NSS,ANALISIS FROM EXPEDIENTE");
                LinkedList consulta=new LinkedList();
                
                if(r.next()){ 
                    consulta.add(new TDAExpediente(r.getString("NSS"),r.getString("ANALISIS")));
                    Predicate<TDAExpediente> busqueda = expediente -> expediente.getNss().equals(buscar);
                    List<TDAExpediente> resultado= new ListComprehension<TDAExpediente>()
                            .suchThat( x->{
                                x.belongsTo(consulta);
                                x.is(busqueda);
                            });
                   return resultado.isEmpty();
                    
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
    public void setRFC(String rfc){
        this.rfc=rfc;
    }
}
