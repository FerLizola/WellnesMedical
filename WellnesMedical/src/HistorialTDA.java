
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class HistorialTDA {
    String peri,NSS,fecha,sinto, pade,expediente;
    
    public HistorialTDA(String peri, String NSS, String fecha, String sinto, String pade,String exp){
    
        this.peri=peri;
        this.NSS=NSS;
        this.fecha=fecha;
        this.sinto=sinto;
        this.pade=pade;
        expediente=exp;
    
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
    
    
}
