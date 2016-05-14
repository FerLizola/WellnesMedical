
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class HistorialTDA {
    String peri,NSS,fecha,sinto, pade,expediente;
    String nombre, presion;
    float peso, temperatura, altura;
    public HistorialTDA(String peri, String NSS, String fecha, String sinto, String pade,String exp){
    
        this.peri=peri;
        this.NSS=NSS;
        this.fecha=fecha;
        this.sinto=sinto;
        this.pade=pade;
        expediente=exp;
    
    }
    public HistorialTDA(){
    }
     public boolean buscarNSS(String buscar){
        Connection miCon = (new Conexion()).conectar();
        
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "SELECT * FROM PACIENTE WHERE NSS ='"+buscar+"'";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    NSS = r.getString("NSS");
                    nombre = r.getString("NOMBRE");
                    
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
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "SELECT * FROM EXPEDIENTE WHERE NSS ='"+buscar+"'";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    expediente=r.getString("ID_EXPEDIENTE");
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
    public boolean guardar(){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
             
               stmt.executeUpdate("INSERT INTO HISTORIAL (ID_EXPEDIENTE, FECHA, PADECIMIENTO_ACTUAL, PERINATALES)"
                     +"VALUES ('"+expediente+"','"+fecha+"','"+pade+"','"+peri+"')"); 
                //JOptionPane.showMessageDialog(null,"Registro de Paciente, Exitoso..!");
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
     public Object[] getDatos(DefaultTableModel modelo, String exp){
        Connection miCon=(new Conexion()).conectar();
        Object[]s= new String[4];
        
        try{
            Statement stmt=miCon.createStatement();
            ResultSet res= stmt.executeQuery("SELECT * FROM HISTORIAL WHERE ID_EXPEDIENTE='"+exp+"'");
            
            
            while(res.next()){
                String fecha=res.getString("FECHA");
                String pad=res.getString("PADECIMIENTO_ACTUAL");
                String des=res.getString("ID_EXPEDIENTE");
                String val=res.getString("PERINATALES");
                //Object a=""+0;
                
                s[0]=fecha;
                s[1]=pad;
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
     public boolean obtenerSignos(String busca){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "SELECT * FROM EXPEDIENTE WHERE NSS ='"+busca+"'";
        //JOptionPane.showMessageDialog(null,expediente);
        ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    peso=Float.parseFloat(r.getString("PESO"));
                    altura=Float.parseFloat(r.getString("ALTURA"));
                    temperatura=Float.parseFloat(r.getString("TEMPERATURA"));
                    presion=r.getString("PRESION_ARTERIAL");
                    miCon.close();
                    return true;
                }
                else{
                    miCon.close();
                    return false;
                     }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }
     public String getExp(){
         return expediente;
     }
     public void setExp(String expediente){
         this.expediente=expediente;
     }
     public String getNombre(){
         return nombre;
     }
     public float getPeso(){
        return peso;
    }
     public float getAltura(){
        return altura;
    }
    public float getTemperatura(){
        return temperatura;
    }
    public String getPresion(){
        return presion;
    }
}
