package Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.XuqiuBean;
import Bean.adminBean;
import Dao.shenheDao;
import Dao.xuqiuDao;

@WebServlet("/shenheServlet")
public class shenheServlet  extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		HttpSession session = request.getSession();
		Object ss = session.getAttribute("adminBean");
		if(ss!=null)
		{
			if("shenhe".equals(method)){
				System.out.println("开始审核");
				shenhe(request,response);
			}else if("checklist".equals(method)){
				checklist(request,response);
			}
		}
		
	}
	//审核员审核全部用户需求
	private void  shenhe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
	    
		shenheDao xuqiuDao = new shenheDao();
		
		 HttpSession session = request.getSession();
		 adminBean admin= (adminBean)session.getAttribute("adminBean");
		    
		List<XuqiuBean> xuqiuBeans = xuqiuDao.list();
		
		request.setAttribute("adminBeans", xuqiuBeans);
		//System.out.println(xuqiuBeans);
		try {
			request.getRequestDispatcher("/index/search/searchdata2.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	 //多条件查询审核全部用户需求
		private void checklist(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
			request.setCharacterEncoding("utf-8");
			int cishu=Integer.parseInt(request.getParameter("i"));
	         
			int m=0;
			String[] leixing=new String[6];
			String[] han=new String[6];
			String[] jingmo=new String[6];
			//String[] inputh=new String[6];
			String[] inputlx=new String[6];
			
			for(m=1;m<=cishu;m++){
		      leixing[m]="leixing"+m;
		      han[m]="han"+m;
		      jingmo[m]="jingmo"+m;
		      inputlx[m]="inputlx"+m;
		     // inputh[m]="inputh"+m;
		      
	       }
			String status=request.getParameter("shenhe");
			String pass=request.getParameter("tongguo");
	        
			for(m=1;m<=cishu;m++){
	          leixing[m]=request.getParameter(leixing[m]);
	          han[m]=request.getParameter(han[m]);
	  	      jingmo[m]=request.getParameter(jingmo[m]);
	  	      inputlx[m]=request.getParameter(inputlx[m]);
	  	      System.out.println(inputlx[m]);
	        }
			
	         shenheDao  shenhedao=new shenheDao();
			 HttpSession session = request.getSession();
			 adminBean admin= (adminBean)session.getAttribute("adminBean");
			 
			 List<XuqiuBean> xuqiuBeans = shenhedao.list(status,pass,leixing,inputlx,han,jingmo,cishu);
		     
				request.setAttribute("adminBeans", xuqiuBeans);
				try {
				request.getRequestDispatcher("/index/search/searchdata2.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
		}

}
