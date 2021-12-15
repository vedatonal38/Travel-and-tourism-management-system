<%-- 
    Document   : header
    Created on : 02.Kas.2021, 21:22:22
    Author     : Vedat Onal
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<header>
    <div class="header-area bg-dark">
        <div class="row align-items-center">
            <div class="col"><!-- -xl-2 col-lg-2 -->
                <div class="logo">
                    <a href="../d_Travel/index.jsp">
                        <img src="../d_Travel/page/resources/images/bannerTitle.png" alt="logo"
                             onload="pagespeed.CriticalImages.checkImageForCriticality(this);">
                    </a>
                </div>
            </div>
            <div class="col-xl-7 col-lg-7" style="float: right;">
                <ul id="navigation">
                    <li><a class="active" href="../d_Travel/index.jsp">Anasayfa</a></li>
                    <li><a href="../d_Travel/register.jsp">Kayit ol</a></li>
                    <li><a href="../d_Travel/login.jsp">Oturum aç<i class="ti-angle-down"></i></a></li>
                    <li><a href="../d_Travel/admin.jsp">Admin<i class="ti-angle-down"></i></a></li>
                </ul>
            </div>
            <div class="col-12">
                <div class="mobile_menu d-block d-lg-none" id="mobile_lst">
                </div>
            </div>
        </div>
    </div>
</header>
