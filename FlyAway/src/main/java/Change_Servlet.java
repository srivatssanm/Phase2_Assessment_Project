

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Change_Servlet
 */
@WebServlet("/Change_Servlet")
public class Change_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Change_Servlet() {
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
	 		 
	 		ServletContext sc = getServletContext();
	 		String username = (String)sc.getAttribute("u");
	 		String password = request.getParameter("password");
	 		out.println(username);
			String str="update Admin_Login set Password='"+password+"' where User_Name='"+username+"';";
		
			Statement  ps=con.createStatement();
			
			
			int x = ps.executeUpdate(str);
			out.println(x);

			if(x>0) {
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
					
			}else {
				out.println("Something went wrong !!!");
			}
			
			
			
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
