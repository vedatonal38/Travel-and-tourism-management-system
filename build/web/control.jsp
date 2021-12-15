<%-- 
    Document   : control
    Created on : 22.Kas.2021, 14:39:21
    Author     : Vedat Önal
--%>  

<%@page import="com.vedat.modules.BusDriver.Bus"%>
<%@page import="com.vedat.modules.Customer"%>
<%@page import="com.vedat.modules.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <%        
        Customer customer = (Customer) session.getAttribute("customer");
        Admin admin_ = (Admin) session.getAttribute("admin");
        String query = request.getParameter("query");
        String id = request.getParameter("id");
        String from = request.getParameter("from");
        String to = request.getParameter("to");

        String del = request.getParameter("del");
        if (del != null) {
            if (del.equals("0")) {
                Cookie[] cookies = request.getCookies();
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
                response.sendRedirect("./index.jsp");
            }
        } else {
            if (customer == null & admin_ == null) {
                Cookie queryCookie = new Cookie("query", query);
                Cookie idCookie = new Cookie("id", id);

                response.addCookie(queryCookie);
                response.addCookie(idCookie);

                response.sendRedirect("./login.jsp");
            } else if (customer != null) {
                response.addCookie(new Cookie("query", query));
                response.addCookie(new Cookie("id", id));
                if (query.equals("bus")) {
                    response.addCookie(new Cookie("from", from.replace("/", " ") + ":00"));
                    response.addCookie(new Cookie("to", to.replace("/", " ") + ":00"));
                }
                response.sendRedirect("process.jsp");
            } else if (admin_ != null) {
                response.sendRedirect("index.jsp");
            }
        }
    %>    
</body>
</html>
