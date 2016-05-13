
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
 * @author nando
 */
public class TDAGenerarHistorial {
    private String NSS, nombre, cirujias,alergias,antecedentes,expediente,medicamento,vacunas
            ,diagnostico,analisis,ts,presion;
    private float  altura, peso,temperatura;
    
    public TDAGenerarHistorial(String nss){
        setNSS(nss);
    }
    public TDAGenerarHistorial(String presion, float altura, float peso, float temperatura){
        setPresion(presion);
        setAltura(altura);
        setPeso(peso);
        setTemperatura(temperatura);
    }
    public TDAGenerarHistorial(String expediente, String alergias, String cirujias,String vacunas,String antecedentes, String ts){
        setExpediente(expediente);
        setAlergias(alergias);
        setCirujias(cirujias);
        setVacuna(vacunas);
        setAntecedentes(antecedentes);
        setTS(ts);
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
    public boolean crearHistorial(String nss){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
             
               stmt.executeUpdate("INSERT INTO EXPEDIENTE (ID_EXPEDIENTE, NSS, ALERGIAS, CIRUJIAS"
                       + ", VACUNAS, ANTECEDENTES_FAMILIARES, GPOSANGUINEO_RH) " +
                  "VALUES ('"+expediente+"','"+nss+"','"+alergias+"','"+cirujias+"','"
                       +vacunas+"','"+antecedentes+"','"+ts+"')"); 
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
    public boolean verificarHistorial(){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
             
               String sql=("SELECT * FROM EXPEDIENTE WHERE NSS= '" +NSS+"')");
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    NSS = r.getString("NSS");
                    nombre = r.getString("NOMBRE");
                    return true;
                }
                else{
                    miCon.close();
                    return false;
                }   
                //JOptionPane.showMessageDialog(null,"Registro de Paciente, Exitoso..!");
                
                
            }
            catch(Exception e){
                //JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    public boolean regSigVit(String NSS){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        
            String sql= "UPDATE EXPEDIENTE SET PESO="+peso+", ALTURA="+altura+", "
                    + "TEMPERATURA="+temperatura+", PRESION_ARTERIAL='"+presion +"' WHERE NSS='"+NSS+"'";
            stmt.executeUpdate(sql);
            miCon.close();
            return true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                return false;}
        }return true;
    }
    public boolean modificarHistorial(String NSS){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
            String sql= "UPDATE EXPEDIENTE SET ALERGIAS='"+alergias+"', CIRUJIAS='"+cirujias+"', VACUNAS='"+vacunas+
                    "', ANTECEDENTES_FAMILIARES='"+antecedentes +"', GPOSANGUINEO_RH='"+ts+"' WHERE NSS='"+NSS+"'";
            int a=stmt.executeUpdate(sql);
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
    public boolean obtenerRegistro(String busca){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "SELECT * FROM EXPEDIENTE WHERE NSS ='"+busca+"'";
        //JOptionPane.showMessageDialog(null,expediente);
        ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    expediente=r.getString("ID_EXPEDIENTE");
                    
                    alergias=r.getString("ALERGIAS");
                    cirujias=r.getString("CIRUJIAS");
                    vacunas=r.getString("VACUNAS");
                    antecedentes=r.getString("ANTECEDENTES_FAMILIARES");
                    ts=r.getString("GPOSANGUINEO_RH");
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
    private void setNSS(String NSS){
        this.NSS=NSS;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    private void setCirujias(String cirujias){
        this.cirujias=cirujias;
    }
    
    private void setAlergias(String alergias){
        this.alergias=alergias;
    }
    
    private void setAntecedentes(String antecedentes){
        this.antecedentes=antecedentes;
    }
    
    private void setExpediente(String expediente){
        this.expediente=expediente;
    }
    
    private void setPresion(String presion){
        this.presion=presion;
    }
    
    private void setAltura(float altura){
        this.altura=altura;
    }
    
    private void setPeso(float peso){
        this.peso=peso;
    }
    private void setMedicamento(String medicamento){
        this.medicamento=medicamento;
    }
    private void setVacuna(String vacunas){
        this.vacunas=vacunas;
    }
    private void setDiagnostico(String diagnostico){
        this.diagnostico=diagnostico;
    }
    private void setAnalisis(String analisis){
        this.analisis=analisis;
    }
    private void setTS(String TS){
        this.ts=TS;
    }
    private void setTemperatura(float temperatura){
        this.temperatura=temperatura;
    }
    public float getPeso(){
        return peso;
    }
    public String getAlergias(){
        return alergias;
    }
    public String getMedicamento(){
        return medicamento;
    }
    public String getCirujias(){
        return cirujias;
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
    public String getVacunas(){
        return vacunas;
    }
    public String getAntecedentes(){
        return vacunas;
    }
    public String getDiagnostico(){
        return diagnostico;
    }
    public String getAnalisis(){
        return analisis;
    }
    public String getTS(){
        return ts;
    }
    public String getExpediente(){
        return expediente;
    }
}
