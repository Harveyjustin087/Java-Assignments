package Util;

import bean.Employee;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.*;

public class DBUtil {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register jdbc driver
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrmanager", "root", "Rock19Star87");
            return conn;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
}
