
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


public class TDAResultadoAnalisis {
    String paciente, medico, resultado, fecha, hora, estado, ana_nom;
    int id, analisis;
    
    
    public TDAResultadoAnalisis(){
        
    }

    /*
    ana_nom = r.getString(1);
                    fecha = r.getString(2);
                    hora = r.getString(3);
                    resultado = r.getString(4);
                    estado = r.getString(5);
    */
    
    public TDAResultadoAnalisis(String ana_nom, String fecha, String hora, String resultado, String estado){
        setAna_nom(ana_nom);
        setFecha(fecha);
        setHora(hora);
        setResultado(resultado);
        setEstado(estado);
    }
    
    public TDAResultadoAnalisis(String paciente, String medico, String resultado,
            String fecha, String hora, String estado, 
            String ana_nom, int id, int analisis){
        setPaciente(paciente);
        setMedico(medico);
        setResultado(resultado);
        setFecha(fecha);
        setHora(hora);
        setEstado(estado);
        setAna_nom(ana_nom);
        setId(id);
        setAnalisis(analisis);
    }
    
    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
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

    public int getAnalisis() {
        return analisis;
    }

    public void setAnalisis(int analisis) {
        this.analisis = analisis;
    }

    public String getAna_nom() {
        return ana_nom;
    }

    public void setAna_nom(String ana_nom) {
        this.ana_nom = ana_nom;
    }
    
    public boolean mostrarReceta(String NSS){
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "select ANALISIS.NOMBRE, RESULTADO_ANALISIS.FECHA, RESULTADO_ANALISIS.HORA,\n" +
                "RESULTADO_ANALISIS.RESULTADO, RESULTADO_ANALISIS.ESTADO from RESULTADO_ANALISIS, ANALISIS\n" +
                "where ANALISIS.ID_ANALISIS = RESULTADO_ANALISIS.ANALISIS and RESULTADO_ANALISIS.PACIENTE = '"+NSS+"'";
        ResultSet r = stmt.executeQuery(sql);
                
                if(r.next()==true){
                   ana_nom = r.getString(1);
                   fecha = r.getString(2);
                   hora = r.getString(3);
                   resultado = r.getString(4);
                   estado = r.getString(5);
                   
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
    
    
    public boolean mostrarRecetaFuncional(String NSS){
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "select ANALISIS.NOMBRE, RESULTADO_ANALISIS.FECHA, RESULTADO_ANALISIS.HORA,\n" +
                "RESULTADO_ANALISIS.RESULTADO, RESULTADO_ANALISIS.ESTADO "
                + "from RESULTADO_ANALISIS, ANALISIS\n" +
                "where ANALISIS.ID_ANALISIS = RESULTADO_ANALISIS.ANALISIS and RESULTADO_ANALISIS.PACIENTE = '"+NSS+"'";
                ResultSet r = stmt.executeQuery(sql);
                
                LinkedList consulta = new LinkedList();
                
                while(r.next()){
                    ana_nom = r.getString(1);
                    fecha = r.getString(2);
                    hora = r.getString(3);
                    resultado = r.getString(4);
                    estado = r.getString(5);

                    TDAResultadoAnalisis analisis = new TDAResultadoAnalisis(ana_nom, 
                            fecha, hora, resultado, estado);
                    
                    consulta.add(analisis);
                }
                
                Predicate <TDAResultadoAnalisis> busqueda = analisis -> analisis.getAnalisis() == 0;
                
                List <TDAResultadoAnalisis> resultado = new ListComprehension<TDAResultadoAnalisis>()
                .suchThat(x -> {
                    x.belongsTo(consulta);
                    x.is(busqueda);
                });
                
            }
            catch(Exception e){
               return false;
            }
        }
        return false;
      }
    
    public boolean ActualizarEstado(String est, String ns){ 
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
             
                stmt.executeUpdate("update RESULTADO_ANALISIS set ESTADO='"+est+"' where PACIENTE='"+ns+"'"); 
                
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
