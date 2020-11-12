

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;

/**
 * Servlet implementation class QuizProcess
 */
@WebServlet("/QuizProcess")
public class QuizProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizProcess() {
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
		
		String quizname = request.getParameter("quiz");
		request.setAttribute("quizname", quizname);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaquizdb", "root", "");
			Statement stmt = con.createStatement();
			String sql = "SELECT qid, question, opa, opb, opc, opd, ans FROM "+ quizname;
			
	        ResultSet rs1 = stmt.executeQuery(sql);
	        ArrayList<Integer> qid = new ArrayList<Integer>();
	        ArrayList<String> questions = new ArrayList<String>(); 
	        ArrayList<String> opa = new ArrayList<String>(); 
	        ArrayList<String> opb = new ArrayList<String>(); 
	        ArrayList<String> opc = new ArrayList<String>(); 
	        ArrayList<String> opd = new ArrayList<String>(); 
	        //ArrayList<String> ans = new ArrayList<String>(); 


	        int i = 0;
	        while(rs1.next()) {
	        	qid.add(rs1.getInt("qid"));
	        	questions.add(rs1.getString("question"));
	        	opa.add(rs1.getString("opa"));
	        	opb.add(rs1.getString("opb"));
	        	opc.add(rs1.getString("opc"));
	        	opd.add(rs1.getString("opd"));
	        	//ans.add(rs1.getString("ans"));
	        	i++;
	        }
	        request.setAttribute("questions", questions);
	        request.setAttribute("opa", opa);
	        request.setAttribute("opb", opb);
	        request.setAttribute("opc", opc);
	        request.setAttribute("opd", opd);
	        request.setAttribute("qid", qid);
	        request.setAttribute("noq", i);

	        con.close();
			stmt.close();
			
			request.getRequestDispatcher("QuizPage.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
