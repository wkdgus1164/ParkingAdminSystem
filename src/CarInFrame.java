import db.DatabaseManager;
import utils.ValueConverter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class CarInFrame extends javax.swing.JFrame {

    DatabaseManager DBM = new DatabaseManager();
    ValueConverter converter = new ValueConverter();
    
    SimpleDateFormat nowTimeDPFormat = new SimpleDateFormat("yyyy년 MM월 dd일, HH:mm:ss");
    SimpleDateFormat nowTimeDBFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    String nowTimeDP = nowTimeDPFormat.format(System.currentTimeMillis());
    String nowTimeDB = nowTimeDBFormat.format(System.currentTimeMillis());
    
    String idx = "";
    int fetchedIdx;
    
    public CarInFrame() {
        initComponents();
        lblInTime.setText(nowTimeDP);
        fetchedIdx = converter.getValue();       
        
        String alpha = "Select car_number From t_car where car_idx = " + fetchedIdx;
        
        try {
            DBM.dbOpen();   
            DBM.DB_rs = DBM.DB_stmt.executeQuery(alpha); 
            while (DBM.DB_rs.next()) {
                idx = DBM.DB_rs.getString("car_number");
                lblInNumber.setText(idx);
            }
            DBM.DB_rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCarInFrameTitle = new javax.swing.JLabel();
        lblInTimeTitle = new javax.swing.JLabel();
        lblInTime = new javax.swing.JLabel();
        lblInNumberTitle = new javax.swing.JLabel();
        lblInNumber = new javax.swing.JLabel();
        lblCaption = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCarInFrameTitle.setFont(new java.awt.Font("나눔스퀘어", 0, 36)); // NOI18N
        lblCarInFrameTitle.setText("입차 차량 확인");

        lblInTimeTitle.setFont(new java.awt.Font("나눔스퀘어", 0, 24)); // NOI18N
        lblInTimeTitle.setText("입차 시간 :");

        lblInTime.setFont(new java.awt.Font("나눔스퀘어", 0, 24)); // NOI18N
        lblInTime.setText("입차 시간 표시");

        lblInNumberTitle.setFont(new java.awt.Font("나눔스퀘어", 0, 24)); // NOI18N
        lblInNumberTitle.setText("차량 번호 :");

        lblInNumber.setFont(new java.awt.Font("나눔스퀘어", 0, 24)); // NOI18N
        lblInNumber.setText("차량 번호 표시");

        lblCaption.setFont(new java.awt.Font("나눔스퀘어", 0, 18)); // NOI18N
        lblCaption.setText("입차 처리하시겠습니까?");

        btnConfirm.setFont(new java.awt.Font("나눔스퀘어", 0, 24)); // NOI18N
        btnConfirm.setText("확인");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("나눔스퀘어", 0, 24)); // NOI18N
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
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblInNumberTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblInTimeTitle))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblInTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblInNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(lblCaption)))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCarInFrameTitle)
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCarInFrameTitle)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInTimeTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInNumberTitle)
                    .addComponent(lblInNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(lblCaption)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        String strSQL = "Insert Into t_log (car_idx, car_recent_in) Values (";
        strSQL += fetchedIdx + ", ";
        strSQL += "'" + nowTimeDB + "')";
        try {
            DBM.dbOpen();
            DBM.DB_stmt.executeUpdate(strSQL);
            DBM.DB_rs.close();
            JOptionPane.showMessageDialog(null, "정상적으로 반영되었습니다.", "입차 처리 완료", JOptionPane.INFORMATION_MESSAGE);
            converter.setValue(1);
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "에러 발생", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(CarInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarInFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel lblCaption;
    private javax.swing.JLabel lblCarInFrameTitle;
    private javax.swing.JLabel lblInNumber;
    private javax.swing.JLabel lblInNumberTitle;
    private javax.swing.JLabel lblInTime;
    private javax.swing.JLabel lblInTimeTitle;
    // End of variables declaration//GEN-END:variables
}
