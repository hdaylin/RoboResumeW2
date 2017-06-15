package Resume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
		
		// comes from the index 
		String firstname = request.getParameter("firstname");
		
		//variable for session - jsp will call this 
		session.setAttribute("fnamesession", firstname);
		
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
				
		
		
		
		
	}

}
