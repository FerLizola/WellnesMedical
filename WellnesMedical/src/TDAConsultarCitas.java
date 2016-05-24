import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TDAConsultarCitas {
    
    String rfc;
    public TDAConsultarCitas(String rfc){
        this.rfc=rfc;
    }
    
    public Object[] getDatos(DefaultTableModel modelo, String exp){
        Connection miCon=(new Conexion()).conectar();
        Object[]s= new String[3];
        
        try{
            Statement stmt=miCon.createStatement();
            ResultSet res= stmt.executeQuery("SELECT * FROM CITAS WHERE PERSONAL='"+rfc+"'");
            
            
            while(res.next()){
                String fecha=res.getString("FECHA");
                String pad=res.getString("HORA");
                String des=res.getString("NSS");
                s[0]=fecha;
                s[1]=pad;
                s[2]=des;
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
    public Object[] getDatosAux(DefaultTableModel modelo, String exp){
        Connection miCon=(new Conexion()).conectar();
        Object[]s= new String[3];
        
        try{
            Statement stmt=miCon.createStatement();
            ResultSet res= stmt.executeQuery("SELECT * FROM CITAS ");
            
            
            while(res.next()){
                String fecha=res.getString("FECHA");
                String pad=res.getString("HORA");
                String des=res.getString("NSS");
                s[0]=fecha;
                s[1]=pad;
                s[2]=des;
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
}
