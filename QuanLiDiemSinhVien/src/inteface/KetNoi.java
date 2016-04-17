/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Pham Tuan Sang
 */
public class KetNoi {
    Connection con;
   // private String table = "SV";
    public Connection getConnectionToSQL(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
               Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diemsv?characterEncoding=utf8", "root", "");
        } catch (SQLException ex) {
        Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    
    
    
    public ResultSet getDataSV(){
        ResultSet rs = null;
        String sqlCommand = "select * from SV";
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public static void updateDataSQL(String sql){
        Statement st;
        try {
            KetNoi k = new KetNoi();
            Connection con = k.getConnectionToSQL();
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ResultSet getDataSQL(String sqlCommand){
        ResultSet rs = null;
        Statement st;
        try {
            KetNoi kn = new KetNoi();
            Connection con = kn.getConnectionToSQL();
            st = con.createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public static DefaultTableModel createModelSQL(String sql){
        DefaultTableModel model = new DefaultTableModel();
        //KetNoi kn = new KetNoi();
        //Connection con = kn.getConnectionToSQL();
        ResultSet rs = KetNoi.getDataSQL(sql);
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int colNumber = rsmd.getColumnCount();
            String[] arr = new String[colNumber];
            for (int i = 0; i <colNumber; i++) {
                arr[i] = rsmd.getColumnName(i+1);
            }
            model.setColumnIdentifiers(arr);
            while(rs.next()){
                for (int i = 0; i <colNumber; i++) {
                    arr[i] = rs.getString(i+1);
                    
                }
                model.addRow(arr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return model;
}
    
    public ResultSet getDataTimKiemTheoLop(String lop){
        ResultSet rs = null;
        String sqlCommand = "select SV.MaSV, HoTen, DiemQT, DiemCK, DiemTong from SV, Diem where (SV.MaSV = Diem.MaSV) and Diem.MaLop=" + lop;
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getDataTimKiemTheoHP(String hp){
        ResultSet rs = null;
        String sqlCommand = "select MaLop, MaGV, MaKyHoc from Lop, HP where Lop.MaHP=HP.MaHP=" + hp;
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getDataLH(){
        ResultSet rs = null;
        String sqlCommand = "select * from Lop";
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getDataHP(){
        ResultSet rs = null;
        String sqlCommand = "select * from HP";
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getDataDiem(){
        ResultSet rs = null;
        String sqlCommand = "select * from Diem";
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
   
   public ResultSet getDataGV(){
        ResultSet rs = null;
        String sqlCommand = "select * from GV";
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    } 
    
    public void showData(ResultSet rs){
        try {
            while(rs.next()){
                System.out.printf("%-10s %-20s %-12s\n", rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void logon(String un, String pw) throws SQLException{
        ResultSet rs=null;
        String sqlCommand = "select * from logon where name=? and pass=?";
        try {
            PreparedStatement pst = con.prepareCall(sqlCommand);
            pst.setString(1, un);
            pst.setString(2, pw);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(rs.next()) System.out.println("Dang nhap thanh cong");
        else System.out.println("Sai ten tai khoan hoac mat khau");
    }
       
   
    
    
    public static void main(String[] args) throws SQLException {
//        KetNoi kn = new KetNoi();
//        Connection con = kn.getConnectionToSQL();
        //s.showData(s.getData());
        //s.logon("1","1");
       
}
}
