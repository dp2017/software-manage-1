package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.powerDao;

/**
 * Servlet implementation class QuanxianServlet
 */
@WebServlet("/QuanxianServlet")
public class QuanxianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanxianServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if("update".equals(method)){
			update(request,response);
		}else if("list".equals(method)){
			list(request,response);
		}
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		powerDao jueseDao=new powerDao();
		
		request.getSession().setAttribute("jueseBeans", jueseDao.list() );
		System.out.println("½ÇÉ«"+jueseDao.list());
		request.getRequestDispatcher("/Menu/quanxian.jsp").forward(request, response);
	    
		request.getSession().setAttribute("xuqiuBeans", null );
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
