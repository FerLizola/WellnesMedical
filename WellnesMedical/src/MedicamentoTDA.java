import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nando
 */
public class MedicamentoTDA {
    private String nombre, descripcion, tipo, presentacion,fecha,precio;
    private int pieza,stock;
    private long cod;
    

    public MedicamentoTDA(String nombre, String descr, String tipo, String pres,int pieza, int stock, long cod, String fecha, String precio){
    
        setNombre(nombre);
        setDescripcion(descr);
        setTipo(tipo);
        setPresentacion(pres);
        setPieza(pieza);
        setStock(stock);
        setCod(cod);
        setFecha(fecha);
        setPrecio(precio);
        
    }
    public MedicamentoTDA(){
    }
    public void setNombre(String nombre){
        
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getPieza(){
        return (""+pieza);
    }
    public String getStock(){
        return (""+stock);
    }
    public String getCod(){
        return (""+cod);
    }
    private void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    private void setTipo(String tipo){
        this.tipo=tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    private void setPresentacion(String presentacion){
        this.presentacion=presentacion;
    }
    
    public String getPresentacion(){
        return presentacion;
    }
    
    private void setFecha(String fecha){
        this.fecha=fecha;
    }
    
    public String getFecha(){
        return fecha;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    
    public boolean guardar(){
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
             
               stmt.executeUpdate("INSERT INTO MEDICAMENTO " +
                  "VALUES ("+cod+",'"+nombre+"','"+descripcion+"','"+tipo+"','"+presentacion+"',"+pieza+","+stock+",'"+fecha+"','"+precio+"')"); 
                miCon.close();
                return true;
                
            }
            catch(Exception e){
                return false;
            }
        }
        return true;
    }
    public boolean buscarNom(String buscar){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "SELECT * FROM MEDICAMENTO WHERE NOMBRE ='"+buscar+"'";
        ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    presentacion=r.getString("PRESENTACION");
                    tipo=r.getString("TIPO");
                    descripcion=r.getString("DESCRIPCION");
                    pieza=Integer.parseInt(r.getString("CANTIDAD"));
                    stock=Integer.parseInt(r.getString("STOCK"));
                    cod=Long.parseLong(r.getString("ID_MEDICAMENTO"));
                    fecha=r.getString("FECHA_CADUCIDAD");
                    precio=r.getString("PRECIO");
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
    
    public boolean buscarNomFuncional(String buscar){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
                String sql = "SELECT * FROM MEDICAMENTO";
                ResultSet r = stmt.executeQuery(sql);
                
                LinkedList consulta = new LinkedList();
                
                while(r.next()){
                    nombre = r.getString("NOMBRE");
                    presentacion = r.getString("PRESENTACION");
                    tipo = r.getString("TIPO");
                    descripcion = r.getString("DESCRIPCION");
                    pieza = Integer.parseInt(r.getString("CANTIDAD"));
                    stock = Integer.parseInt(r.getString("STOCK"));
                    cod = Long.parseLong(r.getString("ID_MEDICAMENTO"));
                    fecha = r.getString("FECHA_CADUCIDAD");
                    precio = r.getString("PRECIO");
                    
                    MedicamentoTDA medicamento = new MedicamentoTDA(nombre, descripcion, 
                                tipo, presentacion, pieza, stock, cod, fecha, precio);
                    
                    consulta.add(medicamento);
                }
                
                Predicate<MedicamentoTDA> busqueda = medicamento -> medicamento.getNombre().equals(buscar);
                
                List <MedicamentoTDA> resultado = new ListComprehension<MedicamentoTDA>()
                .suchThat(x -> {
                    x.belongsTo(consulta);
                    x.is(busqueda);
                });
                
                for(MedicamentoTDA m : resultado){
                    this.nombre = m.getNombre();
                    this.descripcion = m.getDescripcion();
                    this.tipo = m.getTipo();
                    this.presentacion = m.getPresentacion();
                    this.pieza = Integer.parseInt(m.getPieza());
                    this.stock = Integer.parseInt(m.getStock());
                    this.cod = Long.parseLong(m.getCod());
                    this.fecha = m.getFecha();
                    this.precio = m.getPrecio();
                    miCon.close();
                    return true;
                }
                //
            }
            catch(Exception e){
                return false;
            }
        }
        return false;
    }
    
    public boolean buscarCod(long busca){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "SELECT * FROM MEDICAMENTO WHERE ID_MEDICAMENTO ="+busca+"";
        ResultSet r = stmt.executeQuery(sql);
                if(r.next()==true){ 
                    nombre=r.getString("NOMBRE");
                    presentacion=r.getString("PRESENTACION");
                    tipo=r.getString("TIPO");
                    descripcion=r.getString("DESCRIPCION");
                    pieza=Integer.parseInt(r.getString("CANTIDAD"));
                    stock=Integer.parseInt(r.getString("STOCK"));
                    fecha=r.getString("FECHA_CADUCIDAD");
                    precio=r.getString("PRECIO");
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
    
    public boolean buscarCodFuncional(long busca){
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
                Statement stmt = miCon.createStatement();
                String sql = "SELECT * FROM MEDICAMENTO";
                ResultSet r = stmt.executeQuery(sql);
                
                LinkedList consulta = new LinkedList();
                
                while(r.next()){
                    cod = r.getInt("id_medicamento");
                    nombre=r.getString("NOMBRE");
                    presentacion=r.getString("PRESENTACION");
                    tipo=r.getString("TIPO");
                    descripcion=r.getString("DESCRIPCION");
                    pieza=Integer.parseInt(r.getString("CANTIDAD"));
                    stock=Integer.parseInt(r.getString("STOCK"));
                    fecha=r.getString("FECHA_CADUCIDAD");
                    precio=r.getString("PRECIO");
                    
                    MedicamentoTDA medicamento = new MedicamentoTDA(nombre, descripcion, 
                                tipo, presentacion, pieza, stock, cod, fecha, precio);
                    
                    consulta.add(medicamento);
                }

                Predicate<MedicamentoTDA> busqueda = medicamento -> medicamento.getCod().equals(busca+"");
                
                List <MedicamentoTDA> resultado = new ListComprehension<MedicamentoTDA>()
                .suchThat(x -> {
                    x.belongsTo(consulta);
                    x.is(busqueda);
                });
                
                for(MedicamentoTDA m : resultado){
                    this.nombre = m.getNombre();
                    this.descripcion = m.getDescripcion();
                    this.tipo = m.getTipo();
                    this.presentacion = m.getPresentacion();
                    this.pieza = Integer.parseInt(m.getPieza());
                    this.stock = Integer.parseInt(m.getStock());
                    this.cod = Long.parseLong(m.getCod());
                    this.fecha = m.getFecha();
                    this.precio = m.getPrecio();
                    miCon.close();
                    return true;
                }
                
            }
            catch(Exception e){
                return false;
            }
        }
        return false;
    }
    
    public void mostrar(DefaultTableModel modelo){
    Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
               String sql = "SELECT * FROM MEDICAMENTO";
               ResultSet r = stmt.executeQuery(sql);
                
                while(r.next()){ 
                   long Codigo=r.getInt("ID_MEDICAMENTO");
                   String Nombre=r.getString("NOMBRE");
                   String Descripcion=r.getString("DESCRIPCION");
                   String Tipo=r.getString("TIPO");
                   String Presentacion=r.getString("PRESENTACION");
                   int Cantidad=r.getInt("CANTIDAD");
                   int Stock=r.getInt("STOCK");
                   String Caducidad=r.getString("FECHA_CADUCIDAD");
                   String Precio=r.getString("PRECIO");
                   modelo.addRow(new Object[]{Codigo,Nombre,Descripcion,Tipo,Presentacion,Cantidad,Stock,Caducidad,Precio});
                }
                miCon.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
      }
    
    public boolean eliminar(JTable tabla){
        int i=tabla.getSelectedRow();
        if(i==-1){
            return false;
        }
        else {
            long cod=Long.parseLong(tabla.getValueAt(i, 0).toString());
            Connection miCon = (new Conexion()).conectar();
            if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        
            String sql= "DELETE FROM MEDICAMENTO WHERE ID_MEDICAMENTO="+cod+"";
            int a=stmt.executeUpdate(sql);
            
            if(a>0){
                return true;
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
    }
    
    public void limpiarTabla(JTable tabla){
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();   
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
    }
    
    public boolean ActualizarMedicamento(long id, String fechaC, int cantidad, int stoc, String precio){
        
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        
            String sql= "UPDATE MEDICAMENTO SET FECHA_CADUCIDAD='"+fechaC+"', CANTIDAD="+cantidad+", STOCK="+stoc+", PRECIO='"+precio+"'  WHERE ID_MEDICAMENTO="+id+"";
            int a=stmt.executeUpdate(sql);
            
            if(a>0){
                return true;
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
    
    private void setPieza(int pieza) {
        this.pieza=pieza;
    }

    private void setStock(int stock) {
        this.stock=stock;
    }

    private void setCod(long cod) {
        this.cod=cod;
    }

}