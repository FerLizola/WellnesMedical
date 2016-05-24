
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
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
 * @author Medrano
 */
public class TDACita {
    
    String nss, tipo, fecha, hora, personal, rfc, paciente;

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
    
    public boolean buscarNSS(String buscar){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "SELECT NOMBRE FROM PERSONAL WHERE RFC ='"+buscar+"'";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    personal = r.getString("ANALISIS");
                    miCon.close();
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
    
    public boolean buscarHorario(String tip, String fcha, String hra, String rf){ 
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "select * from CITAS where PERSONAL='"+rf+"' and FECHA='"+fcha+"' and HORA='"+hra+"' and TIPO='"+tip+"'";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){
                miCon.close();
                return true;
                } else {
                return false;
                }
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
   }
    
    public boolean Datos(String nss){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "select P.NOMBRE, PE.NOMBRE, PE.RFC  from PACIENTE P, PERSONAL PE, CONSULTORIO C \n" +
                             "where P.CONSULTORIO = C.N_CONSULTORIO and C.MEDICO = PE.RFC and P.NSS='"+nss+"'";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                   paciente = r.getString(1);
                   personal = r.getString(2);
                   rfc=r.getString(3);
                   this.nss=nss;
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
    
     public boolean agendar(String ns, String tip, String fcha, String hra, String rf){ 
        int col=0;
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "select * from CITAS where PERSONAL='"+rf+"' and FECHA='"+fcha+"' and HORA='"+hra+"'";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){
                miCon.close();
                return false;
                } else {
                stmt.executeUpdate("INSERT INTO CITAS VALUES ('"+ns+"','"+tip+"','"+fcha+"','"+hra+"','"+rf+"')"); 
                
                miCon.close();
                return true;
                }
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
   }
    
   public boolean Nombres(String ns, String rf){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "select P.NOMBRE, PE.NOMBRE from PACIENTE P, PERSONAL PE\n" +
                             "where P.NSS='"+ns+"' and PE.RFC='"+rf+"'";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                   paciente = r.getString(1);
                   personal = r.getString(2);
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
   
     public void limpiarTabla(JTable tabla){
         DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();   
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
    }
    
     public void mostrar(DefaultTableModel modelo, String NSS){
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "SELECT * FROM CITAS WHERE TIPO='Cita Previa' AND NSS='"+NSS+"'";
        ResultSet r = stmt.executeQuery(sql);
                
                while(r.next()){ 
                   String id = r.getString("ID_CITA");
                   String fch = r.getString("FECHA");
                   String hr = r.getString("HORA");
                   String person = r.getString("PERSONAL");
                   
                   
                   modelo.addRow(new Object[]{id,fch,hr,person});
                }
                miCon.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
      }
     
     public boolean Nombre(String ns){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "select NOMBRE  from PACIENTE where NSS='"+ns+"'";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                   paciente = r.getString(1);
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
     
    public boolean eliminar(JTable tabla){
        int i=tabla.getSelectedRow();
        if(i==-1){
            return false;
        }
        else {
            String id=tabla.getValueAt(i, 0).toString();
            Connection miCon = (new Conexion()).conectar();
            if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        
            String sql= "DELETE FROM CITAS WHERE ID_CITA="+id+"";
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
