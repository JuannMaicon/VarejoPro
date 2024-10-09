import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
public class CadastroUsuario extends javax.swing.JFrame {

    /**
     * Creates new form CadastroUsuario
     */
    public CadastroUsuario() {
        initComponents();
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
        jPanel3 = new javax.swing.JPanel();
        titleVarejo1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pswSenha1 = new javax.swing.JPasswordField();
        txtNome1 = new javax.swing.JTextField();
        btnEntrar1 = new javax.swing.JButton();
        txtCpf1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Usuário");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        titleVarejo1.setText("VarejoPro");
        titleVarejo1.setMaximumSize(new java.awt.Dimension(60, 16));
        jPanel3.add(titleVarejo1);
        titleVarejo1.setBounds(167, 52, 60, 16);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo varejo 2.png"))); // NOI18N
        jPanel3.add(jLabel6);
        jLabel6.setBounds(108, 40, 53, 36);

        jLabel7.setText("Nome");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(40, 190, 90, 40);

        jLabel8.setText("Senha");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(40, 320, 90, 40);

        pswSenha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswSenha1ActionPerformed(evt);
            }
        });
        jPanel3.add(pswSenha1);
        pswSenha1.setBounds(110, 320, 190, 40);

        txtNome1.setToolTipText("");
        txtNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtNome1);
        txtNome1.setBounds(110, 190, 190, 40);

        btnEntrar1.setBackground(new java.awt.Color(51, 102, 0));
        btnEntrar1.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar1.setMnemonic('e');
        btnEntrar1.setText("Salvar");
        btnEntrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnEntrar1);
        btnEntrar1.setBounds(80, 410, 210, 50);

        txtCpf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpf1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtCpf1);
        txtCpf1.setBounds(110, 250, 190, 40);

        jLabel9.setText("CPF");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(40, 250, 90, 40);

        txtEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmail1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtEmail1);
        txtEmail1.setBounds(110, 120, 190, 40);

        jLabel10.setText("Email");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(40, 120, 90, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(50, 10, 369, 524);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 10, 900, 630);

        setSize(new java.awt.Dimension(504, 562));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pswSenha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswSenha1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pswSenha1ActionPerformed

    private void txtNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome1ActionPerformed

    private void btnEntrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrar1ActionPerformed
        // TODO add U your handling code here:
        String n,e,c,s;
        e = txtEmail1.getText();
        n = txtNome1.getText();
        c = txtCpf1.getText();
        s = pswSenha1.getText();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectar = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/VarejoPro","root","Sarti007@");
            PreparedStatement st = conectar.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?)");
            st.setString(1,e);
            st.setString(2,n);
            st.setString(3,c);
            st.setString(4,s);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
            //5- Limpar os campos
            txtEmail1.setText("");
            txtNome1.setText("");
            txtCpf1.setText("");
            pswSenha1.setText("");
            txtEmail1.requestFocus(); // Posiciona o cursor no campo usuario

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com suporte e informe o erro:" + ex.getMessage());
        } catch (java.sql.SQLException ex) {
            String erro = ex.getMessage();
            if(erro.contains("Duplicate entry")){
                JOptionPane.showMessageDialog(null, "Usuario já cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com suporte e informe o erro:" + ex.getMessage());
            }
        }

        
    }//GEN-LAST:event_btnEntrar1ActionPerformed

    private void txtCpf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpf1ActionPerformed

    private void txtEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField pswSenha1;
    private javax.swing.JLabel titleVarejo1;
    private javax.swing.JTextField txtCpf1;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtNome1;
    // End of variables declaration//GEN-END:variables
}
