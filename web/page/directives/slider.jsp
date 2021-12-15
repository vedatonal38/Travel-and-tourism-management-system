<%-- 
    Document   : slider
    Created on : 19.Kas.2021, 11:12:13
    Author     : Vedat Onal
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <!-- SL?DER -->
<div id="slider">
    <div id="arrow-left" class="arrow"></div>
    <div class="slide slide1">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-xl-12 col-md-12">
                    <div class="slider_text text-center">
                        <h3>Isviçre</h3>
                        <p>Mükemmel tatil firsat</p>
                        <a href="control.jsp?query=package&id=1" class="boxed-btn3">Paket al</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="slide slide2">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-xl-12 col-md-12">
                    <div class="slider_text text-center">
                        <h3>Endonezya</h3>
                        <p>Mükemmel tatil firsat</p>
                        <a href="control.jsp?query=package&id=2" class="boxed-btn3">Paket al</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="slide slide3">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-xl-12 col-md-12">
                    <div class="slider_text text-center">
                        <h3>Avustralya</h3>
                        <p>Mükemmel tatil firsat</p>
                        <a href="control.jsp?query=package&id=3" class="boxed-btn3">Paket al</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="arrow-right" class="arrow"></div>
</div>
<!-- slider end -->

<nav id="container" class="navbar navbar-expand-lg navbar-light bg-dark">
    <div class="d-md-flex d-block flex-row mx-md-auto mx-0">
        <a style="color: white;" class="nav-item nav-link active" href="../d_Travel/index.jsp?query=Araç_Kiralama#container">Araç kiralama <span class="sr-only">(current)</span></a>
        <a style="color: white;" class="nav-item nav-link" href="../d_Travel/index.jsp?query=bus#container">Otobus</a>
        <a style="color: white;" class="nav-item nav-link" href="../d_Travel/index.jsp?query=hotel#container">Hotel</a>
    </div>
</nav>