<%-- 
    Document   : admin
    Created on : 24.Kas.2021, 13:55:59
Author     : Vedat Onal
--%>

<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/page/directives/metas.jsp" %>
    <title>Login Page</title>
    <%@include file="/page/directives/sources.jsp" %>
</head>
<body>
    <!-- HEADER import -->
    <%@include file="/page/directives/header.jsp" %>

<div class="container bg-info" style="padding: 35px; width: 500px">
    <!-- admin from -->
    <div class="card" id="form-admin">
        <article class="card-body">
            <h4 class="card-title text-center mb-4 mt-1">Admin Giriş</h4>
            <hr>
            <p class="text-danger text-center">${errorMsg}</p>
            <form method="post" action="AdminLoginController">
                <input type="hidden" name="status" value="1">
                    <!-- start -->
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                            </div>
                            <input id="adminuser" name="adminuser" class="form-control" placeholder="Admin Username">
                        </div> <!-- input-group.// -->
                    </div> <!-- form-group// -->
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-lock"></i></span>
                            </div>
                            <input id="adminpass" name="adminpass" class="form-control" placeholder="******" type="password">
                        </div> <!-- input-group.// -->
                    </div> <!-- form-group// -->
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">Giriş</button>
                    </div> <!-- form-group// -->
            </form>
        </article>
    </div>

</div>

<!-- FOOTER import -->
<%@include file="/page/directives/footer.jsp" %>


</body>
</html>
