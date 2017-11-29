
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
public class TDALogin {
    private String user,password;
    
    public TDALogin(String usr,String pswd){
        setUser(usr);
        setPass(pswd);
    }
    public String getUser() {
        return user;
    }

    private void setUser(String User) {
        this.user = User;
    }
    public String getPass() {
        return password;
    }

    private void setPass(String Pass) {
        this.password = Pass;
    }
public boolean guardar(){
        
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               
            ResultSet r = miCon.createStatement().executeQuery("SELECT * FROM PERSONAL WHERE RFC ='"+user+"' AND PASSWORD ='"+password+"'");
                if(r.next()){    
                    if(user.equals(password)){
                        new CambiarContraseña(user,r.getString("PUESTO")).setVisible(true);
                    }else{ 
                    if(r.getString("PUESTO").equals("Administrador")){
                        new Menu(user,"Administrador").setVisible(true);
                        new Login().dispose();
                        return true;
                       
                    }
                    if(r.getString("PUESTO").equals("Auxiliar Medico")){
                        new Menu_Auxiliar(user,"Auxiliar Medico").setVisible(true);
                        new Login().dispose();
                        return true;
                   }
                   if(r.getString("PUESTO").equals("Farmaceutico")){
                       new Menu_Farmacia("Farmaceutico",user).setVisible(true);
                       new Login().dispose();
                       return true;
                   }
                   if(r.getString("PUESTO").equals("Secretaria")){
                       new MenuSecretaria(user,"Secretaria").setVisible(true);
                       new Login().dispose();
                       return true;
                   }//Secretaria
                   if(r.getString("PUESTO").equals("Medico General")){
                       new Menu_Medico(user,"Medico General").setVisible(true);
                       new Login().dispose();
                       return true;
                   }
                   if(r.getString("PUESTO").equals("Laboratorista")){
                        new MenuLaboratorista(user,"Laboratorista").setVisible(true);
                        new Login().dispose();
                        return true;
                       
                    }
                    }
                }
                else {
                    //JOptionPane.showMessageDialog(null,"No puede ser Autenticado, porfavor verifique su Usuario y Password","Campos no validos",JOptionPane.WARNING_MESSAGE);
                    return false;
                     }
                miCon.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return true;
    }
    public boolean changePass(){
        
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
           int a=miCon.createStatement().executeUpdate("UPDATE PERSONAL SET PASSWORD='"+password+"' WHERE RFC='"+user+"'");
            
            if(a>0){
                Puesto();
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
    
       
    public boolean Puesto(){
        
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               
        ResultSet r=miCon.createStatement().executeQuery("SELECT * FROM PERSONAL WHERE RFC='"+user+"'");
                if(r.next()){    
                   if(r.getString("PUESTO").equals("Administrador")){
                       
                       new Menu(user,"Administrador").setVisible(true);
                       new Login().dispose();
                       miCon.close();
                       return true;
                   }
                   if(r.getString("PUESTO").equals("Secretaria")){
                       new MenuSecretaria(user,"Secretaria").setVisible(true);
                       new Login().dispose();
                       miCon.close();
                       return true;
                   }
                   if(r.getString("PUESTO").equals("Farmaceutico")){
                       new Menu_Farmacia("Farmaceutico",user).setVisible(true);
                       new Login().dispose();
                       miCon.close();
                       return true;
                   }
                   if(r.getString("PUESTO").equals("Medico General")){
                       new Menu_Medico(user,"Medico General").setVisible(true);
                       new Login().dispose();
                       return true;
                   }
                   if(r.getString("PUESTO").equals("Auxiliar Medico")){
                        new Menu_Auxiliar(user,"Auxiliar Medico").setVisible(true);
                        new Login().dispose();
                        return true;
                   }
                }
                else {
                    //JOptionPane.showMessageDialog(null,"No puede ser Autenticado, porfavor verifique su Usuario y Password","Campos no validos",JOptionPane.WARNING_MESSAGE);
                    return false;
                    }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return true;
    }
}
