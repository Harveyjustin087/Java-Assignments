package Util;

import bean.Employee;

import java.sql.*;

public class EmployeeHandler {
    private Connection dbConnection;
    private String sqlInsert = "INSERT INTO employee(userName, password, firstName, lastName, emailAddress, hireDate) VALUES(?,?,?,?,?,?)";
    private String sqlUser = "SELECT userName FROM employee WHERE userName = ?";
    private String sqlLogin = "SELECT userName, password FROM employee WHERE userName = ? AND password = ?";

    public EmployeeHandler() throws ClassNotFoundException {
        dbConnection = DBUtil.getConnection();
    }

    public void save(String userName, String password, String firstName, String lastName,
                     String emailAddress, Date hireDate) {
        try(PreparedStatement prepStatement = dbConnection
                .prepareStatement(sqlInsert)) {
            prepStatement.setString(1, userName);
            prepStatement.setString(2, password);
            prepStatement.setString(3, firstName);
            prepStatement.setString(4, lastName);
            prepStatement.setString(5, emailAddress);
            prepStatement.setDate(6,hireDate);
            prepStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean findByEmployeeName(String userName) throws SQLException {
        try(PreparedStatement prepStatement = dbConnection
                .prepareStatement(sqlUser)){
            prepStatement.setString(1, userName);
            // fetch employee records with the given username
            ResultSet result = prepStatement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    String userColumn = result.getString(1);
                    if (userColumn.equals(userName)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean findByLogin(String userName, String password) {
        try(PreparedStatement prepStatement = dbConnection
                .prepareStatement(sqlLogin)) {
            prepStatement.setString(1, userName);
            prepStatement.setString(2, password);
            // fetch employee records with given username/password
            ResultSet result = prepStatement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    String passColumn = result.getString(2);
                    if (passColumn.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


