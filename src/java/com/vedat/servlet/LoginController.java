/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vedat.servlet;

import com.vedat.config.Config;
import com.vedat.database.CustomerDB;
import com.vedat.modules.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet implements Config {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // processRequest(request, response);
            String username_or_email = request.getParameter("username");
            String password = request.getParameter("paw");

            boolean rememberMe = "true".equals(request.getParameter("rememberMe"));

            Customer customer = CustomerDB.query(username_or_email, password);// catch buradan olur %100

            if (customer == null) {
                // false
                request.setAttribute("errorMsg", "Kullanıcı veya şifreniz yanlıştır.");
                //request.setAttribute("errorMsg", "Kullanıcı veya şifreniz yanlıştır.");
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                // true
                HttpSession session = request.getSession(true);// reuse existing
                // session if exist
                // or create one
                session.setAttribute("customer", customer);
                session.setMaxInactiveInterval(maxInterval); // 60*60*24 seconds (24 saat)

                if (rememberMe) {
                    Cookie reUserName = new Cookie("username", username_or_email);
                    Cookie rePassword = new Cookie("password", password);

                    reUserName.setMaxAge(365 * 24 * 60 * 60);
                    rePassword.setMaxAge(365 * 24 * 60 * 60);

                    response.addCookie(reUserName);
                    response.addCookie(rePassword);
                }
                // router

                

                response.sendRedirect("index.jsp");

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
