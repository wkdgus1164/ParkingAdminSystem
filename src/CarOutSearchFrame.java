import db.DatabaseManager;
import utils.ValueConverter;
import utils.TimeConverter;

public class CarOutSearchFrame extends javax.swing.JFrame {
    
    TimeConverter TC = new TimeConverter();
    DatabaseManager DBM = new DatabaseManager();
    ValueConverter converter = new ValueConverter();
    String strSQL = "select a.car_idx, b.car_recent_in from t_car a, t_log b where a.car_idx = b.car_idx";

    
    public CarOutSearchFrame() {
        initComponents();
        try {
            DBM.dbOpen();
            setTable(strSQL);
            DBM.dbClose();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }

    public void setTable(String strQuery) {
        int iCntRow = 0;
        try {
            DBM.DB_rs = DBM.DB_stmt.executeQuery(strQuery);
            String carIdxValue, carRecentIn;

            while (DBM.DB_rs.next()) {
                carIdxValue = DBM.DB_rs.getString("car_idx");
                carRecentIn = DBM.DB_rs.getString("car_recent_in");

                tblParkedCarList.setValueAt(carIdxValue, iCntRow, 0);
                tblParkedCarList.setValueAt(carRecentIn, iCntRow, 1);

                int OldYear = Integer.parseInt(carRecentIn.substring(0, 4));
                int OldMonth = Integer.parseInt(carRecentIn.substring(5, 7));
                int OldDate = Integer.parseInt(carRecentIn.substring(8, 10));
                int OldHour = Integer.parseInt(carRecentIn.substring(11, 13));
                int OldMinute = Integer.parseInt(carRecentIn.substring(14, 16));
                int gapYear = TC.getRestYear(OldYear);
                int gapMonth = TC.getRestMonth(OldMonth);
                int gapDate = TC.getRestDate(OldDate);
                int gapHour = TC.getRestHour(OldHour);
                int gapMinute = TC.getRestMinute(OldMinute);
                int gapTime = gapMinute + gapHour * 60 + gapDate * 1440 + gapMonth * 43200 + gapYear * 525600;
                int parkingFee = gapTime * 100;
                
                tblParkedCarList.setValueAt(gapTime, iCntRow, 2);
                tblParkedCarList.setValueAt(parkingFee, iCntRow, 3);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParkedCarList = new javax.swing.JTable();
        btnOut = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("NanumSquare", 0, 36)); // NOI18N
        lblTitle.setText("출차 차량 선택");

        tblParkedCarList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "회원 번호", "입차 시간", "주차 시간(분)", "현재 금액(원)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblParkedCarList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblParkedCarListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblParkedCarList);

        btnOut.setFont(new java.awt.Font("NanumSquare", 0, 24)); // NOI18N
        btnOut.setText("출차하기");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("NanumSquare", 0, 24)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lblTitle)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOut, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        new CarOutFrame().setVisible(true);
    }//GEN-LAST:event_btnOutActionPerformed

    private void tblParkedCarListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblParkedCarListMouseClicked
        // TODO add your handling code here:
        int iCntRow = 0;
        iCntRow = tblParkedCarList.getSelectedRow();
        //System.out.println(iCntRow);
        int idxNum = Integer.parseInt(tblParkedCarList.getValueAt(iCntRow, 0).toString());
        converter.setValue(idxNum);
        int parkedTime = Integer.parseInt(tblParkedCarList.getValueAt(iCntRow, 2).toString());
        converter.setParkedTime(parkedTime);
    }//GEN-LAST:event_tblParkedCarListMouseClicked

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
            java.util.logging.Logger.getLogger(CarOutSearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarOutSearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarOutSearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarOutSearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarOutSearchFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblParkedCarList;
    // End of variables declaration//GEN-END:variables
}
