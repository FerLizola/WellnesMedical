
import java.sql.Connection;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
public class TDAClinica {
    private String clinica;
    private int consultorio;

    public TDAClinica() {
        this.consultorio = 0;
        
    }
    
    public boolean agregarClinica(){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
             
                stmt.executeUpdate("INSERT INTO CLINICA " +
                  "VALUES ('"+clinica+"','"+consultorio+"')");
                
                miCon.close();
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    
    public boolean agregarConsultorio(){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
             
                stmt.executeUpdate("INSERT INTO CLINICA " +
                  "VALUES ('"+clinica+"','"+consultorio+"')"
                + "WHERE CLINICA = "+clinica+"AND CONSULTORIO != "+consultorio); 
                
                miCon.close();
                return true;
            }
            catch(Exception e){
                
                return false;
            }
        }
        return true;
    }
    
    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }
    
}
