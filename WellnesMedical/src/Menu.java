/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nando
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    Paciente pac;
    Personal per;
    Farmacia far;
    String rfc;
    public Menu() {
        initComponents();
        pac=new Paciente();
        per=new Personal();
        far=new Farmacia();
    }
    public Menu(String RFC){
        
        initComponents();
        rfc=RFC;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegPac = new javax.swing.JButton();
        btnRegTra = new javax.swing.JButton();
        btnRegSig = new javax.swing.JButton();
        btnCitas = new javax.swing.JButton();
        btnFar = new javax.swing.JButton();
        btnActHist = new javax.swing.JButton();
        btnGenHist = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnCatAn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel1.setText("Menu Medical Wellness.");

        btnRegPac.setText("Registrar Paciente");
        btnRegPac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegPac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegPacMouseClicked(evt);
            }
        });

        btnRegTra.setText("Registrar Trabajador");
        btnRegTra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegTraMouseClicked(evt);
            }
        });
        btnRegTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegTraActionPerformed(evt);
            }
        });

        btnRegSig.setText("Registrar Signos Vitales");
        btnRegSig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegSig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegSigMouseClicked(evt);
            }
        });

        btnCitas.setText("Citas");
        btnCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCitasMouseClicked(evt);
            }
        });

        btnFar.setText("Farmacia");
        btnFar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFarMouseClicked(evt);
            }
        });

        btnActHist.setText("Actualizar Historial");
        btnActHist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnGenHist.setText("Generar Historial");
        btnGenHist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenHist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenHistMouseClicked(evt);
            }
        });
        btnGenHist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenHistActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar Paciente");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        btnCerrar.setText("Cerrar Sesion");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        btnCatAn.setText("Catalogo de Analisis");
        btnCatAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCatAnMouseClicked(evt);
            }
        });

        jButton1.setText("Cambiar Contraseña");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGenHist)
                                    .addComponent(btnActHist)
                                    .addComponent(btnCatAn)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(btnBuscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(btnCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(btnFar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRegPac)
                                        .addComponent(btnRegTra)
                                        .addComponent(btnRegSig)))))))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCitas)
                            .addComponent(btnRegPac))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(btnRegTra))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGenHist)
                            .addComponent(btnRegSig))
                        .addGap(43, 43, 43)
                        .addComponent(btnActHist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFar)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCatAn)
                    .addComponent(jButton1))
                .addGap(44, 44, 44)
                .addComponent(btnCerrar)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegPacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegPacMouseClicked
        pac.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnRegPacMouseClicked

    private void btnRegTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegTraMouseClicked
        per.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnRegTraMouseClicked

    private void btnFarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFarMouseClicked
        /*Menu_Farmacia men= new Menu_Farmacia("Administrador",rfc);
        men.setVisible(true);
        setVisible(false);*/
        Farmacia far= new Farmacia(rfc);
        far.setVisible(true);
        setVisible(false);
                       
    }//GEN-LAST:event_btnFarMouseClicked

    private void btnCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCitasMouseClicked
        Citas n = new Citas();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCitasMouseClicked

    private void btnRegSigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegSigMouseClicked
        Signos s = new Signos();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegSigMouseClicked

    private void btnGenHistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenHistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenHistActionPerformed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        BuscarPaciente b = new BuscarPaciente();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnGenHistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenHistMouseClicked
        GenerarHistorial g= new GenerarHistorial();
        g.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGenHistMouseClicked

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        Login log= new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnRegTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegTraActionPerformed

    private void btnCatAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCatAnMouseClicked
        CatalogoAnalisis cat= new CatalogoAnalisis();
        cat.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnCatAnMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        CambiarContraseña cam= new CambiarContraseña(rfc);
        cam.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActHist;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCatAn;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnFar;
    private javax.swing.JButton btnGenHist;
    private javax.swing.JButton btnRegPac;
    private javax.swing.JButton btnRegSig;
    private javax.swing.JButton btnRegTra;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
