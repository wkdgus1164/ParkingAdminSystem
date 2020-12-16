import db.DatabaseManager;
import java.text.SimpleDateFormat;
import utils.ValueConverter;

public class CarOutFrame extends javax.swing.JFrame {

    DatabaseManager DBM = new DatabaseManager();
    ValueConverter converter = new ValueConverter();
    String idx = "";
    int fetchedIdx;
    int fetchedParkTime;
    
    SimpleDateFormat nowTimeFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    String nowTime = nowTimeFormat.format(System.currentTimeMillis());
    
    public CarOutFrame() {
        initComponents();
        fetchedIdx = converter.getValue();
        fetchedParkTime = converter.getParkedTime();
        String strSQL = "Select a.car_type, a.car_number, b.car_recent_in From t_car a, t_log b Where a.car_idx = b.car_idx and a.car_idx = " + fetchedIdx;
        
        try {
            DBM.dbOpen();
            setTable(strSQL);
            DBM.DB_rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTable(String strQuery) {
        int iCntRow = 0;
        try {
            DBM.DB_rs = DBM.DB_stmt.executeQuery(strQuery);
            while (DBM.DB_rs.next()) {
                lblCarTypeText.setText((DBM.DB_rs.getString("car_type")));
                lblCarNumText.setText((DBM.DB_rs.getString("car_number")));
                lblCarInTimeText.setText((DBM.DB_rs.getString("car_recent_in")));
                lblCarOutTimeText.setText(nowTime);
                lblParkedTimeText.setText(Integer.toString(fetchedParkTime) + "분");
                iCntRow++;
            }
            DBM.DB_rs.close();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblCarType = new javax.swing.JLabel();
        lblCarNum = new javax.swing.JLabel();
        lblCarInTime = new javax.swing.JLabel();
        lblCarOutTime = new javax.swing.JLabel();
        lblParkedTime = new javax.swing.JLabel();
        lblCarTypeText = new javax.swing.JLabel();
        lblCarNumText = new javax.swing.JLabel();
        lblCarInTimeText = new javax.swing.JLabel();
        lblCarOutTimeText = new javax.swing.JLabel();
        lblParkedTimeText = new javax.swing.JLabel();
        lblCaption = new javax.swing.JLabel();
        btnOutConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("NanumSquare", 0, 36)); // NOI18N
        lblTitle.setText("차량 출차하기");

        lblCarType.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblCarType.setText("차           종 :");

        lblCarNum.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblCarNum.setText("차량    번호 :");

        lblCarInTime.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblCarInTime.setText("입차    시간 :");

        lblCarOutTime.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblCarOutTime.setText("출차    시간 :");

        lblParkedTime.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblParkedTime.setText("총 주차시간 :");

        lblCarTypeText.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblCarTypeText.setToolTipText("차종");

        lblCarNumText.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N

        lblCarInTimeText.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N

        lblCarOutTimeText.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N

        lblParkedTimeText.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N

        lblCaption.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblCaption.setText("출차하시겠습니까?");

        btnOutConfirm.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        btnOutConfirm.setText("출차하기");
        btnOutConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutConfirmActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        btnCancel.setText("취소하기");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCarOutTime, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblParkedTime))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCarOutTimeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblParkedTimeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCarType)
                        .addGap(19, 19, 19)
                        .addComponent(lblCarTypeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCaption)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOutConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCarNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCarInTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCarNumText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCarInTimeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCarTypeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCarType, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarNum, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarNumText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarInTime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarInTimeText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCarOutTimeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCarOutTime, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblParkedTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblParkedTimeText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(lblCaption)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOutConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOutConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutConfirmActionPerformed
        converter.setNowTime(nowTime);
        new CarPayFrame().setVisible(true);
    }//GEN-LAST:event_btnOutConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(CarOutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarOutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarOutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarOutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarOutFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOutConfirm;
    private javax.swing.JLabel lblCaption;
    private javax.swing.JLabel lblCarInTime;
    private javax.swing.JLabel lblCarInTimeText;
    private javax.swing.JLabel lblCarNum;
    private javax.swing.JLabel lblCarNumText;
    private javax.swing.JLabel lblCarOutTime;
    private javax.swing.JLabel lblCarOutTimeText;
    private javax.swing.JLabel lblCarType;
    private javax.swing.JLabel lblCarTypeText;
    private javax.swing.JLabel lblParkedTime;
    private javax.swing.JLabel lblParkedTimeText;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
