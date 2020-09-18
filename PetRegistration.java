package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PetRegistration
 */
@WebServlet("/PetRegistration")
public class PetRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 response.setContentType("text/html");
         PrintWriter pw=response.getWriter();
         String firstname=request.getParameter("fname");
         pw.println("FirstName: "+firstname+"<br/>");
         String lastname=request.getParameter("lname");
         pw.println("LastName: "+lastname+"<br/>");
         String addr=request.getParameter("address");
         pw.println("Address: "+addr+"<br/>");
         String Email=request.getParameter("email");
         pw.println("Email: "+Email+"<br/>");
         String City=request.getParameter("city");
         pw.println("City: "+City+"<br/>");
         String State=request.getParameter("state");
         pw.println("State: "+State+"<br/>");
         String petname=request.getParameter("pname");
         pw.println("Petname: "+petname+"<br/>");
         int pnum=Integer.parseInt(request.getParameter("pno"));
         pw.println("PhoneNo: "+pnum+"<br/>");
         String pettype=request.getParameter("ptype");
         pw.println("Pettype: "+pettype+"<br/>");
         int petage=Integer.parseInt(request.getParameter("page"));
         pw.println("PetAge: "+petage+"<br/>");
         
         try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/petregistration", "root","root");
             PreparedStatement ps=con.prepareStatement("insert into PetRegistration(fname,lname,address,email,city,state,pname,pno,ptype,page)values(?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, firstname);
             ps.setString(2, lastname);
             ps.setString(3, addr);
             ps.setString(4, Email);
             ps.setString(5, City);
             ps.setString(6, State);
             ps.setString(7, petname);
             ps.setInt(8, pnum);
             ps.setString(9, pettype);
             ps.setInt(10, petage);
             int i = ps.executeUpdate();
             if(i==1){
            	 RequestDispatcher rd=request.getRequestDispatcher("/Success.html");
            	 rd.forward(request, response);
             }
}
catch(Exception e){
             System.out.println(e);
}
	}

}
