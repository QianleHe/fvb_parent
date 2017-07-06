/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-07-06 07:51:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.foodvotebox.pojo.FvbFriend;
import java.util.List;

public final class deleteFriend_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Friend List</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("    ");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<h1>Friends list</h1>\n");
      out.write("<div id=\"FriendDiv\">\n");
      out.write("    <table id=\"FriendTable\">\n");
      out.write("        <div id=\"InitialFriendDisplay\">\n");
      out.write("            <tr>\n");
      out.write("                <td>UserId</td>\n");
      out.write("                <td>UserName</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                List<FvbFriend> list = (List)request.getAttribute("friendList");
                if (list.size() != 0) {
                    for (int i = 0; i < list.size(); i++) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(list.get(i).getFriendid() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(list.get(i).getFriendname() );
      out.write("</td>\n");
      out.write("                <td><input type=\"submit\" value=\"Delete\" id=\"");
      out.print(list.get(i).getFriendid());
      out.write("\" onclick=\"deleteFriend(");
      out.print(list.get(i).getFriendid());
      out.write(")\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            }else{
            
      out.write("\n");
      out.write("            <tr><td colspan=\"6\">No data in the database！</td></tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div id = \"showdiv\"></div>\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("<table>\n");
      out.write("    <tr>\n");
      out.write("        <td>Friend Info:</td>\n");
      out.write("        <td><input id=\"friendInput\" placeholder=\"enter name or e-mail\" onblur=\"checkFriend();\"></td>\n");
      out.write("        <td><input id=\"submitFriend\" type=\"submit\" name=\"add\" onclick=\"addFriend();\"></td>\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
      out.write("<script type=\"text/javascript\" src=\"../fvb_web/js/jquery-3.1.1.js\"></script>\n");
      out.write("<script>\n");
      out.write("    function deleteFriend(friendId){\n");
      out.write("        $.ajax({\n");
      out.write("            data: {friendId: friendId},\n");
      out.write("            type: \"GET\",\n");
      out.write("            dataType: \"json\",\n");
      out.write("            url: \"deleteFriend\",\n");
      out.write("            success: function(result){\n");
      out.write("                if (result) {\n");
      out.write("                    $(\"#showdiv\").empty();\n");
      out.write("                    $(\"#FriendTable\").remove();\n");
      out.write("                    var panelTable = $(\"<table></table>\");\n");
      out.write("                    var panelheader = $(\"<tr><td>UserId</td> <td>UserName</td> <td></td></tr>\");\n");
      out.write("                    for(a of result) {\n");
      out.write("                        var panelBody = $(\"<tr></tr>\");\n");
      out.write("                        var panelBodyId = $(\"<td></td>\").text(a.friendId);\n");
      out.write("                        var panelBodyName = $(\"<td></td>\").text(a.friendname);\n");
      out.write("                        var panelBodyDelete = $(\"<input type=\\\"submit\\\" value=\\\"Delete\\\" />\")\n");
      out.write("                        panelBodyDelete.attr(\"onclick\", \"deleteFriend(\"+a.friendId+\")\");\n");
      out.write("                        panelBodyDelete.attr(\"id\", a.friendId);\n");
      out.write("                        panelBodyDelete = $(\"<td></td>\").append(panelBodyDelete);\n");
      out.write("                        panelBody.append(panelBodyId,panelBodyName,panelBodyDelete);\n");
      out.write("                        panelTable.append(panelBody);\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    $(\"#showdiv\").append(panelheader,panelTable);\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            error: function(){\n");
      out.write("                alert(\"Delete friend failed\");\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("<script>\n");
      out.write("    function checkFriend() {\n");
      out.write("        var data = {friendInput: $(\"#friendInput\").val()};\n");
      out.write("        $.ajax({\n");
      out.write("            data: data,\n");
      out.write("            type: \"GET\",\n");
      out.write("            dataType:\"text\",\n");
      out.write("            url:\"checkFriend\",\n");
      out.write("            success: function(result){\n");
      out.write("                if(result == \"true\")\n");
      out.write("                {\n");
      out.write("                    $(\"#friendInput\").css(\"border\", \"5px solid green\")\n");
      out.write("                }\n");
      out.write("                else if(result == \"false\"){\n");
      out.write("                    $(\"#friendInput\").css(\"border\", \"5px solid red\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("<script>\n");
      out.write("    function addFriend(){\n");
      out.write("        var data = {friendInput: $(\"#friendInput\").val()};\n");
      out.write("        $.ajax({\n");
      out.write("            data: data,\n");
      out.write("            type: \"GET\",\n");
      out.write("            dataType: \"json\",\n");
      out.write("            url:\"addFriend/bool\",\n");
      out.write("            success: function(result){\n");
      out.write("                if (result) {\n");
      out.write("                    $(\"#showdiv\").empty();\n");
      out.write("                    $(\"#FriendTable\").remove();\n");
      out.write("                    var panelTable = $(\"<table></table>\");\n");
      out.write("                    var panelheader = $(\"<tr><td>UserId</td> <td>UserName</td> <td></td></tr>\");\n");
      out.write("                    for(a of result) {\n");
      out.write("                        var panelBody = $(\"<tr></tr>\");\n");
      out.write("                        var panelBodyId = $(\"<td></td>\").text(a.friendid);\n");
      out.write("                        var panelBodyName = $(\"<td></td>\").text(a.friendname);\n");
      out.write("                        var panelBodyDelete = $(\"<input type=\\\"submit\\\" value=\\\"Delete\\\" />\")\n");
      out.write("                        panelBodyDelete.attr(\"onclick\", \"deleteFriend(\"+a.friendid+\")\");\n");
      out.write("                        panelBodyDelete.attr(\"id\", a.friendid);\n");
      out.write("                        panelBodyDelete = $(\"<td></td>\").append(panelBodyDelete);\n");
      out.write("                        panelBody.append(panelBodyId,panelBodyName,panelBodyDelete);\n");
      out.write("                        panelTable.append(panelBody);\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    $(\"#showdiv\").append(panelheader,panelTable);\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            error: function(){\n");
      out.write("                alert(\"Add friend failed\");\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
