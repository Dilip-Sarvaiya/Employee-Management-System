/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Employee;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dilip J Sarvaiya
 */
public class EmployeeDAO {
    
      public static Connection getConnection(){  
        Connection con=null;  
        try{  
             //Step-1 : Load the JDBC driver 
            Class.forName("com.mysql.jdbc.Driver");  
            //Step-2 : Define the connection URL 
            String mysqlURL
                    = "jdbc:mysql://localhost:3307/tutorial_4?user=root";
            con=DriverManager.getConnection(mysqlURL);  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int delete(int  id)
   throws IOException {
        int rowsDeleted=0;
        try 
        {   
           
            //Step-3 : Establish the connection 
            Connection con = EmployeeDAO.getConnection();

            //Step-4 : Create a PreparedStatement object 
            //String sql = "INSERT INTO userdetails (email,password,conf_pass, age,branch,msg, gender, hobby) "
            //        + "VALUES (?, ?, ?, ?,?,?,?,?)";

            String sql = "DELETE from emp " + 
                  "WHERE id=?";
            //String sql = "DELET FROM Users " + 
            //        "WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
           

            //Step-5 : Execute a query or update 
            rowsDeleted = st.executeUpdate();

            System.out.println(rowsDeleted);

            //Step-7 : Close the connection 
            con.close();
    
        } catch (SQLException sqle) {
            System.err.println("Error with connection:" + sqle);
        }
        return rowsDeleted;
     }
    public static Employee getEmployeeById(int id){  
        Employee e = null;
        try{  
            Connection con=EmployeeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emp where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7)); 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
        return e;  
    }    
    public static int update(Employee obj)
   throws IOException {
        int rowsUpdated=0;
        try 
        {

            //Step-3 : Establish the connection 
            Connection con = EmployeeDAO.getConnection();

            //Step-4 : Create a PreparedStatement object 
            //String sql = "INSERT INTO userdetails (email,password,conf_pass, age,branch,msg, gender, hobby) "
            //        + "VALUES (?, ?, ?, ?,?,?,?,?)";

            String sql = "UPDATE emp " + 
                    "SET name=?,email=?,salary=?, gender=?, age=?,department=?"+
                  "WHERE id=?";
            //String sql = "DELET FROM Users " + 
            //        "WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
           
            st.setString(1,obj.getName());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getSalary());
            st.setString(4, obj.getGender());
            st.setInt(5, obj.getAge());
            st.setString(6,obj.getDepartment());
            st.setInt(7,obj.getId());
            

            //Step-5 : Execute a query or update 
            rowsUpdated = st.executeUpdate();

            System.out.println(rowsUpdated);

            //Step-7 : Close the connection 
            con.close();
    
        } catch (SQLException sqle) {
            System.err.println("Error with connection:" + sqle);
        }
        return rowsUpdated;
     }
    //Why too much code in the servlet
     public static void insert(Employee obj)
   throws IOException {
        try 
        {
            //Step-3 : Establish the connection 
            Connection con = EmployeeDAO.getConnection();

            //Step-4 : Create a PreparedStatement object 
            String sql = "INSERT INTO emp (name,email,salary,age,gender,department) "
                    + "VALUES (?, ?, ?, ?,?,?)";

            //String sql = "UPDATE usersDetails " + 
             //       "SET password=?,conf_pass=?, age=?,branch=?,msg=?, gender=?, hobby=?" + 
              //    "WHERE username=?";
            //String sql = "DELET FROM Users " + 
            //        "WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getSalary());
            st.setInt(4, obj.getAge());
            st.setString(5, obj.getGender());
            st.setString(6,obj.getDepartment());

            //Step-5 : Execute a query or update 
            int rowsInserted = st.executeUpdate();
           

            //Step-7 : Close the connection 
            con.close();
    
        } catch(Exception ex){ex.printStackTrace();}  
     }
      public static List<Employee> getAllEmployees(){  
        List<Employee> list=new ArrayList<Employee>();  
          
        try{  
            Connection con=EmployeeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emp");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Employee e=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));  
                
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
      }
}
