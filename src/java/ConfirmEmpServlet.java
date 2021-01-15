/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.EmployeeDAO;
import Pojo.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dilip J Sarvaiya
 */
@WebServlet(urlPatterns = {"/ConfirmEmpServlet"})
public class ConfirmEmpServlet extends HttpServlet {

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
            
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String salary=request.getParameter("salary");
            int age=Integer.parseInt(request.getParameter("age"));
            String gender=request.getParameter("gender");
            String department=request.getParameter("department");
            int id=1;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">");
            out.println("<title>Submmited Data</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\"><h2 style=\"color:white\";>Employee Details</h2></nav>");
            out.println("<div class=\"alert alert-success\" role=\"alert\">");
            out.println("<h3>Name: " + name+ "</h3>");
            out.println("<h3>Email: " + email+ "</h3>");
            out.println("<h3>Salary: " + salary+ "</h3>");
            out.println("<h3>Age: " + age + "</h3>");
            out.println("<h3>Gender: " + gender + "</h3>");
            out.println("<h3>Department: " + department + "</h3>");
            Employee obj=new Employee(id,name,email,salary,age,gender,department);
            HttpSession session=request.getSession();  
            session.setAttribute("object",obj);
            out.println("<a href=\"SaveEmpServlet\"><button class=\"btn btn-primary\">Confirm</button></a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
