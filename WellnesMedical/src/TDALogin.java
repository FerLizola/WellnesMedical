
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
        user=usr;
        password=pswd;
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
               Statement stmt = miCon.createStatement();
        String sql = "SELECT * FROM PERSONAL WHERE RFC ='"+user+"' AND PASSWORD ='"+password+"'";
        ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){    
                   if(r.getString("PUESTO").equals("Administrador")){
                       Menu men= new Menu();
                       Login log=new Login();
                       men.setVisible(true);
                       log.dispose();
                       return true;
                   }
                   if(r.getString("PUESTO").equals("Secretaria")){
                       MenuSecretaria men= new MenuSecretaria();
                       Login log=new Login();
                       men.setVisible(true);
                       log.dispose();
                       return true;
                   }
                   if(r.getString("PUESTO").equals("Farmaceutico")){
                       Menu_Farmacia men= new Menu_Farmacia("Farmaceutico");
                       Login log=new Login();
                       men.setVisible(true);
                       log.dispose();
                       return true;
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
}
