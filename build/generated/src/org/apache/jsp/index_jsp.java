package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.vedat.modules.Packages.Packages;
import com.vedat.modules.Hotels.Hotels;
import java.util.Base64;
import java.net.URLDecoder;
import com.vedat.modules.BusDriver.Bus;
import com.vedat.database.Moduls.ModulsDatas;
import com.vedat.modules.Vehicle.Vehicles;
import java.util.ArrayList;
import com.vedat.modules.Admin;
import com.vedat.modules.Customer;
import com.vedat.modules.Customer;
import com.vedat.modules.Admin;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(7);
    _jspx_dependants.add("/page/directives/metas.jsp");
    _jspx_dependants.add("/page/directives/sources.jsp");
    _jspx_dependants.add("/page/directives/header.jsp");
    _jspx_dependants.add("/page/directives/headerAccount.jsp");
    _jspx_dependants.add("/page/directives/headerAdmin.jsp");
    _jspx_dependants.add("/page/directives/slider.jsp");
    _jspx_dependants.add("/page/directives/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("    <title>Ana Sayfa</title>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../d_Travel/page/resources/stylesheet/indexSytle.css\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/SlickNav/1.0.10/slicknav.min.css\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\r\n");
      out.write("      integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"\r\n");
      out.write("        integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\" integrity=\"sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p\" crossorigin=\"anonymous\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"page/resources/stylesheet/indexTravol.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"page/resources/stylesheet/modalstyle.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- HEADER import -->\r\n");
      out.write("    ");

    Customer customer = (Customer) session.getAttribute("customer");
    Admin admin_ = (Admin) session.getAttribute("admin");
    if (customer == null & admin_ == null) {
    
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("    <div class=\"header-area bg-dark\">\r\n");
      out.write("        <div class=\"row align-items-center\">\r\n");
      out.write("            <div class=\"col\"><!-- -xl-2 col-lg-2 -->\r\n");
      out.write("                <div class=\"logo\">\r\n");
      out.write("                    <a href=\"../d_Travel/index.jsp\">\r\n");
      out.write("                        <img src=\"../d_Travel/page/resources/images/bannerTitle.png\" alt=\"logo\"\r\n");
      out.write("                             onload=\"pagespeed.CriticalImages.checkImageForCriticality(this);\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-xl-7 col-lg-7\" style=\"float: right;\">\r\n");
      out.write("                <ul id=\"navigation\">\r\n");
      out.write("                    <li><a class=\"active\" href=\"../d_Travel/index.jsp\">Anasayfa</a></li>\r\n");
      out.write("                    <li><a href=\"../d_Travel/register.jsp\">Kayit ol</a></li>\r\n");
      out.write("                    <li><a href=\"../d_Travel/login.jsp\">Oturum aç<i class=\"ti-angle-down\"></i></a></li>\r\n");
      out.write("                    <li><a href=\"../d_Travel/admin.jsp\">Admin<i class=\"ti-angle-down\"></i></a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-12\">\r\n");
      out.write("                <div class=\"mobile_menu d-block d-lg-none\" id=\"mobile_lst\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("    ");

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
    
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<header>\r\n");
      out.write("    <div class=\"header-area bg-dark\">\r\n");
      out.write("        <div class=\"row align-items-center\">\r\n");
      out.write("            <div class=\"col\" ><!-- -xl-2 col-lg-2 -->\r\n");
      out.write("                <div class=\"logo\">\r\n");
      out.write("                    <a href=\"../d_Travel/index.jsp\">\r\n");
      out.write("                        <img src=\"../d_Travel/page/resources/images/bannerTitle.png\" alt=\"logo\"\r\n");
      out.write("                             onload=\"pagespeed.CriticalImages.checkImageForCriticality(this);\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-xl-5 col-lg-5\">\r\n");
      out.write("                <ul id=\"navigation\">\r\n");
      out.write("                    <li><a class=\"active\" href=\"../d_Travel/index.jsp\">Anasayfa</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col\">\r\n");
      out.write("                <div class=\"acc\">\r\n");
      out.write("                    <a href=\"#\">\r\n");
      out.write("                        <img src=\"../d_Travel/page/resources/images/account.jpg\" alt=\"logo\" width=\"35\" height=\"35\">\r\n");
      out.write("                        <p class=\"lo\">");

                            out.print(customer.getName().toUpperCase() + " " + customer.getSurname().toUpperCase());
                            
      out.write("</p>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul><!-- <a href=\"#\">Exit</a> -->\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <form action=\"Logout\" method=\"post\" id=\"my\">\r\n");
      out.write("                                <a href=\"javascript:{}\" onclick=\"document.getElementById('my').submit();\">Exit</a>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-12\">\r\n");
      out.write("                <div class=\"mobile_menu d-block d-lg-none\" id=\"mobile_lst\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("    ");

    } else if (customer == null & admin_ != null) {
    
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<header>\r\n");
      out.write("    <div class=\"header-area bg-dark\">\r\n");
      out.write("        <div class=\"row align-items-center\">\r\n");
      out.write("            <div class=\"col\" ><!-- -xl-2 col-lg-2 -->\r\n");
      out.write("                <div class=\"logo\">\r\n");
      out.write("                    <a href=\"../d_Travel/index.jsp\">\r\n");
      out.write("                        <img src=\"../d_Travel/page/resources/images/bannerTitle.png\" alt=\"logo\"\r\n");
      out.write("                             onload=\"pagespeed.CriticalImages.checkImageForCriticality(this);\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-xl-5 col-lg-5\">\r\n");
      out.write("                <ul id=\"navigation\">\r\n");
      out.write("                    <li><a class=\"active\" href=\"../d_Travel/index.jsp\">Anasayfa</a></li>\r\n");
      out.write("                    <li><a class=\"\" href=\"../d_Travel/customers.jsp\">Kullanıcılar</a></li>\r\n");
      out.write("                    <li><a class=\"\" href=\"../d_Travel/settings.jsp\">Ayarlar</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col\">\r\n");
      out.write("                <div class=\"acc\">\r\n");
      out.write("                    <a href=\"#\">\r\n");
      out.write("                        <img src=\"../d_Travel/page/resources/images/account.jpg\" alt=\"logo\" width=\"35\" height=\"35\">\r\n");
      out.write("                        <p class=\"lo\">");

                            out.print(admin_.getFullname().toUpperCase());
                        
      out.write("</p>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul><!-- <a href=\"#\">Exit</a> -->\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <form action=\"Logout\" method=\"post\" id=\"my\">\r\n");
      out.write("                                <a href=\"javascript:{}\" onclick=\"document.getElementById('my').submit();\">Exit</a>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-12\">\r\n");
      out.write("                <div class=\"mobile_menu d-block d-lg-none\" id=\"mobile_lst\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("    ");

    }
    
      out.write("\r\n");
      out.write("    <!-- SLİDER import -->\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("    <!-- SL?DER -->\r\n");
      out.write("<div id=\"slider\">\r\n");
      out.write("    <div id=\"arrow-left\" class=\"arrow\"></div>\r\n");
      out.write("    <div class=\"slide slide1\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row align-items-center\">\r\n");
      out.write("                <div class=\"col-xl-12 col-md-12\">\r\n");
      out.write("                    <div class=\"slider_text text-center\">\r\n");
      out.write("                        <h3>Isviçre</h3>\r\n");
      out.write("                        <p>Mükemmel tatil firsat</p>\r\n");
      out.write("                        <a href=\"control.jsp?query=package&id=1\" class=\"boxed-btn3\">Paket al</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"slide slide2\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row align-items-center\">\r\n");
      out.write("                <div class=\"col-xl-12 col-md-12\">\r\n");
      out.write("                    <div class=\"slider_text text-center\">\r\n");
      out.write("                        <h3>Endonezya</h3>\r\n");
      out.write("                        <p>Mükemmel tatil firsat</p>\r\n");
      out.write("                        <a href=\"control.jsp?query=package&id=2\" class=\"boxed-btn3\">Paket al</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"slide slide3\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row align-items-center\">\r\n");
      out.write("                <div class=\"col-xl-12 col-md-12\">\r\n");
      out.write("                    <div class=\"slider_text text-center\">\r\n");
      out.write("                        <h3>Avustralya</h3>\r\n");
      out.write("                        <p>Mükemmel tatil firsat</p>\r\n");
      out.write("                        <a href=\"control.jsp?query=package&id=3\" class=\"boxed-btn3\">Paket al</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"arrow-right\" class=\"arrow\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- slider end -->\r\n");
      out.write("\r\n");
      out.write("<nav id=\"container\" class=\"navbar navbar-expand-lg navbar-light bg-dark\">\r\n");
      out.write("    <div class=\"d-md-flex d-block flex-row mx-md-auto mx-0\">\r\n");
      out.write("        <a style=\"color: white;\" class=\"nav-item nav-link active\" href=\"../d_Travel/index.jsp?query=Araç_Kiralama#container\">Araç kiralama <span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("        <a style=\"color: white;\" class=\"nav-item nav-link\" href=\"../d_Travel/index.jsp?query=bus#container\">Otobus</a>\r\n");
      out.write("        <a style=\"color: white;\" class=\"nav-item nav-link\" href=\"../d_Travel/index.jsp?query=hotel#container\">Hotel</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    ");

        String query = request.getParameter("query");
        if (query == null || query.equals("Araç_Kiralama")) {
            ArrayList<Vehicles> vehicles = ModulsDatas.query_select_vehicles();
            for (Vehicles veh : vehicles) {
                if (veh.getStatus() == 0) {
    
      out.write("\r\n");
      out.write("    <div class=\"row rw\">\r\n");
      out.write("        <!-- Left Column \r\n");
      out.write("        ../d_Travel/page/resources/images/car.jpg\r\n");
      out.write("        -->\r\n");
      out.write("        <div class=\"left-column\" >\r\n");
      out.write("            <img data-image=\"red\" class=\"active\" src=\"");
      out.print( veh.getCar_img());
      out.write("\" alt=\"\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Right Column -->\r\n");
      out.write("        <div class=\"right-column\">\r\n");
      out.write("            <h3>");
      out.print( veh.getPrice());
      out.write(" $ </h3>\r\n");
      out.write("            <ul class=\"rwul\" style=\"float: left\">\r\n");
      out.write("                <li class=\"rwli\">\r\n");
      out.write("                    <strong class=\"rwstrong\">İLAN</strong>\r\n");
      out.write("                    <span class=\"rwspan\">");
      out.print(veh.getId());
      out.write("</span>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"rwli\">\r\n");
      out.write("                    <strong class=\"rwstrong\">YIL</strong>\r\n");
      out.write("                    <span class=\"rwspan\">");
      out.print( veh.getDate_mot_due());
      out.write("</span>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"rwli\">\r\n");
      out.write("                    <strong class=\"rwstrong\">M. hacim</strong>\r\n");
      out.write("                    <span class=\"rwspan\">");
      out.print( veh.getEngine_size());
      out.write(" CC</span>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"rwli\">\r\n");
      out.write("                    <strong class=\"rwstrong\">Model isim</strong>\r\n");
      out.write("                    <span class=\"rwspan\">");
      out.print( veh.getModels().getModel_name());
      out.write("</span>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <ul class=\"rwul\" style=\"float: left\">\r\n");
      out.write("                <li class=\"rwli\"><!-- veh.getModels().getDaily_hire_rate() -->\r\n");
      out.write("                    <strong class=\"rwstrong\">G. kiralama oranı</strong>\r\n");
      out.write("                    <span class=\"rwspan\">");
      out.print( veh.getModels().getDaily_hire_rate());
      out.write("%</span>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"rwli\">\r\n");
      out.write("                    <strong class=\"rwstrong\">Şehir / Ükle</strong>\r\n");
      out.write("                    <span class=\"rwspan\">");
      out.print( veh.getCity_name() + " / " + veh.getCountry_name());
      out.write("</span>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"rwli\">\r\n");
      out.write("                    <strong class=\"rwstrong\">Markası </strong>\r\n");
      out.write("                    <span class=\"rwspan\">");
      out.print( veh.getBrand());
      out.write("</span>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <!--\r\n");
      out.write("        <button style=\"float: right\" >Kirala</button>\r\n");
      out.write("            -->\r\n");
      out.write("            <a style=\"float: right\" href=\"./control.jsp?query=");
      out.print( query );
      out.write("&id=");
      out.print( veh.getId() );
      out.write("\" class=\"boxed-btn2\">Kirala</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
          } // end if          
        }// end for 
    } else if (query.equals("bus")) {
        ArrayList<Bus> buses = ModulsDatas.query_select_buses();
        for (Bus bus : buses) {
    
      out.write("\r\n");
      out.write("    <div class=\"row rwBus\">\r\n");
      out.write("        <div class=\"busListItem\">\r\n");
      out.write("            <div class=\"busListInner\">\r\n");
      out.write("                <div class=\"topDetail\">\r\n");
      out.write("                    <div class=\"rowOne\">\r\n");
      out.write("                        <div class=\"colOne\">\r\n");
      out.write("                            <div id=\"imgadd\" class=\"logobus\">\r\n");
      out.write("                                <div style=\"\" class=\"canvasTXT\">");
      out.print( bus.getAgancet_name());
      out.write("</div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"colTwo\">\r\n");
      out.write("                            <div class=\"time\">\r\n");
      out.write("                                <h3>");
      out.print( bus.getDateFrom() + " / " + bus.getTimeFrom());
      out.write("</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"duration\">\r\n");
      out.write("                                <h5><span class=\"icon-sure\"></span>\r\n");
      out.write("                                    ");
      out.print( bus.getDifferenceDate());
      out.write("\r\n");
      out.write("                                </h5>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"colThree\">\r\n");
      out.write("                            <div class=\"firstRow\">\r\n");
      out.write("                                <div class=\"slotOne\">\r\n");
      out.write("                                    <b>");
      out.print( bus.getFrom_city_name().toUpperCase() + " " + bus.getFrom_country_name().toUpperCase() + " > " + bus.getTo_city_name().toUpperCase() + " " + bus.getTo_country_name().toUpperCase());
      out.write("</b>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"slotTwo\">\r\n");
      out.write("                                    <div class=\"arrangement\">\r\n");
      out.write("                                        <div class=\"seat\">\r\n");
      out.write("                                            2+1\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"feature\">\r\n");
      out.write("                                            <i class=\"fas fa-wifi\"></i>\r\n");
      out.write("                                            <i class=\"fas fa-tv\"></i>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"slotThree\">\r\n");
      out.write("                                    <div class=\"seatPrice\">\r\n");
      out.write("                                        <h3>");
      out.print( bus.getPrice());
      out.write("<span> $</span></h3>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"colFour\">\r\n");
      out.write("                            <a style=\"float: right\" href=\"./control.jsp?query=");
      out.print( query);
      out.write("&id=");
      out.print( bus.getId());
      out.write("&from=");
      out.print( bus.getDateFrom() + "/" + bus.getTimeFrom());
      out.write("&to=");
      out.print( bus.getDateTo() + "/" + bus.getTimeTo());
      out.write("\" class=\"boxed-btn2\">Satın Al</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    ");

        }
        // bus else if 
    } else if (query.equals("hotel")) {
        ArrayList<Hotels> hotelses = ModulsDatas.query_select_hotel();
        for (Hotels hotels : hotelses) {
    
      out.write("\r\n");
      out.write("    <div class=\"row rw-hotel\">\r\n");
      out.write("        <!-- Left Column -->\r\n");
      out.write("        <div class=\"left-column-hotel\" >\r\n");
      out.write("            <img data-image=\"red\" class=\"active\" src=\"");
      out.print( hotels.getHotel_img());
      out.write("\" alt=\"\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Right Column -->\r\n");
      out.write("        <div class=\"right-column-hotel\">\r\n");
      out.write("            <div class=\"inside-left\">\r\n");
      out.write("                <section class=\"slc\">\r\n");
      out.write("                    <div class=\"title\">\r\n");
      out.write("                        <h2 class=\"h2title\">");
      out.print( hotels.getName());
      out.write("</h2>\r\n");
      out.write("                        <div class=\"dvtitle\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <p class=\"adres\">");
      out.print( hotels.getCountry_name() + " / " + hotels.getCity_name() + " Adres : " + hotels.getAddres());
      out.write("</p>\r\n");
      out.write("                </section>\r\n");
      out.write("                <section class=\"slc1\">\r\n");
      out.write("                    <p class=\"detailtitle\">Detay</p>\r\n");
      out.write("                    <ul class=\"ulff\">\r\n");
      out.write("                        <li class=\"li\">A1</li>\r\n");
      out.write("                        <li class=\"li\">A2</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </section>\r\n");
      out.write("                <section class=\"slc2\">\r\n");
      out.write("                    <span class=\"status\">10.0</span>\r\n");
      out.write("                    <span class=\"statustitle\">Süper</span>\r\n");
      out.write("                </section>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"inside-right\">\r\n");
      out.write("                <div class=\"price01\">\r\n");
      out.write("                    <div class=\"price02\">\r\n");
      out.write("                        <span class=\"price03\">");
      out.print( hotels.getPrice());
      out.write(" $</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"price12\">vergi ve masraflar dâhil</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"btn-rezer\">\r\n");
      out.write("                    <a class=\"boxed-btn-hotel\" href=\"./control.jsp?query=");
      out.print( query);
      out.write("&id=");
      out.print( hotels.getId());
      out.write("\">Hemen rezervasyon yap</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");

            }
        }
    
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
  // modals
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

      out.write("\r\n");
      out.write("<!-- The Modal -->\r\n");
      out.write("<div id=\"myModal\" class=\"modal\" style=\"display: block;\">\r\n");
      out.write("    <!-- Modal content -->\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("        <span id=\"close\" class=\"close\">&times;</span>\r\n");
      out.write("        ");

            if (MsgHead.equals("infoMsg")) {
        
      out.write("        \r\n");
      out.write("        <p class=\"text-center\"><i class=\"fas fa-check-circle\"></i>INFO</p>\r\n");
      out.write("        <p class=\"text-center\">");
      out.print( MsgBody);
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("        ");

        } else if (MsgHead.equals("errorMsg")) {
        
      out.write("        \r\n");
      out.write("        <p class=\"text-center text-danger\" style=\"font-size: 36px\">\r\n");
      out.write("        <i class=\"fas fa-exclamation\"></i>  Oppss\r\n");
      out.write("        </p>\r\n");
      out.write("        <p class=\"text-center\">");
      out.print( MsgBody);
      out.write("</p>\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- FOOTER import -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"../d_Travel/page/resources/javascript/banner.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/SlickNav/1.0.10/jquery.slicknav.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    $('#navigation').slicknav({\r\n");
      out.write("        prependTo: '#mobile_lst'\r\n");
      out.write("    });\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    // MODALS\r\n");
      out.write("    var modal = document.getElementById(\"myModal\");\r\n");
      out.write("    var span = document.getElementsByClassName(\"close\")[0];\r\n");
      out.write("    span.onclick = function() {\r\n");
      out.write("        modal.style.display = \"none\";\r\n");
      out.write("        var headers = document.cookie.split(\"; \");\r\n");
      out.write("        for(var i=0;i<headers.length;i++){\r\n");
      out.write("            var head = headers[i].split(\"=\");\r\n");
      out.write("            var key = head[0];\r\n");
      out.write("//            var value = head[1];\r\n");
      out.write("            if (key === \"infoMsg\" || key === \"errorMsg\"){\r\n");
      out.write("                document.cookie = headers[i] +\";max-age=0\";\r\n");
      out.write("            }   \r\n");
      out.write("        }\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
