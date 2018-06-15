package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.adminBean;
import Bean.powerBean;
import utils.DBUtil;

public class powerDao {
	private static Connection con;
	private static Statement state;
	private static ResultSet rs;

   
   
   
   public List<powerBean> list(){
		con = DBUtil.getConnection();
		state = null;
		rs = null;
		String sql="select age,xuguan,mima,jieshao,shenhe,chaxun,quanxian,tubiao from power";
		
		List<powerBean> jueseBeans = new ArrayList<powerBean>();
		
		try {
			state = con.createStatement();
			rs = state.executeQuery(sql);
			powerBean jueseBean;
			while(rs.next())
			{
				jueseBean=new powerBean();
				jueseBean.setAge(rs.getString("age"));
				jueseBean.setXuguan(Integer.parseInt(rs.getString("xuguan")));
				jueseBean.setMima(Integer.parseInt(rs.getString("mima")));
				jueseBean.setJieshao(Integer.parseInt(rs.getString("jieshao")));
				jueseBean.setShenhe(Integer.parseInt(rs.getString("shenhe")));
				jueseBean.setChaxun(Integer.parseInt(rs.getString("chaxun")));
				jueseBean.setQuanxian(Integer.parseInt(rs.getString("quanxian")));
				jueseBean.setTubiao(Integer.parseInt(rs.getString("tubiao")));
				
				jueseBeans.add(jueseBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, con);
		}
		
		return jueseBeans;
		
	}
   
   public static powerBean getnumber(String age){
	  powerBean powerbean = null;
	  String sql = "select * from power where age='" + age +"'" ;
		try {
			con = DBUtil.getConnection();
			state = con.createStatement();
			rs = state.executeQuery(sql);
			if (rs.next()) {
				String ae=rs.getString("age");
				int xuguan=rs.getInt("xuguan");
				int mima=rs.getInt("mima");
				int jieshao=rs.getInt("jieshao");
				int shenhe=rs.getInt("shenhe");
				int chaxun=rs.getInt("chaxun");
				int quanxian=rs.getInt("quanxian");
				int tubiao=rs.getInt("tubiao");
				powerbean = new powerBean(age,xuguan,mima,jieshao,shenhe,chaxun,quanxian,tubiao);
			}
		}catch (SQLException e) {
				e.printStackTrace();
			} finally {// ¹Ø±ÕÊý¾Ý¿â
				DBUtil.close(rs, state, con);
			}
	  
	   return powerbean;
   }
   
}
