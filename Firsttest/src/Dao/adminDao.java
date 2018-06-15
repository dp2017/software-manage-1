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
		// java.util.Date().toLocaleString()+"\t查询数据库:"+sql);
		try {
			con = DBUtil.getConnection();
			state = con.createStatement();
			rs = state.executeQuery(sql);
			if (rs.next()) {
				// 用户名存在
				
				String passwd = rs.getString("password");
				
				if (passwd.equals(/* password */password)) {
					// 密码验证成功

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
					// java.util.Date().toLocaleString()+"\t用户身份核对成功");
				} else {
					
					System.out.print(new java.util.Date().toLocaleString() + "\t身份认证失败.....\t");
					// System.out.println(passwd+" should be "+md5Code);
				}
			}else{
				admin = new adminBean();
			    System.out.println("用户名不正确");
				admin.setUsername("x");
				admin.setId(00);
				admin.setName("x");
				admin.setPassword("x");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {// 关闭数据库
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
				String chewei = rs.getString("chewei");//车位编号
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
	 * 检查该用户名是否已经存在，当用户注册的时候调用
	 * 
	 * @param name
	 *            用户名
	 * @return 如果用户名存在，返回false，否则返回true
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
			// Date())+"\t执行AdminDao.checkReg()");
			// System.out.println(DateUtil.getDateStr(new
			// Date())+"\t执行sql语句："+sql);
			while (rs.next()) {
				String username = rs.getString("username");
				// System.out.println(DateUtil.getDateStr(new
				// Date())+"\t比较"+name+"与"+username);
				if (Username.equals(username)||Username==""){
					System.out.println("错误");
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
	 * 保存用户信息
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
			// Date().toLocaleString()+"\t"+adminBean.getUsername()+"保存成功！");
		} catch (Exception e) {
			// System.out.println(new
			// Date().toLocaleString()+"\t"+adminBean.getUsername()+"保存失败！");
			e.printStackTrace();
		} finally {
			DBUtil.close(state, con);
		}
	}
	/**
	 * 查询用户数量
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
		// Date().toLocaleString()+"\tAdminDao.getListByPage()执行开始！");
		String sql = "select top " + (size) + " * from admin where id not in ( select top " + (start)
				+ " id from admin)";

		Connection con = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<adminBean> adminBeans = new ArrayList<adminBean>();

		try {
			statement = con.createStatement();
			// System.out.println(new Date().toLocaleString()+"\t执行："+sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String address =resultSet.getString("address");
				String chewei = resultSet.getString("chewei");//车位编号
				String sex = resultSet.getString("sex");
				String age = resultSet.getString("age");
				String cheliang = resultSet.getString("cheliang");

				
				//adminBeans.add(new adminBean(id,address, username, password, chewei, age,sex,cheliang));
				// System.out.println(adminBeans+"测试");
			}
			// System.out.println(new
			// Date().toLocaleString()+"\t查询成功！查询结果"+adminBeans.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, con);
			// System.out.println(new
			// Date().toLocaleString()+"\tAdminDao.getListByPage()执行结束！");
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
