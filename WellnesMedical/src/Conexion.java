import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Medrano
 */
public class Conexion {
    public Connection conectar(){
        Connection con=null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=MEDICAL_WELLNESS";
            con = DriverManager.getConnection(url, "sa", "abril21");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error en la Conexión con la BD "+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            con=null;
        }
        return con;
    }
}
