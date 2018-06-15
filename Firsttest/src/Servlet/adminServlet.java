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
        
		System.out.println("��");
		String method = request.getParameter("method");
		HttpSession session = request.getSession();
		Object ss = session.getAttribute("adminBean");
		if(ss!=null)
		{
			System.out.println("ss���ǿ�");
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
			System.out.println("��ת");
			req.getRequestDispatcher("/login/add.jsp").forward(req, rep);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ������Ӧ��Ϊlistuser.jspҳ�淢���޸��û���Ϣ�������ã�ҳ��Ӧ�ô��ݵĲ�������Ҫ�޸ĵ��û���id
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void toUpdate(HttpServletRequest req,HttpServletResponse resp)
			throws IOException, ServletException
	{
//		System.out.println(new Date().toLocaleString()+"\tAdminServlet.toUpdate()��ʼִ�У�");
		req.setCharacterEncoding("UTF-8");
		int id = StringUtil.StringToInt(req.getParameter("id"));
//		System.out.println(new Date().toLocaleString()+"\tid="+id);
		if(id > 1){
			/*
			 * 1. �����ݿ��в�ѯ��ָ��id���û���Ϣ
			 * 2. ��ת��addUser.jspҳ����ʾ������û���Ϣ
			 * 3. addUser.jspҳ�潫������д��Ϣ���浽���ݿ� 
			 */
			
			adminDao adminDao = new adminDao();
			adminBean adminBean = adminDao.getById(id);
			System.out.println(adminBean);
			req.setAttribute("updateBean", adminBean);
			
			req.getRequestDispatcher("/admin/addUser.jsp").forward(req, resp);
		}else if(id == 1){
			// ��һ���û�Ĭ��Ϊ��������Ա�������޸�
			resp.sendRedirect(req.getContextPath());
		}else{
		//	adminDao adminDao = new adminDao();
			///adminBean adminBean = adminDao.getById(id);
			//System.out.println(adminBean);
			System.out.println("����");
			resp.sendRedirect("/servlet?method=list&status=2");
		}
	}
	
	
	
	/**
	 * ɾ��һ���û�����Ҫָ������Ϊ�û���id
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		int id = StringUtil.StringToInt(request.getParameter("id"));
		// id Ϊ1����Ϊ��������Ա�ǲ�����ɾ����
	
			adminDao adminDao = new adminDao();
			adminDao.delete(id);
			// ��Ӧ�ض���鿴�û��б�״̬status=3��ʾɾ��ָ��id���û��ɹ�
			response.sendRedirect(request.getContextPath()+"/servlet?method=list&status=3");
	
	}

	/*
	 * ��ѯ�û���Ϣ
	 */
	private void listUsers(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
//		
		req.setCharacterEncoding("utf-8");
		/*
		 * status ���Ǵ�listUsers.jspҳ�洫�ݹ����Ĳ��������Ǵ����� servlet �������ݹ����Ĳ���
		 * listUser.jspҳ����ɾ�������޸ĺ�������ô˷�������ʱ�Ż���status����
		 */
		String status = req.getParameter("status");
		adminDao adminDao = new adminDao();
		
		// �õ���ǰ��ʾ��ҳ�������current pageΪ�գ���ô��ǰҳ��Ĭ�� 0
		int currentPage = StringUtil.StringToInt(req.getParameter("currentPage"));
		// �õ���¼������
		int countSize = adminDao.getCount();
//		System.out.println(new Date().toLocaleString()+"\tlistUsers status="+status+";currentPage = "+currentPage+";countSize = "+countSize);
		
		// ����PagingBean����
		PagingBean pagingBean = new PagingBean(countSize, currentPage, utils.Constants.PAGE_SIZE_3);
		List<adminBean> adminBeans = adminDao.getListByPage(currentPage * utils.Constants.PAGE_SIZE_3, utils.Constants.PAGE_SIZE_3);
		System.out.println(adminBeans);
		/*
		 * ��
		 * */
		pagingBean.setPrefixUrl(req.getContextPath() + "/servlet?method=list");
		pagingBean.setAnd(true);
		
		// ����Ҫ��ʾ���û������ŵ�request��������
		req.setAttribute(utils.Constants.SESSION_ADMIN_BEANS, adminBeans);
		req.setAttribute("pagingBean", pagingBean);
		
		// ���ݵ��ô˷�����λ�ò�ͬѡ����תʱ���ݵĲ���
		if (status != null) {
			req.getRequestDispatcher("/admin/listUsers.jsp?status=" + status).forward(req, resp);
		} else {
			req.getRequestDispatcher("/admin/listUsers.jsp").forward(req, resp);
		}
	}
	
		
	/**
		 * ���û���¼ʱ���ô˷���
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
			
			String clientCheckcode = request.getParameter("checkCodeInput");//���տͻ���������ύ��������֤��		
			String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//�ӷ������˵�session��ȡ����֤��
	
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
				             System.out.println("��¼session"+adminbean);
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
//			System.out.println(new Date().toLocaleString()+"\tAdminServlet.addUser()��ʼִ��");
			
			req.setCharacterEncoding("utf-8");
			/*
			 * updateId �����жϵ��õ�ǰ�����ĳ���������û������޸��û���Ϣ
			 */
			adminDao adminDao = new adminDao();
			
			String username = req.getParameter("username");//�û���
			String name = req.getParameter("name");//����
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
			// ����һ���û������������û��ĸ�������
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

	        
     //System.out.println(DateUtil.getDateStr(new Date())+"\tAdminServlet.add()ִ�����");

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
