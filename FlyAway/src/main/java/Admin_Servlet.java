

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Admin_Servlet")
public class Admin_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection con=DB_Connection.getMyConnection();
			
			HttpSession session=request.getSession(); 
	 		PrintWriter out = response.getWriter();
	 		
	 		String user=request.getParameter("userid");  
			String pass=request.getParameter("pword"); 
			
			String str="select * from Admin_Login where User_Name='"+user+"' and Password='"+pass+"';";
		
			
			//to execute query create object of Statement
			Statement  ps=con.createStatement();
			//get ResultSet
			ResultSet ans =ps.executeQuery(str);
		
			if(ans.next()) {
				
				
				RequestDispatcher rd = request.getRequestDispatcher("Admin_Portal.jsp");
				rd.forward(request, response);
					
			}
			else {
				out.println("Invalid_Credentials!");
			}
			ServletContext servletcontext = getServletContext();
			servletcontext.setAttribute("u", user);
						
			
				}catch(Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
