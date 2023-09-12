package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
//import javax.servlet.*;
//import javax.servlet.http.*;



@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
	       throws ServletException, IOException {
		
	     // declare variables
	     PrintWriter pw = null;


	     // set content type
	     resp.setContentType("text/html");

	     // get PrintWriter
	     pw = resp.getWriter();

	     // get form data
	     try {
		     Bill billObj = new Bill();
		     ResultSet rs = billObj.get_bills();
		     while(rs.next()) {
		    	 int id = rs.getInt(0);
		    	 String name = rs.getString(1);
		    	 int salary = rs.getInt(2);
		    	 String location = rs.getString(3);
		    	 
		    	 pw.println("id: "+id);
		    	 pw.println("name: "+name);
		    	 pw.println("salary: "+salary);
		    	 pw.println("location: "+location);
		     }
	     }catch(Exception e) {
	    	 System.out.println("Exception occured: "+e);
	     }
	     // close stream
	     pw.close();
	   }

	   @Override
	   public void doGet(HttpServletRequest req, HttpServletResponse resp) 
	       throws ServletException, IOException {
	     doPost(req, resp);
	   }

}