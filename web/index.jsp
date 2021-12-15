<%-- 
    Document   : index
    Created on : 02.Kas.2021, 21:00:03
    Author     : Vedat Onal
--%>

<%@page import="com.vedat.modules.Packages.Packages"%>
<%@page import="com.vedat.modules.Hotels.Hotels"%>
<%@page import="java.util.Base64"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.vedat.modules.BusDriver.Bus"%>
<%@page import="com.vedat.database.Moduls.ModulsDatas"%>
<%@page import="com.vedat.modules.Vehicle.Vehicles"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vedat.modules.Admin"%>
<%@page import="com.vedat.modules.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/page/directives/metas.jsp" %>
    <title>Ana Sayfa</title>
    <%@include file="/page/directives/sources.jsp" %>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="page/resources/stylesheet/indexTravol.css"/>
    <link rel="stylesheet" href="page/resources/stylesheet/modalstyle.css"/>
</head>
<body>
    <!-- HEADER import -->
    <%
    Customer customer = (Customer) session.getAttribute("customer");
    Admin admin_ = (Admin) session.getAttribute("admin");
    if (customer == null & admin_ == null) {
    %>
        <%@include file="/page/directives/header.jsp" %>
    <%
    } else if (customer != null & admin_ == null) {
        String query = null, id = null;
        Cookie[] coo = request.getCookies();
        if (coo != null) {
            for (int i = 0; i < coo.length; i++) {
                Cookie cookie = coo[i];
                if (cookie.getName().equals("query")) {
                    query = cookie.getValue();
                }
                if (cookie.getName().equals("id")) {
                    id = cookie.getValue();
                }
            }
        }
        if (query != null && id != null) {
            response.sendRedirect("process.jsp");
        }
    %>
        <%@include file="/page/directives/headerAccount.jsp" %>
    <%
    } else if (customer == null & admin_ != null) {
    %>
        <%@include file="/page/directives/headerAdmin.jsp" %>
    <%
    }
    %>
    <!-- SLİDER import -->
        <%@include file="/page/directives/slider.jsp" %>

<div class="container">
    <%
        String query = request.getParameter("query");
        if (query == null || query.equals("Araç_Kiralama")) {
            ArrayList<Vehicles> vehicles = ModulsDatas.query_select_vehicles();
            for (Vehicles veh : vehicles) {
                if (veh.getStatus() == 0) {
    %>
    <div class="row rw">
        <!-- Left Column 
        ../d_Travel/page/resources/images/car.jpg
        -->
        <div class="left-column" >
            <img data-image="red" class="active" src="<%= veh.getCar_img()%>" alt="">
        </div>
        <!-- Right Column -->
        <div class="right-column">
            <h3><%= veh.getPrice()%> $ </h3>
            <ul class="rwul" style="float: left">
                <li class="rwli">
                    <strong class="rwstrong">İLAN</strong>
                    <span class="rwspan"><%=veh.getId()%></span>
                </li>
                <li class="rwli">
                    <strong class="rwstrong">YIL</strong>
                    <span class="rwspan"><%= veh.getDate_mot_due()%></span>
                </li>
                <li class="rwli">
                    <strong class="rwstrong">M. hacim</strong>
                    <span class="rwspan"><%= veh.getEngine_size()%> CC</span>
                </li>
                <li class="rwli">
                    <strong class="rwstrong">Model isim</strong>
                    <span class="rwspan"><%= veh.getModels().getModel_name()%></span>
                </li>
            </ul>
            <ul class="rwul" style="float: left">
                <li class="rwli"><!-- veh.getModels().getDaily_hire_rate() -->
                    <strong class="rwstrong">G. kiralama oranı</strong>
                    <span class="rwspan"><%= veh.getModels().getDaily_hire_rate()%>%</span>
                </li>
                <li class="rwli">
                    <strong class="rwstrong">Şehir / Ükle</strong>
                    <span class="rwspan"><%= veh.getCity_name() + " / " + veh.getCountry_name()%></span>
                </li>
                <li class="rwli">
                    <strong class="rwstrong">Markası </strong>
                    <span class="rwspan"><%= veh.getBrand()%></span>
                </li>
            </ul>
            <!--
        <button style="float: right" >Kirala</button>
            -->
            <a style="float: right" href="./control.jsp?query=<%= query %>&id=<%= veh.getId() %>" class="boxed-btn2">Kirala</a>
        </div>
    </div>
    <%          } // end if          
        }// end for 
    } else if (query.equals("bus")) {
        ArrayList<Bus> buses = ModulsDatas.query_select_buses();
        for (Bus bus : buses) {
    %>
    <div class="row rwBus">
        <div class="busListItem">
            <div class="busListInner">
                <div class="topDetail">
                    <div class="rowOne">
                        <div class="colOne">
                            <div id="imgadd" class="logobus">
                                <div style="" class="canvasTXT"><%= bus.getAgancet_name()%></div>
                            </div>
                        </div>
                        <div class="colTwo">
                            <div class="time">
                                <h3><%= bus.getDateFrom() + " / " + bus.getTimeFrom()%></h3>
                            </div>
                            <div class="duration">
                                <h5><span class="icon-sure"></span>
                                    <%= bus.getDifferenceDate()%>
                                </h5>
                            </div>
                        </div>
                        <div class="colThree">
                            <div class="firstRow">
                                <div class="slotOne">
                                    <b><%= bus.getFrom_city_name().toUpperCase() + " " + bus.getFrom_country_name().toUpperCase() + " > " + bus.getTo_city_name().toUpperCase() + " " + bus.getTo_country_name().toUpperCase()%></b>
                                </div>
                                <div class="slotTwo">
                                    <div class="arrangement">
                                        <div class="seat">
                                            2+1
                                        </div>
                                        <div class="feature">
                                            <i class="fas fa-wifi"></i>
                                            <i class="fas fa-tv"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="slotThree">
                                    <div class="seatPrice">
                                        <h3><%= bus.getPrice()%><span> $</span></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="colFour">
                            <a style="float: right" href="./control.jsp?query=<%= query%>&id=<%= bus.getId()%>&from=<%= bus.getDateFrom() + "/" + bus.getTimeFrom()%>&to=<%= bus.getDateTo() + "/" + bus.getTimeTo()%>" class="boxed-btn2">Satın Al</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <%
        }
        // bus else if 
    } else if (query.equals("hotel")) {
        ArrayList<Hotels> hotelses = ModulsDatas.query_select_hotel();
        for (Hotels hotels : hotelses) {
    %>
    <div class="row rw-hotel">
        <!-- Left Column -->
        <div class="left-column-hotel" >
            <img data-image="red" class="active" src="<%= hotels.getHotel_img()%>" alt="">
        </div>
        <!-- Right Column -->
        <div class="right-column-hotel">
            <div class="inside-left">
                <section class="slc">
                    <div class="title">
                        <h2 class="h2title"><%= hotels.getName()%></h2>
                        <div class="dvtitle"></div>
                    </div>
                    <p class="adres"><%= hotels.getCountry_name() + " / " + hotels.getCity_name() + " Adres : " + hotels.getAddres()%></p>
                </section>
                <section class="slc1">
                    <p class="detailtitle">Detay</p>
                    <ul class="ulff">
                        <li class="li">A1</li>
                        <li class="li">A2</li>
                    </ul>
                </section>
                <section class="slc2">
                    <span class="status">10.0</span>
                    <span class="statustitle">Süper</span>
                </section>
            </div>
            <div class="inside-right">
                <div class="price01">
                    <div class="price02">
                        <span class="price03"><%= hotels.getPrice()%> $</span>
                    </div>
                    <div class="price12">vergi ve masraflar dâhil</div>
                </div>
                <div class="btn-rezer">
                    <a class="boxed-btn-hotel" href="./control.jsp?query=<%= query%>&id=<%= hotels.getId()%>">Hemen rezervasyon yap</a>
                </div>
            </div>
        </div>
    </div>
    <%
            }
        }
    %>
</div>


<%  // modals
    String MsgHead = null;
    String MsgBody = null;

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("infoMsg") || cookie.getName().equals("errorMsg")) {
                MsgHead = cookie.getName();
                String urldecode = URLDecoder.decode(cookie.getValue(), "UTF-8");
                String decode = new String(Base64.getDecoder().decode(urldecode));
                MsgBody = decode;
            }
        }
    }

    if (MsgHead != null || MsgBody != null) {
%>
<!-- The Modal -->
<div id="myModal" class="modal" style="display: block;">
    <!-- Modal content -->
    <div class="modal-content">
        <span id="close" class="close">&times;</span>
        <%
            if (MsgHead.equals("infoMsg")) {
        %>        
        <p class="text-center"><i class="fas fa-check-circle"></i>INFO</p>
        <p class="text-center"><%= MsgBody%></p>

        <%
        } else if (MsgHead.equals("errorMsg")) {
        %>        
        <p class="text-center text-danger" style="font-size: 36px">
        <i class="fas fa-exclamation"></i>  Oppss
        </p>
        <p class="text-center"><%= MsgBody%></p>
        <%
            }
        %>
    </div>
</div>

<%
    }
%>

<!-- FOOTER import -->
<%@include file="/page/directives/footer.jsp" %>
</body>
<script>
    // MODALS
    var modal = document.getElementById("myModal");
    var span = document.getElementsByClassName("close")[0];
    span.onclick = function() {
        modal.style.display = "none";
        var headers = document.cookie.split("; ");
        for(var i=0;i<headers.length;i++){
            var head = headers[i].split("=");
            var key = head[0];
//            var value = head[1];
            if (key === "infoMsg" || key === "errorMsg"){
                document.cookie = headers[i] +";max-age=0";
            }   
        }
    };

</script>
</html>
