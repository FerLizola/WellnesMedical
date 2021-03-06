
import com.lavantech.gui.comp.DateTimePicker;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;
import java.util.stream.IntStream;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
public class Receta extends javax.swing.JFrame {

    /**
     * Creates new form Receta
     */
    
    java.util.Date date;
    Timestamp t;
    String f,h,rfc,puesto;
    DefaultTableModel model;        
    public Receta() {
        initComponents();
        Calendar fecha = new GregorianCalendar();
        String fec="";
        fec+= fecha.get(Calendar.YEAR)+"-";
        int a=(fecha.get(Calendar.MONTH)+1);
        if(a<10)
            fec+="0"+(fecha.get(Calendar.MONTH)+1)+"-";
        else
            fec+= (fecha.get(Calendar.MONTH)+1)+"-";
        fec+= fecha.get(Calendar.DAY_OF_MONTH);
        txtFecha.setText(fec);
        txtFecha.setEditable(false);
        model=(DefaultTableModel)tblMedicamentos.getModel();
    }
    public Receta(String rfc,String puesto, String NSS){
        initComponents();
        txtNSS.setText(NSS);
        txtPersonal.setText(rfc);
        this.rfc=rfc;
        this.puesto=puesto;
        Calendar fecha = new GregorianCalendar();
        String fec="";
        fec+= fecha.get(Calendar.YEAR)+"-";
        if((fecha.get(Calendar.MONTH)+1)<10)
            fec+="0"+(fecha.get(Calendar.MONTH)+1)+"-";
        else
            fec+= (fecha.get(Calendar.MONTH)+1)+"-";
        fec+= fecha.get(Calendar.DAY_OF_MONTH);
        txtFecha.setText(fec);
        txtFecha.setEditable(false);
        model=(DefaultTableModel)tblMedicamentos.getModel();
        TDAReceta rec=new TDAReceta();
        rec.setNss(txtNSS.getText());
        rec.setPersonal(txtPersonal.getText());
        rec.setFecha(txtFecha.getText());
        rec.inserRec();
        txtIdRec.setText(rec.getId());
        
        txtMed.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        Connection miCon = (new Conexion()).conectar();
        if(miCon!=null){
            try{
               ResultSet r = miCon.createStatement().executeQuery("SELECT * FROM MEDICAMENTO");
                
                while(r.next()){ 
                   String consultorio=r.getString("NOMBRE");
                   cbxMed.addItem(consultorio+"");
                }
                miCon.close();
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtNSS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPersonal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        txtMed = new javax.swing.JTextField();
        txtPres = new javax.swing.JTextField();
        txtCant = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMedicamentos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbxMed = new javax.swing.JComboBox<>();
        txtIdRec = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Generar Receta");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("NSS:");

        txtNSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNSSActionPerformed(evt);
            }
        });
        txtNSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNSSKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("RFC Medico:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fecha:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Prescripción:");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGenerar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarMouseClicked(evt);
            }
        });

        jLabel6.setText("Medicamento:");

        tblMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicamento", "Prescripcion", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblMedicamentos);

        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cantidad:");

        cbxMed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Otro" }));
        cbxMed.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMedItemStateChanged(evt);
            }
        });
        cbxMed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxMedFocusGained(evt);
            }
        });
        cbxMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxMedMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxMedMousePressed(evt);
            }
        });

        jLabel8.setText("No. Receta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNSS, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(cbxMed, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAgregar)))))
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnGenerar)
                                .addGap(38, 38, 38)
                                .addComponent(btnCancelar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(8, 8, 8)
                        .addComponent(txtIdRec, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtMed, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(cbxMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(txtMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGenerar))
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNSSActionPerformed

    private void btnGenerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarMouseClicked
        TableModel m= tblMedicamentos.getModel();
        int a= m.getRowCount();
        TDAReceta rec= new TDAReceta();
        rec.setID(txtIdRec.getText());
        IntStream.range(0,a).forEach(i->{
            rec.setMed(m.getValueAt(i,0).toString());
            rec.setPres(m.getValueAt(i,1).toString());
            rec.setCan(m.getValueAt(i,2).toString());
            rec.obtenerPrecio();
            rec.setPrecio(""+(Float.parseFloat(m.getValueAt(i,2).toString())*Float.parseFloat(rec.getPrecio())));
            rec.inserMed();
        });
        
        showMessageDialog(this,"Receta Generada Correctamente");
        new Consulta(rfc,puesto,txtNSS.getText())
            .setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnGenerarMouseClicked

    private void txtNSSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNSSKeyTyped
        // TODO add your handling code here:
        Character e= evt.getKeyChar();
        if(((e < '0') ||
         (e > '9')) &&
         (e != '\b' /*corresponde a BACK_SPACE*/))
        {
         evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtNSSKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        new Consulta(rfc,puesto,txtNSS.getText())
            .setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        
        String[] datos= new String[3];
        if(cbxMed.getSelectedItem().equals("Otro"))
            datos[0]=txtMed.getText();
        else
            datos[0]=cbxMed.getSelectedItem().toString();
        datos[1]=txtPres.getText();
        datos[2]=txtCant.getText();
        model.addRow(datos);
        txtMed.setText("");
        txtPres.setText("");
        txtCant.setText("");
        cbxMed.setSelectedIndex(0);
        
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void cbxMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxMedMouseClicked
        /*String valor=cbxMed.getSelectedItem().toString();
        if(valor.equals("Otro")){
            txtMed.setEditable(true);
        }*/
    }//GEN-LAST:event_cbxMedMouseClicked

    private void cbxMedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxMedMousePressed
        /*String valor=cbxMed.getSelectedItem().toString();
        if(valor.equals("Otro")){
            txtMed.setEditable(true);
            txtMed.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        }
        else{
            txtMed.setEditable(false);
            txtMed.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        }*/
    }//GEN-LAST:event_cbxMedMousePressed

    private void cbxMedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxMedFocusGained
        /*String valor=cbxMed.getSelectedItem().toString();
        if(valor.equals("Otro")){
            txtMed.setEditable(true);
            txtMed.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        }
        else{
            txtMed.setEditable(false);
            txtMed.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        }*/
    }//GEN-LAST:event_cbxMedFocusGained

    private void cbxMedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMedItemStateChanged
        if(cbxMed.getSelectedItem().toString().equals("Otro")){
            txtMed.setEditable(true);
            txtMed.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        }
        else{
            txtMed.setEditable(false);
            txtMed.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        }
    }//GEN-LAST:event_cbxMedItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> cbxMed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblMedicamentos;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdRec;
    private javax.swing.JTextField txtMed;
    private javax.swing.JTextField txtNSS;
    private javax.swing.JTextField txtPersonal;
    private javax.swing.JTextField txtPres;
    // End of variables declaration//GEN-END:variables
}
