package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/page/directives/metas.jsp");
    _jspx_dependants.add("/page/directives/sources.jsp");
    _jspx_dependants.add("/page/directives/header.jsp");
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
      out.write("<!DOCTYPE html>\r\n");
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
      out.write("        <title>Login Page</title>\r\n");
      out.write("        ");
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
      out.write("    </head>\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- HEADER import -->\r\n");
      out.write("    ");
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
      out.write("                    <li><a href=\"about.html\">Hakkimizda</a></li>\r\n");
      out.write("                    <li><a class=\"\" href=\"travel_destination.html\">Paketlerimiz</a></li>\r\n");
      out.write("                    <li><a href=\"../d_Travel/register.jsp\">Kayit ol</a></li>\r\n");
      out.write("                    <li><a href=\"../d_Travel/login.jsp\">Oturum aç<i class=\"ti-angle-down\"></i></a></li>\r\n");
      out.write("                    <li><a href=\"admin.html\">Admin<i class=\"ti-angle-down\"></i></a></li>\r\n");
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
      out.write("\r\n");
      out.write("    <div class=\"container bg-info\" style=\"padding: 35px; width: 500px\">\r\n");
      out.write("        <!-- Login account -->\r\n");
      out.write("        <div class=\"card\" id=\"form-signin\">\r\n");
      out.write("            <article class=\"card-body\">\r\n");
      out.write("                <h4 class=\"card-title text-uppercase text-center mb-4 mt-1\">Kullanıcı Giriş</h4>\r\n");
      out.write("                <hr>\r\n");
      out.write("                <p class=\"text-danger text-center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${err}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                <form method=\"post\" action=\"LoginController\">\r\n");
      out.write("                    <!-- start -->\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <div class=\"input-group-prepend\">\r\n");
      out.write("                                <span class=\"input-group-text\"> <i class=\"fa fa-user\"></i> </span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <input id=\"username\" name=\"username\" class=\"form-control\" placeholder=\"Email or Username\">\r\n");
      out.write("                        </div> <!-- input-group.// -->\r\n");
      out.write("                    </div> <!-- form-group// -->\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <div class=\"input-group-prepend\">\r\n");
      out.write("                                <span class=\"input-group-text\"> <i class=\"fa fa-lock\"></i></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <input id=\"paw\" name=\"paw\" class=\"form-control\" placeholder=\"******\" type=\"password\">\r\n");
      out.write("                        </div> <!-- input-group.// -->\r\n");
      out.write("                    </div> <!-- form-group// -->\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary btn-block\">Giriş</button>\r\n");
      out.write("                    </div> <!-- form-group// -->\r\n");
      out.write("                    <p class=\"text-center\"><a href=\"#\" class=\"btn\" id=\"password\">Parolanızı mı unuttunuz?</a></p>\r\n");
      out.write("                    <p class=\"text-center\"><a href=\"#\" class=\"btn\" id=\"admin\">Admin Paneli</a></p>\r\n");
      out.write("                </form>\r\n");
      out.write("            </article>\r\n");
      out.write("        </div> <!-- card.// -->\r\n");
      out.write("        <!-- Forgot password -->\r\n");
      out.write("        <div class=\"card\" id=\"form-pass\" style=\"display: none;\">\r\n");
      out.write("            <article class=\"card-body\">\r\n");
      out.write("                <h4 class=\"card-title text-uppercase text-center mb-4 mt-1\">Parolanızı mı unuttunuz?\r\n");
      out.write("                </h4>\r\n");
      out.write("                <hr>\r\n");
      out.write("                <form action=\"ForgotPass\" role=\"form\" id=\"login-recordar\" method=\"post\">\r\n");
      out.write("                    <fieldset>\r\n");
      out.write("                        <span class=\"help-block\">\r\n");
      out.write("                            Hesabınıza giriş yapmak için kullandığınız e-posta adresi, \r\n");
      out.write("                            yeni bir şifre seçmek için talimatlara sahip bir e-posta göndereceğiz.\r\n");
      out.write("                            <br>\r\n");
      out.write("                        </span>\r\n");
      out.write("                        <div class=\"form-group input-group\">\r\n");
      out.write("                            <div class=\"input-group-prepend\">\r\n");
      out.write("                                <span class=\"input-group-text\"> <i class=\"fa fa-lock\"></i> @ </span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <input class=\"form-control\" placeholder=\"Email\" name=\"email\" type=\"email\" required=\"\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary btn-block\" id=\"btn-olvidado\">\r\n");
      out.write("                                Gönder\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <p class=\"text-center\">\r\n");
      out.write("                            <a href=\"#\" id=\"acceso\">Hesap erişimi</a>\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </fieldset>\r\n");
      out.write("                </form>\r\n");
      out.write("            </article>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- admin from -->\r\n");
      out.write("        <div class=\"card\" id=\"form-admin\" style=\"display: none;\">\r\n");
      out.write("            <article class=\"card-body\">\r\n");
      out.write("                <h4 class=\"card-title text-center mb-4 mt-1\">Admin Giriş</h4>\r\n");
      out.write("                <hr>\r\n");
      out.write("                <p class=\"text-danger text-center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${err}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                <form method=\"post\" action=\"LoginAdmin\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"status\" value=\"1\">\r\n");
      out.write("                    <!-- start -->\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <div class=\"input-group-prepend\">\r\n");
      out.write("                                <span class=\"input-group-text\"> <i class=\"fa fa-user\"></i> </span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <input id=\"name_\" name=\"username\" class=\"form-control\" placeholder=\"Email or Username\">\r\n");
      out.write("                        </div> <!-- input-group.// -->\r\n");
      out.write("                    </div> <!-- form-group// -->\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <div class=\"input-group-prepend\">\r\n");
      out.write("                                <span class=\"input-group-text\"> <i class=\"fa fa-lock\"></i></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <input id=\"paw_\" class=\"form-control\" placeholder=\"******\" type=\"password\">\r\n");
      out.write("                        </div> <!-- input-group.// -->\r\n");
      out.write("                    </div> <!-- form-group// -->\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary btn-block\">Giriş</button>\r\n");
      out.write("                    </div> <!-- form-group// -->\r\n");
      out.write("                    <p class=\"text-center\">\r\n");
      out.write("                        <a href=\"#\" id=\"accesoL\">Kullanıcı Paneli</a>\r\n");
      out.write("                    </p>\r\n");
      out.write("                </form>\r\n");
      out.write("            </article>\r\n");
      out.write("        </div>\r\n");
      out.write("                ");

                
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- FOOTER import -->\r\n");
      out.write("    ");
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
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        $(document).ready(function () {\r\n");
      out.write("            $('#password').click(function (e) {\r\n");
      out.write("                e.preventDefault(); // form-signin\r\n");
      out.write("                $('div#form-signin').toggle('500');\r\n");
      out.write("                $('div#form-pass').toggle('500');\r\n");
      out.write("            });\r\n");
      out.write("            $('#acceso').click(function (e) {\r\n");
      out.write("                e.preventDefault();\r\n");
      out.write("                $('div#form-signin').toggle('500');\r\n");
      out.write("                $('div#form-pass').toggle('500');\r\n");
      out.write("            });\r\n");
      out.write("            $('#admin').click(function (e) {\r\n");
      out.write("                e.preventDefault();// form-admin\r\n");
      out.write("                $('div#form-signin').toggle('500');\r\n");
      out.write("                $('div#form-admin').toggle('500');\r\n");
      out.write("            });\r\n");
      out.write("            $('#accesoL').click(function (e) {\r\n");
      out.write("                e.preventDefault();\r\n");
      out.write("                $('div#form-signin').toggle('500');\r\n");
      out.write("                $('div#form-admin').toggle('500');\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
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
