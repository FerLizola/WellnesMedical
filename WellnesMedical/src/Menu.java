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
    String rfc, puesto;
    public Menu() {
        initComponents();
    }
    public Menu(String RFC,String puesto){
        
        initComponents();
        rfc=RFC;
        this.puesto=puesto;
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
        btnMenuMEd = new javax.swing.JButton();
        btnActHist = new javax.swing.JButton();
        btnBuscarPer = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel1.setText("Menu Medical Wellness.");

        btnRegPac.setText("Menu Secretaria");
        btnRegPac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegPac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegPacMouseClicked(evt);
            }
        });
        btnRegPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPacActionPerformed(evt);
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

        btnRegSig.setText("Menu Farmaceutico");
        btnRegSig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegSig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegSigMouseClicked(evt);
            }
        });

        btnMenuMEd.setText("Menu Medico");
        btnMenuMEd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuMEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuMEdMouseClicked(evt);
            }
        });

        btnActHist.setText("Menu Laboratorio");
        btnActHist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActHist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActHistMouseClicked(evt);
            }
        });

        btnBuscarPer.setText("Buscar Personal");
        btnBuscarPer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarPer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarPerMouseClicked(evt);
            }
        });
        btnBuscarPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPerActionPerformed(evt);
            }
        });

        btnBuscar.setText("Menu Auxiliar");
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

        jButton1.setText("Cambiar Contraseña");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imss_2.png"))); // NOI18N

        jButton2.setText("Agregar consultorio");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMenuMEd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegSig, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActHist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegPac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegTra)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btnBuscarPer, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMenuMEd)
                    .addComponent(btnRegTra))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnBuscarPer))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(58, 58, 58)
                                .addComponent(jButton2)
                                .addGap(37, 37, 37)
                                .addComponent(btnCerrar))
                            .addComponent(jLabel2))
                        .addGap(22, 55, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegSig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActHist)
                        .addGap(37, 37, 37)
                        .addComponent(btnRegPac)
                        .addGap(70, 70, 70))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegPacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegPacMouseClicked
        new MenuSecretaria(rfc,"Administrador")
            .setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegPacMouseClicked

    private void btnRegTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegTraMouseClicked
        new Personal(rfc,"Administrador")
        .setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegTraMouseClicked

    private void btnMenuMEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMEdMouseClicked
        new Menu_Medico(rfc,"Administrador")
        .setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuMEdMouseClicked

    private void btnRegSigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegSigMouseClicked
        new Menu_Farmacia("Administrador",rfc)
        .setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegSigMouseClicked

    private void btnBuscarPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarPerActionPerformed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        new Menu_Auxiliar(rfc,"Administrador")
        .setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnBuscarPerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarPerMouseClicked
        new BuscarPersonal(rfc,puesto)
        .setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarPerMouseClicked

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        new Login()
        .setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnRegTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegTraActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        new CambiarContraseña(rfc,"Administrador")
        .setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnRegPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegPacActionPerformed

    private void btnActHistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActHistMouseClicked
         new MenuLaboratorista(rfc,"Administrador")
        .setVisible(true);
        dispose();
    }//GEN-LAST:event_btnActHistMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
       new AgregarClinica()
        .setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

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
    private javax.swing.JButton btnBuscarPer;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMenuMEd;
    private javax.swing.JButton btnRegPac;
    private javax.swing.JButton btnRegSig;
    private javax.swing.JButton btnRegTra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
