import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Bryan
 */
public class TDAReceta {
    private String nss, personal, prescripcion, fcha, hra;
    private String fecha, idRec;
    String med,can,precio,pres;
    Boolean estatus;
    public String getPrecio(){
        return precio;
    }
    public void setMed(String med){this.med=med;}
    public void setCan(String can){this.can=can;}
    public void setPres(String pres){this.pres=pres;}
    public void setPrecio(String pres){precio=pres;}
    
    private Timestamp hora;
    
    public String getNss() {
        return nss;
    }
    public String getId(){
        return idRec;
    }
    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getPrescripcion() {
        return prescripcion;
    }

    public void setPrescripcion(String prescripcion) {
        this.prescripcion = prescripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    public String getFcha() {
        return fcha;
    }

    public void setFcha(String fcha) {
        this.fcha = fcha;
    }

    public String getHra() {
        return hra;
    }

    public void setHra(String hra) {
        this.hra = hra;
    }  
    
    public boolean insertar(){ 
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
             
                stmt.executeUpdate("INSERT INTO RECETA " +
                  "VALUES ('"+nss+"','"+personal+"','"+fcha+"','"+hra+"','"+prescripcion+"','Pendiente')"); 
                
                
                miCon.close();
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    public boolean inserRec(){ 
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
             
                stmt.executeUpdate("INSERT INTO RECETA (NSS,PERSONAL,FECHA) " +
                  "VALUES ('"+nss+"','"+personal+"','"+fecha+"')"); 
                
                
                String sql = "SELECT TOP 1 * FROM RECETA WHERE NSS ='"+nss+"' ORDER BY ID_RECETA DESC";
                ResultSet r= stmt.executeQuery(sql);
                if(r.next())
                    idRec=""+r.getInt("ID_RECETA");
                miCon.close();
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    public boolean inserMed(){ 
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
             
                stmt.executeUpdate("INSERT INTO EXPEDICION_RECETA (ID_RECETA,NOM_MEDIC,CANTIDAD,PRESCRIPCION,SUBTOTAL) " +
                  "VALUES ('"+idRec+"','"+med+"','"+can+"','"+pres+"','"+precio+"')"); 
                miCon.close();
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    public boolean guardarEstatus(){ 
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql= "UPDATE EXPEDICION_RECETA SET ESTATUS='"+estatus+"' WHERE NOM_MEDIC='"+med+"' AND ID_RECETA='"+
                        idRec+"'";
                stmt.executeUpdate(sql);
                if(estatus){
                    sql="SELECT * FROM MEDICAMENTO WHERE NOMBRE='"+med+"'";
                    ResultSet r=stmt.executeQuery(sql);
                    if(r.next()){
                        int a= r.getInt("CANTIDAD");
                        a=a-Integer.parseInt(can);
                        sql= "UPDATE MEDICAMENTO SET CANTIDAD='"+a+"' WHERE NOMBRE='"+med+"'";
                        stmt.executeUpdate(sql);
                    }
                    
                }
                //stmt.executeUpdate("INSERT INTO EXPEDICION_RECETA (ID_RECETA,NOM_MEDIC,CANTIDAD,PRESCRIPCION,SUBTOTAL) " +
                 // "VALUES ('"+idRec+"','"+med+"','"+can+"','"+pres+"','"+precio+"')"); 
                miCon.close();
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    public boolean obtenerNSS(){
    
        Connection miCon= (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql="SELECT * FROM RECETA WHERE NSS='"+nss+"'";
                ResultSet r= stmt.executeQuery(sql);
                if(r.next()){
                    personal=r.getString("PERSONAL");
                    fecha=r.getString("FECHA");
                }
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    public boolean obtenerRec(DefaultTableModel modelo){ 
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "SELECT TOP 1 * FROM RECETA WHERE NSS ='"+nss+"' ORDER BY ID_RECETA DESC";
                ResultSet r=stmt.executeQuery(sql);
                
                if(r.next())
                    idRec=""+r.getInt("ID_RECETA");
                sql = "SELECT * FROM EXPEDICION_RECETA WHERE ID_RECETA ='"+idRec+"'";
                r= stmt.executeQuery(sql);
                Object[] a= new Object[4];
                while(r.next()){
                    med=""+r.getString("NOM_MEDIC");
                    can=r.getString("CANTIDAD");
                    pres=r.getString("PRESCRIPCION");
                    a[0]=Boolean.parseBoolean("false");
                    a[1]=med;
                    a[2]=can;
                    a[3]=pres;
                    modelo.addRow(a);
                    
                }
                miCon.close();
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    public boolean obtenerPrecio(){ 
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                
                String sql = "SELECT * FROM MEDICAMENTO WHERE NOMBRE ='"+med+"'";
                ResultSet r= stmt.executeQuery(sql);
                if(r.next())
                    precio=""+r.getFloat("PRECIO");
                miCon.close();
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    public void imprimir() throws FileNotFoundException, DocumentException, BadElementException, IOException{
        
        TDAPaciente pac = new TDAPaciente();
        pac.buscarNSS(nss);
        
        Document receta = new Document();
        FileOutputStream ficheroPdf = new FileOutputStream("receta_"+nss+".pdf");
        PdfWriter.getInstance(receta,ficheroPdf).setInitialLeading(20);
        receta.open();
        
        Paragraph parrafo = new Paragraph("Instituto Mexicano del Seguro Social");
        parrafo.setAlignment(Element.ALIGN_CENTER);
        receta.add(parrafo);
        
        Image logo = Image.getInstance("imss_2.png");
        logo.scaleToFit(50,50);
        logo.setAlignment(Chunk.ALIGN_MIDDLE);
        receta.add(logo);
        
        receta.add(new Paragraph(" "));
        receta.add(new Paragraph("NSS: "+nss));
        receta.add(new Paragraph("Nombre: "+pac.getNombre()));
        receta.add(new Paragraph("Unidad Medica: "+pac.getUnidad_medica()));
        receta.add(new Paragraph("Consultorio: "+pac.getUnidad_medica()));
        receta.add(new Paragraph("Unidad Medica: "+pac.getUnidad_medica()));
        receta.add(new Paragraph(" "));
        
        PdfPTable tabla = new PdfPTable(1);
        tabla.addCell("Fecha: "+fecha);
        tabla.addCell(" "+prescripcion);
        tabla.addCell("Medico:        "+pac.getDoctor());
        tabla.addCell("Firma: _____________________________");
        
        receta.add(tabla);
        receta.close();
    }
    
  String[] AgregarMedicamentos(){
     Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
             
                ResultSet res=stmt.executeQuery("SELECT COUNT(ID_MEDICAMENTO) AS TOTAL FROM MEDICAMENTO");
                res.next();
                int x=res.getInt("TOTAL");
                String[] med= new String[x];
                res = stmt.executeQuery("SELECT * FROM MEDICAMENTO");
                res.next();
                int a=0;
                while(res.next()){
                    med[a]=res.getString("NOMBRE");
                    a++;
                    res.next();
                }
                
                miCon.close();
                return med;
            }
            catch(Exception e){
                return null;
            }
        }
      return null;
  }  

    void setID(String text) {
        idRec=text;
    }

    void setEstatus(Boolean toString) {
        estatus=toString;
    }
}
