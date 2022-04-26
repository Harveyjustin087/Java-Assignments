package com.example.justinharvey_assignment4;

import EJB.AccountBean;

import java.io.*;
import java.security.PrivateKey;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;

@WebServlet(name = "accountServlet", value = "/account")
public class AccountServlet extends HttpServlet {
    //set up variables
    private AccountBean accountBean;
    private final String INDEX = "/index.jsp";
    private double Balance;
    String forward = "";
    String Message = "";
    //initialize connection to user account enterprise bean
    public void init() {
        try {
            Context context = new InitialContext();
            accountBean = (AccountBean)context.lookup("java:module/AccountBeanImpl!EJB.AccountBean");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        Balance = accountBean.getBalance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get deposit or withdrawal selection and the amount passed
        String selection = request.getParameter("select");
        double amount = Double.parseDouble(request.getParameter("amount"));
        //complete actions based on withdraw or deposit and forward back to index page with result
        try {
            if (selection.equals("withdraw")) {
                accountBean.withdraw(amount);
                Balance = accountBean.getBalance();
                //format to 2 decimal places
                String Final = String.format("%.2f", Balance);
                request.setAttribute("Final", Final);
                forward = INDEX;
            } else if (selection.equals("deposit")) {
                accountBean.deposit(amount);
                Balance = accountBean.getBalance();
                String Final = String.format("%.2f", Balance);
                request.setAttribute("Final", Final);
                forward = INDEX;
            }
        }catch (Exception e){
            // if no selection is made print error message
            Message = "No Selection was made or invalid input based on: " + e;
            request.setAttribute("Message",Message);
            forward = INDEX;
        }
        RequestDispatcher page = request.getRequestDispatcher(forward);
        page.forward(request, response);

    }
        public void destroy() {
    }
}