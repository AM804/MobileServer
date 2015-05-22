
package com.example.Server;

import java.io.BufferedReader;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;


public class Servlet4 extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                PrintWriter out = response.getWriter();
                Connection conn = null;
                PreparedStatement pst = null;
                
                //request.setCharacterEncoding("UTF-8");
                
               String n=request.getParameter("Name");
		
                ResultSet rs = null;
                boolean status = false;  
                String url = "jdbc:mysql://localhost:3306/";  
                String dbName = "test";  
                String driver = "com.mysql.jdbc.Driver";  
                String userName = "root";  
                String password = "";
                
                
              try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  
            pst = conn  
                    .prepareStatement("select * from favorites where Name=?");  
            pst.setString(1,n); 
            
            
            rs = pst.executeQuery();  
            status=rs.next();
            
  
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }
        }
              
        if (status) {
                out.print("1");
            }
            else {
                out.print("0");
            }
        out.close();
    }
		
        
        
    }
    

