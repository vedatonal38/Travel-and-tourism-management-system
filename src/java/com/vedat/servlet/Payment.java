/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vedat.servlet;

import com.vedat.database.Moduls.ModulsDatas;
import com.vedat.modules.BusDriver.Seat;
import com.vedat.modules.Customer;
import com.vedat.modules.reservations.BusBooking;
import com.vedat.modules.reservations.Hotel_booking;
import com.vedat.modules.reservations.PackagesBooking;
import com.vedat.modules.reservations.VehicleRenals;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Dell
 */
@WebServlet(name = "Payment", urlPatterns = {"/Payment"})
public class Payment extends HttpServlet {

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
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        String id = request.getParameter("hidis");
        JSONObject object = null;
        try (PrintWriter out = response.getWriter()) {
            JSONParser jsonParser = new JSONParser();
            try {
                object = (JSONObject) jsonParser.parse(id);
            } catch (ParseException ex) {
                out.println("error");
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Payment</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + object + "</h1>");
            out.println("<h1>" + object.get("driverId") + "</h1>");
            Set<String> seat = object.keySet();
            out.println("<h1>" + seat + "</h1>");
            JSONArray array = (JSONArray) object.get("seat");
            out.println("<h1>" + array + "</h1>");

            Iterator iter = array.iterator();

            while (iter.hasNext()) {
                JSONObject jSONObject = (JSONObject) iter.next();
                out.println("<h1>" + jSONObject.get("gender") + "</h1>");

            }

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
//        Customer customer = (Customer) request.getSession(false).getAttribute("customer");
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("customer");
        String id = request.getParameter("hidis");
        String query = request.getParameter("query");
        String date_from = request.getParameter("date_from");
        String date_to = request.getParameter("date_to");

        if (query.equals("null") || query.equals("Arac_Kiralama")) {
            // booking
            int idcalc = ModulsDatas.last_index_vehicles_renals();

            VehicleRenals renals = new VehicleRenals(idcalc, date_from, date_to, customer.getId(), Integer.parseInt(id), 1, "Ozel");
            try {
                Boolean status_ = ModulsDatas.insert_vehicle_renal(renals);
                if (status_) { // insert OK
                    Boolean up_status = ModulsDatas.update_vehicles_status_set_1(Integer.parseInt(id));
                    if (up_status) {
                        String value = "Başarılı bir şekilde işlemleriniz gerçekleşmiştir.";
                        deleteCookies(request.getCookies(), response);
                        sendRedirict("infoMsg", value, response);
                    } else {
                        deleteCookies(request.getCookies(), response);
                        sendRedirict("errorMsg", "İstemedik bir sorun oluştu LÜTFEN daha sonra yeniden deneyiniz. \nİYİ GÜNLER...", response);
                    }
                } else {
                    deleteCookies(request.getCookies(), response);
                    sendRedirict("errorMsg", "İstemedik bir sorun oluştu LÜTFEN daha sonra yeniden deneyiniz. \nİYİ GÜNLER...", response);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
//                errorResponse(request, response);
            }
        } else if (query.equals("Bus")) {
            // bus bus 
            // veriler id içerinde json yapısı ile gelecektir.
            int bookingID = ModulsDatas.last_indexBusBooking();
            int start_no_seat_id = ModulsDatas.last_index_seats();

            int driverId = parseDriverId(id);
            ArrayList<Seat> seats = parseSeat(id, customer.getId(), driverId, start_no_seat_id);// seats
            BusBooking booking = new BusBooking(bookingID, date_from, date_to, customer.getId(), driverId, 1);
            // insert
            try {
                Boolean status_ = ModulsDatas.insert_busBookings(seats, booking);
                if (status_) {
                    String value = "Başarılı bir şekilde işlemleriniz gerçekleşmiştir.";
                    deleteCookies(request.getCookies(), response);
                    sendRedirict("infoMsg", value, response);
                } else {
                    deleteCookies(request.getCookies(), response);
                    sendRedirict("errorMsg", "İstemedik bir sorun oluştu LÜTFEN daha sonra yeniden deneyiniz. \nİYİ GÜNLER...", response);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                //                errorResponse(request, response);
            }
        } else if (query.equals("Hotel")) {
            int bookingID = ModulsDatas.last_indexHotelBooking();

            Hotel_booking booking = new Hotel_booking(bookingID, date_from, date_to, customer.getId(), Integer.parseInt(id), 1);

            try {
                boolean status_ = ModulsDatas.insert_hotelBooking(booking);
                if (status_) {
                    String value = "Başarılı bir şekilde işlemleriniz gerçekleşmiştir.";
                    deleteCookies(request.getCookies(), response);
                    sendRedirict("infoMsg", value, response);
                } else {
                    deleteCookies(request.getCookies(), response);
                    sendRedirict("errorMsg", "İstemedik bir sorun oluştu LÜTFEN daha sonra yeniden deneyiniz. \nİYİ GÜNLER...", response);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (query.equals("Package")) {
            int bookingID = ModulsDatas.last_index_PackagesBooking();

            PackagesBooking booking = new PackagesBooking(bookingID, null, customer.getId(), Integer.parseInt(id), 1);

            try {
                boolean status_ = ModulsDatas.insert_packageBooking(booking);
                if (status_) {
                    String value = "Başarılı bir şekilde işlemleriniz gerçekleşmiştir.";
                    deleteCookies(request.getCookies(), response);
                    sendRedirict("infoMsg", value, response);
                } else {
                    deleteCookies(request.getCookies(), response);
                    sendRedirict("errorMsg", "İstemedik bir sorun oluştu LÜTFEN daha sonra yeniden deneyiniz. \nİYİ GÜNLER...", response);
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    //  seat        index   mod
    //  1-4-7...    5       1%3=1
    //  2-5-8...    2       2%3=2
    //  3-6-9..     1       3%3=0

    private ArrayList<Seat> parseSeat(String dt, int cusId, int driverId, int seat_no_id) {
        ArrayList<Seat> seats = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONParser js = new JSONParser();

        try {
            JSONObject object = (JSONObject) parser.parse(dt);
            JSONArray array_seat = (JSONArray) object.get("seat");
            Iterator iter = array_seat.iterator();

            while (iter.hasNext()) {
                JSONObject json = (JSONObject) iter.next();
                String gender = (String) json.get("gender");
                int gndr = 0;
                if (gender.toUpperCase().equals("ERKEK")) {
                    gndr = 2;
                } else if (gender.toUpperCase().equals("KADIN")) {
                    gndr = 1;
                }

                int seat_no = Integer.parseInt((String) json.get("seatId"));
                int seat_index = -1;
                if (seat_no % 3 == 1) {
                    seat_index = 5;
                } else if (seat_no % 3 == 2) {
                    seat_index = 2;
                } else if (seat_no % 3 == 0) {
                    seat_index = 1;
                }
                Seat st = new Seat(seat_no_id, driverId, cusId, Integer.toString(seat_no), gndr, seat_index);
                seats.add(st);

                seat_no_id++;
            }

        } catch (ParseException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }

        return seats;
    }

    private int parseDriverId(String dt) {
        JSONParser parser = new JSONParser();

        try {
            JSONObject object = (JSONObject) parser.parse(dt);

            return Integer.parseInt((String) object.get("driverId"));
        } catch (ParseException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    private void print_(HttpServletResponse response, String data) throws IOException {
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Payment</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + data + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

    private void deleteCookies(Cookie[] cookies, HttpServletResponse response) {
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("query") || cookie.getName().equals("id")
                        || cookie.getName().equals("from") || cookie.getName().equals("to")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }

    private void sendRedirict(String header, String value, HttpServletResponse response) throws IOException {
        String encode = Base64.getEncoder().encodeToString(value.getBytes());
        response.addCookie(new Cookie(header, URLEncoder.encode(encode, "UTF-8")));
        response.sendRedirect("index.jsp");
    }
}
