/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Pojo.Employee;
import DAO.EmployeeDAO;
/**
 *
 * @author Dilip J Sarvaiya
 */
@WebServlet(urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

    
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
               
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Employee e=EmployeeDAO.getEmployeeById(id);  
            out.println("<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Dilip Sarvaiya</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"       \n" +
"        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\n" +
"        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
"        <script src=\"js/validation.js\"></script>\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"            \n" +
"        <style>\n" +
"            body\n" +
"            {\n" +
"                background-color: purple;\n" +
"                \n" +
"            }\n" +
"            .container\n" +
"            {\n" +
"               \n" +
"                padding-bottom:15px;\n" +
"            }\n" +
"            p\n" +
"            {\n" +
"                font-size: 18px;\n" +
"            }\n" +
"            h2,label\n" +
"            {\n" +
"                color:#ffffff;\n" +
"            }\n" +
"           .navbar-dark .navbar-nav .nav-link\n"+
"            {\n"+
"               color: white\n" +
"            }\n" +
"           \n" +
"        .navbar-dark .navbar-nav .nav-link\n" +
"            {\n" +
"                color: white;          \n" +
"            }\n" +
"            a.disabled\n" +
"            {\n" +
"                pointer-events: none;\n" +
"                cursor:default;\n" +
"            }\n" +              
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"       <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n" +
"  <a class=\"navbar-brand disabled\" >Employee Management</a>\n" +
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
"       <div class=\"container\">\n" +
"           <h2>Employee Form</h2>\n" +
"            <form  method =\"post\" action=\"EditServlet2\">\n" +
"                    <input type='hidden' name='id' value='"+e.getId()+"' />\n"+ 
"            <div class=\"form-group\">\n" +
"              <label for=\"name\">Name:</label>\n" +
"              <input type=\"text\" class=\"form-control\" id=\"name\" value='"+e.getName()+"' placeholder=\"Enter Name\" name=\"name\" />\n" +
"              <p id=\"p6\"></p>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"email\">Email:</label>\n" +
"              <input type=\"email\" class=\"form-control\" id=\"email\" value='"+e.getEmail()+"' placeholder=\"Enter email\" name=\"email\" />\n" +
"              <p id=\"p1\"></p>\n" +
"            </div>\n" +
"                 <div class=\"form-group\">\n" +
"              <label for=\"salary\">Salary</label>\n" +
"              <input type=\"number\" class=\"form-control\" id=\"salary\" value='"+e.getSalary()+"' placeholder=\"Enter salary\" name=\"salary\" />\n" +
"              <p id=\"p2\"></p>\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"                <label for=\"age\">Age</label>\n" +
"                <input type=\"number\" class=\"form-control\" id=\"age\" value='"+e.getAge()+"' placeholder=\"Choose Age\" name=\"age\">\n" +
"                 <p id=\"p4\"></p>\n" +
"            </div>\n" +
"            <div class=\"form-group\">   \n" +
"                <label for=\"gender\">Gender</label>\n" +
"                 <input type=\"radio\" id=\"gender\" checked value=\"Male\" name=\"gender\" /><font color=\"white\"> Male</font>\n" +
"                <input type=\"radio\" id=\"gender\" value=\"Female\" name=\"gender\" /><font color=\"white\"> Female</font>\n" +
"                 <p id=\"p6\"></p>\n" +
"           </div>\n" +
"            <div class=\"form-group\">\n" +
"              <label for=\"department\">Select the Department</label>\n" +
"              <select id=\"department\" class=\"form-control\" name=\"department\">\n" +
"                             <option>Computer Engineering</option>\n" +
"                             <option>Electrical Engineering</option>\n" +
"                             <option>Mechnical Engineering</option>\n" +
"                             <option>Electronics Engineering</option>\n" +
"                             <option>Civil Engineering</option>\n" +
"              </select>\n" +
"               <p id=\"p5\"></p>\n" +
"            </div>\n" +
"       <div class=\"form-group\">\n" +
"            <input name=\"submit\" class=\"btn btn-success\" type=\"submit\" value=\"Submit\">\n" +
"       </div>\n" +
"        </form>\n" +
"    </div>\n" +
"    </body>\n" +
"</html>  ");          
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
