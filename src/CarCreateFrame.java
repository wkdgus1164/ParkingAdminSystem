import db.DatabaseManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CarCreateFrame extends javax.swing.JFrame {

    DatabaseManager DBM = new DatabaseManager();
    String strSQL = "Select * From t_car";
    
    public CarCreateFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCarCreateFrameTitle = new javax.swing.JLabel();
        lblCarType = new javax.swing.JLabel();
        lblCarNum = new javax.swing.JLabel();
        txtCarType = new javax.swing.JTextField();
        txtCarNum = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        lblCaption = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCarCreateFrameTitle.setFont(new java.awt.Font("NanumSquare", 0, 36)); // NOI18N
        lblCarCreateFrameTitle.setText("차량 등록");

        lblCarType.setFont(new java.awt.Font("NanumSquare", 0, 24)); // NOI18N
        lblCarType.setText("차      종 : ");

        lblCarNum.setFont(new java.awt.Font("NanumSquare", 0, 24)); // NOI18N
        lblCarNum.setText("차량번호 : ");

        txtCarType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarTypeActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("NanumSquare", 0, 24)); // NOI18N
        btnCreate.setText("등록");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblCaption.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblCaption.setText("등록 처리하시겠습니까?");

        btnCancel.setFont(new java.awt.Font("NanumSquare", 0, 24)); // NOI18N
        btnCancel.setText("취소");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCaption)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCarType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCarType, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCarNum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCarNum, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(lblCarCreateFrameTitle)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCarCreateFrameTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblCarType))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCarType, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCarNum)
                    .addComponent(txtCarNum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(lblCaption)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCarTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarTypeActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String errorText = "";
        if (txtCarType.getText().length() == 0) {
            errorText += "차종 ";
        }
        if (txtCarNum.getText().length() == 0) {
            errorText += "차량번호";
        }
        if (errorText != "") {
            errorText += "를 확인해 주세요.";
            JOptionPane.showMessageDialog(null, errorText, "입력값 확인", JOptionPane.WARNING_MESSAGE);
        }
        
        strSQL = "Insert Into t_car (car_type, car_number, car_register_date, car_visit_count, car_point) Values (";
        strSQL += "'" + txtCarType.getText() + "', ";
        strSQL += "'" + txtCarNum.getText() + "', ";
        strSQL += "to_char(sysdate,'yyyy.mm.dd hh24:mi'), 0, 0)";
        try {
            DBM.dbOpen();
            DBM.DB_stmt.executeUpdate(strSQL);
            strSQL = "Select * From t_car";
            DBM.dbClose();
            JOptionPane.showMessageDialog(null, "회원 등록이 완료되었습니다", "회원 등록 완료", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(CarCreateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarCreateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarCreateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarCreateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CarCreateFrame().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(CarCreateFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel lblCaption;
    private javax.swing.JLabel lblCarCreateFrameTitle;
    private javax.swing.JLabel lblCarNum;
    private javax.swing.JLabel lblCarType;
    private javax.swing.JTextField txtCarNum;
    private javax.swing.JTextField txtCarType;
    // End of variables declaration//GEN-END:variables
}
