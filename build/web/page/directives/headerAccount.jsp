<%-- 
    Document   : headerAccount
    Created on : 07.Kas.2021, 13:40:45
    Author     : Vedat Onal
--%>
<%@page import="com.vedat.modules.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<header>
    <div class="header-area bg-dark">
        <div class="row align-items-center">
            <div class="col" ><!-- -xl-2 col-lg-2 -->
                <div class="logo">
                    <a href="../d_Travel/index.jsp">
                        <img src="../d_Travel/page/resources/images/bannerTitle.png" alt="logo"
                             onload="pagespeed.CriticalImages.checkImageForCriticality(this);">
                    </a>
                </div>
            </div>
            <div class="col-xl-5 col-lg-5">
                <ul id="navigation">
                    <li><a class="active" href="../d_Travel/index.jsp">Anasayfa</a></li>
                </ul>
            </div>
            <div class="col">
                <div class="acc">
                    <a href="#">
                        <img src="../d_Travel/page/resources/images/account.jpg" alt="logo" width="35" height="35">
                        <p class="lo"><%
                            out.print(customer.getName().toUpperCase() + " " + customer.getSurname().toUpperCase());
                            %></p>
                    </a>
                    <ul><!-- <a href="#">Exit</a> -->
                        <li>
                            <form action="Logout" method="post" id="my">
                                <a href="javascript:{}" onclick="document.getElementById('my').submit();">Exit</a>
                            </form>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-12">
                <div class="mobile_menu d-block d-lg-none" id="mobile_lst">
                </div>
            </div>
        </div>
    </div>
</header>