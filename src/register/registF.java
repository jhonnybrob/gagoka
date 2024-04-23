/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import config.PassWordH;
import config.dbConnector;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import testappnew.loginF;


/**
 *
 * @author User
 */
public class registF extends javax.swing.JFrame {

    /**
     * Creates new form registF
     */
    public registF() {
        initComponents();
    }
    
    public static String email,username;
            
    
    public boolean duplicateCheck(){
        
        dbConnector dbc = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user  WHERE u_username = '" + us.getText() + "' OR u_email = '" + mail.getText() + "'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                email = resultSet.getString("u_email");
                if(email.equals(mail.getText())){
                      JOptionPane.showMessageDialog(null, "Email is Already Used!");
                      mail.setText("");
                }
                username = resultSet.getString("u_username");
                if(username.equals(us.getText())){
                      JOptionPane.showMessageDialog(null, "Email is Already Used!");
                      us.setText("");
            }
            return true;
            }else{
                return false;
            }
          
        }catch (SQLException ex) {
            System.out.println(""+ex);
            return false;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        us = new javax.swing.JTextField();
        ut = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pw = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("REGISTRATION FORM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 61, 164, 32));

        jLabel2.setText("First Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        jLabel3.setText("Last Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jLabel4.setText("Gmail");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        jLabel5.setText("UserName");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        jLabel6.setText("PassWord");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        jLabel7.setText("User Type");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));
        getContentPane().add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 190, -1));
        getContentPane().add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 190, -1));
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 190, -1));
        getContentPane().add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 190, -1));

        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin", " " }));
        getContentPane().add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 190, -1));

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        jButton2.setText("Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));
        getContentPane().add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 190, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        
        
        if(fn.getText().isEmpty()|| ln.getText().isEmpty() || mail.getText().isEmpty()
                || us.getText().isEmpty()|| pw.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!");
        }else if(pw.getText().length() < 8){
            JOptionPane.showMessageDialog(null, "Characters password is 8 above!");
            pw.setText("");
        }else if(duplicateCheck()){
            System.out.println("Duplicate Exist!");
            
        }else{
            
             dbConnector dbc = new dbConnector();
             
             try{
             String pass = PassWordH.hashPassword(pw.getText());
             
             
      if (dbc.insertData("INSERT INTO tbl_user (u_fname, u_lname, u_email, u_username, u_password, u_type, u_status) VALUES('"
     + fn.getText() + "','"+ln.getText()+"','"+ mail.getText() + "','" + us.getText() + "','" + pass + "','" + ut.getSelectedItem() + "','Pending')")){
          
        
          JOptionPane.showMessageDialog(null, "Inserted Successfully!");
          loginF ads = new loginF();
         ads.setVisible(true);
         this.dispose();
          
      }else{
          JOptionPane.showMessageDialog(null, "Connection Error!");
      }
             }catch(NoSuchAlgorithmException ex){
                 System.out.println(""+ex);
             }    
        }        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       loginF ads = new loginF();
       ads.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(registF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField ln;
    private javax.swing.JTextField mail;
    private javax.swing.JPasswordField pw;
    private javax.swing.JTextField us;
    private javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
