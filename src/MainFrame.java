import db.DatabaseManager;
import utils.ValueConverter;
import java.text.SimpleDateFormat;
import utils.TimeConverter;

public class MainFrame extends javax.swing.JFrame {

    TimeConverter TC = new TimeConverter();
    DatabaseManager DBM = new DatabaseManager();
    ValueConverter converter = new ValueConverter();
    int fetchedIdx = converter.getValue();
    String strSQL = "select a.car_idx, b.car_recent_in from t_car a, t_log b where a.car_idx = b.car_idx";

    SimpleDateFormat nowTimeFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    String nowTime = nowTimeFormat.format(System.currentTimeMillis());

    public MainFrame() {
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
        lblParkedCarList = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParkedCarList = new javax.swing.JTable();
        btnIn = new javax.swing.JButton();
        btnOut = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("나눔스퀘어", 0, 36)); // NOI18N
        lblTitle.setText("주차 관리 시스템");

        lblParkedCarList.setFont(new java.awt.Font("나눔스퀘어", 0, 14)); // NOI18N
        lblParkedCarList.setText("현재 입차 차량 목록 :");

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
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblParkedCarList);

        btnIn.setFont(new java.awt.Font("나눔스퀘어", 0, 24)); // NOI18N
        btnIn.setText("차량 입차");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        btnOut.setFont(new java.awt.Font("나눔스퀘어", 0, 24)); // NOI18N
        btnOut.setText("차량 출차");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("나눔스퀘어", 0, 14)); // NOI18N
        btnRefresh.setText("새로 고침");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblParkedCarList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(lblTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblParkedCarList)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        new CarListFrame().setVisible(true);
    }//GEN-LAST:event_btnInActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        new CarOutSearchFrame().setVisible(true);
    }//GEN-LAST:event_btnOutActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        try {
            DBM.dbOpen();
            setTable(strSQL);
            DBM.dbClose();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblParkedCarList;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblParkedCarList;
    // End of variables declaration//GEN-END:variables

    private void getYear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
