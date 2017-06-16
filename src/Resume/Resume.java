package Resume;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import java.sql.DriverManager;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Resume")
public class Resume extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Resume() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 


		try {

			Class.forName("com.mysql.jdbc.Driver");

			//Establish connection to database  

			// comes from the index 
			String firstname = request.getParameter("fname"); 
			//String firstname = request.getParameter("firstname");

			//variable for session - jsp will call this 
			session.setAttribute("fnamesession", firstname);


			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RESUME?USSL","root","password");  
			//PreparedStatement preparedStmt;

			// this inserts only the first name and last name not id because we have auto increment 
			String query = ("SELECT * FROM PERSON WHERE FNAME ='"+firstname+"'");  
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);  //cursor pointer to the row of the table 

			String nextURL = "/output.jsp"; 
			
			//executeQuery: to execute the select query
			while(rs.next()){  // from the current pointer till the end of the table
				System.out.println(rs.getString(1)+"  "+rs.getString(2)
				+"  "+rs.getString(3) +"  "+rs.getString(4));  	  

				String fname = rs.getString("fname"); 
				String lname = rs.getString("lastname");
				String email = rs.getString("email"); 
				request.setAttribute("fname", fname); 
				request.setAttribute("lname", lname);
				request.setAttribute("email", email); 

				
			}
			query = ("SELECT SKILL_NAME FROM PERSON, EDUCATION, SKILLS WHERE FNAME = '"+firstname+"';"); 
			ResultSet rs2=stmt.executeQuery(query);  //cursor pointer to the row of the table 

		//	Iterator itr = new rs2.iterator(); 
			
			while(rs2.next()){  // from the current pointer till the end of the table
					
					String skill = rs2.getString(1); 
					request.setAttribute("skill", skill); 
					System.out.println(rs2.getString(1));
				}
				
				
				getServletContext().getRequestDispatcher(nextURL).forward(request, response);

			}catch(Exception e)
			{ System.out.println(e);
			
			}

		} 

	
} 








