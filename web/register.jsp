<%-- 
    Document   : register
    Created on : 03.Kas.2021, 07:25:56
    Author     : Vedat Onal
--%>

<%@page import="com.vedat.modules.Customer"%>
<%@page import="com.vedat.modules.Admin"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/page/directives/metas.jsp" %>
    <title>Register Page</title>
    <%@include file="/page/directives/sources.jsp" %>
    <%@include file="/page/directives/registersources.jsp" %>
</head>
<body>
    <%
        Admin admin = (Admin) session.getAttribute("admin");
        Customer customer = (Customer) session.getAttribute("customer");
        if (admin == null & customer == null) {
    %>
    <!-- HEADER import -->
    <%@include file="/page/directives/header.jsp" %>

    <!-- Register -->
    <div class="container bg-info" style="padding: 35px; width: 500px; margin-top: 30px;">
        <div class="card">
            <div class="col-sm-12 col-sm-offset-12">
                <div class="search-box">
                    <h2 class="text-center text-uppercase">kayıt</h2>
                    <hr>
                </div>
                <form action="Register" method="post" name="submitForm">
                    <!-- Name -->
                    <div class="form-group">
                        <label for="name" class="cols-sm-2 control-label"
                            style="padding-left: 5px; margin-top: 10px;">İsminiz:
                            <span class="text-danger">*</span>
                        </label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <input type="text" class="form-control" name="name" id="name" 
                                    placeholder="İsminiz giriniz" />
                            </div>
                        </div>
                    </div>
                    <!-- Surname -->
                    <div class="form-group">
                        <label for="surname" class="cols-sm-2 control-label" style="padding-left: 5px;">Soyadiniz:
                            <span class="text-danger">*</span>
                        </label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <input type="text" class="form-control" name="surname" id="surname"
                                    placeholder="Soyadınız giriniz" />
                            </div>
                        </div>
                    </div>
                    <!-- Email -->
                    <div class="form-group">
                        <label for="email" class="cols-sm-2 control-label">E-posta adres:
                            <span class="text-danger">*</span>
                        </label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <input type="email" class="form-control" name="email" id="email"
                                    placeholder="E-posta adresiniz giriniz" />
                            </div>
                        </div>
                    </div>
                    <!-- username -->
                    <div class="form-group">
                        <label for="username" class="cols-sm-2 control-label" style="padding-left: 5px;">Kullanıcı
                            adiniz:
                            <span class="text-danger">*</span>
                        </label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <input type="text" class="form-control" name="username" id="username"
                                    placeholder="Kullanıcı adiniz giriniz" required />
                            </div>
                        </div>
                    </div>
                    <!-- password -->
                    <div class="form-group">
                        <label for="password" class="cols-sm-2 control-label">Şifreniz:
                            <span class="text-danger">*</span>
                        </label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <input type="password" class="form-control" name="password" id="password"
                                    placeholder="Parolanızı giriniz" required />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="confirm" class="cols-sm-2 control-label">Şifreniz tekrar giriniz
                            <span class="text-danger">*</span>
                        </label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <input type="password" class="form-control" name="confirm" id="confirm"
                                    placeholder="Parolanızı tekrar giriniz" required />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <p id="msg" class="text-danger"></p>
                        <span class="text-danger">${errorMsg}</span>
                    </div>
                    <div class="form-group">
                        <a href="javascript: validatorFormSubmit()" type="button" id="button"
                            class="btn btn-primary btn-lg btn-block login-button">Register</a>

                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-4">
            <div id="pswd_info">
                <h3>Şifre aşağıdakileri içermelidir:</h3>
                <p id="letter" class="invalid">En az bir <b>küçük</b> harf</p>
                <p id="capital" class="invalid">En az bir <b>büyük</b> harf</p>
                <p id="number" class="invalid">En az bir <b>rakam</b></p>
                <p id="length" class="invalid">Minimum <b>8 karakter</b></p>
            </div>
        </div>
        <div class="col-md-4">
            <div id="pswd_diff">
                <p id="diff" class="invalid">Aynı <b>parolayı</b> giriniz</p>
            </div>
        </div>
        <div class="col-md-4">
            <div id="email_">
                <p id="e_" class="invalid">exmlep<b>@</b>mail.com formatta bir mail yazın.</p>
            </div>
        </div>
    </div>

    <%
        } else {
            response.sendRedirect("index.jsp");
        }
    %>
    <!-- FOOTER import -->
    <%@include file="/page/directives/footer.jsp" %>
</body>
</html>
