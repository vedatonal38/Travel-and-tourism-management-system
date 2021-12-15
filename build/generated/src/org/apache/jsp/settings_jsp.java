package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.vedat.modules.Admin;
import com.vedat.modules.Admin;

public final class settings_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/page/directives/metas.jsp");
    _jspx_dependants.add("/page/directives/sources.jsp");
    _jspx_dependants.add("/page/directives/headerAdmin.jsp");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("    <title>Kullanıcıların listesi</title>\r\n");
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- HEADER import -->\r\n");
      out.write("    ");
        Admin admin_ = (Admin) session.getAttribute("admin");
        if (admin_ == null) {
            response.sendRedirect("index.jsp");
        } else {
    
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<header>\r\n");
      out.write("    ");

//        admin = (Admin) session.getAttribute("admin");
        out.print(session.getId());
    
      out.write("\r\n");
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
      out.write("                    <li><a class=\"\" href=\"travel_destination.html\">Paketler ekle/kaldır</a></li>\r\n");
      out.write("                    <li><a class=\"\" href=\"../d_Travel/settings.jsp\">Ayarlar</a></li>\r\n");
      out.write("                    <li><a class=\"\" href=\"travel_destination.html\">>P1<</a></li>\r\n");
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
      out.write("<nav class=\"navbar navbar-toggleable-md navbar-light bg-info\">\r\n");
      out.write("    <div class=\"d-md-flex d-block flex-row mx-md-auto mx-0\">\r\n");
      out.write("        <a class=\"nav-item nav-link active\" href=\"../d_Travel/settings1.jsp\">Araç kiralama <span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("        <a class=\"nav-item nav-link\" href=\"#\">Otobus</a>\r\n");
      out.write("        <a class=\"nav-item nav-link\" href=\"#\">Hotel</a>\r\n");
      out.write("        <a class=\"nav-item nav-link\" href=\"#\">Ükle ve şehirler</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");

    }

      out.write("\r\n");
      out.write("</body>\r\n");
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
