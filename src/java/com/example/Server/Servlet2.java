/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Giorgos
 */
public class Servlet2 extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                PrintWriter out = response.getWriter();
                Connection conn = null;
                PreparedStatement pst = null;
                
                //request.setCharacterEncoding("UTF-8");
                
                String n=request.getParameter("Name");
		String lat=request.getParameter("Lat");
		String lon=request.getParameter("Lng");
                
                String url = "jdbc:mysql://localhost:3306/";  
                String dbName = "test";  
                String driver = "com.mysql.jdbc.Driver";  
                String userName = "root";  
                String password = "";
                
                
                try{
		Class.forName(driver).newInstance();  
                conn = DriverManager  
                    .getConnection(url + dbName, userName, password);  
                pst = conn  
                    .prepareStatement("insert into favorites values(?,?,?)");
		
		pst.setString(1,n);
		pst.setString(2,lat);
		pst.setString(3,lon);
		
		
		int i=pst.executeUpdate();
                out.print("1");
                if(i>0)
		out.print("Your place is successfully registered 2 ...");
                //RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
               // rd.include(request,response);
                
                }catch (ClassNotFoundException e2) {System.out.println(e2);} catch (SQLException e2) {
                    System.out.println(e2);
            } catch (InstantiationException ex) {
                //Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
               // Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
		
		out.close();
        
        
    }
    
}
