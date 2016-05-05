
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
    
    private String nss, personal, prescripcion, fecha, hora, estado;
    private int id;

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
