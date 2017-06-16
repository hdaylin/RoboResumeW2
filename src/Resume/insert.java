package Resume;


import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public insert() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();  
		
		
		// comes from the index 
					String firstname = request.getParameter("fname"); 
					//String firstname = request.getParameter("firstname");

					//variable for session - jsp will call this 
					session.setAttribute("fname", firstname);

		try {

			Class.forName("com.mysql.jdbc.Driver");

			//Establish connection to database  

			// comes from the index 
			firstname = request.getParameter("fname"); 
			String lname = request.getParameter("lname"); 
			String email = request.getParameter("email"); 
			String exp = request.getParameter("exp"); 
			String duty1 = request.getParameter("duty1");
			String duty2 = request.getParameter("duty2");
			
			String school = request.getParameter("school");
			String degree = request.getParameter("degree");
			String year = request.getParameter("year"); 
			
			String skill = request.getParameter("skill");
			String level = request.getParameter("level"); 
			
			
		

			//variable for session - jsp will call this 
			session.setAttribute("fname", firstname); 
			session.setAttribute("lnamesession", lname);  
			session.setAttribute("emailsession", email); 
			
			session.setAttribute("degreesession", degree); 
			session.setAttribute("schoolsession", school); 
			session.setAttribute("degreeyear", year); 
			
			session.setAttribute("skill", skill);
			session.setAttribute("level", level); 
			
			session.setAttribute("exp",exp);
			session.setAttribute("duty1", duty1); 
			session.setAttribute("duty2", duty2);
		

			education a = new education(degree, school, year); 
			Skill b =new Skill(skill, level); 
			experience c = new experience(exp, duty1, duty2);
			
			
			ArrayList<education> al = new ArrayList<education>(); 
			ArrayList<Skill> sk = new ArrayList<Skill>();
			ArrayList<experience> ex = new ArrayList<experience>();
			
			
			al.add(a); 
			sk.add(b);
			ex.add(c);
			
			for (education edu : al)
			    System.out.println(edu.getDegree() + edu.getSchool() + edu.getYear());
			

			//ArrayList<String> experience = new ArrayList<String>();
			
			for(experience expr : ex)
				System.out.println(expr.getJob() + expr.getDuty1() + expr.getDuty2());
		
			for(Skill s : sk)
				System.out.println(s.getName() + s.getLevel());
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RESUME?USSL","root","password");  
			PreparedStatement preparedStmt;
			String query = ("INSERT INTO EDUCATION (DEGREE_NAME,PERSON_ID, SCHOOL, D_YEAR) VALUES (?,?,?,?)");
			preparedStmt = con.prepareStatement(query);
			
			int pid= 1;
			
			preparedStmt.setString(1, degree);
			preparedStmt.setInt(2, pid);
			preparedStmt.setString(3, school);
			preparedStmt.setString(4, year);
		
			
			String query2 = ("INSERT INTO EXPERIENCE (EXP,DUTY1, DUTY2, PERSON_ID) VALUES (?,?,?,?)");
			preparedStmt = con.prepareStatement(query2);
			
			preparedStmt.setString(1, exp);
			preparedStmt.setString(2, duty1);
			preparedStmt.setString(3, duty2);
			preparedStmt.setInt(4, pid);
			
			String query3 = ("INSERT INTO SKILLS (SKILL_NAME, SLEVEL,  PERSON_ID) VALUES (?,?,?)");
			preparedStmt = con.prepareStatement(query3);
			
			preparedStmt.setString(1, skill);
			preparedStmt.setString(2, level);
			preparedStmt.setInt(3, pid);
			
			
			preparedStmt.executeUpdate(); 
			
			// this inserts only the first name and last name not id because we have auto increment 
						String query4 = ("SELECT * FROM PERSON WHERE FNAME ='"+firstname+"'");  
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(query4);  //cursor pointer to the row of the table 

						
						//executeQuery: to execute the select query
						while(rs.next()){  // from the current pointer till the end of the table
							System.out.println(rs.getString(1)+"  "+rs.getString(2)
							+"  "+rs.getString(3) +"  "+rs.getString(4));  	  

							String fname = rs.getString("fname"); 
							 lname = rs.getString("lname");
							 email = rs.getString("email"); 
							request.setAttribute("fname", fname); 
							request.setAttribute("lname", lname);
							request.setAttribute("email", email); 
	
						}
									
			
			getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
			
		}catch(Exception e)
		
		
		{ System.out.println(e);
		
		
		}

	} 

	}


