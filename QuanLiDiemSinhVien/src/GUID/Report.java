/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUID;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

/**
 *
 * @author Vaio
 */
public class Report extends JFrame {

    public Report(String fileName) {
        this(fileName, null);
    }

    public   Report(String fileName, HashMap parameter) {
        super("View Report");
        try {
            KetNoi kn = new KetNoi();
            JasperPrint print = JasperFillManager.fillReport(fileName, parameter, Con());
            JRViewer viewer = new JRViewer(print);

            Container c = getContentPane();
            c.add(viewer);
        } catch (Exception ex) {
        }

        setBounds(10, 10, 600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        
    }
    
    private  Connection Con(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/diemsv", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(conn==null) System.out.println("Kết nối lỗi");
        else System.out.println("Kết nối thành công");
        return conn;
    }
    //public static void main(String[] args) {
//        String manv=JOptionPane.showInputDialog(null, "Nhập vào mã nhân viên: ");
//        HashMap param=new HashMap();
//        param.put("MDG", "DG01");
//        Report viewer = new Report("C:\\Users\\Pham Tuan Sang\\Desktop\\QuanLyThuVien\\src\\Report\\report1.jasper", param);
//        viewer.setVisible(true);
        //HashMap param = new HashMap();
        //param.put("column", "TenTacGia");
        //param.put("value", "Nam Cao");
//        h.put("name", "Sang");
       // Report rp = new Report("C:\\Users\\Pham Tuan Sang\\Desktop\\QuanLyThuVien\\src\\Report\\Sach.jasper", param);
        
    //}
}
