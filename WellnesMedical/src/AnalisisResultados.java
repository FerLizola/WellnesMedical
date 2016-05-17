
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
 * @author Nando Lizola
 */
public class AnalisisResultados {
    String nss, campo1,campo2,campo3,campo4,campo5,campo6,campo7,campo8,campo9,campo10,campo11,campo12;
    String campo13,campo14,campo15,campo16,campo17,campo18,analisis;
    public AnalisisResultados(String nss, String campo1,String campo2,String campo3,String campo4,
            String campo5,String campo6,String campo7,String campo8,String campo9,String campo10,String campo11,
            String campo12,String campo13,String campo14,String campo15,String campo16,String campo17,String campo18){
        this.nss=nss;
        this.campo1=campo1;
        this.campo2=campo2;
        this.campo3=campo3;
        this.campo4=campo4;
        this.campo5=campo5;
        this.campo6=campo6;
        this.campo7=campo7;
        this.campo8=campo8;
        this.campo9=campo9;
        this.campo10=campo10;
        this.campo11=campo11;
        this.campo12=campo12;
        this.campo13=campo13;
        this.campo14=campo14;
        this.campo15=campo15;
        this.campo16=campo16;
        this.campo17=campo17;
        this.campo18=campo18;
        guardarHem();
    }
    public AnalisisResultados(String nss, String campo1,String campo2,String campo3,String campo4,
            String campo5,String campo6,String campo7){
        this.nss=nss;
        this.campo1=campo1;
        this.campo2=campo2;
        this.campo3=campo3;
        this.campo4=campo4;
        this.campo5=campo5;
        this.campo6=campo6;
        this.campo7=campo7;
        
        
    }
    public AnalisisResultados(String nss){
        this.nss=nss;
        //buscarTipo();
    }
    private void guardarHem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean guardarLipidos() {
        Connection miCon = (new Conexion()).conectar();
        
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "SELECT TOP 1 * FROM RESULTADO_ANALISIS WHERE PACIENTE ='"+nss+"' ORDER BY ID_RESULTADO DESC";
                ResultSet r = stmt.executeQuery(sql);
                
                if(r.next()==true){ 
                    
                    analisis = r.getString("ID_RESULTADO");
                    
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
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                
                String sql = "INSERT INTO ANALISIS (RESULTADO, CAMPO1, CAMPO2, CAMPO3, CAMPO4, CAMPO5, CAMPO6, CAMPO7)"
                        + "VALUES('"+analisis+"','"+campo1+"','"+campo2+"','"+campo3+"','"+campo4
                        +"','"+campo5+"','"+campo6+"','"+campo7+"')";
                stmt.executeUpdate(sql);
                /*stmt.executeUpdate("INSERT INTO EXPEDIENTE (ID_EXPEDIENTE, NSS, ALERGIAS, CIRUJIAS"
                       + ", VACUNAS, ANTECEDENTES_FAMILIARES, GPOSANGUINEO_RH) " +
                  "VALUES ('"+expediente+"','"+nss+"','"+alergias+"','"+cirujias+"','"
                       +vacunas+"','"+antecedentes+"','"+ts+"')"); */
                return true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }

    public boolean buscarTipo() {
        
        Connection miCon = (new Conexion()).conectar();
        
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "SELECT TOP 1 * FROM RESULTADO_ANALISIS WHERE PACIENTE ='"+nss+"' ORDER BY ID_RESULTADO DESC";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    
                    analisis = r.getString("ANALISIS");
                    
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
    public boolean getLipidos(){
    Connection miCon = (new Conexion()).conectar();
        
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "SELECT TOP 1 * FROM RESULTADO_ANALISIS WHERE PACIENTE ='"+nss+"' ORDER BY ID_RESULTADO DESC";
                ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    
                    analisis = r.getString("ID_RESULTADO");
                    
                    sql= "SELECT * FROM ANALISIS WHERE RESULTADO='"+analisis+"'";
                    r= stmt.executeQuery(sql);
                    r.next();
                    campo1=r.getString("CAMPO1");
                    campo2=r.getString("CAMPO2");
                    campo3=r.getString("CAMPO3");
                    campo4=r.getString("CAMPO4");
                    campo5=r.getString("CAMPO5");
                    campo6=r.getString("CAMPO6");
                    campo7=r.getString("CAMPO7");
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
    public String getTipo(){
        return analisis;
    }
    
}
