

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Places
 */
@WebServlet("/Places")
public class Places extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Places() {
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

	 		 
			
			String str="select Source, Destination from Airline_Details";
			
			//to execute query create object of Statement
			Statement  ps=con.createStatement();
			//get ResultSet
			ResultSet ans =ps.executeQuery(str);
		
			List<String[]> map = new ArrayList<>();
			while(ans.next()) {
				String[] flight=new String[2];
				flight[0]=ans.getString("source");
				flight[1]=ans.getString("destination");
				
				map.add(flight);
				
					
			}		
			session.setAttribute("sd", map);
			RequestDispatcher rd = request.getRequestDispatcher("Places.jsp");
			rd.forward(request, response);
			
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
