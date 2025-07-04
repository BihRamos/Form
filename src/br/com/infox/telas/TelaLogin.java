/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.infox.telas;

import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import java.awt.Color;
import javax.swing.*;

public class TelaLogin extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void logar() {
        //logica para pesquisar no banco de dados
        String sql = "select * from tbusuarios where login=? and senha=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TF_Login.getText());
            pst.setString(2, TF_Senha.getText());
            // a linha a baixo executa a query consulta
            rs = pst.executeQuery();
            //se exirtir um usuario e senha correspondnete

            if (rs.next()) {
                //linha abaixo obtem o conteudo do campo perfil da tabela usuario
                String perfil = rs.getString(5);
                if (perfil.equals("admin")) {

                    Telaprincipal principal = new Telaprincipal();
                    principal.setVisible(true);
                    Telaprincipal.TF_Relatorio.setEnabled(true);
                    Telaprincipal.TF_MenUsu.setEnabled(true);
                    Telaprincipal.TF_Usuario.setText(rs.getString(2));
                    Telaprincipal.TF_Usuario.setForeground(Color.red);
                    
                    this.dispose();
                    conexao.close();
                } else {
                    Telaprincipal principal = new Telaprincipal();
                    principal.setVisible(true);
                    Telaprincipal.TF_Usuario.setText(rs.getString(2));
                    this.dispose();

                }

            } else {
                JOptionPane.showMessageDialog(null, "usuário e/ou senha inválido");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    /**public void logar() {
    String usuario = TF_Login.getText();
    String senha = TF_Senha.getText();

    if (usuario.equals("admin") && senha.equals("123")) {
        Telaprincipal principal = new Telaprincipal();
        principal.setVisible(true);
        Telaprincipal.TF_Relatorio.setEnabled(true);
        Telaprincipal.TF_MenUsu.setEnabled(true);
        Telaprincipal.TF_Usuario.setText("Admin");
        Telaprincipal.TF_Usuario.setForeground(Color.red);
        this.dispose();
    } else if (usuario.equals("user") && senha.equals("123")) {
        Telaprincipal principal = new Telaprincipal();
        principal.setVisible(true);
        Telaprincipal.TF_Usuario.setText("Usuário Comum");
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido");
    }
}
**/

    public TelaLogin() {
        initComponents();
       conexao = ModuloConexao.conector();
        System.out.println(conexao);
        if (conexao != null) {
            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/livre.png")));
        } else {
            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/negado.png")));
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

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TF_Login = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        TF_Senha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("X System - Login");
        setResizable(false);

        jLabel1.setText("Usuário");

        jLabel2.setText("Senha");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/livre.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(238, 238, 238))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addComponent(TF_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogin))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(54, 54, 54)
                            .addComponent(TF_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TF_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TF_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(jLabel5))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        logar();
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_Login;
    private javax.swing.JPasswordField TF_Senha;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
