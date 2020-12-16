import db.DatabaseManager;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import utils.ValueConverter;

public class CarPayFrame extends javax.swing.JFrame {

    DatabaseManager DBM = new DatabaseManager();
    ValueConverter converter = new ValueConverter();
    String idx = "";
    int fetchedIdx;
    int fetchedParkTime;
    String fetchedNowTime;
    int totalFee;
    int availablePoint;
    int usePoint;
    int finalFee;
    int savedPoint;
    
    public CarPayFrame() {
        initComponents();
        fetchedIdx = converter.getValue();
        fetchedParkTime = converter.getParkedTime();
        fetchedNowTime = converter.getNowTime();
        
        totalFee = fetchedParkTime * 100;
        savedPoint = (int) Math.round(totalFee * 0.01);
        
        String strSQL = "Select car_point From t_car Where car_idx = " + fetchedIdx;
                
        try {
            DBM.dbOpen();
            getPointValue(strSQL);
            DBM.DB_rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        lblParkTimeText.setText(Integer.toString(fetchedParkTime) + "분");
        lblTotalFeeText.setText(Integer.toString(totalFee) + "원");
        lblFinalFeeText.setText(Integer.toString(calFinalFee()) + "원");
        
        int delay = 1000;
        Timer timer = new Timer( delay, e -> {
            lblFinalFeeText.setText(Integer.toString(calFinalFee()) + "원Ref");
        });
        timer.start(); 
    }

    public void getPointValue(String strQuery) {
        int iCntRow = 0;
        try {
            DBM.DB_rs = DBM.DB_stmt.executeQuery(strQuery);
            while (DBM.DB_rs.next()) {
                availablePoint = DBM.DB_rs.getInt("car_point");
                lblAvailablePointText.setText(Integer.toString(availablePoint));
                iCntRow++;
            }
            DBM.DB_rs.close();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }
    
    public int calFinalFee() {
        finalFee = totalFee - usePoint;
        return finalFee;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblParkTime = new javax.swing.JLabel();
        lblFreeTime = new javax.swing.JLabel();
        lblTotalFee = new javax.swing.JLabel();
        lblAvailablePoint = new javax.swing.JLabel();
        lblParkTimeText = new javax.swing.JLabel();
        lblFreeTimeText = new javax.swing.JLabel();
        lblTotalFeeText = new javax.swing.JLabel();
        lblAvailablePointText = new javax.swing.JLabel();
        lblUsePoint = new javax.swing.JLabel();
        txtUsePoint = new javax.swing.JTextField();
        lblFinalFee = new javax.swing.JLabel();
        lblFinalFeeText = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnPay = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("NanumSquare", 0, 36)); // NOI18N
        lblTitle.setText("출차요금 결제");

        lblParkTime.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblParkTime.setText("총 주차 시간 :");

        lblFreeTime.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblFreeTime.setText("무료 주차 시간 :");

        lblTotalFee.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblTotalFee.setText("총 부과 요금 :");

        lblAvailablePoint.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblAvailablePoint.setText("사용 가능 포인트 :");

        lblParkTimeText.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblParkTimeText.setText("  ");

        lblFreeTimeText.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblFreeTimeText.setText("  ");

        lblTotalFeeText.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblTotalFeeText.setText("  ");

        lblAvailablePointText.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblAvailablePointText.setText("  ");

        lblUsePoint.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblUsePoint.setText("사용 포인트 입력 :");

        txtUsePoint.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N

        lblFinalFee.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblFinalFee.setText("총 결제 금액 :");

        lblFinalFeeText.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        lblFinalFeeText.setText("  ");

        jLabel8.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        jLabel8.setText("P");

        jLabel9.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        jLabel9.setText("결제 수단 선택 :");

        jComboBox1.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "신용카드", "계좌이체", "현금결제" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnPay.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        btnPay.setText("결제하기");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        btnCancel.setText("취소하기");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("NanumSquare", 0, 18)); // NOI18N
        jLabel10.setText("P");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFreeTime)
                            .addComponent(lblParkTime)
                            .addComponent(lblTotalFee))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblParkTimeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFreeTimeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalFeeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFinalFee)
                                    .addComponent(lblUsePoint))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtUsePoint)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8))
                                    .addComponent(lblFinalFeeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lblTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAvailablePoint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAvailablePointText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParkTime)
                    .addComponent(lblParkTimeText))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFreeTime)
                    .addComponent(lblFreeTimeText))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalFee)
                    .addComponent(lblTotalFeeText))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvailablePoint)
                    .addComponent(lblAvailablePointText)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsePoint)
                    .addComponent(txtUsePoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFinalFee)
                    .addComponent(lblFinalFeeText))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        String errorText = "";
        if (txtUsePoint.getText() != null) {
            if (Integer.parseInt(txtUsePoint.getText()) < 0) {
            errorText = "포인트를 사용하시려면 0 이상의 숫자를 입력해주세요.";
            }
            if (Integer.parseInt(txtUsePoint.getText()) > totalFee) {
                errorText = "포인트 사용량은 부과 요금보다 클 수 없습니다.";
            }
            if (Integer.parseInt(txtUsePoint.getText()) > availablePoint) {
                errorText = "사용 가능한 포인트가 모자랍니다.";
            }
        }
        if (errorText != "") {
            JOptionPane.showMessageDialog(null, errorText, "입력값 확인", JOptionPane.WARNING_MESSAGE);
        }
        
        try {
            DBM.dbOpen();
            String strSQL = "Update t_car Set ";
            strSQL += "car_visit_count = car_visit_count + 1, ";
            strSQL += "car_point = car_point + " + savedPoint + " - " + usePoint + " Where ";
            strSQL += "car_idx = " + fetchedIdx;
            DBM.DB_stmt.executeUpdate(strSQL);
            
            System.out.println(strSQL);
            
            strSQL = "Delete From t_log Where ";
            strSQL += "car_idx = " + fetchedIdx + ";";
            DBM.DB_stmt.executeUpdate(strSQL);
            
            System.out.println(strSQL);
            
            DBM.dbClose();
            JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.", "결제 완료", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new MainFrame().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(CarPayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarPayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarPayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarPayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarPayFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnPay;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAvailablePoint;
    private javax.swing.JLabel lblAvailablePointText;
    private javax.swing.JLabel lblFinalFee;
    private javax.swing.JLabel lblFinalFeeText;
    private javax.swing.JLabel lblFreeTime;
    private javax.swing.JLabel lblFreeTimeText;
    private javax.swing.JLabel lblParkTime;
    private javax.swing.JLabel lblParkTimeText;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalFee;
    private javax.swing.JLabel lblTotalFeeText;
    private javax.swing.JLabel lblUsePoint;
    private javax.swing.JTextField txtUsePoint;
    // End of variables declaration//GEN-END:variables
}
