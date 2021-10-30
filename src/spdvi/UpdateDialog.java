/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package spdvi;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author DevMike
 */
public class UpdateDialog extends javax.swing.JDialog {
    private Obra selectedObra = new Obra();
    JFileChooser fileChooser = new JFileChooser();
    BufferedImage profileBufferedImage;
    BufferedImage resizBufferedImage;
    
    /**
     * Creates new form InsertDialog
     */
    public UpdateDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public UpdateDialog(java.awt.Frame parent, boolean modal, Obra selectedObra) {
        super(parent, modal);
        initComponents();
        this.selectedObra = selectedObra;
        txtRegistre.setText(selectedObra.getRegistre());
        txtRegistre.setEnabled(false);
        populateFields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        txtRegistre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTitol = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAny = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbFormat = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblProfileImage = new javax.swing.JLabel();
        btnSelectImage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        jLabel1.setText("Registre:");
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 24));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 24));
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel1, gridBagConstraints);

        txtRegistre.setText("Ref. + Intro para buscar");
        txtRegistre.setMaximumSize(new java.awt.Dimension(200, 24));
        txtRegistre.setMinimumSize(new java.awt.Dimension(200, 24));
        txtRegistre.setPreferredSize(new java.awt.Dimension(200, 24));
        txtRegistre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRegistreFocusGained(evt);
            }
        });
        txtRegistre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRegistreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRegistreKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtRegistre, gridBagConstraints);

        jLabel2.setText("Titol:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel2, gridBagConstraints);

        txtTitol.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtTitol, gridBagConstraints);

        jLabel3.setText("Any:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel3, gridBagConstraints);

        txtAny.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtAny, gridBagConstraints);

        jLabel4.setText("Format:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel4, gridBagConstraints);

        cmbFormat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pintura", "Escultura", "Fotografia" }));
        cmbFormat.setEnabled(false);
        cmbFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFormatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(cmbFormat, gridBagConstraints);

        jLabel5.setText("Autor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel5, gridBagConstraints);

        txtAutor.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtAutor, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        jPanel1.add(btnCancel, gridBagConstraints);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        jPanel1.add(btnUpdate, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel6.setText("Picture:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel6, gridBagConstraints);

        lblProfileImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spdvi/noImage.png"))); // NOI18N

        btnSelectImage.setText("...");
        btnSelectImage.setEnabled(false);
        btnSelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnSelectImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(lblProfileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProfileImage))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cmbFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFormatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFormatActionPerformed

    private void btnSelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImageActionPerformed
        int returnValue = fileChooser.showDialog(this, "Open");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                profileBufferedImage = ImageIO.read(fileChooser.getSelectedFile());
                resizBufferedImage = Helper.resizeImageIcon(profileBufferedImage, lblProfileImage.getWidth(), lblProfileImage.getHeight());
                lblProfileImage.setIcon(new ImageIcon(resizBufferedImage));              
            }
            catch(IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSelectImageActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        DataController.updateObra(selectedObra, txtTitol.getText(), txtAny.getText(), cmbFormat.getSelectedItem().toString(), 
                txtAutor.getText(), 
                fileChooser.getSelectedFile() != null ? fileChooser.getSelectedFile().getAbsolutePath() : null);

        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtRegistreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRegistreFocusGained
        txtRegistre.selectAll();
    }//GEN-LAST:event_txtRegistreFocusGained

    private void txtRegistreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegistreKeyTyped

    }//GEN-LAST:event_txtRegistreKeyTyped

    private void txtRegistreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegistreKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            // Search for an Obra with Registre = txtRegistre.text
            selectedObra = DataController.getObra(txtRegistre.getText());
            populateFields();
        }
    }//GEN-LAST:event_txtRegistreKeyPressed

    private void populateFields() {
        if (selectedObra != null) {
            txtTitol.setText(selectedObra.getTitol());
            txtTitol.setEnabled(true);
            txtAny.setText(selectedObra.getAny());
            txtAny.setEnabled(true);
            txtAutor.setText(selectedObra.getAutor());
            txtAutor.setEnabled(true);
            cmbFormat.setSelectedItem(selectedObra.getFormat());
            cmbFormat.setEnabled(true);
            if (!selectedObra.getImatge().equals(Constants.NO_IMAGE)) {
                try {
                    BufferedImage image = ImageIO.read(new File(Constants.IMAGES_FOLDER + selectedObra.getImatge()));
                    BufferedImage resizedImage = Helper.resizeImageIcon(image, lblProfileImage.getWidth(), lblProfileImage.getHeight());
                    lblProfileImage.setIcon(new ImageIcon(resizedImage));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            btnSelectImage.setEnabled(true);
            txtRegistre.setEnabled(false);
        }
    }
   
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
            java.util.logging.Logger.getLogger(UpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdateDialog dialog = new UpdateDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSelectImage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbFormat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblProfileImage;
    private javax.swing.JTextField txtAny;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtRegistre;
    private javax.swing.JTextField txtTitol;
    // End of variables declaration//GEN-END:variables

}
