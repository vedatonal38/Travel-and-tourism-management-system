<%-- 
    Document   : settings
    Created on : 13.Kas.2021, 18:10:22
    Author     : Vedat Önal
--%>

<%@page import="com.vedat.modules.Hotels.Hotels"%>
<%@page import="com.vedat.modules.BusDriver.Bus"%>
<%@page import="com.vedat.modules.Vehicle.TypeDescription"%>
<%@page import="com.vedat.modules.Country"%>
<%@page import="com.vedat.modules.City"%>
<%@page import="com.vedat.database.Moduls.ModulsDatas"%>
<%@page import="com.vedat.modules.Vehicle.Vehicles"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vedat.modules.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/page/directives/metas.jsp" %>
        <%        String query_title = request.getParameter("query");
            if (query_title == null || query_title.equals("Araç_Kiralama")) {
        %>
    <title>Araç Kiralama Listesi</title>
    <%
    } else if (query_title.equals("bus")) {
    %>
    <title>Otobüs Listesi</title>
    <%
    } else if (query_title.equals("hotel")) {
    %>
    <title>Hotel listesi</title>
    <%
    } else {
    %>
    <title>Ükle ve Şehir Listesi</title>
    <%
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
<nav class="navbar navbar-toggleable-md navbar-light bg-info">
    <div class="d-md-flex d-block flex-row mx-md-auto mx-0">
        <a style="color: white;" class="nav-item nav-link active" href="../d_Travel/settings.jsp?query=Araç_Kiralama">Araç kiralama <span class="sr-only">(current)</span></a>
        <a style="color: white;" class="nav-item nav-link" href="../d_Travel/settings.jsp?query=bus">Otobus</a>
        <a style="color: white;" class="nav-item nav-link" href="../d_Travel/settings.jsp?query=hotel">Hotel</a>
        <a style="color: white;" class="nav-item nav-link" href="../d_Travel/settings.jsp?query=cc">Ükle ve şehirler</a>
    </div>
</nav>
<div class="container">
    <%
        String query = request.getParameter("query");
        if (query == null || query.equals("Araç_Kiralama")) {
    %>
    <div class="row header" style="text-align:center;">
        <div class="col-12">
            <h3>Araç Kiralama Listesi</h3>
            <p id="msg" class="text-danger"></p>
            <span class="text-danger">${errorMsg}</span>
            <!-- Trigger/Open The Modal -->
            <button id="myBtn" value="cars" class="btn btn-outline-primary btn-sm float-right">EKLE / KALDIR</button>
        </div>
    </div>
    <%
    } else if (query.equals("bus")) {
    %>
    <div class="row header" style="text-align:center;">
        <div class="col-12">
            <h3>Otobüs Listesi</h3><p id="msg" class="text-danger"></p>
            <span class="text-danger">${errorMsg}</span>
            <!-- Trigger/Open The Modal -->
            <button id="myBtn" value="buses" class="btn btn-outline-primary btn-sm float-right">EKLE / KALDIR</button>
        </div>
    </div>
    <%
    } else if (query.equals("hotel")) {
    %>
    <div class="row header" style="text-align:center;">
        <div class="col-12">
            <h3>Hotel Listesi</h3><p id="msg" class="text-danger"></p>
            <span class="text-danger">${errorMsg}</span>
            <!-- Trigger/Open The Modal -->
            <button id="myBtn" value="hotels" class="btn btn-outline-primary btn-sm float-right">EKLE / KALDIR</button>
        </div>
    </div>
    <%
    } else if (query.equals("cc")) {
    %>
    <div class="row header" style="text-align:center;">
        <div class="col-12">
            <h3>Ükle ve şehir Listesi</h3><p id="msg" class="text-danger"></p>
            <span class="text-danger">${errorMsg}</span>
            <!-- Trigger/Open The Modal -->
            <button id="myBtn" value="cc" class="btn btn-outline-primary btn-sm float-right">EKLE / KALDIR</button>
        </div>
    </div>
    <%}
        }
    %>
    <div id="myTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
        <div class="row">
            <div class="col-sm-12">
                <table id="myTable" class="table table-bordered dataTable" aria-describedby="myTable_info" role="grid">
                    <thead>
                        <tr>
                            <%
                                String query = request.getParameter("query");
                                if (query == null || query.equals("Araç_Kiralama")) {
                                    String[] headers = {"ID", "BRAND", "MODELLİ", "BULUNDUĞU YER", "DURUMU"};
                                    for (String ys : headers) {
                                        if (ys.equals("DURUMU")) {
                                            out.print("<th style=\"width: 50px;\">" + ys + "</th>");
                                        } else {
                                            out.print("<th>" + ys + "</th>");
                                        }
                                    }
                                } else if (query.equals("bus")) {
                                    String[] headers = {"ID", "FİRMA", "KALKIŞ", "VARIŞ", "DURUMU", "DETAY"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                } else if (query.equals("hotel")) {
                                    String[] headers = {"ID", "İSİM", "ŞEHİR / ÜKLE", "ADDRES", "DETAY"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                } else if (query.equals("cc")) {
                                    String[] headers = {"ID", "ŞEHİR", "ÜKLE"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                }
                            %>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (query == null || query.equals("Araç_Kiralama")) {
                                ArrayList<Vehicles> vehicles = ModulsDatas.query_select_vehicles();
                                for (Vehicles veh : vehicles) {
                                    out.print("<tr>");
                                    out.print("<td>" + veh.getId() + "</td>");
                                    out.print("<td>" + veh.getBrand() + "</td>");
                                    out.print("<td>" + veh.getModels().getModel_name() + "</td>");
                                    out.print("<td>" + veh.getCity_name() + " / " + veh.getCountry_name() + "</td>");
                                    int st = veh.getStatus();
                                    if (st == 0) {
                                        out.print("<td style=\"color: white; background-color: red;\"> Garajda </td>");
                                    } else {
                                        out.print("<td style=\"color: white; background-color: green;\"> Yolda </td>");
                                    }
                                    out.print("</tr>");
                                }
                            } else if (query.equals("bus")) {
                                ArrayList<Bus> buses = ModulsDatas.query_select_buses();
                                for (Bus bus : buses) {
                                    out.print("<tr>");
                                    out.print("<td>" + bus.getId() + "</td>");
                                    out.print("<td>" + bus.getAgancet_name() + "</td>");
                                    out.print("<td>" + bus.getFrom_city_name() + " / " + bus.getFrom_country_name() + "</td>");
                                    out.print("<td>" + bus.getTo_city_name() + " / " + bus.getTo_country_name() + "</td>");
                                    out.print("<td>null</td>");
                                    out.print("<td>null</td>");
                                    out.print("</tr>");
                                }

                            } else if (query.equals("hotel")) {
                                ArrayList<Hotels> hotelses = ModulsDatas.query_select_hotel();
                                for (Hotels hotels : hotelses) {
                                    out.print("<tr>");
                                    out.print("<td>" + hotels.getId() + "</td>");
                                    out.print("<td>" + hotels.getName() + "</td>");
                                    out.print("<td>" + hotels.getCity_name() + " / " + hotels.getCountry_name() + "</td>");
                                    out.print("<td>" + hotels.getAddres() + "</td>");
                                    out.print("<td>null</td>");
                                    out.print("</tr>");
                                }

                            } else if (query.equals("cc")) {
                                ArrayList<City> citys = ModulsDatas.query_select_city();
                                for (City cc : citys) {
                                    out.print("<tr>");
                                    out.print("<td>" + cc.getId() + "</td>");
                                    out.print("<td>" + cc.getName() + "</td>");
                                    out.print("<td>" + cc.getCountry_name() + "</td>");
                                    out.print("</tr>");
                                }

                            }
                        %>
                    </tbody>
                    <tfoot>
                        <tr>
                            <%
                                if (query == null || query.equals("Araç_Kiralama")) {
                                    String[] headers = {"ID", "BRAND", "MODELLİ", "BULUNDUĞU YER", "DURUMU"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                } else if (query.equals("bus")) {
                                    String[] headers = {"ID", "FİRMA", "KALKIŞ", "VARIŞ", "DURUMU", "DETAY"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                } else if (query.equals("hotel")) {
                                    String[] headers = {"ID", "İSİM", "ŞEHİR / ÜKLE", "ADDRES", "DETAY"};
                                    for (String ys : headers) {
                                        out.print("<th>" + ys + "</th>");
                                    }
                                } else if (query.equals("cc")) {
                                    String[] headers = {"ID", "ŞEHİR", "ÜKLE"};
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


<!-- The Modal -->
<div id="myModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <div class="row header" style="text-align:center; margin-top: -30px">
            <div class="col-12">
                <p id="pp"></p>
            </div></div>
            <%
                if (query == null || query.equals("Araç_Kiralama")) {
            %>
        <div id="j1" class="" style="display: none">
            <button name="submit" class="action_btn btn btn-success" id="adds">EKLEME</button>
            <button name="submit" class="action_btn btn btn-danger" id="dels">KALDIRMA</button>
            <div class="" id="dips1" style="margin: 20px auto">
                <form method="post" action="Controller">
                    <input type="hidden" id="object" name="object" value="cars&add">
                    <div class="settingBox rin rin101">
                        <div class="form-group">
                            <label for="brand" class="cols-sm-2 control-label"
                                   style="padding-left: 5px; margin-top: 10px;">Marka
                            </label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="brand" id="brand" 
                                           placeholder="Marka giriniz" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="engine_size" class="cols-sm-2 control-label"
                                   style="padding-left: 5px; margin-top: 10px;">Araçın Hacmi (cc türünden)
                            </label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="engine_size" id="engine_size" 
                                           placeholder="Araçın Hacmi (CC) giriniz" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="date_mot_due" class="cols-sm-2 control-label"
                                   style="padding-left: 5px; margin-top: 10px;">Araçın Modelli (YIL türünden)
                            </label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <select name="date_mot_due" id="date_mot_due" class="form-select form-select-sm" aria-label=".form-select-sm example">
                                        <%
                                            for (int date = 1990; date < 2022; date++) {
                                                out.print("<option value=\'" + date + "\'>" + date + "</option>");
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="model_name" class="cols-sm-2 control-label"
                                   style="padding-left: 5px; margin-top: 10px;">Araçın modelin adı
                            </label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="model_name" id="model_name" 
                                           placeholder="Araçın modelin adı giriniz" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="type_description" class="cols-sm-2 control-label"
                                   style="padding-left: 5px; margin-top: 10px;">Araçın Tip Açıklama
                            </label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <select name="type_description" id="type_description" class="form-select form-select-sm" aria-label=".form-select-sm example">
                                        <option value="-1" selected="selected">---</option>
                                        <%
                                            ArrayList<TypeDescription> tds = ModulsDatas.query_select_type_description();
                                            for (TypeDescription td : tds) {
                                                out.print("<option value=\"" + td.getId() + "\">" + td.getType_description() + "</option>");
                                            }
                                        %>
                                    </select>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- -->
                    <div class="settingBox rin101">
                        <div class="form-group">
                            <label for="price" class="cols-sm-2 control-label"
                                   style="padding-left: 5px; margin-top: 10px;">Fiyat
                            </label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="price" id="price" 
                                           placeholder="Fiyat giriniz" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="current_mileage" class="cols-sm-2 control-label"
                                   style="padding-left: 5px; margin-top: 10px;">Araç kaç kilometrede
                            </label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="current_mileage" id="current_mileage" 
                                           placeholder="Kilometre giriniz" />
                                </div>
                            </div>
                        </div>
                        <form>
                            <div class="form-group">
                                <label for="country" class="cols-sm-2 control-label"
                                       style="padding-left: 5px; margin-top: 10px;">Bulunduğu ükle
                                </label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <select name="country" id="country" class="form-select form-select-sm" aria-label=".form-select-sm example">
                                            <option value="-1" selected="selected">---</option>
                                            <%
                                                ArrayList<Country> countrys = ModulsDatas.query_select_country();

                                                for (Country c : countrys) {
                                                    out.print("<option value=\"" + c.getId() + "\">" + c.getName() + "</option>");
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="city" class="cols-sm-2 control-label"
                                       style="padding-left: 5px; margin-top: 10px;">Bulunduğu şehir
                                </label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <select name="city" id="city" class="form-select form-select-sm" aria-label=".form-select-sm example">
                                            <option value="-1" selected>---</option>

                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="daily_hire_rate" class="cols-sm-2 control-label"
                                       style="padding-left: 5px; margin-top: 10px;">Günlük kiralama oranı
                                </label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <input type="number" min="10" max="100" step="2" value="50" class="form-control" name="daily_hire_rate" id="daily_hire_rate" 
                                               placeholder="Günlük kiralama oranı giriniz" />
                                    </div>
                                </div>
                            </div>

                    </div> 
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">Ekle</button>
                    </div> 
                </form>
            </div>
            <div id="dips2" style="display: none">
                <div class="container" style=" ">
                    <div class="card">
                        <div class="card-body">
                            <form method="post" action="Controller">
                                <input type="hidden" id="object" name="object" value="cars&del">

                                <div class="form-group">
                                    <label for="delete_id" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Silmek istediniz araçın ID sın
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <input type="number" min="0" class="form-control" name="delete_id" id="delete_id" 
                                                   placeholder="Araçın ID giriniz" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">Kaldır / Sil</button>
                                </div> 
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
        } else if (query.equals("bus")) {
        %>
        <div id="j2" class="" style="display: none">
            <button name="submit" class="action_btn btn btn-success" id="adds">EKLEME</button>
            <button name="submit" class="action_btn btn btn-danger" id="dels">KALDIRMA</button>
            <div class="" id="dips1" style="margin: 20px auto">
                <div class="container" style="margin-top: -10px ">
                    <div class="card">
                        <div class="card-body">
                            <form method="post" action="Controller">
                                <input type="hidden" id="object" name="object" value="bus&add">

                                <div class="form-group">
                                    <label for="agancet_name" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Firma isimi 
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="agancet_name" id="agancet_name" 
                                                   placeholder="Firma ismi giriniz" />
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group" style="width: 50%; float: left">
                                    <label for="from_country" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Kalkış ükle
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <select name="from_country" id="from_country" class="form-select form-select-sm" aria-label=".form-select-sm example">
                                                <option value="-1" selected="selected">---</option>
                                                <%
                                                    ArrayList<Country> countrys = ModulsDatas.query_select_country();

                                                    for (Country c : countrys) {
                                                        out.print("<option value=\"" + c.getId() + "\">" + c.getName() + "</option>");
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group" style="width: 50%; float: left">
                                    <label for="from_city" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Kalkış şehir
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <select name="from_city" id="from_city" class="form-select form-select-sm" aria-label=".form-select-sm example">
                                                <option value="-1" selected>---</option>

                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <!-- TO -->
                                <div class="form-group" style="width: 50%; float: left">
                                    <label for="to_country" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Varış ükle
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <select name="to_country" id="to_country" class="form-select form-select-sm" aria-label=".form-select-sm example">
                                                <option value="-1" selected="selected">---</option>
                                                <%
//                                                    ArrayList<Country> countrys1 = ModulsDatas.query_select_country();
                                                    for (Country c : countrys) {
                                                        out.print("<option value=\"" + c.getId() + "\">" + c.getName() + "</option>");
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group" style="width: 50%; float: left">
                                    <label for="to_city" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Varış şehir
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <select name="to_city" id="to_city" class="form-select form-select-sm" aria-label=".form-select-sm example">
                                                <option value="-1" selected>---</option>

                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="price" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Fiyat
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="price" id="price" 
                                                   placeholder="Fiyat giriniz" />
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">Ekle</button>
                                </div> 
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div id="dips2" style="display: none">
                <div class="container">
                    <div class="card">
                        <div class="card-body">
                            <form method="post" action="Controller">
                                <input type="hidden" id="object" name="object" value="bus&del">

                                <div class="form-group">
                                    <label for="delete_id" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Silmek istediniz otobüs ID sın
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <input type="number" min="0" class="form-control" name="delete_id" id="delete_id" 
                                                   placeholder="Araçın ID giriniz" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">Kaldır / Sil</button>
                                </div> 
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
        } else if (query.equals("hotel")) {
        %>
        <div id="j3" class="" style="display: none">
            <button name="submit" class="action_btn btn btn-success" id="adds">EKLEME</button>
            <button name="submit" class="action_btn btn btn-danger" id="dels">KALDIRMA</button>
            <div class="" id="dips1" style="margin: 20px auto">
                <div class="container" style="margin-top: -10px ">
                    <div class="card">
                        <div class="card-body">
                            <form method="post" action="Controller">
                                <input type="hidden" id="object" name="object" value="hotel&add">

                                <div class="form-group">
                                    <label for="hotel_name" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Otel isimi 
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="hotel_name" id="hotel_name" 
                                                   placeholder="Otel ismi giriniz" />
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group" style="width: 50%; float: left">
                                    <label for="hotel_country" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Otelin bulunduğu ükle
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <select name="hotel_country" id="hotel_country" class="form-select form-select-sm" aria-label=".form-select-sm example">
                                                <option value="-1" selected="selected">---</option>
                                                <%
                                                    ArrayList<Country> countrys = ModulsDatas.query_select_country();

                                                    for (Country c : countrys) {
                                                        out.print("<option value=\"" + c.getId() + "\">" + c.getName() + "</option>");
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group" style="width: 50%; float: left">
                                    <label for="hotel_city" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Otelin bulunduğu şehir
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <select name="hotel_city" id="hotel_city" class="form-select form-select-sm" aria-label=".form-select-sm example">
                                                <option value="-1" selected>---</option>

                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="price" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Fiyat
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="price" id="price" 
                                                   placeholder="Fiyat giriniz" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="hotel_address" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Otel adresi 
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="hotel_address" id="hotel_address" 
                                                   placeholder="Otel adresi giriniz" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">Ekle</button>
                                </div> 
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div id="dips2" style="display: none">
                <div class="container">
                    <div class="card">
                        <div class="card-body">
                            <form method="post" action="Controller">
                                <input type="hidden" id="object" name="object" value="hotel&del">

                                <div class="form-group">
                                    <label for="delete_id" class="cols-sm-2 control-label"
                                           style="padding-left: 5px; margin-top: 10px;">Silmek istediniz otelin ID sın
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <input type="number" min="0" class="form-control" name="delete_id" id="delete_id" 
                                                   placeholder="Otelin ID giriniz" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">Kaldır / Sil</button>
                                </div> 
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
        } else if (query.equals("cc")) {
        %>
        <div id="j4" class="" style="display: none">4</div>
        <%
            }
        %>
    </div>

</div>

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
                    "previous": "Geri"},
                "aria": {
                    "sortAscending": ": activate to sort column ascending",
                    "sortDescending": ": activate to sort column descending"
                }
            }
        });
    });
</script>

<script src="../d_Travel/page/resources/javascript/settings.js"></script>

</body>
</html>
