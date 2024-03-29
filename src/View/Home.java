/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ConnectionBD;
import Models.autor;
import Models.livro;
import Models.usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public class Home extends javax.swing.JFrame {

    ArrayList<usuario> arrayusuario;
    ArrayList<livro> arraylivro;
    ArrayList<autor> arrayAutor;

    /**
     * Creates new form Home
     */
    public Home(java.awt.Frame parent, boolean modal) {

        initComponents();
        this.setLocationRelativeTo(null);
        this.arrayusuario = new ArrayList();
        this.arrayAutor = new ArrayList();
        this.arraylivro = new ArrayList();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Home dialog = new Home(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });

        Connection con = new ConnectionBD().getConnection();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        head1 = new javax.swing.JLabel();
        btHome = new javax.swing.JLabel();
        btUsuarios = new javax.swing.JLabel();
        btAutores = new javax.swing.JLabel();
        btLivros = new javax.swing.JLabel();
        btReserva = new javax.swing.JLabel();
        btSolicitacao = new javax.swing.JLabel();
        gif = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/head1.png"))); // NOI18N
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 900, -1));

        btHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/home1.png"))); // NOI18N
        btHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btHomeMouseExited(evt);
            }
        });
        getContentPane().add(btHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        btUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/usuarios1.png"))); // NOI18N
        btUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btUsuariosMouseExited(evt);
            }
        });
        getContentPane().add(btUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        btAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/autores1.png"))); // NOI18N
        btAutores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAutoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAutoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAutoresMouseExited(evt);
            }
        });
        getContentPane().add(btAutores, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        btLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/livros1.png"))); // NOI18N
        btLivros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLivrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btLivrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btLivrosMouseExited(evt);
            }
        });
        getContentPane().add(btLivros, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        btReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reserva1.png"))); // NOI18N
        btReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btReservaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btReservaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btReservaMouseExited(evt);
            }
        });
        getContentPane().add(btReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        btSolicitacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/solicitacao1.png"))); // NOI18N
        btSolicitacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSolicitacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSolicitacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSolicitacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSolicitacaoMouseExited(evt);
            }
        });
        getContentPane().add(btSolicitacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 200, -1));

        gif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gif.gif"))); // NOI18N
        getContentPane().add(gif, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 280, 900, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btHomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btHomeMouseClicked

    private void btHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btHomeMouseEntered
        btHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Home2.png")));
    }//GEN-LAST:event_btHomeMouseEntered

    private void btHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btHomeMouseExited
        btHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Home1.png")));
    }//GEN-LAST:event_btHomeMouseExited

    private void btUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUsuariosMouseClicked
        interno1 i = new interno1(this, true, this.arrayusuario);
        i.setVisible(true);
    }//GEN-LAST:event_btUsuariosMouseClicked

    private void btUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUsuariosMouseEntered
        btUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/usuarios2.png")));
    }//GEN-LAST:event_btUsuariosMouseEntered

    private void btUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUsuariosMouseExited
        btUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/usuarios1.png")));
    }//GEN-LAST:event_btUsuariosMouseExited

    private void btAutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAutoresMouseClicked
      interno3 i = new interno3(this, true);
        i.setVisible(true);
    }//GEN-LAST:event_btAutoresMouseClicked

    private void btAutoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAutoresMouseEntered
        btAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/autores2.png")));
    }//GEN-LAST:event_btAutoresMouseEntered

    private void btAutoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAutoresMouseExited
        btAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/autores1.png")));
    }//GEN-LAST:event_btAutoresMouseExited

    private void btLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLivrosMouseClicked
       interno2 i = new interno2(this, true);
        i.setVisible(true);
    }//GEN-LAST:event_btLivrosMouseClicked

    private void btLivrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLivrosMouseEntered
        btLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/livros2.png")));
    }//GEN-LAST:event_btLivrosMouseEntered

    private void btLivrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLivrosMouseExited
        btLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/livros1.png")));
    }//GEN-LAST:event_btLivrosMouseExited

    private void btReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btReservaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btReservaMouseClicked

    private void btReservaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btReservaMouseEntered
        btReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reserva2.png")));
    }//GEN-LAST:event_btReservaMouseEntered

    private void btReservaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btReservaMouseExited
        btReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reserva1.png")));
    }//GEN-LAST:event_btReservaMouseExited

    private void btSolicitacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSolicitacaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btSolicitacaoMouseClicked

    private void btSolicitacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSolicitacaoMouseEntered
        btSolicitacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/solicitacao2.png")));
    }//GEN-LAST:event_btSolicitacaoMouseEntered

    private void btSolicitacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSolicitacaoMouseExited
        btSolicitacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/solicitacao1.png")));
    }//GEN-LAST:event_btSolicitacaoMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btAutores;
    private javax.swing.JLabel btHome;
    private javax.swing.JLabel btLivros;
    private javax.swing.JLabel btReserva;
    private javax.swing.JLabel btSolicitacao;
    private javax.swing.JLabel btUsuarios;
    private javax.swing.JLabel gif;
    private javax.swing.JLabel head1;
    // End of variables declaration//GEN-END:variables
}
