<%-- 
    Document   : login
    Created on : 03.Kas.2021, 20:00:03
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
    <%        String username = null, password = null;
        Boolean foundCookie = false;
        Cookie[] cookies1 = request.getCookies();
        for (int c = 0; c < cookies1.length; c++) {
            Cookie cookie = cookies1[c];
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
            }
            if (cookie.getName().equals("password")) {
                password = cookie.getValue();
                foundCookie = true;
            }
        }
    %>
    <!-- Login account -->
    <div class="card" id="form-signin">
        <article class="card-body">
            <h4 class="card-title text-uppercase text-center mb-4 mt-1">Kullanıcı Giriş</h4>
            <hr>
            <p class="text-danger text-center">${errorMsg}</p>
            <form method="post" action="LoginController">
                <!-- start -->
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <% if (!foundCookie) { %>
                        <input id="username" name="username" class="form-control" placeholder="Email or Username"></input>
                        <%
                        } else {
                        %>
                        <input id="username" name="username" class="form-control" value="<%= username%>"></input>
                        <%
                            }
                        %>
                    </div> <!-- input-group.// -->
                </div> <!-- form-group// -->
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-lock"></i></span>
                        </div>
                        <% if (!foundCookie) { %>
                        <input id="paw" name="paw" class="form-control" placeholder="******" type="password"></input>
                        <%
                        } else {
                        %>
                        <input id="paw" name="paw" class="form-control" type="password" value="<%= password%>"></input>
                        <%
                            }
                        %>
                    </div> <!-- input-group.// -->
                </div> <!-- form-group// -->
                <div class="form-group">
                    <div class="input-group">
                        <% if (!foundCookie) { %>
                        <input type="checkbox" name="rememberMe" value="true"> Beni Hatırla </input>
                        <%
                        } else {
                        %>
                        <input type="checkbox" name="rememberMe" value="true" checked> Beni Hatırla </input>
                        <%
                            }
                        %>
                    </div> <!-- input-group.// -->
                </div> <!-- form-group// -->                
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Giriş</button>
                </div> <!-- form-group// -->
                <p class="text-center"><a href="#" class="btn" id="password">Parolanızı mı unuttunuz?</a></p>
                <p class="text-center"><a href="#" class="btn" id="admin">Admin Paneli</a></p>
            </form>
        </article>
    </div> <!-- card.// -->
    <!-- Forgot password -->
    <div class="card" id="form-pass" style="display: none;">
        <article class="card-body">
            <h4 class="card-title text-uppercase text-center mb-4 mt-1">Parolanızı mı unuttunuz?
            </h4>
            <hr>
            <form action="ForgotPass" role="form" id="login-recordar" method="post">
                <fieldset>
                    <span class="help-block">
                        Hesabınıza giriş yapmak için kullandığınız e-posta adresi, 
                        yeni bir şifre seçmek için talimatlara sahip bir e-posta göndereceğiz.
                        <br>
                    </span>
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-lock"></i> @ </span>
                        </div>
                        <input class="form-control" placeholder="Email" name="email" type="email" required="">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block" id="btn-olvidado">
                            Gönder
                        </button>
                    </div>
                    <p class="text-center">
                        <a href="#" id="acceso">Hesap erişimi</a>
                    </p>
                </fieldset>
            </form>
        </article>
    </div>
    <!-- admin from -->
    <div class="card" id="form-admin" style="display: none;">
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
                    <p class="text-center">
                        <a href="#" id="accesoL">Kullanıcı Paneli</a>
                    </p>
            </form>
        </article>
    </div>
</div>


<!-- FOOTER import -->
<%@include file="/page/directives/footer.jsp" %>

<script>
    $(document).ready(function() {
        $('#password').click(function(e) {
            e.preventDefault(); // form-signin
            $('div#form-signin').toggle('500');
            $('div#form-pass').toggle('500');
        });
        $('#acceso').click(function(e) {
            e.preventDefault();
            $('div#form-signin').toggle('500');
            $('div#form-pass').toggle('500');
        });
        $('#admin').click(function(e) {
            e.preventDefault();// form-admin
            $('div#form-signin').toggle('500');
            $('div#form-admin').toggle('500');
        });
        $('#accesoL').click(function(e) {
            e.preventDefault();
            $('div#form-signin').toggle('500');
            $('div#form-admin').toggle('500');
        });
    });
</script>

</body>
</html>
