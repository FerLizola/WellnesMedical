import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class TDAPersonal {
    
    private String rfc, nombre, domicilio, telefono, puesto, pass, horario;
    private Date hora_ini, hora_fin;
    
    public TDAPersonal(){
    }
    public TDAPersonal(String rfc,String nombre, String domicilio, String telefono, String puesto,String horario, String pass){
        setRfc(rfc);
        setNombre(nombre);
        setDomicilio(domicilio);
        setTelefono(telefono);
        setPuesto(puesto);
        setHorario(horario);
        setPass(pass);
    }
    public boolean insertar(){
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
             
               stmt.executeUpdate("INSERT INTO PERSONAL " +
                  "VALUES ('"+rfc+"','"+nombre+"','"+domicilio+"','"+telefono+"','"+puesto+"','"+horario+"','"+pass+"')"); 
                
                //JOptionPane.showMessageDialog(null,"Registro de Personal, Exitoso..!");
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
    
    public String getRfc() {
        return rfc;
    }

    private void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    private void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    private void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    private void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Date getHora_ini() {
        return hora_ini;
    }

    private void setHorario(String hora_ini) {
        this.horario = hora_ini;
    }

    public Date getHora_fin() {
        return hora_fin;
    }

    private void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
