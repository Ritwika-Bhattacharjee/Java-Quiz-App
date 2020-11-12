

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import javax.servlet.http.*;  
import java.util.ArrayList; 



/**
 * Servlet implementation class LoginProcess
 */
@WebServlet("/LoginProcess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcess() {
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
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String name="";
		String error="";
		String pass="";
		String role="";
		try {
			HttpSession session=request.getSession();  

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaquizdb", "root", "");
			Statement stmt = con.createStatement();
			String sql = "SELECT name, password, role FROM users WHERE username='"+uname+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				name = rs.getString("name");
				pass = rs.getString("password");
				role = rs.getString("role");
			}
			if(pass.equals(password)) {
				request.setAttribute("name", name);
				if(role.equals("A")) {
					session.setAttribute("currentuser",uname);  
			        session.setAttribute("currentrole","A"); 
			        
			        sql = "SELECT name, username FROM users WHERE role='S'";
			        ResultSet rs1 = stmt.executeQuery(sql);
			        //String[] quiznames = new String[10];
			        ArrayList<String> names = new ArrayList<String>(); 
			        ArrayList<String> usernames = new ArrayList<String>(); 

			        while(rs1.next()) {
			        	names.add(rs1.getString("name"));
			        	usernames.add(rs1.getString("username"));
			        }
			        request.setAttribute("names", names);
			        request.setAttribute("usernames", usernames);
					
					request.getRequestDispatcher("Admin.jsp").forward(request, response);
				}else {
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

					request.getRequestDispatcher("Student.jsp").forward(request, response);
				}
			}else {
				error = "Invalid credentials";
				request.setAttribute("error", error);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
			con.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
