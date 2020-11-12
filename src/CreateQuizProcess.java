

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class CreateQuizProcess
 */
@WebServlet("/CreateQuizProcess")
public class CreateQuizProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateQuizProcess() {
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
		String name = request.getParameter("quiztitle");
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaquizdb", "root", "");
			Statement stmt = con.createStatement();
			String sql = "CREATE TABLE `"+name+"`(qid INTEGER(11), question VARCHAR(100), opa VARCHAR(20), opb VARCHAR(20), opc VARCHAR(20), opd VARCHAR(20), ans VARCHAR(3))";
			stmt.executeUpdate(sql);
			System.out.println("Quiz table created Successfully!!");
			
			sql = "INSERT INTO `quiznames`(`names`) VALUES ('"+name+"')";
			stmt.executeUpdate(sql);
			System.out.println("Quiz name inserted in quiznames table Successfully!!");
			
			String q = request.getParameter("q1");
			String opa = request.getParameter("opa1");
			String opb = request.getParameter("opb1");
			String opc = request.getParameter("opc1");
			String opd = request.getParameter("opd1");
			String ans = request.getParameter("ans1");
			
			sql = "INSERT INTO `"+name+"`(`qid`, `question`, `opa`, `opb`, `opc`, `opd`, `ans`) VALUES (1, '"+q+"','"+opa+"','"+opb+"','"+opc+"','"+opd+"','"+ans+"')";
			stmt.executeUpdate(sql);
			
			q = request.getParameter("q2");
			opa = request.getParameter("opa2");
			opb = request.getParameter("opb2");
			opc = request.getParameter("opc2");
			opd = request.getParameter("opd2");
			ans = request.getParameter("ans2");
			
			sql = "INSERT INTO `"+name+"`(`qid`, `question`, `opa`, `opb`, `opc`, `opd`, `ans`) VALUES (2, '"+q+"','"+opa+"','"+opb+"','"+opc+"','"+opd+"','"+ans+"')";
			stmt.executeUpdate(sql);
			
			q = request.getParameter("q3");
			opa = request.getParameter("opa3");
			opb = request.getParameter("opb3");
			opc = request.getParameter("opc3");
			opd = request.getParameter("opd3");
			ans = request.getParameter("ans3");
			
			sql = "INSERT INTO `"+name+"`(`qid` `question`, `opa`, `opb`, `opc`, `opd`, `ans`) VALUES (3, '"+q+"','"+opa+"','"+opb+"','"+opc+"','"+opd+"','"+ans+"')";
			stmt.executeUpdate(sql);
			
			q = request.getParameter("q4");
			opa = request.getParameter("opa4");
			opb = request.getParameter("opb4");
			opc = request.getParameter("opc4");
			opd = request.getParameter("opd4");
			ans = request.getParameter("ans4");
			
			sql = "INSERT INTO `"+name+"`(`qid`, `question`, `opa`, `opb`, `opc`, `opd`, `ans`) VALUES (4, '"+q+"','"+opa+"','"+opb+"','"+opc+"','"+opd+"','"+ans+"')";
			stmt.executeUpdate(sql);
			
			q = request.getParameter("q5");
			opa = request.getParameter("opa5");
			opb = request.getParameter("opb5");
			opc = request.getParameter("opc5");
			opd = request.getParameter("opd5");
			ans = request.getParameter("ans5");
			
			sql = "INSERT INTO `"+name+"`(`qid`, `question`, `opa`, `opb`, `opc`, `opd`, `ans`) VALUES (5, '"+q+"','"+opa+"','"+opb+"','"+opc+"','"+opd+"','"+ans+"')";
			stmt.executeUpdate(sql);
			
			System.out.println("All questions entered successfully!!!");

			con.close();
			stmt.close();
			request.getRequestDispatcher("Admin.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
