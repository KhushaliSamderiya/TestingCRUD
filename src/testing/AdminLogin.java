package testing;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        String uname = request.getParameter("username");
	        String upass = request.getParameter("password");
	        
	        if(AdminDao.checkUser(uname, upass))
	        {
               RequestDispatcher rs = request.getRequestDispatcher("ViewUsers");
               rs.forward(request, response);
	           out.print("Welcome"+uname);
	        }
	        else
	        {
	           out.println("Username or Password incorrect");
//	           RequestDispatcher rs = request.getRequestDispatcher("index.html");
//	           rs.include(request, response);
	        }
	    }  
	}
	