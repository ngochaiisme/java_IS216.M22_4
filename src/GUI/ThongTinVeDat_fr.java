
package GUI;

import ConnectDB.OracleConnection;
import Resouces.ReportViewer;
import java.sql.Connection;
import javax.swing.JTable;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author TIEN NHAN
 */
public class ThongTinVeDat_fr extends javax.swing.JFrame {

    static String MKHHT = null;
    private String MVEHT= "";
    private String MTAU= "";
    DefaultTableModel dtmctVe;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();
    String nowDate = dtf.format(now);
    public ArrayList<String> listmaGhe = new ArrayList<String>();
    /**
     * Creates new form ChitietVeDat
     */
    public ThongTinVeDat_fr() {
        initComponents();
        dtmctVe = (DefaultTableModel) jTable1.getModel();
        jButton3.setEnabled(false);
        jTextField4.setText(nowDate);
        setVisible(true);
    }
    
    public JTextField getTextFieldKH(){
        return jTextField1;
    }
    
    public void set_MKHHT(String a){
        MKHHT=a;            
    }
    
    public void getTTKH(String kh){
        try{
            OracleConnection OC = new OracleConnection();
            Connection conn = null;
            conn = OC.getOracleConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            String SQL1 = "SELECT * FROM KHACHHANG WHERE MAKH LIKE ?";
            PreparedStatement pres1 = conn.prepareStatement(SQL1);
            pres1.setString(1,'%'+kh+'%');
            ResultSet rs1 = pres1.executeQuery();
            while(rs1.next()){
                jTextField2.setText(rs1.getString("HOTEN"));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String LaymaVe(){
        String maVE = "";
        try{
            OracleConnection OC = new OracleConnection();
            Connection conn = null;
            conn = OC.getOracleConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            String SQL1 = "SELECT MAVE FROM VE ORDER BY MAVE DESC";
            Statement pres1 = conn.createStatement();
            ResultSet rs1 = pres1.executeQuery(SQL1);
            if(rs1.next()==false){
                maVE = "VE01";
            } else{
                int MVhientai = Integer.parseInt(rs1.getString(1).substring(2,rs1.getString(1).length()-1)) + 1;
                
                if (MVhientai < 10){
                    maVE = "VE0" + MVhientai;
                } else 
                    maVE = "VE" + MVhientai; 
            }
            MVEHT = maVE;
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return maVE;
    }

    public void dsmaGhe(String mag){
        listmaGhe.add(mag);
    }
    
    public void TongTien(double tt){
        jTextField3.setText(String.valueOf(tt));
    }
    
    public void getMaTau(String mtau){
        MTAU = mtau;
    }
    
    public JTable gettbCTVe(){
        return jTable1;
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
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thông tin vé đặt");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông tin vé đặt");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 32, 308, 44));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 102, 0));
        jLabel2.setText("Mã KH:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 98, 92, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 94, 184, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 102, 0));
        jLabel3.setText("Họ tên KH: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 149, -1, -1));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 145, 184, -1));

        jTable1.setBackground(new java.awt.Color(102, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã lịch trình", "Ga khởi hành", "Ga kết thúc", "Ngày khởi hành", "Giờ khởi hành", "Tên tàu", "Vị trí ghế", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 196, 1008, 172));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tổng tiền: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 390, -1, -1));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(836, 386, 178, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 102, 0));
        jLabel5.setText("Ngày đặt vé:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 98, 120, -1));

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 94, 193, -1));

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton1.setText("Thanh toán");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 427, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 204, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton2.setText("Hủy vé đặt");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 427, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 204, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton3.setText("In hóa đơn");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 427, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIC_ICON/nen_all.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        if(MKHHT == null){
            new TrangChu_Admin_fr();
        } else{
            DatVe_fr a = new DatVe_fr();
            a.set_MKHHT(MKHHT);
        }       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        OracleConnection OC = new OracleConnection();
        Connection conn = null;
        try{
            conn = OC.getOracleConnection();
            String SQL = "SELECT HOTEN FROM KHACHHANG WHERE MAKH = '"+jTextField1.getText()+"'";
            Statement pres = conn.createStatement();
//            pres.setString(1, jTextField1.getText());
            ResultSet rs = pres.executeQuery(SQL);
            if(rs.next()){
                jTextField2.setText(rs.getString(1));
            } else
                JOptionPane.showMessageDialog(null, "Mã khách hàng nhập không đúng!", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().equals("") || jTextField2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mã và họ tên của khách hàng không được để trống!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String MVE = LaymaVe();
        System.out.println(MVE);
        dtmctVe = (DefaultTableModel) jTable1.getModel();
        if(jTextField1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mã khách hàng chưa nhập không đúng!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        OracleConnection OC = new OracleConnection();
        Connection conn = null;
        try{
            conn = OC.getOracleConnection();
            String SQL = "INSERT INTO VE VALUES (?,?,?,TO_DATE(?,'YYYY-MM-DD'),?)";
            PreparedStatement pres = conn.prepareStatement(SQL);
            pres.setString(1, MVE);
            pres.setString(2, jTextField1.getText());
            pres.setString(3, dtmctVe.getValueAt(0, 1).toString());
            pres.setString(4, jTextField4.getText());
            pres.setDouble(5, Double.parseDouble(jTextField3.getText()));
            pres.executeUpdate();
            pres.close();
            for(int i = 0; i < dtmctVe.getRowCount() ; i++){
                String SQL1 = "INSERT INTO CTVE VALUES (?,?)";
                PreparedStatement pres1 = conn.prepareStatement(SQL1);
                pres1.setString(1, MVE);
                pres1.setString(2, listmaGhe.get(i));
                pres1.executeUpdate();
                pres1.close();
            }
            JOptionPane.showMessageDialog(null, "Thanh toán thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            jButton3.setEnabled(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            String maVe = MVEHT + ' ';
            System.out.println(maVe);
            String maTau = MTAU;
            try {
                LayThongTinVe(maVe,maTau,dtmctVe.getValueAt(0, 2).toString(),dtmctVe.getValueAt(0, 3).toString());
            } catch (SQLException | JRException ex) {
                System.out.println(ex);
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void LayThongTinVe(String maVe, String maTau, String gkh, String gkt) throws SQLException, JRException {
        // TODO code application logic here
        
        HashMap hs= new HashMap();
        hs.put("mavemoidat", maVe);
        hs.put("matau", maTau);
        hs.put("gakh", gkh);
        hs.put("gakt", gkt);
        String localDir = System.getProperty("user.dir");

        ReportViewer viewer = new ReportViewer(localDir+"\\src\\Resouces\\report_DatVe.jrxml",hs);
        viewer.setVisible(true);
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
            java.util.logging.Logger.getLogger(ThongTinVeDat_fr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinVeDat_fr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinVeDat_fr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinVeDat_fr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongTinVeDat_fr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}