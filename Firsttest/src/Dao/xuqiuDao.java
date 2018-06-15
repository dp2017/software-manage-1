package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Bean.XuqiuBean;
import Bean.adminBean;
import utils.DBUtil;

public class xuqiuDao {
	private static Connection con;
	private static Statement state;
	private static ResultSet rs;
	
	//�������
	public static void shenhe(int id,String status,String pass){
		
		String sql="update Xuqiu set pass='"+pass+"',status='"+status+"' where id="+id+"";
	    System.out.println(sql);
		try{
	    	con = DBUtil.getConnection();
			state = con.createStatement();
			state.execute(sql);
			 
					
	    } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, con);
		}
	
	}
	
	//�������
	public static  void update(adminBean admin,XuqiuBean xuqiu){
		String sql="update Xuqiu set name='"+xuqiu.getName()+"',gguan='"+xuqiu.getGguan()+"',address='"+xuqiu.getAddress()+
				"',saddress='"+xuqiu.getSaddress()+"',web='"+xuqiu.getWeb()+"',email='"+xuqiu.getEmail()+"',represent='"+xuqiu.getRepresent()+
				"',zipcode='"+xuqiu.getZipcode()+"',phone='"+xuqiu.getPhone()+"',telephone='"+xuqiu.getTelephone()+"',xuming='"+xuqiu.getXuming()+
				"',chuanzhen='"+xuqiu.getChuanzhen()+"',shuxing='"+xuqiu.getShuxing()+"',jianjie='"+xuqiu.getJianjie()+"',theme='"+xuqiu.getThem()+
				"',money='"+xuqiu.getMoney()+"',key1='"+xuqiu.getKey1()+"',type='"+xuqiu.getType()+"',firstSubjects='"+xuqiu.getFirstSubjects()+
				"',model='"+xuqiu.getModel()+"',servics='"+xuqiu.getServic()+"',firstIndustry='"+xuqiu.getFirstlndustry()+"',lianxiren='"+xuqiu.getLianxiren()+
				"',status='"+0+"',pass='"+0+"',create_date="+"getdate()"+" where username='"+admin.getUsername()+"' and xuming='"+xuqiu.getXuming()+"'";
	       Connection con = DBUtil.getConnection();
	       try {
				Statement state = con.createStatement();
				state.execute(sql);
				// System.out.println(new
				// Date().toLocaleString()+"\t"+adminBean.getUsername()+"����ɹ���");
			} catch (Exception e) {
				// System.out.println(new
				// Date().toLocaleString()+"\t"+adminBean.getUsername()+"����ʧ�ܣ�");
				e.printStackTrace();
			} finally {
				DBUtil.close(state, con);
			}
	       
	       
	}
	
	
	
	
	//���νṹ������
	public static List<XuqiuBean> choosexu(String jibie) {
		String sql = "select * from [Xuqiu] where firstSubjects='"+jibie+"'";
		Connection conn = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		List<XuqiuBean> xuqiuBeans = new ArrayList<XuqiuBean>();

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			XuqiuBean xuqiuBean;
			while (resultSet.next()) {
				xuqiuBean = new XuqiuBean();
				
				xuqiuBean.setUsername(resultSet.getString("username"));
				xuqiuBean.setName(resultSet.getString("name"));
				xuqiuBean.setAddress(resultSet.getString("address"));
				xuqiuBean.setXuming(resultSet.getString("xuming"));
				xuqiuBean.setRepresent(resultSet.getString("represent"));
				xuqiuBean.setFirstSubjects(resultSet.getString("firstSubjects"));
				xuqiuBean.setId(resultSet.getString("id"));
				xuqiuBean.setCreateDate(resultSet.getString("create_date"));
				xuqiuBeans.add(xuqiuBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, conn);
		}

		return xuqiuBeans;
	}
	
	/**
	 * ���������Ƿ��Ѿ����ڣ���ע���ʱ�����
	 * 
	 * @param name
	 *            
	 * @return ���������ڣ�����false�����򷵻�true
	 */
	public boolean checkReg(String Username) {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			String sql = "select username from admin ";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			// System.out.println(DateUtil.getDateStr(new
			// Date())+"\tִ��AdminDao.checkReg()");
			// System.out.println(DateUtil.getDateStr(new
			// Date())+"\tִ��sql��䣺"+sql);
			while (rs.next()) {
				String username = rs.getString("username");
				// System.out.println(DateUtil.getDateStr(new
				// Date())+"\t�Ƚ�"+name+"��"+username);
				if (Username.equals(username)||Username==""){
					System.out.println("����");
					return false;
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, st, conn);
		}
		return true;
	}
	
	/**
	 * ����������Ϣ
	 * 
	 * @param adminBean
	 */
	public void save(XuqiuBean adminBean,adminBean admin) {
		HttpServletRequest request = null;
		String sql = "insert into Xuqiu(username,name,gguan,address,saddress,web,email,represent,zipcode,lianxiren,phone,telephone,"
				+ "xuming,chuanzhen,shuxing,jianjie,theme,money,key1,type,firstSubjects,model,servics,firstIndustry,status,pass,create_date) "
				+ "values('" 
				     +admin.getUsername()+"','" +adminBean.getName()+"','"+adminBean.getGguan()+"','"+
				     adminBean.getAddress()+"','"+ adminBean.getSaddress()+"','"+adminBean.getWeb()+ "','" +
				         adminBean.getEmail() + "','"  + adminBean.getRepresent()+"','"+adminBean.getZipcode()+"','"+
				         adminBean.getLianxiren()+"','"+adminBean.getPhone()+"','"+adminBean.getTelephone()+"','"+
				         adminBean.getXuming()+"','"+adminBean.getChuanzhen()+"','"+adminBean.getShuxing()+"','"+
				         adminBean.getJianjie()+"','"+adminBean.getThem()+"','"+adminBean.getMoney()+"','"+adminBean.getKey1()+"','"+
	                    adminBean.getType()+"','"+adminBean.getFirstSubjects()+"','"+adminBean.getModel()+"','"+
				         adminBean.getServic()+"','"+ adminBean.getFirstlndustry()+"','"+0+"','"+0+"',getdate() )";
		// System.out.println(new Date().toLocaleString()+"\t"+sql);
		Connection con = DBUtil.getConnection();
		Statement state = null;
		try {
			state = con.createStatement();
			state.execute(sql);
			// System.out.println(new
			// Date().toLocaleString()+"\t"+adminBean.getUsername()+"����ɹ���");
		} catch (Exception e) {
			// System.out.println(new
			// Date().toLocaleString()+"\t"+adminBean.getUsername()+"����ʧ�ܣ�");
			e.printStackTrace();
		} finally {
			DBUtil.close(state, con);
		}
	}
	
	/**
	 * ��ѯ��������
	 * 
	 * @return
	 */
	public int getCount() {
		ResultSet rs = null;
		Statement state = null;
		Connection con = null;
		int size = 0;
		con = DBUtil.getConnection();
		//��ȡsession
		HttpServletRequest request = null;
	    adminBean admin=(adminBean) request.getSession().getAttribute("adminBean");
		System.out.println(admin.getUsername());
		String username=admin.getUsername();
		try {
			state = con.createStatement();
			rs = state.executeQuery("select count(*) count from Xuqiu where username = '"+username+"'");
			if (rs.next())
				size = rs.getInt("count");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, con);
		}
		return size;
	}
	
	
	
	//�������г�����(�ɹ�)
	public static List<XuqiuBean> list(adminBean admin,String status,String pass,
			  String[]leixing,String[]inputlx,String []han,String []jingque,int m) {
		int k=1;
		String sum = "";

		for(k=1;k<=m;k++){
		if(han[k].equals("NOT")){
			if(jingque[k].equals("like")){
				  // System.out.println("not�е���like��ʱ��"+jingque[k]);
				      sum=sum+" "+" and "+leixing[k]+" not "+jingque[k]+" '%"+inputlx[k]+"%' ";
				      }
			       else{
			    	 // System.out.println("not�в�����like��ʱ��"+jingque[k]);
			    	  sum=sum+" and "+leixing[k]+"!"+jingque[k]+"'"+inputlx[k]+"'";
			       }	
		}
		else   {if(jingque[k].equals("like")){
			   //System.out.println("����like��ʱ��"+jingque[k]);
			      sum=sum+" "+han[k]+" "+leixing[k]+" "+jingque[k]+" '%"+inputlx[k]+"%'";}
		       else{
		    	 // System.out.println("������like��ʱ��"+jingque[k]);
		    	  sum=sum+han[k]+" "+leixing[k]+jingque[k]+"'"+inputlx[k]+"'";
		       }	
		}
		
	}		
		
	String sql = "select * from [Xuqiu] where username='"+admin.getUsername()+
			"'and status='"+status+"'and pass='"+pass+"'"+sum;
		Connection conn = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		List<XuqiuBean> xuqiuBeans = new ArrayList<XuqiuBean>();

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			XuqiuBean xuqiuBean;
			while (resultSet.next()) {
				xuqiuBean = new XuqiuBean();
				xuqiuBean.setUsername(resultSet.getString("username"));
				xuqiuBean.setName(resultSet.getString("name"));
				xuqiuBean.setAddress(resultSet.getString("address"));
				xuqiuBean.setFirstSubjects(resultSet.getString("firstSubjects"));
				xuqiuBean.setXuming(resultSet.getString("xuming"));
				xuqiuBean.setRepresent(resultSet.getString("represent"));
				xuqiuBean.setId(resultSet.getString("id"));
				xuqiuBean.setStatus(resultSet.getString("status"));
				xuqiuBean.setPass(resultSet.getString("pass"));
				xuqiuBean.setCreateDate(resultSet.getString("create_date"));
				xuqiuBeans.add(xuqiuBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, conn);
		}

		return xuqiuBeans;
	}
	
	
	//�г��û��������󣨳ɹ���
	public List<XuqiuBean> list(adminBean admin) {
		String sql = "select * from [Xuqiu] where username='"+admin.getUsername()+"' ";
		Connection conn = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		List<XuqiuBean> xuqiuBeans = new ArrayList<XuqiuBean>();

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			XuqiuBean xuqiuBean;
			while (resultSet.next()) {
				xuqiuBean = new XuqiuBean();
				xuqiuBean.setUsername(resultSet.getString("username"));
				xuqiuBean.setName(resultSet.getString("name"));
				xuqiuBean.setAddress(resultSet.getString("address"));
				xuqiuBean.setFirstSubjects(resultSet.getString("firstSubjects"));
				xuqiuBean.setXuming(resultSet.getString("xuming"));
				xuqiuBean.setRepresent(resultSet.getString("represent"));
				xuqiuBean.setId(resultSet.getString("id"));
				xuqiuBean.setStatus(resultSet.getString("status"));
				xuqiuBean.setPass(resultSet.getString("pass"));
				xuqiuBean.setCreateDate(resultSet.getString("create_date"));
				xuqiuBeans.add(xuqiuBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, conn);
		}

		return xuqiuBeans;
	}

	/*
     * ɾ���û����󣨳ɹ���
    */
	public void delete(int id){
		String sql = "delete from Xuqiu where id=" + id;
		Connection con = DBUtil.getConnection();
		Statement state = null;
		try {
			state = con.createStatement();
			state.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(state, con);
		}
	}
	
	 
	// ͨ��Id��������������
		public XuqiuBean getBYxuqiuid(String id){
			String sql="select * from [Xuqiu] where id=" + id;
			Connection conn = DBUtil.getConnection();
			Statement statement = null;
			ResultSet resultSet = null;
			
			XuqiuBean xuqiuBean = new XuqiuBean();
			try {
				statement = conn.createStatement();
				resultSet = statement.executeQuery(sql);
				
				while (resultSet.next()) {
					xuqiuBean.setId(resultSet.getString("id"));
					xuqiuBean.setUsername(resultSet.getString("username"));
					xuqiuBean.setName(resultSet.getString("name"));
					xuqiuBean.setGguan(resultSet.getString("gguan"));
					xuqiuBean.setAddress(resultSet.getString("address"));
					xuqiuBean.setSaddress(resultSet.getString("saddress"));
					xuqiuBean.setWeb(resultSet.getString("web"));
					xuqiuBean.setEmail(resultSet.getString("email"));
					xuqiuBean.setRepresent(resultSet.getString("represent"));
					xuqiuBean.setZipcode(resultSet.getString("zipcode"));
					xuqiuBean.setPhone(resultSet.getString("phone"));
					xuqiuBean.setTelephone(resultSet.getString("telephone"));
					xuqiuBean.setXuming(resultSet.getString("xuming"));
					xuqiuBean.setChuanzhen(resultSet.getString("chuanzhen"));
					xuqiuBean.setShuxing(resultSet.getString("shuxing"));
					xuqiuBean.setJianjie(resultSet.getString("jianjie"));
					xuqiuBean.setThem(resultSet.getString("theme"));
					xuqiuBean.setMoney(resultSet.getString("money"));
					xuqiuBean.setKey1(resultSet.getString("key1"));
					xuqiuBean.setType(resultSet.getString("type"));
					xuqiuBean.setFirstSubjects(resultSet.getString("firstSubjects"));
					xuqiuBean.setModel(resultSet.getString("model"));
					xuqiuBean.setServic(resultSet.getString("servics"));
					xuqiuBean.setFirstlndustry(resultSet.getString("firstIndustry"));
					xuqiuBean.setLianxiren(resultSet.getString("lianxiren"));
					xuqiuBean.setStatus(resultSet.getString("status"));
					xuqiuBean.setPass(resultSet.getString("pass"));
					xuqiuBean.setCreateDate(resultSet.getString("create_date"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(resultSet, statement, conn);
			}
			return xuqiuBean;
			
		}
	
	
    
	//�г�����ʧ��
	public List<XuqiuBean> getListByPage(int start, int size) {
		// System.out.println(new
		// Date().toLocaleString()+"\tAdminDao.getListByPage()ִ�п�ʼ��");
		String sql = "select top " + (size) + " * from admin where id not in ( select top " + (start)
				+ " id from admin)";

		Connection con = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<XuqiuBean> adminBeans = new ArrayList<XuqiuBean>();

		try {
			statement = con.createStatement();
			// System.out.println(new Date().toLocaleString()+"\tִ�У�"+sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				adminBeans.add(new XuqiuBean());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, con);
			// System.out.println(new
			// Date().toLocaleString()+"\tAdminDao.getListByPage()ִ�н�����");
		}
		return adminBeans;
	}
}
