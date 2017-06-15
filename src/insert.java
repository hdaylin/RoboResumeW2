

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public insert() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(); 
		
		//education a = new education(null, null, null)
		
		ArrayList<String> education = new ArrayList<String>();
		ArrayList<String> experience = new ArrayList<String>();
		ArrayList<String> skill = new ArrayList<String>();


		try {

			Class.forName("com.mysql.jdbc.Driver");

			//Establish connection to database  

			// comes from the index 
			String firstname = request.getParameter("firstname"); 
			String lname = request.getParameter("lname"); 
			String email = request.getParameter("email");
			String school = request.getParameter("school");
			String degree = request.getParameter("degree");
			String year = request.getParameter("year");

			//variable for session - jsp will call this 
			session.setAttribute("fnamesession", firstname); 
			session.setAttribute("lnamesession", lname);  
			session.setAttribute("emailsession", email); 
			session.setAttribute("degreesession", degree); 
			session.setAttribute("degreeyear", year); 
			
			
			education.add(degree); 
		
			
			/*String space =" ";
			 StringBuilder eduString = new StringBuilder();
			 space="";
			 for (String edus: education) {
				 eduString.append(space);
				 eduString.append(edus);
				 space = ", ";
				 System.out.println(education);
			 }

			 */
			
			for (String edu : education)
			    System.out.println(edu);
			
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RESUME?USSL","root","password");  
			//PreparedStatement preparedStmt;
		}catch(Exception e)
		
		{ System.out.println(e);
		
		
		}

	} 

	}


