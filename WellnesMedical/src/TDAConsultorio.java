
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TDAConsultorio {
    private String medico, especialidad;
    private int consultorio;
    
    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }
    
    public boolean insertar(){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
             
                stmt.executeUpdate("INSERT INTO CONSULTORIO " +
                  "VALUES ('"+consultorio+"','"+medico+"','"+especialidad+"')"); 
                
                miCon.close();
                return true;
            }
            catch(Exception e){
                
                return false;
            }
        }
        return true;
    }
        
    public void mostrar(DefaultTableModel modelo){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
               String sql = "SELECT * FROM CONSULTORIO";
               ResultSet r = stmt.executeQuery(sql);
                
                while(r.next()){ 
                   long consultorio=r.getInt("N_CONSULTORIO");
                   String medico=r.getString("MEDICO");
                   String especialidad=r.getString("DESCRIPCION");
                   modelo.addRow(new Object[]{consultorio, medico, especialidad});
                }
                miCon.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
      }
    
    public void limpiarTabla(JTable tabla){
         DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();   
         int filas=tabla.getRowCount();
         for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
         }
    }
    

}
