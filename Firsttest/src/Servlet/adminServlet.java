package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.adminBean;
import Bean.powerBean;
import Dao.adminDao;
import Dao.powerDao;
import Bean.adminBean;
import Bean.PagingBean;
import Dao.adminDao;
import Bean.adminBean;
import Dao.adminDao;
import utils.Constants;
import utils.StringUtil;
import Bean.adminBean;
import Dao.adminDao;

@WebServlet("/userServlet")
public class adminServlet extends HttpServlet{

    public adminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        
		System.out.println("跳");
		String method = request.getParameter("method");
		HttpSession session = request.getSession();
		Object ss = session.getAttribute("adminBean");
		if(ss!=null)
		{
			System.out.println("ss不是空");
		  if("listDetails".equals(method)){
			list(request,response);
		}
		}
		else 
		if("login".equals(method)){
			login(request,response);
		}else if("reg".equals(method)){
			addUser(request,response);
		}else if ("list".equals(method)) { 
			listUsers(request, response); 
		}else if("delete".equals(method)){
			delete(request,response);
		}else if("toUpdate".equals(method)){
			toUpdate(request,response);
		}
	}
	
     private void list(HttpServletRequest req,HttpServletResponse rep){
		String username=req.getParameter("id");
		adminDao admindao=new adminDao();
		
		adminBean adminBean=admindao.getByusername(username);
		req.setAttribute("adminBean", adminBean);
		try {
			System.out.println("跳转");
			req.getRequestDispatcher("/login/add.jsp").forward(req, rep);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 本方法应该为listuser.jsp页面发送修改用户信息请求后调用，页面应该传递的参数有需要修改的用户的id
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void toUpdate(HttpServletRequest req,HttpServletResponse resp)
			throws IOException, ServletException
	{
//		System.out.println(new Date().toLocaleString()+"\tAdminServlet.toUpdate()开始执行！");
		req.setCharacterEncoding("UTF-8");
		int id = StringUtil.StringToInt(req.getParameter("id"));
//		System.out.println(new Date().toLocaleString()+"\tid="+id);
		if(id > 1){
			/*
			 * 1. 从数据库中查询出指定id的用户信息
			 * 2. 跳转到addUser.jsp页面显示查出的用户信息
			 * 3. addUser.jsp页面将重新填写信息保存到数据库 
			 */
			
			adminDao adminDao = new adminDao();
			adminBean adminBean = adminDao.getById(id);
			System.out.println(adminBean);
			req.setAttribute("updateBean", adminBean);
			
			req.getRequestDispatcher("/admin/addUser.jsp").forward(req, resp);
		}else if(id == 1){
			// 第一个用户默认为超级管理员，不可修改
			resp.sendRedirect(req.getContextPath());
		}else{
		//	adminDao adminDao = new adminDao();
			///adminBean adminBean = adminDao.getById(id);
			//System.out.println(adminBean);
			System.out.println("出来");
			resp.sendRedirect("/servlet?method=list&status=2");
		}
	}
	
	
	
	/**
	 * 删除一个用户，需要指定参数为用户的id
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		int id = StringUtil.StringToInt(request.getParameter("id"));
		// id 为1的作为超级管理员是不可以删除的
	
			adminDao adminDao = new adminDao();
			adminDao.delete(id);
			// 响应重定向查看用户列表，状态status=3表示删除指定id的用户成功
			response.sendRedirect(request.getContextPath()+"/servlet?method=list&status=3");
	
	}

	/*
	 * 查询用户信息
	 */
	private void listUsers(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
//		
		req.setCharacterEncoding("utf-8");
		/*
		 * status 不是从listUsers.jsp页面传递过来的参数，而是从其他 servlet 方法传递过来的参数
		 * listUser.jsp页面点击删除或者修改后，最后会调用此方法，此时才会有status参数
		 */
		String status = req.getParameter("status");
		adminDao adminDao = new adminDao();
		
		// 得到当前显示的页数，如果current page为空，那么当前页数默认 0
		int currentPage = StringUtil.StringToInt(req.getParameter("currentPage"));
		// 得到记录总条数
		int countSize = adminDao.getCount();
//		System.out.println(new Date().toLocaleString()+"\tlistUsers status="+status+";currentPage = "+currentPage+";countSize = "+countSize);
		
		// 创建PagingBean对象
		PagingBean pagingBean = new PagingBean(countSize, currentPage, utils.Constants.PAGE_SIZE_3);
		List<adminBean> adminBeans = adminDao.getListByPage(currentPage * utils.Constants.PAGE_SIZE_3, utils.Constants.PAGE_SIZE_3);
		System.out.println(adminBeans);
		/*
		 * ？
		 * */
		pagingBean.setPrefixUrl(req.getContextPath() + "/servlet?method=list");
		pagingBean.setAnd(true);
		
		// 将需要显示的用户对象存放到request作用域中
		req.setAttribute(utils.Constants.SESSION_ADMIN_BEANS, adminBeans);
		req.setAttribute("pagingBean", pagingBean);
		
		// 根据调用此方法的位置不同选择跳转时传递的参数
		if (status != null) {
			req.getRequestDispatcher("/admin/listUsers.jsp?status=" + status).forward(req, resp);
		} else {
			req.getRequestDispatcher("/admin/listUsers.jsp").forward(req, resp);
		}
	}
	
		
	/**
		 * 当用户登录时调用此方法
		 * @param request
		 * @param response
		 * @throws IOException 
		 */
		private void login(HttpServletRequest request, HttpServletResponse response) 
				throws IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			String clientCheckcode = request.getParameter("checkCodeInput");//接收客户端浏览器提交上来的验证码		
			String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//从服务器端的session中取出验证码
	
		    adminBean adminbean =adminDao.checkLogin(username, password);
		   
		    powerBean powerbean=powerDao.getnumber(adminbean.age);
			
		    PrintWriter out = response.getWriter();
			if(adminbean != null){
				if(adminbean.getUsername().equals("x") ){
				 out.println(1);
			     } else{
			            if(clientCheckcode.equals(serverCheckcode)){
				            //request.getSession().setAttribute("adminBean", adminbean);
				             out.println(4);
				             request.getSession().setAttribute(Constants.SESSION_ADMIN_BEAN, adminbean);
				             request.getSession().setAttribute("power", powerbean);
				             System.out.println(powerbean);
				             System.out.println("登录session"+adminbean);
			            }else{
				             out.println(3);
			                 }
			        }
			 }
			else{
				out.println(2);
			}
		}

		
		private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
//			System.out.println(new Date().toLocaleString()+"\tAdminServlet.addUser()开始执行");
			
			req.setCharacterEncoding("utf-8");
			/*
			 * updateId 用来判断调用当前方法的场景是添加用户还是修改用户信息
			 */
			adminDao adminDao = new adminDao();
			
			String username = req.getParameter("username");//用户名
			String name = req.getParameter("name");//姓名
			String password = req.getParameter("password");
			String sex=req.getParameter("sex");			
			String gshi = req.getParameter("Gshi");
			String danwei = req.getParameter("danwei");
			
			String zhuanye = req.getParameter("zhuanye");
			String hangye = req.getParameter("hangye");
			String jiaoyu = req.getParameter("jiaoyu");
			String zhicheng = req.getParameter("zhicheng");
			String tongxun= req.getParameter("tongxun");
			String youbian = req.getParameter("youbian");
			String id = req.getParameter("id");
			int ID=StringUtil.StringToInt(id);
			String guhua = req.getParameter("guhua");
			String youxiang = req.getParameter("youxiang");
			String qq = req.getParameter("qq");
			String msn = req.getParameter("msn");
			
//			System.out.println(new Date().toLocaleString()+"\tupdateId = "+updateId+"; username = "+username+"; password="+password);
			// 创建一个用户对象并且设置用户的各个属性
			adminBean adminBean = new adminBean();
			adminBean.setUsername(username);
			adminBean.setName(name);
			adminBean.setPassword(password);
			adminBean.setSex(sex);
			
	        adminBean.setGshi(gshi);
	        adminBean.setDanwei(danwei);
	        adminBean.setZhuanye(zhuanye);
	        adminBean.setHangye(hangye);
	        adminBean.setJiaoyu(jiaoyu);
	        adminBean.setZhicheng(zhicheng);
	        adminBean.setTongxun(tongxun);
	        adminBean.setYoubian(youbian);
	        adminBean.setId(ID);
	        adminBean.setGuhua(guhua);
	        adminBean.setYouxiang(youxiang);
	        adminBean.setQq(qq);
	        adminBean.setMsn(msn);

	        
     //System.out.println(DateUtil.getDateStr(new Date())+"\tAdminServlet.add()执行添加");

			boolean flag = adminDao.checkReg(username);
				if(flag){
					if(danwei == ""){
						resp.sendRedirect("login/add.jsp?status=2");
					}else if(zhuanye == ""){
						resp.sendRedirect("login/add.jsp?status=4");
					}
					else if(hangye == ""){
						resp.sendRedirect("login/add.jsp?status=5");
					}else{
					   adminDao.save(adminBean);
					   resp.sendRedirect("login/add.jsp?status=3");
					   }
				 }
				else{
					resp.sendRedirect("login/add.jsp?status=1");
				}
			
			
		}
}
