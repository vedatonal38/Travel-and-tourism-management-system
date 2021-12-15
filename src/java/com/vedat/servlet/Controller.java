/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vedat.servlet;

import com.vedat.database.Moduls.ModulsDatas;
import com.vedat.modules.BusDriver.Bus;
import com.vedat.modules.Hotels.Hotels;
import com.vedat.modules.Vehicle.TypeDescription;
import com.vedat.modules.Vehicle.Vehicles;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

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
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
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
        // processRequest(request, response);

        PrintWriter out = response.getWriter();
        String[] object = request.getParameter("object").split("&");
        if (object[0].equals("cars")) {
            if (object[1].equals("add")) {
                TypeDescription td = null;
                String brand = request.getParameter("brand");
                String engine_size = request.getParameter("engine_size");
                String date_mot_due = request.getParameter("date_mot_due");
                String price_ = request.getParameter("price");
                double price = Double.parseDouble(price_);
                String current_milleage = request.getParameter("current_mileage");
                // model table
                String daily_hire_rate = request.getParameter("daily_hire_rate");
                String model_name = request.getParameter("model_name");
                // type table
                String type_description = request.getParameter("type_description");//id

                try {
                    td = ModulsDatas.query_where_type_description(type_description);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                // city table
//                String country = request.getParameter("country");
                String city_id = request.getParameter("city");
                // currrent id
                int idCalc = ModulsDatas.last_index_vehicles();

                if (!city_id.equals("-1")) {
                    Vehicles vehicle = new Vehicles(idCalc, current_milleage, date_mot_due, engine_size, daily_hire_rate, model_name, td, city_id, model_name, price, brand, 0,"../d_Travel/page/resources/images/car.jpg");

                    try {
                        Boolean status_ = ModulsDatas.insert_vehicle(vehicle);
                        if (status_) { // insert OK

                            response.sendRedirect("settings.jsp");
                        } else {
                            request.setAttribute("errorMsg", "İstemedik bir hata oluştur bir süre sonra tekrar deneyiniz..");
                            request.setCharacterEncoding("UTF-8");
                            request.getRequestDispatcher("/settings.jsp").forward(request, response);

                        }

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    request.setAttribute("errorMsg", "Şehir seçmediniz..");
                    response.setContentType("text/html;charset=UTF-8");
                    request.setCharacterEncoding("UTF-8");
                    request.getRequestDispatcher("/settings.jsp").forward(request, response);

                }
//                out.println(brand + "<br>" + engine_size + "<br>" + date_mot_due + "<br>" + price + "<br>"
//                        + current_milleage + "<hr><br>" + daily_hire_rate + "<br>" + model_name + "<br>"
//                        + type_description + "<br>" + city_id + "<br>" + idCalc);
            } else {
                String id = request.getParameter("delete_id");

                try {
                    Boolean status_ = ModulsDatas.delete_vehicle(id);
                    if (status_) { // delete OK

                        response.sendRedirect("settings.jsp");
                    } else {
                        request.setAttribute("errorMsg", "İstemedik bir hata oluştur bir süre sonra tekrar deneyiniz..");
                        request.setCharacterEncoding("UTF-8");
                        request.getRequestDispatcher("/settings.jsp").forward(request, response);

                    }
//                out.println("del");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (object[0].equals("bus")) {
            if (object[1].equals("add")) {
//                out.println("add");
                String agancet_name = request.getParameter("agancet_name");
                String from_country = request.getParameter("from_country");
                String from_city = request.getParameter("from_city");
                String to_country = request.getParameter("to_country");
                String to_city = request.getParameter("to_city");
                String price_ = request.getParameter("price");
                double price = Double.parseDouble(price_);

                int id = ModulsDatas.last_index_buses();
                Bus bus = new Bus(id, agancet_name, from_city, from_country, to_city, to_country, price);
                
                try {
                    boolean status_ = ModulsDatas.insert_bus(bus);
                    if (status_) { // insert OK

                            response.sendRedirect("settings.jsp?query=bus");
                        } else {
                            request.setAttribute("errorMsg", "İstemedik bir hata oluştur bir süre sonra tekrar deneyiniz..");
                            request.setCharacterEncoding("UTF-8");
                            request.getRequestDispatcher("/settings.jsp?query=bus").forward(request, response);

                        }
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }  
            } else {
                String id = request.getParameter("delete_id");

                try {
                    Boolean status_ = ModulsDatas.delete_bus(id);
                    if (status_) { // delete OK

                        response.sendRedirect("settings.jsp?query=bus");
                    } else {
                        request.setAttribute("errorMsg", "İstemedik bir hata oluştur bir süre sonra tekrar deneyiniz..");
                        request.setCharacterEncoding("UTF-8");
                        request.getRequestDispatcher("/settings.jsp?query=bus").forward(request, response);
                    }
//                out.println("del");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (object[0].equals("hotel")) {
            if (object[1].equals("add")) {
                String hotel_name = request.getParameter("hotel_name");
                String hotel_country = request.getParameter("hotel_country");
                String hotel_city = request.getParameter("hotel_city");
                String price_ = request.getParameter("price");
                double price = Double.parseDouble(price_);
                String adres = request.getParameter("hotel_address");
                
                int id = ModulsDatas.last_index_hotelses();
                
                Hotels hotels = new Hotels(id, hotel_city, hotel_country, hotel_name, adres, price);
                try {
                    boolean status_ = ModulsDatas.insert_hotels(hotels);
                    if (status_) { // insert OK

                            response.sendRedirect("settings.jsp?query=hotel");
                        } else {
                            request.setAttribute("errorMsg", "İstemedik bir hata oluştur bir süre sonra tekrar deneyiniz..");
                            request.setCharacterEncoding("UTF-8");
                            request.getRequestDispatcher("/settings.jsp?query=hotel").forward(request, response);

                        }
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }  
                
                
            } else {
                String id = request.getParameter("delete_id");

                try {
                    Boolean status_ = ModulsDatas.delete_hotel(id);
                    if (status_) { // delete OK

                        response.sendRedirect("settings.jsp?query=hotel");
                    } else {
                        request.setAttribute("errorMsg", "İstemedik bir hata oluştur bir süre sonra tekrar deneyiniz..");
                        request.setCharacterEncoding("UTF-8");
                        request.getRequestDispatcher("/settings.jsp?query=hotel").forward(request, response);
                    }
//                out.println("del");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    } // end metot

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
