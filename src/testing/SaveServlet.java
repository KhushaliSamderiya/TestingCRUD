package testing;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String id=request.getParameter("id");  
        Long cost=Long.parseLong(request.getParameter("cost"));  
        String name=request.getParameter("name");  
        String type=request.getParameter("type");  
        String inclusion=request.getParameter("inclusions");  
        String duration=request.getParameter("duration");  
          
        Emp e=new Emp();  
        e.setPackage_ID(id);
        e.setPackage_Name(name);
        e.setPackage_type(type);
        e.setInclusions(inclusion);
        e.setNights( duration);
        e.setPrice_per_person(cost); 
           
          
        int status=EmpDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("ViewServlet").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  