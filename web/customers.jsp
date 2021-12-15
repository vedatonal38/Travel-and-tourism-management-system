<%-- 
    Document   : customers
    Created on : 12.Kas.2021, 10:38:58
    Author     : Vedat Önal
--%>

<%@page import="com.vedat.modules.reservations.PackagesBooking"%>
<%@page import="com.vedat.database.Moduls.ModulsDatas"%>
<%@page import="com.vedat.modules.reservations.Hotel_booking"%>
<%@page import="com.vedat.modules.reservations.BusBooking"%>
<%@page import="com.vedat.modules.reservations.VehicleRenals"%>
<%@page import="com.vedat.database.CustomerDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vedat.modules.Admin"%>
<%@page import="com.vedat.modules.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/page/directives/metas.jsp" %>
        <%        String cus_id = request.getParameter("id");
            if (cus_id == null) {
        %>
    <title>Kullanıcıların listesi</title>
    <%
    } else {
        Customer customer = CustomerDB.query_where(cus_id);
        if (customer == null) {
            response.sendRedirect("customers.jsp");
        } else {
    %>
    <title><% out.print(customer.getName()); %> | Kullanıcı</title>
    <%
            }
        }
    %>
    <%@include file="/page/directives/sources.jsp" %>
    <!-- data -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css"/>
    <script src=" https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>
    <!-- HEADER import -->
    <%        Admin admin_ = (Admin) session.getAttribute("admin");
        if (admin_ == null) {
            response.sendRedirect("index.jsp");
        } else {
    %>
    <%@include file="/page/directives/headerAdmin.jsp" %>

    <%
        Customer customer = CustomerDB.query_where(cus_id);
        if (customer == null) {
    %>
<div class="container">

    <div class="row header" style="text-align:center;">
        <div class="col-12">
            <h3>Kullanıcılar listesi</h3>
        </div>
    </div>
    <div id="myTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
        <div class="row">
            <div class="col-sm-12">
                <table id="myTable" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th> 
                            <th>ADI</th> 
                            <th>SOYAD</th> 
                            <th>KULLANICI ADI</th> 
                            <th>EMAİL</th> 
                            <th>DETAYLAR</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Customer> customers = CustomerDB.getCustomers();
                            for (Customer cus : customers) {
                                int id = cus.getId();
                        %>
                        <tr>
                            <td><% out.print(id); %></td>
                            <td><% out.print(cus.getName()); %></td>
                            <td><% out.print(cus.getSurname()); %></td>
                            <td><% out.print(cus.getUsername()); %></td>
                            <td><% out.print(cus.getEmail()); %></td>
                            <td><% out.print("<a href='customers.jsp?id=" + id + "'>Click</a>");%></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                    <tfoot>
                        <tr>
                            <th>ID</th> 
                            <th>ADI</th> 
                            <th>SOYAD</th> 
                            <th>KULLANICI ADI</th> 
                            <th>EMAİL</th> 
                            <th>DETAYLAR</th> 
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>

</div>
<%
} else {
%>

<nav class="navbar navbar-toggleable-md navbar-light bg-info">
    <div class="d-md-flex d-block flex-row mx-md-auto mx-0">
        <a style="color: white;" class="nav-item nav-link active" href="../d_Travel/customers.jsp?id=<% out.print(cus_id + "&query=cars"); %>">Araç kiralama <span class="sr-only">(current)</span></a>
        <a style="color: white;" class="nav-item nav-link" href="../d_Travel/customers.jsp?id=<% out.print(cus_id + "&query=bus"); %>">Otobus</a>
        <a style="color: white;" class="nav-item nav-link" href="../d_Travel/customers.jsp?id=<% out.print(cus_id + "&query=hotel"); %>">Hotel</a>
        <a style="color: white;" class="nav-item nav-link" href="../d_Travel/customers.jsp?id=<% out.print(cus_id + "&query=package"); %>">Paket</a>
    </div>
</nav>
<div class="container">
    <%
        String query = request.getParameter("query");
        if (query == null || query.equals("cars")) {
    %>
    <div class="row header" style="text-align:center;">
        <div class="col-12">
            <h3><% out.print(customer.getName() + " " + customer.getSurname()); %> | Araç Kiralama Listesi</h3>
            <hr>
        </div>
    </div>
    <%
    } else if (query.equals("bus")) {
    %>
    <div class="row header" style="text-align:center;">
        <div class="col-12">
            <h3><% out.print(customer.getName() + " " + customer.getSurname()); %> | Otobüs  Listesi</h3>
            <hr>
        </div>
    </div>
    <%
    } else if (query.equals("hotel")) {
    %>
    <div class="row header" style="text-align:center;">
        <div class="col-12">
            <h3><% out.print(customer.getName() + " " + customer.getSurname()); %> | Hotel Listesi</h3>
            <hr>
        </div>
    </div>
    <%
    } else if (query.equals("package")) {
    %>
    <div class="row header" style="text-align:center;">
        <div class="col-12">
            <h3><% out.print(customer.getName() + " " + customer.getSurname()); %> | Paket Listesi</h3>
            <hr>
        </div>
    </div>
    <%
        }
    %>
    <div id="myTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
        <div class="row">
            <div class="col-sm-12">
                <table id="myTable" class="table table-bordered dataTable" aria-describedby="myTable_info" role="grid">
                    <thead>
                        <tr>
                            <%
                                //query = request.getParameter("query");
                                if (query == null || query.equals("cars")) {
                                    String[] headers = {"ID", "BAŞLANGIÇ", "BİTİŞ", "AÇIKLAMA", "ARAÇ ID"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                } else if (query.equals("bus")) {
                                    String[] headers = {"ID", "BAŞLANGIÇ", "BİTİŞ", "OTOBUS ID"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                } else if (query.equals("hotel")) {
                                    String[] headers = {"ID", "BAŞLANGIÇ", "BİTİŞ", "HOTEL ID"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                } else if (query.equals("package")) {
                                    String[] headers = {"ID", "BAŞLANGIÇ", "PAKET ID"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                }
                            %>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (query == null || query.equals("cars")) {
                                ArrayList<VehicleRenals> renalses = ModulsDatas.query_where_select_VehicleRenals(cus_id);  //.query_where_select_VehicleRenals(cus_id);
                                //out.print(!renalses.isEmpty());
                                if (!renalses.isEmpty()) {
                                    for (VehicleRenals vr : renalses) {
                                        out.print("<tr>");
                                        out.print("<td>" + vr.getId() + "</td>");
                                        out.print("<td>" + vr.getDate_from() + "</td>");
                                        out.print("<td>" + vr.getDate_to() + "</td>");
                                        out.print("<td>" + vr.getDescription() + "</td>");
                                        out.print("<td>" + vr.getVeh_id() + "</td>");
                                        out.print("</tr>");
                                    }
                                }
                            } else if (query.equals("bus")) {
                                ArrayList<BusBooking> bookings = ModulsDatas.query_where_select_busBooking(cus_id);
                                //  out.print(bookings.isEmpty());
                                if (!bookings.isEmpty()) {
                                    for (BusBooking bus : bookings) {
                                        out.print("<tr>");
                                        out.print("<td>" + bus.getId() + "</td>");
                                        out.print("<td>" + bus.getDate_from() + "</td>");
                                        out.print("<td>" + bus.getDate_to() + "</td>");
                                        out.print("<td>" + bus.getDriver_id() + "</td>");
                                        out.print("</tr>");
                                    }
                                }
                            } else if (query.equals("hotel")) {
                                ArrayList<Hotel_booking> bookings = ModulsDatas.query_where_select_HotelBookings(cus_id);
                                //    out.print(bookings.isEmpty());
                                if (!bookings.isEmpty()) {
                                    for (Hotel_booking hot : bookings) {
                                        out.print("<tr>");
                                        out.print("<td>" + hot.getId() + "</td>");
                                        out.print("<td>" + hot.getDate_from() + "</td>");
                                        out.print("<td>" + hot.getDate_to() + "</td>");
                                        out.print("<td>" + hot.getHotel_id() + "</td>");
                                        out.print("</tr>");
                                    }
                                }

                            } else if (query.equals("package")) {
                                ArrayList<PackagesBooking> bookings = ModulsDatas.query_where_select_PackagesBooking(cus_id);
                                if (!bookings.isEmpty()) {
                                    for (PackagesBooking b : bookings) {
                                        out.print("<tr>");
                                        out.print("<td>" + b.getId() + "</td>");
                                        out.print("<td>" + b.getCreat() + "</td>");
                                        out.print("<td>" + b.getPackage_id() + "</td>");
                                        out.print("</tr>");
                                    }
                                }
                            }
                        %>
                    </tbody>
                    <tfoot>
                        <tr>
                            <%
                                if (query == null || query.equals("cars")) {
                                    String[] headers = {"ID", "BAŞLANGIÇ", "BİTİŞ", "AÇIKLAMA", "ARAÇ ID"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                } else if (query.equals("bus")) {
                                    String[] headers = {"ID", "BAŞLANGIÇ", "BİTİŞ", "OTOBUS ID"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                } else if (query.equals("hotel")) {
                                    String[] headers = {"ID", "BAŞLANGIÇ", "BİTİŞ", "HOTEL ID"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                } else if (query.equals("package")) {
                                    String[] headers = {"ID", "BAŞLANGIÇ", "PAKET ID"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                }
                            %>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>

</div>
<%    }
%>

<%    }
%>




<!-- FOOTER import 
<%@include file="/page/directives/footer.jsp" %>
-->
<script>
    $(document).ready(function() {
        $('#myTable').DataTable({
            "language": {
                "decimal": "",
                "emptyTable": "Tabloda veri yok",
                "info": "_TOTAL_ verinin _START_ ile _END_ arasında gösteriliyor", //Showing _START_ to _END_ of _TOTAL_ entries
                "infoEmpty": "0 veri 0'dan 0'a gösteriliyor",
                "infoFiltered": "(_MAX_ toplam veri filtrelendi)",
                "infoPostFix": "",
                "thousands": ",",
                "lengthMenu": "_MENU_ veri göster",
                "loadingRecords": "Yükleniyor...",
                "processing": "İşleme...",
                "search": "Arama :",
                "zeroRecords": "Hiçbir eşleşen kayıt bulunamadı",
                "paginate": {
                    "first": "İlk",
                    "last": "Son",
                    "next": "İleri",
                    "previous": "Geri"
                },
                "aria": {
                    "sortAscending": ": activate to sort column ascending",
                    "sortDescending": ": activate to sort column descending"
                }
            }
        });
    });
</script>

</body>
</html>
