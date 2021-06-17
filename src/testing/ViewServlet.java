package testing;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<!DOCTYPE html>\r\n"
        		+ "<html lang=\"en\">\r\n"
        		+ "<head>\r\n"
        		+ "    <meta charset=\"UTF-8\">\r\n"
        		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
        		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
        		+ "    <title> Admin Home | Truvaile</title>\r\n"
        		+ "    <link rel=\"icon\" href=\"/Images/logo01.png\">\r\n"
        		+ "    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n"
        		+ "    <link rel=\"stylesheet\" href=\"css/style07.css\">\r\n"
        		+ "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.1/css/all.css\" integrity=\"sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ\" crossorigin=\"anonymous\">\r\n"
        		+ "    <style>\r\n"
        		+ "      .content-table{\r\n"
        		+ "        margin: 2rem 0.2rem;\r\n"
        		+ "      }\r\n"
        		+ "    </style>\r\n"
        		+ "</head>\r\n"
        		+ "<body>\r\n"
        		+ "    <header class=\"main\">\r\n"
        		+ "        <div class=\"header-cotainer\">\r\n"
        		+ "           <div class=\"top-container\">\r\n"
        		+ "                <nav class=\"navigation container\">\r\n"
        		+ "                    <div class=\"nav-brand\">Truvaile</div>\r\n"
        		+ "                    <ul class=\"list-non-bullet nav-pills\">\r\n"
        		+ "                        <li class=\"list-item-inline\">\r\n"
        		+ "                            <a class=\"link\" href=\"ViewUsers\">Users List</a>\r\n"
        		+ "                        </li>\r\n"
        		+ "                        <li class=\"list-item-inline\">\r\n"
        		+ "                            <a class=\"link link-active\" href=\"ViewServlet\">Packages</a>\r\n"
        		+ "                        </li>\r\n"
        		+ "                        <li class=\"list-item-inline\">\r\n"
        		+ "                            <a class=\"link\" href=\"ViewBookedPackages\">Booked Packages </a>\r\n"
        		+ "                        </li>\r\n"
        		+ "                        <li class=\"list-item-inline\">\r\n"
        		+ "                            <a class=\"link \" href=\"ViewFeedback\">Feedback</a>\r\n"
        		+ "                        </li>\r\n"
        		+ "                        <li class=\"list-item-inline\">\r\n"
        		+ "                            <a class=\"link\" href=\"AdminLogout\">Logout</a>\r\n"
        		+ "                        </li>\r\n"
        		+ "                    </ul>\r\n"
        		+ "                 </nav>\r\n"
        		+ "            </div>\r\n"
        		+ "         </div>\r\n"
        		+ "       </header>\r\n"
        		+ "<section class=\"view-tables\">");
        out.println("<h2>Packages List</h2>\r\n"
        		+ "    <a href=\"CreatePackage.html\" style=\"text-decoration: none; font-size: large; text-transform: capitalize; \">Add new package</a>");    
          
        List<Emp> list=EmpDao.getAllEmployees();  
          
        out.print("<table class=\"content-table\" border='1' width='100%'>");  
        out.print("<thead><tr><th>Id</th><th>Name</th><th>Type</th><th>Inclusions</th><th>Duration</th><th>Cost</th><th>Edit</th><th>Delete</th></tr></thead>");  
        for(Emp e:list){  
         out.print("<tbody><tr><td>"+e.getPackage_ID()+"</td><td>"+e.getPackage_Name()+"</td><td>"+e.getPackage_type()+"</td><td>"
        +e.getInclusions()+"</td><td>"+e.getNights()+"</td><td>"+e.getPrice_per_person()+"</td><td><a href='EditServlet?id="+e.getPackage_ID()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getPackage_ID()+"'>delete</a></td></tr><tbody>");  
        }  
        out.print("</table></section>\r\n"
        		+ "<footer class=\"footer\">\r\n"
        		+ "    \r\n"
        		+ "    <div class=\"footer-header\">\r\n"
        		+ "        <div class=\"icon\">\r\n"
        		+ "           <i class=\"fas fa-chevron-up\"></i></div>\r\n"
        		+ "        <p>© 2020 Truvaile Trips Pvt Ltd.</p>\r\n"
        		+ "    </div>\r\n"
        		+ "    <ul class=\"social-link list-non-bullet\">\r\n"
        		+ "        <li class=\"list-item-inline\">\r\n"
        		+ "            <a href=\"#\" class=\"link\"><i class=\"fab fa-linkedin-in\"></i></a> \r\n"
        		+ "        </li>\r\n"
        		+ "        <li class=\"list-item-inline\">\r\n"
        		+ "            <a href=\"#\" class=\"link\"><i class=\"fab fa-facebook-f\"></i></a> \r\n"
        		+ "        </li>\r\n"
        		+ "        <li class=\"list-item-inline\">\r\n"
        		+ "            <a href=\"#\" class=\"link\"><i class=\"fas fa-play\"></i></a> \r\n"
        		+ "        </li>\r\n"
        		+ "        <li class=\"list-item-inline\">\r\n"
        		+ "            <a href=\"#\" class=\"link\"><i class=\"fab fa-instagram\"></i></a> \r\n"
        		+ "        </li>\r\n"
        		+ "        <li class=\"list-item-inline\">\r\n"
        		+ "            <a href=\"#\" class=\"link\"><i class=\"fab fa-twitter\"></i></a> \r\n"
        		+ "        </li>\r\n"
        		+ "    </ul>\r\n"
        		+ "</footer></body></html>");  
          
        out.close();  
    }  
}  