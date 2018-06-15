package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.XuqiuBean;
import Bean.adminBean;
import utils.DBUtil;

public class shenheDao {
	
	
	//列出用户所有未审核需求（成功）
		public List<XuqiuBean> list() {
			String sql = "select * from [Xuqiu] where status=0";
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
		//按条件列出需求(成功)
		public static List<XuqiuBean> list(String status,String pass,
				  String[]leixing,String[]inputlx,String []han,String []jingque,int m) {
			int k=1;
			String sum = "";

			for(k=1;k<=m;k++){
			if(han[k].equals("NOT")){
				if(jingque[k].equals("like")){
					  // System.out.println("not中等于like的时候"+jingque[k]);
					      sum=sum+" "+" and "+leixing[k]+" not "+jingque[k]+" '%"+inputlx[k]+"%' ";
					      }
				       else{
				    	 // System.out.println("not中不等于like的时候"+jingque[k]);
				    	  sum=sum+" and "+leixing[k]+"!"+jingque[k]+"'"+inputlx[k]+"'";
				       }	
			}
			else   {if(jingque[k].equals("like")){
				   //System.out.println("等于like的时候"+jingque[k]);
				      sum=sum+" "+han[k]+" "+leixing[k]+" "+jingque[k]+" '%"+inputlx[k]+"%'";}
			       else{
			    	 // System.out.println("不等于like的时候"+jingque[k]);
			    	  sum=sum+han[k]+" "+leixing[k]+jingque[k]+"'"+inputlx[k]+"'";
			       }	
			}
			
		}		
			
		String sql = "select * from [Xuqiu] where  status='"+status+"' and pass='"+pass+"'"+sum;
		System.out.println(sql);	
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
		
}
