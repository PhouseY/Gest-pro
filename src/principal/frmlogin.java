package principal;

import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN JOSE MUÑOZ - ANA HERRERA - YHOJAN CASTAÑO
 */
public final class frmlogin extends javax.swing.JFrame {

    Conexion cx;
    private String useri;
    private String useri2;

    public frmlogin() {
        initComponents();
        this.setTitle("INICIO DE SESION");
        this.setSize(400, 400);
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo.png"));
        Image imag = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/SEGP.png"));
        this.setIconImage(img);
        lblimage.setIcon(new ImageIcon(imag.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        cx = new Conexion("bd_gestpro");
        cx.conectar();
        this.useri = useri;

    }

    public String getUseri() {
        return useri;
    }

    public void setUseri(String useri) {
        this.useri = useri;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        lblimage = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("USUARIO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("CONTRASEÑA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 239, -1));

        btnLogin.setText("INGRESAR");
        btnLogin.setMaximumSize(new java.awt.Dimension(90, 23));
        btnLogin.setMinimumSize(new java.awt.Dimension(90, 23));
        btnLogin.setPreferredSize(new java.awt.Dimension(90, 23));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, 30));

        jToggleButton1.setText("CANCELAR");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        jPanel1.add(lblimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 274, 85));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:

        this.useri = txtUsuario.getText();
        proceso p = new proceso();

        p.setValor(useri);

        try {
            String user = txtUsuario.getText();

            String password = String.valueOf(txtPassword.getPassword());
            if (user.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Usuario y contraseña no debe estar vacía", "Error", JOptionPane.ERROR_MESSAGE);

            } else {

                String query = "SELECT * FROM administrador WHERE Idusuario = '1111' and Usuario='" + user + "' and Password='" + password + "'";
                Statement st = cx.conectar().createStatement();
                ResultSet rs = st.executeQuery(query);
                if (rs.next()) {
                    if (txtUsuario.getText().equals("Administrador")) {

//                        JOptionPane.showMessageDialog(this, "BIENVENIDO " + user.toUpperCase());
                        int opcion = JOptionPane.showOptionDialog(this, "BIENVENIDO " + user.toUpperCase(), "Mensaje", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                        if (opcion == JOptionPane.OK_OPTION) {
                            this.dispose();
                            p.setVisible(true);
                            p.arrancar();

                        }

                    }

                } else {

                    String sql = "SELECT * FROM  usuario  WHERE Usuario='" + user + "' and Password='" + password + "'";
                    Statement st2 = cx.conectar().createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    if (rs2.next()) {
                        if (txtUsuario.getText().equals("Jefe de proyectos")) {

//                               JOptionPane.showMessageDialog(this,"BIENVENIDO "+user.toUpperCase(),"Mensaje",JOptionPane.INFORMATION_MESSAGE);
                            int opcion = JOptionPane.showOptionDialog(null, "BIENVENIDO " + user.toUpperCase(), "Mensaje", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                            if (opcion == JOptionPane.OK_OPTION) {
                                this.dispose();
                                p.setVisible(true);
                                p.arrancar();
                            }

                        } else {
                            if (txtUsuario.getText().equals("Auxiliar de proyectos")) {

                                int opcion = JOptionPane.showOptionDialog(null, "BIENVENIDO " + user.toUpperCase(), "Mensaje", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                                if (opcion == JOptionPane.OK_OPTION) {
                                    this.dispose();
                                    p.setVisible(true);
                                    p.arrancar();
                                }
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "EL USUARIO NO ESTA EN LA BASE DE DATOS");
                    }
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(frmlogin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmlogin dialog = new frmlogin();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblimage;
    private javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
