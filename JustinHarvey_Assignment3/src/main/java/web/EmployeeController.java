package web;

import Util.EmployeeHandler;
import Util.DBUtil;
import bean.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "EmployeeController", value = "/EmployeeController")
public class EmployeeController extends HttpServlet {
    private EmployeeHandler empHandler;
    // set Constants for forwarding the request/response
    private final String EMP_SIGNUP = "/signup.jsp";
    private final String EMP_LOGIN = "/login.jsp";
    private final String EMP_SUCCESS = "/success.jsp";

    public EmployeeController() throws ClassNotFoundException {
        super();
        empHandler = new EmployeeHandler();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageName = request.getParameter("pageName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String forward = "";
        if (empHandler != null) {
            if (pageName.equals("signup")) {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String emailAddress = request.getParameter("emailAddress");
                Date hireDate = Date.valueOf(request.getParameter("hireDate"));
                try {
                    boolean firstResult = empHandler.findByEmployeeName(request.getParameter("userName"));
                    if (firstResult){
                        forward = EMP_SIGNUP;
                        String message = "Sorry but that Username already exists";
                        request.setAttribute("message", message);
                        RequestDispatcher view = request
                                .getRequestDispatcher(forward);
                        view.forward(request, response);
                        return;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                empHandler.save(userName, password, firstName, lastName, emailAddress, hireDate);
                        forward = EMP_LOGIN;
            } else if (pageName.equals("login")) {
                boolean result = empHandler.findByLogin(userName, password);
                if (result) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userName", userName);
                    forward = EMP_SUCCESS;
                } else {
                    String message = "User does not Exist or Invalid Credentials";
                    request.setAttribute("message", message);
                    forward = EMP_LOGIN;
                }
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}