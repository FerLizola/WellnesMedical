
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import static javax.swing.JOptionPane.showMessageDialog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Medrano
 */
public class TDABuscarReceta {
    
    private String nss, personal, prescripcion, fecha, hora, estado, paciente, unidad_medica;
    private int id, consultorio;

    public String getNss() {
        return nss;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getUnidad_medica() {
        return unidad_medica;
    }

    public void setUnidad_medica(String unidad_medica) {
        this.unidad_medica = unidad_medica;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }
    
    
    
    public boolean mostrarReceta(String NSS){
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "select PERSONAL.NOMBRE, RECETA.ID_RECETA, RECETA.FECHA, RECETA.HORA,\n" +
                     "RECETA.PRESCRIPCION, RECETA.ESTADO from RECETA, PERSONAL where\n" +
                     "RECETA.PERSONAL=PERSONAL.RFC and RECETA.NSS='"+NSS+"'";
        ResultSet r = stmt.executeQuery(sql);
                
                if(r.next()==true){ 
                   personal = r.getString(1);
                   id = r.getInt(2);
                   fecha = r.getString(3);
                   hora = r.getString(4);
                   prescripcion = r.getString(5);
                   estado = r.getString(6);
                   nss=NSS;
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
    
    public void imprimir() throws FileNotFoundException, DocumentException, BadElementException, IOException{
        
         Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "select NOMBRE, UNIDAD_MEDICA, CONSULTORIO from PACIENTE where NSS='"+nss+"'";
        ResultSet r = stmt.executeQuery(sql);
                
                if(r.next()==true){ 
                   paciente = r.getString(1);
                   unidad_medica = r.getString(2);
                  consultorio = r.getInt(3);
                  miCon.close();
                }
                else{
                    miCon.close();
                }
            }
            catch(Exception e){   
            }
        }
        
        TDAPaciente pac = new TDAPaciente();
        TDABuscarReceta rec = new TDABuscarReceta();
        pac.buscarNSS(nss);
        rec.mostrarReceta(nss);
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
        receta.add(new Paragraph("Nombre: "+paciente));
        receta.add(new Paragraph("Unidad Medica: "+unidad_medica));
        receta.add(new Paragraph("Consultorio: "+consultorio));
        receta.add(new Paragraph(" "));
        
        PdfPTable tabla = new PdfPTable(1);
        tabla.addCell("Fecha: "+fecha);
        tabla.addCell(" "+prescripcion);
        tabla.addCell("Medico:        "+personal);
        tabla.addCell("Firma: _____________________________");
        
        receta.add(tabla);
        receta.close();
       
        try{
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"receta_"+nss+".pdf");
        }catch(IOException e){
            //e.printStackTrace()
        }
        
    }
    
    public boolean ActualizarEstado(String est, String ns){ 
        Connection miCon = (new Conexion()).conectar();
            if(miCon!=null){
                try{
                    Statement stmt = miCon.createStatement();

                    stmt.executeUpdate("update RECETA set ESTADO='"+est+"' where NSS='"+ns+"'"); 

                    miCon.close();
                    return true;
                }
                catch(Exception e){
                    return false;
                }
            }
        return true;
   }
    
}
