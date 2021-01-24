/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.EmployeeDAO;
import Pojo.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dilip J Sarvaiya
 */
@WebServlet(urlPatterns = {"/ViewServlet"})
public class ViewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Submmited Data</title>");    
            out.println(" <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
            out.println("<script>\n" +
"	$(\"document\").ready(function(){\n" +
"		$(\".btn-danger\").click(function(){\n" +
"			$(this).closest('tr').fadeOut(\n" +
"				1000,\n" +
"				function(){\n" +
"					$(this).remove();\n" +
"				});\n" +
"			});\n" +
"		});\n" +
"</script>\n" +
"<style>\n" +
"#button{\n" +
"    float:right;\n" +
"    display:block;\n" +
"    margin-right:0px;\n" +
"    clear:left;\n" +
"	margin:5px;\n" +
"}\n" +
"h1 {\n" +
"  text-shadow: 2px 2px #99ff66;\n" +
"}\n" +
"table {\n" +
"  border-collapse: collapse;\n" +
"  border-spacing: 0;\n" +
"  width: 100%;\n" +
"  border: 5px solid #ff3030;\n" +
"  outline: 8px  yellow;\n" +
"}\n" +
                    
"th {\n"+
"background-color: #21FF37;\n"+
"}\n" +            
            
                        
"th, td {\n" +
"  text-align: left;\n" +
"  padding: 15px;\n" +
"  font-size:18px;\n" +
"  background-repeat:no-repeat;\n" +
"  font-family:Cambria Math;\n" +
" outline: 2px double green;\n" +
"  border: 1px solid yellow;\n" +
"  outline-style: double;\n" +
"  outline-color: blue;\n" +
"}\n" +
"           .navbar-dark .navbar-nav .nav-link\n"+
"            {\n"+
"               color: white\n" +
"            }\n" +
" .navbar-dark .navbar-nav .nav-link\n" +
"            {\n" +
"                color: white;          \n" +
"            }\n" +
"            a.disabled\n" +
"            {\n" +
"                pointer-events: none;\n" +
"                cursor:default;\n" +
"            }\n" +                 
"tr:nth-child(even){background-color: #fef700fa}"+
"tr:nth-child(odd){background-color: #1cfc6c}"+
"</style>\n");
            out.println("</head>");
            out.println("<body>"+
                    "<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n" +
"  <a class=\"navbar-brand\" >Employee Management</a>\n" +
"  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarColor02\" aria-controls=\"navbarColor02\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"    <span class=\"navbar-toggler-icon\"></span>\n" +
"  </button>\n" +
"\n" +
"  <div class=\"collapse navbar-collapse\" id=\"navbarColor02\">\n" +
"    <ul class=\"navbar-nav mr-auto\">\n" +
"      <li class=\"nav-item active\">\n" +
"        <a class=\"nav-link\" href=\"index.html\">Home\n" +
"          <span class=\"sr-only\">(current)</span>\n" +
"        </a>\n" +
"      </li>\n" +
"      <li class=\"nav-item\">\n" +
"        <a class=\"nav-link\" href=\"add_employee.html\">Add Employee</a>\n" +
"      </li>\n" +
"      <li class=\"nav-item\">\n" +
"        <a class=\"nav-link\" href=\"ViewServlet\">View Employee</a>\n" +
"      </li>\n" +
"  <li class=\"nav-item\">\n" +
"        <a class=\"nav-link\" href=\"ProfileServlet\">Login</a>\n" +
"      </li>"+                    
"      <li class=\"nav-item\">\n" +
"        <a class=\"nav-link\" href=\"Session_logout\">Logout</a>\n" +
"      </li>\n" +
"      \n" +
"    </ul>\n" +
"    <form class=\"form-inline my-2 my-lg-0\">\n" +
"      <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search\">\n" +
"      <button class=\"btn btn-secondary my-2 my-sm-0\" type=\"submit\">Search</button>\n" +
"    </form>\n" +
"  </div>\n" +
"</nav>"+
"<div class=\"container\">\n" +
"<h1 class=\"text-primary\" align=\"center\">Employee Details</h1>\n" +
"	<table class=\"table table-stripped\" \"table table-bordered\">");
        
        
          
        List<Employee> list=EmployeeDAO.getAllEmployees();  
          
        out.print("<table class=\"table table-striped table-hover\" border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Salary</th><th>Age</th><th>Gender</th><th>Select the Department<th colspan='2'>Action</th></tr>");  
        for(Employee e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td>"+  
                 "<td>"+e.getSalary()+"</td><td>"+e.getAge()+"</td><td>"+e.getGender()+"</td>"+
                   "<td>"+e.getDepartment()+"</td>"+
                         "<td><a href='EditServlet?id="+e.getId()+"'><button type=\"button\" class=\"btn btn-primary\">Edit</button></a></td>" +
                        "<td><a href='DeleteServlet?id="+e.getId()+"'><button type=\"button\" class=\"btn btn-danger\">Delete</button></a></td></tr>");  
        }  
        out.print("</table>");  
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
 
          
        out.close();
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
