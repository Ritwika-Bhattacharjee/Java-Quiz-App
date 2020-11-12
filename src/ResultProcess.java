

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.*;  

/**
 * Servlet implementation class ResultProcess
 */
@WebServlet("/ResultProcess")
public class ResultProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultProcess() {
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
		
		String quizname = request.getParameter("quizname");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaquizdb", "root", "");
			Statement stmt = con.createStatement();
			String sql = "SELECT `qid`, `ans` FROM `"+quizname+"`";
			ResultSet rs = stmt.executeQuery(sql);
			
	        int marks = 0;
	        while(rs.next()) {
	        	String qid = rs.getString("qid");
	        	String ans = rs.getString("ans");
	        	String givenans = request.getParameter(qid);
	        	if(givenans.equals(ans)) {
	        		marks = marks+5;
	        	}
	        }
	        request.setAttribute("quizname", quizname);
	        request.setAttribute("marks", marks);
	        
	        HttpSession session=request.getSession(false);
	        String uname =(String)session.getAttribute("currentuser");  
			
	        sql = "INSERT INTO `marks`(`username`, `quizname`, `marks`) VALUES('"+uname+"','"+quizname+"',"+marks+")";
			stmt.executeUpdate(sql);

	        System.out.println("Marks Successfully Entered for user "+uname);
	        con.close();
			stmt.close();
			
			request.getRequestDispatcher("Result.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
