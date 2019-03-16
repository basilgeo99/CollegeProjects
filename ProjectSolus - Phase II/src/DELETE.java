/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.sql.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author tulsi
 */
public class DELETE extends javax.swing.JFrame {

    static Connection conn = null;
    static String item;
    static String deleteKey;
    static establishConnection ec;

    /**
     * Creates new form DELETE
     */
    public DELETE(establishConnection ec) {
        this.ec = ec;
        initComponents();

    }

    public DELETE() {
        initComponents();

    }

    public void setTable(String item) {
        this.item = item;
        itemLabel.setText("DELETING FROM " + item);
        itemLabel.setHorizontalAlignment(JLabel.CENTER);
        itemLabel.setHorizontalAlignment(JLabel.CENTER);

    }

    private void deleteStuff() {

        try {
            statusLabel.setText("status");
            statusLabel.setForeground(Color.BLACK);
            Statement st = conn.createStatement();
            System.out.println("\nTable = " + item);
            ResultSet rs = st.executeQuery("Select * from " + item);
            ResultSetMetaData rsmd = rs.getMetaData();
            int n = rsmd.getColumnCount();

            System.out.println("Column count =  " + n);
            String[] cname = new String[n + 1];
            String[] value = new String[n + 1];

            for (int i = 1; i <= n; i++) {
                cname[i] = (String) rsmd.getColumnName(i);
                System.out.println(cname[i]);

            }
            int x = Integer.parseInt(deleteKey);
            boolean flag = false;
            while (rs.next()) {
                int i = 1;
                if ((String.valueOf(rs.getObject(1))).equals(deleteKey)) {
                    st.executeUpdate("delete from " + item + " where " + cname[i] + " = " + x + ";");
                    statusLabel.setText("Deleted");
                    statusLabel.setForeground(Color.GREEN);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                statusLabel.setText("Not Found");
                statusLabel.setForeground(Color.RED);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error Occurred!");
            statusLabel.setText("Failed");
            statusLabel.setForeground(Color.RED);
            e.printStackTrace();
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
        keyField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        itemLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DELETE");

        jLabel1.setText("ID : ");

        keyField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyFieldKeyTyped(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        statusLabel.setText("status");

        itemLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        itemLabel.setText("DELETE FROM ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addComponent(returnButton)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(itemLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keyField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(deleteButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 259, Short.MAX_VALUE)
                        .addComponent(returnButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(itemLabel)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(31, 31, 31)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusLabel)))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        SelectRelation l = new SelectRelation();
        l.setVisible(true);
        l.setLocation(300, 300);
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        try {
            deleteKey = (String) keyField.getText();
        } catch (Exception e) {
            System.out.println("Invalid field value !");
        }
        conn = ec.establishConn();
        deleteStuff();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void keyFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyFieldKeyTyped
        // TODO add your handling code here:
        char ch = evt.getKeyChar();
        if (!Character.isDigit(ch)) {
            evt.consume();
        }
    }//GEN-LAST:event_keyFieldKeyTyped

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
            java.util.logging.Logger.getLogger(DELETE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DELETE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DELETE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DELETE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DELETE s = new DELETE();
                s.setVisible(true);
                s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel itemLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField keyField;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
