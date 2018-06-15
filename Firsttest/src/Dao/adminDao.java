package Dao;

import utils.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import Bean.XuqiuBean;
import Bean.adminBean;

public class adminDao {
	
	private static Connection con;
	private static Statement state;
	private static ResultSet rs;

	public adminDao() {
	}
	
	public static adminBean checkLogin(String username, String password){
		adminBean admin = null;
		
		String sql = "select * from admin where username='" + username +"'" ;
		// System.out.println(new
		// java.util.Date().toLocaleString()+"\t��ѯ���ݿ�:"+sql);
		try {
			con = DBUtil.getConnection();
			state = con.createStatement();
			rs = state.executeQuery(sql);
			if (rs.next()) {
				// �û�������
				
				String passwd = rs.getString("password");
				
				if (passwd.equals(/* password */password)) {
					// ������֤�ɹ�

					int id = rs.getInt("id");
					String userne=rs.getString("username");
					String name=rs.getString("name");
					String age=rs.getString("age");
					admin = new adminBean();
					admin.setUsername(userne);
					admin.setId(id);
					admin.setName(name);
					admin.setPassword(passwd);
					admin.setAge(age);
				
					// System.out.println(new
					// java.util.Date().toLocaleString()+"\t�û���ݺ˶Գɹ�");
				} else {
					
					System.out.print(new java.util.Date().toLocaleString() + "\t�����֤ʧ��.....\t");
					// System.out.println(passwd+" should be "+md5Code);
				}
			}else{
				admin = new adminBean();
			    System.out.println("�û�������ȷ");
				admin.setUsername("x");
				admin.setId(00);
				admin.setName("x");
				admin.setPassword("x");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {// �ر����ݿ�
			DBUtil.close(rs, state, con);
		}

		return admin;
	}
  
	

	public adminBean getByusername(String usernam){
		String sql="select * from admin where username ='"+usernam+"'";
		Connection  con =DBUtil.getConnection();
		adminBean adminbean = null ;
		Statement st=null;
		ResultSet rs = null;
		try {
			state = con.createStatement();
			rs = state.executeQuery(sql);
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String sex = rs.getString("sex");
				String Gshi = rs.getString("Gshi");
				String danwei = rs.getString("danwei");
				
				String zhuanye = rs.getString("zhuanye");
				String hangye = rs.getString("hangye");
				String jiaoyu = rs.getString("jiaoyu");
				String zhicheng = rs.getString("zhicheng");
				String tongxun = rs.getString("tongxun");
				String youbian = rs.getString("youbian");
				
				String guhua = rs.getString("guhua");
				String youxiang = rs.getString("youxiang");
				String qq = rs.getString("qq");
				String msn = rs.getString("msn");
				 adminbean = new adminBean(id,username, name, password, sex,Gshi,danwei,zhuanye,hangye,jiaoyu,zhicheng,tongxun,youbian,guhua,youxiang,qq,msn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, con);
		}
		return adminbean;
		
	}
	public adminBean getById(int id) {

		String sql = "select * from admin where id = " + id;
		Connection con = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		adminBean adminBean = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id1 = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String address =rs.getString("address");
				String chewei = rs.getString("chewei");//��λ���
				String sex = rs.getString("sex");
				String age = rs.getString("age");
				String cheliang = rs.getString("cheliang");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, st, con);
		}
		return adminBean;
	}

	
	/**
	 * �����û����Ƿ��Ѿ����ڣ����û�ע���ʱ�����
	 * 
	 * @param name
	 *            �û���
	 * @return ����û������ڣ�����false�����򷵻�true
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
	 * �����û���Ϣ
	 * 
	 * @param adminBean
	 */
	public void save(adminBean adminBean) {
		String sql = "insert into admin(id,name,username,password,sex,Gshi,danwei,zhuanye,hangye,jiaoyu,zhicheng,tongxun,youbian,guhua,youxiang,qq,msn) values('" 
	                    +adminBean.getId()+"','"+adminBean.getName()+"','"+ adminBean.getUsername()+ "','" +
				         adminBean.getPassword() + "','"  + adminBean.getSex()+"','"+adminBean.getGshi()+"','"+adminBean.getDanwei()+"','"+
				         adminBean.getZhuanye()+"','"+adminBean.getHangye()+"','"+adminBean.getJiaoyu()+"','"+adminBean.getZhicheng()+"','"+
				         adminBean.getTongxun()+"','"+adminBean.getYoubian()+"','"+adminBean.getGuhua()+"','"+adminBean.getYouxiang()+"','"+
				         adminBean.getQq()+"','"+adminBean.getMsn()+"')";
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
	 * ��ѯ�û�����
	 * 
	 * @return
	 */
	public int getCount() {
		ResultSet rs = null;
		Statement state = null;
		Connection con = null;
		int size = 0;
		con = DBUtil.getConnection();
		try {
			state = con.createStatement();
			rs = state.executeQuery("select count(*) count from admin");
			if (rs.next())
				size = rs.getInt("count");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, con);
		}

		return size;
	}
	
	public List<adminBean> getListByPage(int start, int size) {
		// System.out.println(new
		// Date().toLocaleString()+"\tAdminDao.getListByPage()ִ�п�ʼ��");
		String sql = "select top " + (size) + " * from admin where id not in ( select top " + (start)
				+ " id from admin)";

		Connection con = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<adminBean> adminBeans = new ArrayList<adminBean>();

		try {
			statement = con.createStatement();
			// System.out.println(new Date().toLocaleString()+"\tִ�У�"+sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String address =resultSet.getString("address");
				String chewei = resultSet.getString("chewei");//��λ���
				String sex = resultSet.getString("sex");
				String age = resultSet.getString("age");
				String cheliang = resultSet.getString("cheliang");

				
				//adminBeans.add(new adminBean(id,address, username, password, chewei, age,sex,cheliang));
				// System.out.println(adminBeans+"����");
			}
			// System.out.println(new
			// Date().toLocaleString()+"\t��ѯ�ɹ�����ѯ���"+adminBeans.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, con);
			// System.out.println(new
			// Date().toLocaleString()+"\tAdminDao.getListByPage()ִ�н�����");
		}
		return adminBeans;
	}
	
	public void delete(int id) {
		String sql = "delete from admin where id=" + id;

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
	
}
