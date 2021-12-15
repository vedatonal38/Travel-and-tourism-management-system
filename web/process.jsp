<%-- 
    Document   : process
    Created on : 22.Kas.2021, 15:01:25
    Author     : Vedat Onal
--%>
<%@page import="com.vedat.modules.Packages.Packages"%>
<%@page import="com.vedat.modules.Hotels.Hotels"%>
<%@page import="com.vedat.modules.BusDriver.Seat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vedat.modules.BusDriver.Bus"%>
<%@page import="com.vedat.modules.Customer"%>
<%@page import="com.vedat.database.Moduls.ModulsDatas"%>
<%@page import="com.vedat.modules.Vehicle.Vehicles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="./page/directives/metas.jsp" %>
    <title>PROCESS Page</title>
    <%@include file="./page/directives/sources.jsp" %>
    <link rel="stylesheet" href="https://cardjs.co.uk/css/dependencies.min.css">
    <link rel="stylesheet" href="./page/resources/stylesheet/mobildriver.css">
    <link rel="stylesheet" href="./page/resources/stylesheet/icons.css">
    <link rel="stylesheet" href="./page/resources/stylesheet/process.css">
    <link rel="stylesheet" href="./page/resources/stylesheet/modalstyle.css">
    <link href='https://css.gg/battery.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <%
        String from = null, to = null;
        String query = null, id = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("query")) {
                    query = cookie.getValue();
                }
                if (cookie.getName().equals("id")) {
                    id = cookie.getValue();
                }
            }
        }
        if (query == null) {
            response.sendRedirect("/index.jsp");
        }
//        out.print(query + " :: " + id);
        if (query.equals("bus")) {
    %>
    <link rel="stylesheet" href="https://biletall-cdn.mncdn.com/bundles/operationbuspagescss"/>
    <link rel="stylesheet" href="./page/resources/stylesheet/bus_.css"
          <%  }
              //<link rel="stylesheet" href="https://biletall-cdn.mncdn.com/bundles/desktopfullpackagecss"/>

          %>
</head>
<body>
<header>
    <%        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            response.sendRedirect("/index.jsp");

        } else {
    %>
    <div class="header-area bg-dark">
        <div class="row align-items-center">
            <div class="col-4">
                <a href="control.jsp?del=0">
                    <svg xmlns="http://www.w3.org/2000/svg" style="margin-left: 25px; margin-bottom: 10px;margin-top: 10px;" width="50" height="50" fill="currentColor" class="bi bi-arrow-left-circle" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
                    </svg>
                </a>
            </div>
            <div class="col-4 text-center" id="banner">
                PROCESS
            </div>
            <div class="col-4"></div>
        </div>
    </div>
</header>
<div class="container" style="border: 2px solid red; margin-top: 15px">
    <%
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("query")) {
                    query = cookie.getValue();
                }
                if (cookie.getName().equals("id")) {
                    id = cookie.getValue();
                }
                if (query.equals("bus")) {
                    if (cookie.getName().equals("from")) {
                        from = cookie.getValue();
                    }
                    if (cookie.getName().equals("to")) {
                        to = cookie.getValue();
                    }
                }
            }
        }

        if (query.equals("null") || query.equals("Araç_Kiralama")) {
            Vehicles veh = ModulsDatas.query_where_vehicles(id);

    %>
    <nav class="navbar navbar-toggleable-md navbar-light bg-info">
        <div class="d-md-flex d-block flex-row mx-md-auto mx-0" id="navBanner">
            ARAÇ
        </div>
    </nav>
    <div id="card1">
        <div class="row rimg">
            <div class="col text-center" >
                <img style="width: 400px" class="active" src="<%= veh.getCar_img()%>" alt="">
            </div> 
        </div>
        <div class="row">
            <div class="col">
                <h3 class="text-center"><%= veh.getBrand().toUpperCase()%></h3>
                <div id="star12" class="star12"></div>
                <p class="text-center star12 starText"><%= veh.getPrice()%> $</p>
                <div class="col">
                    <ul class="rwul" style="float: left; width: calc(100%/2)">
                        <li class="rwli">
                            <strong class="rwstrong">İLAN</strong>
                            <span id="textid" class="rwspan"><%=veh.getId()%></span>
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
                    <ul class="rwul" style="float: left; width: calc(100%/2)">
                        <li class="rwli"><!-- veh.getModels().getDaily_hire_rate() -->
                            <strong class="rwstrong">G. kiralama oranı</strong>
                            <span class="rwspan"><%= veh.getModels().getDaily_hire_rate()%>%</span>
                        </li>
                        <li class="rwli">
                            <strong class="rwstrong">Şehir / Ükle</strong>
                            <span class="rwspan"><%= veh.getCity_name().toUpperCase() + " / " + veh.getCountry_name().toUpperCase()%></span>
                        </li>
                        <li class="rwli">
                            <strong class="rwstrong">Kilometresi </strong>
                            <span class="rwspan"><%= veh.getCurrent_mileage()%> KM</span>
                        </li>
                        <li class="rwli">
                            <strong class="rwstrong">TIP </strong>
                            <span class="rwspan"><%= veh.getType_description().getType_description().toUpperCase()%> </span>
                        </li>
                    </ul>
                </div>
                <div class="text-center" style="margin-top: 200px">
                    <p  class="text-danger" id="errortext"></p>
                    <label for="start">Başlangıç Tarihi : </label>
                    <input type="date" id="start" name="start" value="2018-07-22" min="2018-07-21"> 
                    <label for="stop">Bitiş Tarihi : </label>
                    <input type="date" id="stop" name="stop" value="2018-07-22" min="2018-07-21">

                    <!--                    <label>Kaç günlük kiralamak istersiniz    </label>
                                        <input class="card-number" type="number" placeholder="0" min="0" max="100" value="0" id="gun">                            
                    -->                </div>
                <p class="text-center"><a href="#" class="btn boxed-btn2" id="ileri2">İLERİ</a></p>
            </div>
        </div>
    </div><!-- id card1 -->

    <%
    } else if (query.equals("bus")) {
        Bus bus = ModulsDatas.query_where_bus(id);
    %>
    <nav class="navbar navbar-toggleable-md navbar-light bg-info">
        <div class="d-md-flex d-block flex-row mx-md-auto mx-0" id="navBanner">
            OTOBÜS | <%= bus.getAgancet_name().toUpperCase()%>
        </div>
    </nav>
    <div id="card1">
        <div style="display: none">
            <span id="busId"><%= id%></span>
            <span id="busFrom"><%= from%></span>
            <span id="busTo"><%= to%></span>
        </div>
        <div class="expand-details" style="display: block;">
            <div class="bus-selection-part">
                <div class="bus-section-header">
                    <div class="gender-wrap">
                        <div class="ba-radio-grup">
                            <div class="women redio-control" style="padding-left: 70px">
                                <img class="kadin-all" src="https://biletall-cdn.mncdn.com/img-v7/ortak/female.svg?v=57498" alt="">
                                <input name="gender-282-0" type="radio" id="radio-kadin-282-0" class="radio-kadin" value="1">
                                <label class="radio-kadin seat-text" for="radio-kadin-282-0"></label>Kadın
                                <img class="kadin-split" src="https://biletall-cdn.mncdn.com/img-v7/ortak/female.svg?v=57498" alt="">
                            </div>
                            <div class="men redio-control" style="padding-left: 70px">
                                <img src="https://biletall-cdn.mncdn.com/img-v7/ortak/male.svg?v=57498" alt="">
                                <input name="gender-282-0" type="radio" id="radio-erkek-282-0" class="radio-erkek" value="2">
                                <label class="radio-erkek seat-text" for="radio-erkek-282-0"></label>Erkek
                            </div>
                        </div>
                    </div>

                    <div class="empty-seat-index">
                        <span class="icon-boskoltuk" style="padding-right: 52px">
                            <img src='../page/resources/images/boskoltuk.png'>
                        </span> Boş Koltuk
                    </div>
                </div>
                <div class="bus-select-wrapper">
                    <div class="bus-section-outer">
                        <div class="bus-section" style="width: 750px;">
                            <div class="otobus-on">
                                <img style="height: 240px" src="https://biletall-cdn.mncdn.com/img-v7/desktop/vendor-images/on_yeni.svg">
                            </div>
                            <div class="otobus-orta">
                                <%
                                    ArrayList<Seat> seats = ModulsDatas.query_select_seats(id);
                                %>
                                <div class="koltuk-sira" seat-location="sagDisCamKenar">
                                    <%
                                        for (Seat seat : seats) {
                                            if (seat.getSeat_index() == 1) {
//                                            out.print(seat.getSeat_index() +"--#" + seat.getCinsiyet()+"}");
                                                if (Integer.parseInt(seat.getSeat_no()) == 24) {
                                                    out.print("<a class='koltuk'></a>");
                                                    out.print("<a class='koltuk'></a>");
                                                }
                                                if (seat.getCinsiyet() == 0) {
                                                    out.print("<a class='koltuk available' onclick='javascript:kontrolluKoltukSec(this," + seat.getSeat_no() + ");' seat='" + seat.getSeat_no() + "' koltukfiyat='" + bus.getPrice() + "' koltuk-sira-index='1'>"
                                                            + "<span>" + seat.getSeat_no() + "</span><img src='https://biletall-cdn.mncdn.com/img-v7/ortak/ikonlar/bos_koltuk.svg'></a>");
                                                } else if (seat.getCinsiyet() == 1) { // kadın
                                                    out.print("<a class='koltuk unavailable' seat='" + seat.getSeat_no() + "' koltuk-sira-index='1'><span>" + seat.getSeat_no() + "</span><img src='https://biletall-cdn.mncdn.com/img-v7/ortak/bayan_dolu.svg'></a>");
                                                } else if (seat.getCinsiyet() == 2) { // er
                                                    out.print("<a class='koltuk unavailable' seat='" + seat.getSeat_no() + "' koltuk-sira-index='1'><span>" + seat.getSeat_no() + "</span><img src='https://biletall-cdn.mncdn.com/img-v7/ortak/bay_dolu.svg'></a>");
                                                }
                                            }
                                        }
                                    %>
                                </div>
                                <div class="koltuk-sira" seat-location="sagIcKoridor">                                
                                    <%
                                        for (Seat seat : seats) {
                                            if (seat.getSeat_index() == 2) {
//                                            out.print(seat.getSeat_index() +"--#" + seat.getCinsiyet()+"}");
                                                if (Integer.parseInt(seat.getSeat_no()) == 23) {
                                                    out.print("<a class='koltuk'></a>");
                                                    out.print("<a class='koltuk'></a>");
                                                }
                                                if (seat.getCinsiyet() == 0) {
                                                    out.print("<a class='koltuk available' onclick='javascript:kontrolluKoltukSec(this," + seat.getSeat_no() + ");' seat='" + seat.getSeat_no() + "' koltukfiyat='" + bus.getPrice() + "' koltuk-sira-index='2'>"
                                                            + "<span>" + seat.getSeat_no() + "</span><img src='https://biletall-cdn.mncdn.com/img-v7/ortak/ikonlar/bos_koltuk.svg'></a>");
                                                } else if (seat.getCinsiyet() == 1) { // kadın
                                                    out.print("<a class='koltuk unavailable' seat='" + seat.getSeat_no() + "' koltuk-sira-index='2'><span>" + seat.getSeat_no() + "</span><img src='https://biletall-cdn.mncdn.com/img-v7/ortak/bayan_dolu.svg'></a>");
                                                } else if (seat.getCinsiyet() == 2) { // er
                                                    out.print("<a class='koltuk unavailable' seat='" + seat.getSeat_no() + "' koltuk-sira-index='2'><span>" + seat.getSeat_no() + "</span><img src='https://biletall-cdn.mncdn.com/img-v7/ortak/bay_dolu.svg'></a>");
                                                }
                                            }
                                        }
                                    %>
                                </div>
                                <div class="koltuk-sira">
                                    <%
                                        for (int k = 0; k < 15; k++) {
                                            out.print("<a class='koltuk'></a>");
                                        }
                                    %>
                                </div>
                                <div class="koltuk-sira">
                                    <%
                                        for (int k = 0; k < 15; k++) {
                                            out.print("<a class='koltuk'></a>");
                                        }
                                    %>
                                </div>
                                <div class="koltuk-sira" seat-location="solDisCamKenar">
                                    <%
                                        for (Seat seat : seats) {
                                            if (seat.getSeat_index() == 5) {
//                                            out.print(seat.getSeat_index() +"--#" + seat.getCinsiyet()+"}");
                                                if (seat.getCinsiyet() == 0) {
                                                    out.print("<a class='koltuk available' onclick='javascript:kontrolluKoltukSec(this," + seat.getSeat_no() + ");' seat='" + seat.getSeat_no() + "' koltukfiyat='" + bus.getPrice() + "' koltuk-sira-index='5'>"
                                                            + "<span>" + seat.getSeat_no() + "</span><img src='https://biletall-cdn.mncdn.com/img-v7/ortak/ikonlar/bos_koltuk.svg'></a>");
                                                } else if (seat.getCinsiyet() == 1) { // kadın
                                                    out.print("<a class='koltuk unavailable' seat='" + seat.getSeat_no() + "' koltuk-sira-index='5'><span>" + seat.getSeat_no() + "</span><img src='https://biletall-cdn.mncdn.com/img-v7/ortak/bayan_dolu.svg'></a>");
                                                } else if (seat.getCinsiyet() == 2) { // er
                                                    out.print("<a class='koltuk unavailable' seat='" + seat.getSeat_no() + "' koltuk-sira-index='5'><span>" + seat.getSeat_no() + "</span><img src='https://biletall-cdn.mncdn.com/img-v7/ortak/bay_dolu.svg'></a>");
                                                }
                                            }
                                        }
                                    %>
                                </div>
                            </div>

                            <div class="otobus-arka">
                                <img style="height: 240px" src="https://biletall-cdn.mncdn.com/img-v7/desktop/vendor-images/arka_yeni.svg">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="bus-section-footer">
                <div class="upper-slot">
                    <div class="not-select-msg" style="">
                        <p><i class="icon-info-flash"></i><span>Henüz koltuk seçmediniz.</span></p>
                    </div>
                    <div class="selected-seat" style="display: none;text-align: center;">
                        <div class="selected-seat-head">Seçilen Koltuklar</div>
                        <div class="selected-seat-list" style="margin: auto;width: 250px">
                            <div class="col-list-seat">
                                <div class="gird-seat-list"></div>
                                <div class="gird-seat-list"></div>
                                <div class="gird-seat-list"></div>
                            </div>
                            <div class="col-list-seat">
                                <div class="gird-seat-list"></div>
                                <div class="gird-seat-list"></div>
                                <div class="gird-seat-list"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="middle-slot">
                    <a id="ileri2" href="javascript:void(0)" class="boxed-btn3 total-btn deactive_link grey" value="0">
                        <span>Toplam <strong id="totalPrice">0<i> TL</i></strong></span>
                        <span class="">Devam Et  > </span>
                    </a>
                </div>

            </div>
        </div>

    </div>

    <%
    } else if (query.equals("hotel")) {
        Hotels hotel = ModulsDatas.query_where_hotel(id);
    %>
    <nav class="navbar navbar-toggleable-md navbar-light bg-info">
        <div class="d-md-flex d-block flex-row mx-md-auto mx-0" id="navBanner">
            HOTEL | <%= hotel.getName().toUpperCase()%>
        </div>
    </nav>
    <div id="card1">
        <div class="row rimg">
            <div class="col text-center" >
                <img style="width: 500px" class="active" src="<%= hotel.getHotel_img()%>" alt="">
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div id="star12" class="star12"></div>
                <p class="text-center star12 starText"><%= hotel.getPrice()%> $</p>
                <span id="textid" style="display: none"><%= hotel.getId()%></span>
                <section class="hotelsec">
                    <div class="ozel">
                        <ul class="slot">
                            <li class="slotLi">
                            <i class="fas fa-wifi"></i>
                            <div><span>Ücretsiz Kablosuz İnternet</span></div>
                            </li>

                            <li class="slotLi" style="width: 15%;">
                            <i class="fas fa-utensils"></i>
                            <div><span>Restoran</span></div>
                            </li>
                            <li class="slotLi" style="width: 20%;">
                            <i class="fas fa-smoking-ban"></i>
                            <div><span>Sigara İçilmez</span></div>
                            </li>
                        </ul>
                    </div>
                    <div class="ozel2">
                        <h2>Otelde öne çıkanlar</h2>
                        <div class="oeck">
                            <div style="    float: inline-start;">
                                <h3>Temel imkân ve kolaylıklar</h3>
                                <ul class="FWXvlZ _2WrGNz">
                                    <li><i class="fas fa-check"></i><span>12 sigara içilmeyen otel odası</span></li>
                                    <li><i class="fas fa-check"></i><span>Günlük kat hizmetleri</span></li>
                                    <li><i class="fas fa-check"></i><span>Restoran ve oturma salonu</span></li>
                                    <li><i class="fas fa-check"></i><span>Ücretsiz bölge ulaşım servisi</span></li>
                                    <li><i class="fas fa-check"></i><span>Ofis</span></li>
                                    <li><i class="fas fa-check"></i><span>24 saat açık resepsiyon</span></li>
                                </ul>
                            </div>
                            <div>
                                <h3>Ailelere Yönelik Özellikler</h3>
                                <ul class="FWXvlZ _2WrGNz">
                                    <li><i class="fas fa-check"></i><span>Özel banyo</span></li>
                                    <li><i class="fas fa-check"></i><span>Kaliteli TV kanalları</span></li>
                                    <li><i class="fas fa-check"></i><span>Televizyon</span></li>
                                    <li><i class="fas fa-check"></i><span>Ücretsiz banyo/kozmetik ürünleri</span></li>
                                    <li><i class="fas fa-check"></i><span>Bahçe</span></li>
                                    <li><i class="fas fa-check"></i><span>Günlük kat hizmeti</span></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </section>
                <div class="text-center" style="margin-top: 50px">
                    <p  class="text-danger" id="errortext"></p>
                    <label for="start">Başlangıç Tarihi : </label>
                    <input type="date" id="start" name="start" value="2018-07-22" min="2018-07-21"> 
                    <label for="stop1">Bitiş Tarihi : </label>
                    <input type="date" id="stop1" name="stop1" value="2018-07-22" min="2018-07-21">
                </div>
                <p class="text-center"><a href="#" class="btn boxed-btn2" id="ileri2">İLERİ</a></p>

            </div>
        </div>
    </div>
    <%
    } // hotel
    else if (query.equals("package")) {
        Packages packages = ModulsDatas.query_where_packages(id);
    %>
    <nav class="navbar navbar-toggleable-md navbar-light bg-info">
        <div class="d-md-flex d-block flex-row mx-md-auto mx-0" id="navBanner">
            PAKET
        </div>
    </nav>
    <div id="card1">
        <div class="row">
            <div class="rw-package-left">
                <nav class="navbar navbar-light bg-light">
                    <span class="navbar-brand mb-0 h1 titleP"><%= packages.getTitle().toUpperCase()%></span>
                </nav>
                <div class="text-center" style="background-color: #ff4a52; color: #fff">
                    <span class="wh"><%= packages.getDescription()%></span>
                </div>

                <div class="detailo">
                    <h4>İçerikler :</h4>
                    <ul class="FWXvlZ _2WrGNz">
                        <li style="display: none"><span id="textid"><%= packages.getId()%></span></li>
                        <li class="tth"><i class="fas fa-check"></i><span>Ükle : <%= packages.getCountryName()%></span></li>
                        <li class="tth"><i class="fas fa-check"></i><span>Şehir : <%= packages.getCityName()%></span></li>
                        <li class="tth"><i class="fas fa-check"></i><span>Başlangıç tarihi : <%= packages.getStart_date()%></span></li>
                        <li class="tth"><i class="fas fa-check"></i><span>Bittiş tarihi : <%= packages.getStop_date()%></span></li>
                        <li class="tth"><i class="fas fa-check"></i><span>Otel : <%= packages.getHotelName() + "  -> Geceliği: " + packages.getHotelPrice() + "$  Toplam : " + (packages.getHotelPrice() * packages.getDays()) + " $"%></span></li>
                        <li class="tth"><i class="fas fa-check"></i><span>Otobüs agancet : <%= packages.getAgancetName() + " Giriş-dönüş " + (packages.getBusPrice() * 2) + "$"%></span></li>
                        <li class="tth"><i class="fas fa-check"></i><span id="pText">Toplam Fiyat : <%= (packages.getHotelPrice() * packages.getDays() + packages.getPrice() + packages.getBusPrice() * 2)%> </span>$</li>
                    </ul>
                </div>
            </div>
            <div class="rw-package-right">
                <div class="text-center" >
                    <img style="width: 400px" class="active" src="<%= packages.getHotelImg()%>" alt="">
                </div>
            </div>
            <div class="col">
                <p class="text-center"><a href="#" class="btn boxed-btn2" id="ileri2">İLERİ</a></p>
            </div>
        </div>
    </div>
    <%
        } // package
    %>
    <div class="card" id="card2" style="display: none;">
        <a href="#" id="ileri1" style="width: 50px">
            <svg xmlns="http://www.w3.org/2000/svg" style="margin-left: 25px; margin-bottom: 10px;margin-top: 10px;" width="50" height="50" fill="currentColor" class="bi bi-arrow-left-circle" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"></path>
            </svg>
        </a>

        <div class="row d-flex justify-content-center flex-nowrap">
            <div class="panel shaded" style="display: inline-block; width: 280px;">
                <div class="panel-body">

                    <span id="tutar" style="font-size: 20px; color: #000"></span><br>

                    <span style="font-size: 20px; color: #000">Kart Bilgileri</span>
                    <div class="card-js">
                        <!-- Kart Numarası -->
                        <div class="card-number-wrapper">
                            <input class="card-number" type="tel" placeholder="Kart Numarası" maxlength="19" x-autocompletetype="cc-number" autocompletetype="cc-number" 
                                   autocorrect="off" spellcheck="off" autocapitalize="none" id="cardnum">
                            <div id="shw" class="card-type-icon show master-card"></div>
                            <div class="icon">
                                <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" 
                                     y="3px" width="24px" height="17px" viewBox="0 0 216 146" enable-background="new 0 0 216 146" xml:space="preserve">
                                    <g>
                                        <path class="svg" d="M182.385,14.258c-2.553-2.553-5.621-3.829-9.205-3.829H42.821c-3.585,0-6.653,1.276-9.207,3.829c-2.
                                              553,2.553-3.829,5.621-3.829,9.206v99.071c0,3.585,1.276,6.654,3.829,9.207c2.554,2.553,5.622,3.829,9.207,3.829H173.
                                              18c3.584,0,6.652-1.276,9.205-3.829s3.83-5.622,3.83-9.207V23.464C186.215,19.879,184.938,16.811,182.385,14.258z M175.
                                              785,122.536c0,0.707-0.258,1.317-0.773,1.834c-0.516,0.515-1.127,0.772-1.832,0.772H42.821c-0.706,0-1.317-0.258-1.833-0.
                                              773c-0.516-0.518-0.774-1.127-0.774-1.834V73h135.571V122.536z M175.785,41.713H40.214v-18.25c0-0.706,0.257-1.316,0.774-1.
                                              833c0.516-0.515,1.127-0.773,1.833-0.773H173.18c0.705,0,1.316,0.257,1.832,0.773c0.516,0.517,0.773,1.127,0.773,1.833V41.713z" 
                                              style="fill: rgb(21, 140, 186);"></path>
                                        <rect class="svg" x="50.643" y="104.285" width="20.857" height="10.429" style="fill: rgb(21, 140, 186);"></rect>
                                        <rect class="svg" x="81.929" y="104.285" width="31.286" height="10.429" style="fill: rgb(21, 140, 186);"></rect>
                                    </g></svg>
                            </div>
                        </div>
                        <div class="expiry-container">
                            <div class="expiry-wrapper">
                                <div>
                                    <input id="monthYear" class="expiry" type="tel" placeholder="AA / YY" maxlength="7" x-autocompletetype="cc-exp" autocompletetype="cc-exp" autocorrect="off" 
                                           spellcheck="off" autocapitalize="none">
                                    <input id="month" type="hidden" name="expiry-month">
                                    <input id="year" type="hidden" name="expiry-year">
                                </div>
                                <div class="icon">
                                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="4px" width="24px" height="16px" 
                                         viewBox="0 0 216 146" enable-background="new 0 0 216 146" xml:space="preserve">
                                        <path class="svg" d="M172.691,23.953c-2.062-2.064-4.508-3.096-7.332-3.096h-10.428v-7.822c0-3.584-1.277-6.653-3.83-9.206c-2.554-2.553-5.621-3.83-9.207-3.
                                              83h-5.213c-3.586,0-6.654,1.277-9.207,3.83c-2.554,2.553-3.83,5.622-3.83,9.206v7.822H92.359v-7.822c0-3.584-1.277-6.653-3.83-9.206c-2.553-2.553-5.622-3
                                              .83-9.207-3.83h-5.214c-3.585,0-6.654,1.277-9.207,3.83c-2.553,2.553-3.83,5.622-3.83,9.206v7.822H50.643c-2.825,0-5.269,1.032-7.333,3.096s-3.096,4.509-3
                                              .096,7.333v104.287c0,2.823,1.032,5.267,3.096,7.332c2.064,2.064,4.508,3.096,7.333,3.096h114.714c2.824,0,5.27-1.032,7.332-3.096c2.064-2.064,3.096-4.509
                                              ,3.096-7.332V31.286C175.785,28.461,174.754,26.017,172.691,23.953z M134.073,13.036c0-0.761,0.243-1.386,0.731-1.874c0.488-0.488,1.113-0.733,1.875-0.733
                                              h5.213c0.762,0,1.385,0.244,1.875,0.733c0.488,0.489,0.732,1.114,0.732,1.874V36.5c0,0.761-0.244,1.385-0.732,1.874c-0.49,0.488-1.113,0.733-1.875,0.733h-
                                              5.213c-0.762,0-1.387-0.244-1.875-0.733s-0.731-1.113-0.731-1.874V13.036z M71.501,13.036c0-0.761,0.244-1.386,0.733-1.874c0.489-0.488,1.113-0.733,1.874-
                                              0.733h5.214c0.761,0,1.386,0.244,1.874,0.733c0.488,0.489,0.733,1.114,0.733,1.874V36.5c0,0.761-0.244,1.386-0.733,1.874c-0.489,0.488-1.113,0.733-1.874,0
                                              .733h-5.214c-0.761,0-1.386-0.244-1.874-0.733c-0.488-0.489-0.733-1.113-0.733-1.874V13.036z M165.357,135.572H50.643V52.143h114.714V135.572z" 
                                              style="fill: rgb(21, 140, 186);">
                                        </path>
                                    </svg>
                                </div>
                            </div>
                        </div>
                        <div class="cvc-container">
                            <div class="cvc-wrapper">
                                <input id="cvc" class="cvc" type="tel" placeholder="CVC" maxlength="3" x-autocompletetype="cc-csc" autocompletetype="cc-csc" autocorrect="off" spellcheck="off" 
                                       autocapitalize="none">
                                <div class="icon">
                                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="3px" width="24px" height="17px" 
                                         viewBox="0 0 216 146" enable-background="new 0 0 216 146" xml:space="preserve">
                                        <path class="svg" d="M152.646,70.067c-1.521-1.521-3.367-2.281-5.541-2.281H144.5V52.142c0-9.994-3.585-18.575-10.754-25.745c-7.17-7.17-15.751-10.755-25
                                              .746-10.755s-18.577,3.585-25.746,10.755C75.084,33.567,71.5,42.148,71.5,52.142v15.644h-2.607c-2.172,0-4.019,0.76-5.54,2.281c-1.521,1.52-2.281,3.
                                              367-2.281,5.541v46.929c0,2.172,0.76,4.019,2.281,5.54c1.521,1.52,3.368,2.281,5.54,2.281h78.214c2.174,0,4.02-0.76,5.541-2.281c1.52-1.521,2.281-3.
                                              368,2.281-5.54V75.607C154.93,73.435,154.168,71.588,152.646,70.067z M128.857,67.786H87.143V52.142c0-5.757,2.037-10.673,6.111-14.746c4.074-4.074,
                                              8.989-6.11,14.747-6.11s10.673,2.036,14.746,6.11c4.073,4.073,6.11,8.989,6.11,14.746V67.786z" style="fill: rgb(21, 140, 186);"></path>
                                    </svg>
                                </div>
                            </div>
                        </div>
                    </div>
                    <span class="mt-20 btn btn-block btn-primary" id="odeme">Ödeme Yap</span>
                </div>
            </div>
        </div>
        <p id="errormsj" class="text-danger text-center"></p>
    </div>

    <div class="card" id="card3" style="display: none;">    
        <button id="cd3">Bas</button>

        <div class="row d-flex justify-content-center flex-nowrap">
            <div class="panel shaded" style="display: inline-block; width: 280px;">
                <div class="panel-body">
                    <span style="font-size: 20px; color: #000">Kart Güvenlik kodu</span>
                    <input placeholder="######" name="secode" id="secode" maxlength="6"/>
                    <span style="font-size: 15px; color: #000">Telefonuza kodu gönderdik.</span>
                </div>
                <span class="mt-20 btn btn-block btn-primary" id="gg">Gönder</span>
            </div>
        </div>

        <p id="errormsj2" class="text-danger text-center"></p>


        <div id="driver" class="driver">
            <div class="marvel-device iphone-x">
                <div class="notch">
                    <div class="camera"></div>
                    <div class="speaker"></div>
                </div>
                <div class="top-bar"></div>
                <div class="sleep"></div>
                <div class="bottom-bar"></div>
                <div class="volume"></div>
                <div class="overflow">
                    <div class="shadow shadow--tr"></div>
                    <div class="shadow shadow--tl"></div>
                    <div class="shadow shadow--br"></div>
                    <div class="shadow shadow--bl"></div>
                </div>
                <div class="inner-shadow"></div>
                <div class="screen">
                    <i id="battery" class="gg-battery"></i>
                    <i class="fa fa-wifi" id="wifi" ></i><br>
                    <i class="fa fa-lock" id="lock"></i><br>

                    <div id="digital-clock"> </div>
                    <div id="monthAndDay"> </div>

                    <div id="meesages">
                        <img src="https://imobie-resource.com/en/support/img/how-to-fix-iphone-message-icon-missing-from-the-share-list-issues-1.png">
                        <p id="msj">MESAJ</p>
                        <p id="clock">ŞİMDİ</p>
                        <p id="title">BANK</p>
                        <p id="msjcode"></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%
    }
%>


<!-- The Modal -->
<div id="myModal" class="modal">
    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <p class="text-center">Onaylıyormusunuz?</p>
        <form action="Payment" method="post">
            <input type="hidden" value="null" name="query" id="query"/>
            <input type="hidden" value="null" name="hidis" id="hidis"/>
            <input type="hidden" value="null" name="date_from" id="date_from"/>
            <input type="hidden" value="null" name="date_to" id="date_to"/>
            <button type="submit" style="width: 70px;" class="mt-20 btn btn-block btn-primary">Gönder</button>
        </form>
        <div class="text-center" style="float: left;width: 50%;">
            <span style="width: 70px; " class="mt-20 btn btn-block btn-primary" id="iptal">iPTAL</span>
        </div>
    </div>

</div>

<!-- FOOTER import -->
<%@include file="/page/directives/footerprocess.jsp" %>

<script>
    $(document).ready(function() {

        $('#ileri1').click(function(e) {
            e.preventDefault();
            $('div#card2').toggle('500');
            $('div#card1').toggle('500');
        });
    <%
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("query")) {
                    query = cookie.getValue();
                }
                if (cookie.getName().equals("id")) {
                    id = cookie.getValue();
                }
            }
        }

        if (query.equals("null") || query.equals("Araç_Kiralama")) {
    %>

        $('#ileri2').click(function(e) {
            e.preventDefault();
            var st = document.getElementById("start");
            var stp = document.getElementById("stop");
            var start = new Date(st.value); //$('#start').val().toString().split("-");
            var stop = new Date(stp.value); // $('#stop').val().toString().split("-");
            st.defaultValue = start.getFullYear() + "-" + (start.getMonth() + 1) + "-" + start.getDate();
            stp.defaultValue = stop.getFullYear() + "-" + (stop.getMonth() + 1) + "-" + stop.getDate();
            var day = convertMiliseconds((stop - start), 'd');
            if (day >= 3) {
                var price = document.getElementsByClassName("starText")[0].textContent.split(" ")[0];
                price = parseFloat(price) * day;
                var tutar = $("#tutar");
                tutar.text("Toplam Tutar " + price + " $");
                $('div#card1').toggle('500');
                $('div#card2').toggle('500');
            } else {
                $('#errortext').text("En az 3 günlük kiralana bilir.");
            }
        }); // ileri2
        // MODALS
        var modal = document.getElementById("myModal");
        var span = document.getElementsByClassName("close")[0];
        span.onclick = function() {
            modal.style.display = "none";
        };
        var iptal = document.getElementById("iptal");
        iptal.onclick = function() {
            modal.style.display = "none";
        };
        var btn = $("#gg");
        btn.click(function(e) {
            e.preventDefault();
            var input = $("#secode").val();
            var cd = document.getElementById("msjcode").textContent.split(": ")[1];
            var errormsj2 = $("#errormsj2");
            if (input === cd) {
                errormsj2.text("");
                var query = document.getElementById("query");
                var id = document.getElementById("hidis");
                var date_from = document.getElementById("date_from");
                var date_to = document.getElementById("date_to");
                var textid = document.getElementById("textid").textContent;
                var start = document.getElementById("start").value;
                var stop = document.getElementById("stop").value;
                query.value = "Arac_Kiralama";
                id.value = textid;
                date_from.value = start;
                date_to.value = stop;
                var dri = $("#driver");
                dri.animate({left: "-540px"});
                var modal = document.getElementById("myModal");
                modal.style.display = "block";
            } else {
                errormsj2.text("GÜVENLİK KODUNUZ HATALI.");
            }
        });
    <%
    } else if (query.equals("bus")) {
    %>
        $('#ileri2').click(function(e) {
            e.preventDefault();
            var vr = document.getElementById("ileri2").getAttribute("value");
            if (vr === "1") {// 1 ise gir
                var price = document.getElementById("totalPrice");
                var tutar = $("#tutar");
                tutar.text("Toplam Tutar " + price.textContent);
                $('div#card1').toggle('500');
                $('div#card2').toggle('500');
            }
        });
        // MODALS
        var modal = document.getElementById("myModal");
        var span = document.getElementsByClassName("close")[0];
        span.onclick = function() {
            modal.style.display = "none";
        };
        var iptal = document.getElementById("iptal");
        iptal.onclick = function() {
            modal.style.display = "none";
        };
        var btn = $("#gg");
        btn.click(function(e) {
            e.preventDefault();
            var input = $("#secode").val();
            var cd = document.getElementById("msjcode").textContent.split(": ")[1];
            var errormsj2 = $("#errormsj2");
            /*
             * query = bus
             * id   -> get 
             * from -> get
             * to   -> get
             * seats -> get
             * 
             */
            if (input === cd) {
                errormsj2.text("");
                var query = document.getElementById("query");
                var id = document.getElementById("hidis");
                var date_from = document.getElementById("date_from");
                var date_to = document.getElementById("date_to");
                var getId = $("#busId").text();
                var getFrom = $("#busFrom").text();
                var getTo = $("#busTo").text();
                var json = {"driverId": getId};
                var arr = [];
                var list_seat = document.querySelectorAll(".gird-seat-list");
                for (ch = 0; ch < list_seat.length; ch++) {
                    var child = list_seat[ch];
                    if (child.childElementCount !== 0) {
                        var seat = child.childNodes[1].childNodes[0].textContent;
                        var gender = child.childNodes[1].childNodes[1].textContent;
                        arr.push({"seatId": seat, "gender": gender});
                        //  json["key" + ch] = ;
                    }
                }
                json["seat"] = arr;
                query.value = "Bus";
                id.value = JSON.stringify(json);
                date_from.value = getFrom;
                date_to.value = getTo;
                var dri = $("#driver");
                dri.animate({left: "-540px"});
                var modal = document.getElementById("myModal");
                modal.style.display = "block";
            } else {
                errormsj2.text("GÜVENLİK KODUNUZ HATALI.");
            }
        });
    <%
    } else if (query.equals("hotel")) {
    %>
        $('#ileri2').click(function(e) {
            e.preventDefault();
            var st = document.getElementById("start");
            var stp = document.getElementById("stop1");
            var start = new Date(st.value); //$('#start').val().toString().split("-");
            var stop = new Date(stp.value); // $('#stop').val().toString().split("-");
            st.defaultValue = start.getFullYear() + "-" + (start.getMonth() + 1) + "-" + start.getDate();
            stp.defaultValue = stop.getFullYear() + "-" + (stop.getMonth() + 1) + "-" + stop.getDate();
            var day = convertMiliseconds((stop - start), 'd');
            if (day >= 1) {
                var price = document.getElementsByClassName("starText")[0].textContent.split(" ")[0];
                price = parseFloat(price) * day;
                var tutar = $("#tutar");
                tutar.text("Toplam Tutar " + price + " $");
                $('div#card1').toggle('500');
                $('div#card2').toggle('500');
            } else {
                $('#errortext').text("En az 1 günlük kiralana bilir.");
            }
        }); // ileri2
        // MODALS
        var modal = document.getElementById("myModal");
        var span = document.getElementsByClassName("close")[0];
        span.onclick = function() {
            modal.style.display = "none";
        };
        var iptal = document.getElementById("iptal");
        iptal.onclick = function() {
            modal.style.display = "none";
        };
        var btn = $("#gg");
        btn.click(function(e) {
            e.preventDefault();
            var input = $("#secode").val();
            var cd = document.getElementById("msjcode").textContent.split(": ")[1];
            var errormsj2 = $("#errormsj2");
            if (input === cd) {
                errormsj2.text("");
                var query = document.getElementById("query");
                var id = document.getElementById("hidis");
                var date_from = document.getElementById("date_from");
                var date_to = document.getElementById("date_to");
                var textid = document.getElementById("textid").textContent;
                var start = document.getElementById("start").value;
                var stop = document.getElementById("stop1").value;
                query.value = "Hotel";
                id.value = textid;
                date_from.value = start;
                date_to.value = stop;
                var dri = $("#driver");
                dri.animate({left: "-540px"});
                var modal = document.getElementById("myModal");
                modal.style.display = "block";
            } else {
                errormsj2.text("GÜVENLİK KODUNUZ HATALI.");
            }
        });

    <%
    } else if (query.equals("package")) {
    %>

        $('#ileri2').click(function(e) {
            e.preventDefault();
            var price = document.getElementById("pText").textContent.split(": ")[1];
            var tutar = $("#tutar");
            tutar.text("Toplam Tutar " + price + " $");
            $('div#card1').toggle('500');
            $('div#card2').toggle('500');
            // MODALS
            var modal = document.getElementById("myModal");
            var span = document.getElementsByClassName("close")[0];
            span.onclick = function() {
                modal.style.display = "none";
            };
            var iptal = document.getElementById("iptal");
            iptal.onclick = function() {
                modal.style.display = "none";
            };
            var btn = $("#gg");
            btn.click(function(e) {
                e.preventDefault();
                var input = $("#secode").val();
                var cd = document.getElementById("msjcode").textContent.split(": ")[1];
                var errormsj2 = $("#errormsj2");
                if (input === cd) {
                    errormsj2.text("");
                    var query = document.getElementById("query");
                    var id = document.getElementById("hidis");
                    var textId = document.getElementById("textid").textContent;
                    query.value = "Package";
                    id.value = textId;
                    var dri = $("#driver");
                    dri.animate({left: "-540px"});
                    var modal = document.getElementById("myModal");
                    modal.style.display = "block";
                } else {
                    errormsj2.text("GÜVENLİK KODUNUZ HATALI.");
                }
            });
        });
    <%
        }
    %>

    });
</script>
<script src="./page/resources/javascript/digitalClock.js"></script>

<script src="https://cardjs.co.uk/js/dependencies.min.js"></script>
<script src="./page/resources/javascript/mobildriver.js"></script>
<script src="./page/resources/javascript/bus.js"></script>
</body>
</html>
