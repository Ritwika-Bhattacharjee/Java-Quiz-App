

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.*;  

/**
 * Servlet implementation class AllResultsProcess
 */
@WebServlet("/AllResultsProcess")
public class AllResultsProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllResultsProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String uname =request.getParameter("uname"); 
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaquizdb", "root", "");
			Statement stmt = con.createStatement();
			String sql = "SELECT `quizname`, `marks` FROM `marks` WHERE `username`='"+uname+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			ArrayList<String> quiznames = new ArrayList<String>();
	        ArrayList<Integer> marks = new ArrayList<Integer>(); 
			
	        while(rs.next()) {
	        	quiznames.add(rs.getString("quizname"));
	        	marks.add(rs.getInt("marks"));
	        }
	        request.setAttribute("quiznames", quiznames);
	        request.setAttribute("marks", marks);
	        
	        con.close();
			stmt.close();
			
			request.getRequestDispatcher("MyResults.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
