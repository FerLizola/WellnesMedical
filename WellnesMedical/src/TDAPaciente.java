
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date; //pendiente sql.Date o util.Date
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TDAPaciente {
    
    private String nombre, nss, domicilio, unidad_medica, telefono, curp, doctor,
                    ciudad, estado, edo_civil, ocupacion, consultorio, sexo, depende;

    public String getDepende() {
        return depende;
    }

    public void setDepende(String depende) {
        this.depende = depende;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }
    private String fecha; //Pendiente analizar el uso de util.Date ó sql.Date para almacenar la fecha
    private int edad, codigo_postal;
    public TDAPaciente(){
    }
    public boolean insertar(){ 
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
             
               stmt.executeUpdate("INSERT INTO PACIENTE " +
                  "VALUES ('"+nss+"','"+nombre+"','"+domicilio+"','"+unidad_medica+"','"+telefono+"','"+curp+"','"+fecha+"','"+ciudad+"','"+estado+"','"+edo_civil+"','"+ocupacion+"',"+edad+","+codigo_postal+",'"+sexo+"',"+consultorio+")"); 
                
                //JOptionPane.showMessageDialog(null,"Registro de Paciente, Exitoso..!");
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
    
    public boolean eliminar(JTable tabla){
        int i=tabla.getSelectedRow();
        if(i==-1){
            return false;
        }
        else {
            String nss=tabla.getValueAt(i, 0).toString();
            Connection miCon = (new Conexion()).conectar();
            if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        
            String sql= "DELETE FROM PACIENTE WHERE NSS='"+nss+"'";
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
    public boolean Modificar(){
        int i=0;
        if(i==-1){
            return false;
        }
        else {
            
            Connection miCon = (new Conexion()).conectar();
            if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        
            String sql= "DELETE FROM PACIENTE WHERE NSS='"+nss+"'";
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
    public void limpiarTabla(JTable tabla){
         DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();   
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
    }
    
    public void mostrar(DefaultTableModel modelo){
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
               String sql = "SELECT * FROM PACIENTE";
               ResultSet r = stmt.executeQuery(sql);
                
                while(r.next()){ 
                   String nss = r.getString("NSS");
                   String Nombre = r.getString("NOMBRE");
                   String Domicilio = r.getString("DOMICILIO");
                   String Unidad = r.getString("UNIDAD_MEDICA");
                   String Telefono = r.getString("TELEFONO");
                   String Curp = r.getString("CURP");
                   String Fecha_nac = r.getString("FECHA_NACIMIENTO");
                   String Ciudad = r.getString("CIUDAD");
                   String Estado = r.getString("ESTADO");
                   String Estado_civ = r.getString("ESTADO_CIVIL");
                   String Ocupacion = r.getString("OCUPACION");
                   String Edad = r.getString("EDAD");
                   String Cp = r.getString("CP");
                   String Sexo = r.getString("SEXO");
                   String Consultorio = r.getString("CONSULTORIO");
                   
                   modelo.addRow(new Object[]{nss,Nombre,Domicilio,Unidad,Telefono,
                       Curp,Fecha_nac,Ciudad,Estado,Estado_civ,Ocupacion,
                       Edad,Cp,Sexo,Consultorio});
                }
                miCon.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
      }
    
    public boolean buscarNSS(String buscar){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "SELECT * FROM PACIENTE WHERE NSS ='"+buscar+"'";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    nss = r.getString("NSS");
                    nombre = r.getString("NOMBRE");
                    consultorio = r.getString("CONSULTORIO");
                    ciudad = r.getString("CIUDAD");
                    edad = Integer.parseInt(r.getString("EDAD"));
                    domicilio = r.getString("DOMICILIO");
                    estado = r.getString("ESTADO");
                    
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

    public boolean mostrarPaciente(DefaultTableModel modelo,String rfc){
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql ="select NSS, NOMBRE, CURP, TELEFONO from PACIENTE \n" +
                    "inner join CONSULTORIO on PACIENTE.CONSULTORIO = CONSULTORIO.N_CONSULTORIO \n" +
                    "and CONSULTORIO.MEDICO =  '"+rfc+"'";
        ResultSet r = stmt.executeQuery(sql);
                
                while(r.next()){ 
                   String NSS = r.getString("NSS");
                   String Nombre = r.getString("NOMBRE");
                   String Curp = r.getString("CURP");
                   String Telefono = r.getString("TELEFONO");
                   modelo.addRow(new Object[]{NSS,Nombre,Curp,Telefono});
                }
                miCon.close();
                return true;
            }
            catch(Exception e){
               return false;
            }
        }
        return false;
      }
    
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getUnidad_medica() {
        return unidad_medica;
    }

    public void setUnidad_medica(String unidad_medica) {
        this.unidad_medica = unidad_medica;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEdo_civil() {
        return edo_civil;
    }

    public void setEdo_civil(String edo_civil) {
        this.edo_civil = edo_civil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }    
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    
    public void setNss(String nss){
        this.nss = nss;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    
    public String getNss(){
        return nss;
    }
    
    public int getEdad() {
        return edad;
    }

}
