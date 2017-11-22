import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import javax.swing.JOptionPane;


public class TDAPersonal {
    
    private String rfc, nombre, domicilio, telefono, puesto, pass, horario;

    public String getPass() {
        return pass;
    }

    public String getHorario() {
        return horario;
    }
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
             
               stmt.executeUpdate("INSERT INTO PERSONAL (RFC,NOMBRE,DOMICILIO,TELEFONO,PUESTO,HORARIO,PASSWORD"
                       +") " +
                  "VALUES ('"+rfc+"','"+nombre+"','"+domicilio+"','"+telefono+"','"+puesto+"','"+horario+"','"+pass+"')"); 
                
                //JOptionPane.showMessageDialog(null,"Registro de Personal, Exitoso..!");
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
    
    public boolean buscarRFC(String buscar){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "SELECT * FROM PERSONAL WHERE RFC ='"+buscar+"'";
                ResultSet r = stmt.executeQuery(sql);                
                if(r.next()){ 
                    nombre = r.getString("NOMBRE");
                    domicilio = r.getString("DOMICILIO");
                    telefono = r.getString("TELEFONO");
                    puesto = r.getString("PUESTO");
                    horario = r.getString("HORARIO");
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
   
    public boolean buscarRfcFuncional(String buscar){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                
                Statement stmt = miCon.createStatement();
                String sql = "SELECT * FROM PERSONAL";
                ResultSet r = stmt.executeQuery(sql);
                
                LinkedList consulta = new LinkedList();
                // 
                while(r.next()) {
                  String rfc = r.getString("rfc");
                  String nombre = r.getString("nombre");
                  String domicilio = r.getString("domicilio");
                  String telefono = r.getString("telefono");
                  String puesto = r.getString("puesto");
                  String horario = r.getString("horario");
                  String pass = r.getString("password");
                  
                  TDAPersonal personal = new TDAPersonal(rfc, nombre, domicilio, 
                          telefono, puesto, horario, pass);
                  consulta.add(personal);
                }
                
                Predicate<TDAPersonal> busqueda = persona -> persona.getRfc().equals(buscar);
                
                List <TDAPersonal> resultado = new ListComprehension<TDAPersonal>()
                .suchThat(x -> {
                    x.belongsTo(consulta);
                    x.is(busqueda);
                });
                
                for(TDAPersonal personal : resultado){
                    this.rfc = personal.getRfc();
                    this.nombre = personal.getNombre();
                    this.domicilio = personal.getDomicilio();
                    this.telefono = personal.getTelefono();
                    this.puesto = personal.getPuesto();
                    this.horario = personal.getHorario();
                    this.pass = personal.getPass();
                    miCon.close();
                    return true;
                }
                
                miCon.close();
                return false;
                
            }
            catch(Exception e){
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
