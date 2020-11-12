

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.*;  

/**
 * Servlet implementation class RegisterProcess
 */
@WebServlet("/RegisterProcess")
public class RegisterProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProcess() {
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
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		request.setAttribute("name", name);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaquizdb", "root", "");
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO `users`(`name`, `username`, `password`, `role`, `attempted`) VALUES ('"+name+"','"+uname+"','"+password+"','S','')";
			stmt.executeUpdate(sql);
			System.out.println("Registered Successfully!!");
			
			HttpSession session=request.getSession();  
	        session.setAttribute("currentuser",uname);  
	        session.setAttribute("currentrole","S"); 
	        
	        sql = "SELECT names FROM quiznames";
	        ResultSet rs1 = stmt.executeQuery(sql);
	        //String[] quiznames = new String[10];
	        ArrayList<String> quiznames = new ArrayList<String>(); 
	        int i = 0;
	        while(rs1.next()) {
	        	quiznames.add(rs1.getString("names"));
	        	i++;
	        }
	        request.setAttribute("quiznames", quiznames);
	        request.setAttribute("noq", i);

	        con.close();
			stmt.close();
			
			request.getRequestDispatcher("Student.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
