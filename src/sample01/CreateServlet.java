package sample01;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.setAttribute("users", UserDao.selectAll());
		}catch (SQLException e) {
			throw new ServletException(e);		
		}
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		if (name.trim().length() == 0){
			request.setAttribute("error", "'name' is required");
			request.getRequestDispatcher("/WEB-INF/jsp/new.jsp").forward(request, response);
			return;
		}
		
		User user = new User(name, email);
		
		try{
			UserDao.insert(user);
		}catch (SQLException e) {
			throw new ServletException(e);		
		}
		response.setStatus(HttpServletResponse.SC_SEE_OTHER);
		response.setHeader("location", request.getContextPath() + "/list");
	}

}
