

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Get_Data
 */
@WebServlet("/Get_Data")
public class Get_Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Get_Data() {
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
 		
 		String source=request.getParameter("source");  
		String destination=request.getParameter("destination"); 
		String traveldate=request.getParameter("date");  
		String str="select * from Airline_Details where Source='"+source+"' and Destination='"+destination+"' and Dt='"+traveldate+"'";
		
		//to execute query create object of Statement
		Statement  ps=con.createStatement();
		//get ResultSet
		ResultSet ans =ps.executeQuery(str);
		HashMap<String, String> map = new HashMap<>();
		while(ans.next()) {
			map.put(ans.getString("Flight_Name"),ans.getString("Cost"));
			
				
		}
				session.setAttribute("details", map);
		
		
		ServletContext servletcontext = getServletContext();
		servletcontext.setAttribute("source", source);
		servletcontext.setAttribute("destination", destination);
		servletcontext.setAttribute("date", traveldate);
		servletcontext.setAttribute("a", map);
		
		if(map.isEmpty()) {
			out.println("No flights found !");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Book_Details.jsp");
			rd.forward(request, response);
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
