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
import javax.xml.ws.http.HTTPBinding;

import Bean.PagingBean;
import Bean.XuqiuBean;
import Bean.adminBean;
import Dao.adminDao;
import Dao.xuqiuDao;
import sun.rmi.transport.proxy.HttpReceiveSocket;
import utils.Constants;
import utils.StringUtil;

@WebServlet("/xuqiuServlet")
public class xuqiuServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/*
		 * ÿһ�����ô� Servlet �ĵط�����Ҫ����һ��method��������ָ����Ҫ�����еĲ���
		 */
		String method = request.getParameter("method");
		HttpSession session = request.getSession();
		Object ss = session.getAttribute("adminBean");
		if(ss!=null)
		{
			if("reg".equals(method)){
				reg(request,response);
			 }
			else if("list".equals(method)){
				list(request,response);
			}else if("delete".equals(method)){
				delete(request,response);
			}else if("shu".equals(method)){
			     dengji(request,response);
			}else if("checklist".equals(method)){
				checklist(request,response);
			}else if("listxu".equals(method)){
				listxu(request,response);
			}else if("update".equals(method)){
				update(request,response);
			}else if("pass".equals(method)){
				shenhe(request,response);
			}
		}
		else{
		    System.out.println("δ��¼״̬");
		}
		
	}
	//�������
	private void shenhe(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		String status=req.getParameter("status");
		String pass=req.getParameter("pass");
		String id1=req.getParameter("id");
		int id=Integer.parseInt(id1);
		System.out.println(status+" "+pass+" "+id);
		xuqiuDao xuqiudao=new xuqiuDao();
		xuqiudao.shenhe(id,status,pass);
		
	}
	
	//��������
	private void update(HttpServletRequest request,HttpServletResponse response)
			throws  ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		
        xuqiuDao xuqiudao = new xuqiuDao();
		
		String name = request.getParameter("name");
		String gguan = request.getParameter("gguan");
		String address = request.getParameter("address");
		String saddress = request.getParameter("saddress");
		String web  = request.getParameter("web");
		String email =request.getParameter("email");			
		String represent = request.getParameter("represent");
		String zipcode = request.getParameter("zipcode");
		
		String xuming = request.getParameter("xuming");
		String lianxiren = request.getParameter("lianxiren");
		String phone = request.getParameter("phone");
		String telephone = request.getParameter("telephone");
		String chuanzhen = request.getParameter("chuanzhen");
		String shuxing = request.getParameter("shuxing");
		String jianjie = request.getParameter("jianjie");
		
		String theme = request.getParameter("theme");
		String money = request.getParameter("money");
		String key1 = request.getParameter("key1");
		String type = request.getParameter("type");
		String firstSubjects = request.getParameter("firstSubjects");
		String model =request.getParameter("model");
		String servics = request.getParameter("servics");
		
		String firstIndustry = request.getParameter("firstIndustry");
		XuqiuBean xuqiuBean = new XuqiuBean();
		xuqiuBean.setName(name);
		xuqiuBean.setGguan(gguan);
		xuqiuBean.setAddress(address);
		xuqiuBean.setSaddress(saddress);
		xuqiuBean.setWeb(web);
		xuqiuBean.setEmail(email);	
		xuqiuBean.setRepresent(represent);
		xuqiuBean.setZipcode(zipcode);
       
		xuqiuBean.setXuming(xuming);
		xuqiuBean.setLianxiren(lianxiren);
		xuqiuBean.setPhone(phone);
		xuqiuBean.setTelephone(telephone);
		xuqiuBean.setChuanzhen(chuanzhen);
		xuqiuBean.setShuxing(shuxing);
		xuqiuBean.setJianjie(jianjie);
       
		xuqiuBean.setThem(theme);
		xuqiuBean.setMoney(money);
		xuqiuBean.setKey1(key1);
		xuqiuBean.setType(type);
		xuqiuBean.setFirstSubjects(firstSubjects);
		xuqiuBean.setModel(model);
		xuqiuBean.setServic(servics);
		xuqiuBean.setFirstlndustry(firstIndustry);
       System.out.println("��������"+xuqiuBean.getXuming());
        HttpSession session = request.getSession();
        //��ȡ�û���
        adminBean admin;
		admin = (adminBean) session.getAttribute("adminBean");
		System.out.println("�û���"+admin.getUsername());

		xuqiudao.update(admin,xuqiuBean);
		//����jsp
		 response.sendRedirect("index/CreateDemand.jsp?status=1");
		
		
	}
	
	
	//�г���ϸ����������
	private void listxu(HttpServletRequest request,HttpServletResponse response)
			throws  ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
	    System.out.println(id);
	    xuqiuDao xuqiudao=new xuqiuDao();
	    XuqiuBean xuqiubean=xuqiudao.getBYxuqiuid(id);
	    
	    request.setAttribute("xuqiubean", xuqiubean);
	    String button=request.getParameter("button");
	    if("chakan".equals(button)){
	    	try {
				request.getRequestDispatcher("/index/CreateDemand3.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
	    }
	    else{try {
			request.getRequestDispatcher("/index/CreateDemand2.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		}
	}
	
	
	//��������ѯ����
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
  	      }
		
         xuqiuDao  xuqiudao=new xuqiuDao();
		 HttpSession session = request.getSession();
		 adminBean admin= (adminBean)session.getAttribute("adminBean");
		 List<XuqiuBean> xuqiuBeans = xuqiuDao.list(admin,status,pass,leixing,inputlx,han,jingmo,cishu);
	     
			request.setAttribute("adminBeans", xuqiuBeans);
			System.out.println("��������ѯ"+xuqiuBeans);
			try {
			request.getRequestDispatcher("/index/search/searchdata.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
	}
	
	//ʧ�ܵȼ�
	private void dengji(HttpServletRequest request,HttpServletResponse response){
		String jibie=request.getParameter("name");
		xuqiuDao  xuqiudao=new xuqiuDao();
		
		
		List<XuqiuBean> xuqiuBeans = xuqiuDao.choosexu(jibie);
		request.setAttribute("adminBeans", xuqiuBeans);
		System.out.println(xuqiuBeans);
		try {
			request.getRequestDispatcher("/Rxuqiu/xqfind.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 *ɾ������
	 */
	private void delete(HttpServletRequest request,HttpServletResponse response) 
			throws IOException{
		request.setCharacterEncoding("utf-8");
		xuqiuDao  xuqiudao=new xuqiuDao();
		String id = request.getParameter("id");
		int Id=Integer.parseInt(id);
			xuqiudao.delete(Id);
		
	    response.sendRedirect(request.getContextPath()+"/xuqiuServlet?method=list&status=2");
			
 	}
	
	/*
	 * ��ʾ����û�ȫ������
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) 
			throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		xuqiuDao xuqiuDao = new xuqiuDao();
		
		 HttpSession session = req.getSession();
		 adminBean admin= (adminBean)session.getAttribute("adminBean");
		    
		List<XuqiuBean> xuqiuBeans = xuqiuDao.list(admin);
		
		req.setAttribute("adminBeans", xuqiuBeans);
		//System.out.println(xuqiuBeans);
		try {
			req.getRequestDispatcher("/index/search/searchdata.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
/*
 * �����
 */
	private void reg(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException,IOException{	
		req.setCharacterEncoding("utf-8");

		xuqiuDao adminDao = new xuqiuDao();
		
		String name = req.getParameter("name");
		String gguan = req.getParameter("gguan");
		String address = req.getParameter("address");
		String saddress = req.getParameter("saddress");
		String web  = req.getParameter("web");
		String email =req.getParameter("email");			
		String represent = req.getParameter("represent");
		String zipcode = req.getParameter("zipcode");
		
		String xuming = req.getParameter("xuming");
		String lianxiren = req.getParameter("lianxiren");
		String phone = req.getParameter("phone");
		String telephone = req.getParameter("telephone");
		String chuanzhen = req.getParameter("chuanzhen");
		String shuxing = req.getParameter("shuxing");
		String jianjie = req.getParameter("jianjie");
		
		String theme = req.getParameter("theme");
		String money = req.getParameter("money");
		String key1 = req.getParameter("key1");
		String type = req.getParameter("type");
		String firstSubjects = req.getParameter("firstSubjects");
		String model = req.getParameter("model");
		String servics = req.getParameter("servics");
		
		String firstIndustry = req.getParameter("firstIndustry");
		XuqiuBean xuqiuBean = new XuqiuBean();
		xuqiuBean.setName(name);
		xuqiuBean.setGguan(gguan);
		xuqiuBean.setAddress(address);
		xuqiuBean.setSaddress(saddress);
		xuqiuBean.setWeb(web);
		xuqiuBean.setEmail(email);	
		xuqiuBean.setRepresent(represent);
		xuqiuBean.setZipcode(zipcode);
       
		xuqiuBean.setXuming(xuming);
		xuqiuBean.setLianxiren(lianxiren);
		xuqiuBean.setPhone(phone);
		xuqiuBean.setTelephone(telephone);
		xuqiuBean.setChuanzhen(chuanzhen);
		xuqiuBean.setShuxing(shuxing);
		xuqiuBean.setJianjie(jianjie);
       
		xuqiuBean.setThem(theme);
		xuqiuBean.setMoney(money);
		xuqiuBean.setKey1(key1);
		xuqiuBean.setType(type);
		xuqiuBean.setFirstSubjects(firstSubjects);
		xuqiuBean.setModel(model);
		xuqiuBean.setServic(servics);
		xuqiuBean.setFirstlndustry(firstIndustry);
       
        //��Ԥ�����ݷ���session��
        HttpSession session = req.getSession();
        session.setAttribute("xuqiubean", xuqiuBean);
        System.out.println("��������"+xuqiuBean.getXuming());
     
        //session��֤ȡ��
        System.out.println("�û�"+session.getAttribute("xuqiubean"));
        
        //��ȡ�û���
        adminBean admin;
		admin = (adminBean) session.getAttribute("adminBean");
		System.out.println("�û���"+admin.getUsername());

		//�������ݿ�
		 adminDao.save(xuqiuBean,admin);
		
		//����jsp
		  resp.sendRedirect("index/CreateDemand.jsp?status=1");
		
		   
		   /*boolean flag = adminDao.checkReg(name);
			
		   if(flag){
				   adminDao.save(adminBean,admin);
				   System.out.println("�ɹ�");
				   resp.sendRedirect("index/CreateDemand.jsp?status=1");   
			 }
			else{
				System.out.println("ʧ��");
				resp.sendRedirect("index/CreateDemand.jsp?status=2");
			}*/	
	}
}
	
