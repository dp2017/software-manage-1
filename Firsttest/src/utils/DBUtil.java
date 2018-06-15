package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;



/**
 * 数据库工具类，用来连接数据库，执行SQL语句，关闭数据库连接等。
 * @version 1
 */
public class DBUtil {

	public DBUtil() {
	}
	
	 private static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 private  static String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=eshop";
	 private  static String userName="sa";
	 private  static String userPwd="123456";
	
	
	/**
	 * 返回一个数据库的连接对象的应用
	 * @return
	 */
	public static Connection getConnection(){
		 Connection dbConn=null;
		 try
		{
			Class.forName(driverName);
			//System.out.println("加载驱动成功！");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		try{
			dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
				//System.out.println("连接数据库成功！");
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("SQL Server连接失败！");
			JOptionPane.showMessageDialog(null,"连接数据库失败，请检查重试","错误",JOptionPane.ERROR_MESSAGE);
		}
		return dbConn;	
	}
	
	/**
	 * 关闭数据库的连接对象，SQL语句对象
	 * @param state sql语句对象
	 * @param con	数据库连接对象
	 */
	public static void close(Statement state,Connection con){
		if(state!=null){
			try {
				state.close();
			} catch (SQLException e) {
			}
		}
		
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
			}
	}
	
	/**
	 * 关闭数据库的连接对象，SQL语句对象，查询结果集对象
	 * 
	 * @param rs		结果集对象
	 * @param state		Statement对象
	 * @param con		Connection对象
	 */
	public static void close(ResultSet rs,java.sql.Statement state,Connection con){
		
		
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		if(state!=null)
			try {
				state.close();
			} catch (SQLException e) {
			}
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
			}
		
	}
	
	/**
	 * 对数据库执行曾删改操作
	 * @param sql		SQL语句
	 * @param params	SQL语句中的参数值
	 * @return			影响行
	 * @throws SQLException
	 */
	public static int update(String sql,Object...params ) throws SQLException
	{
		Connection conn = getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ParameterMetaData metaData = statement.getParameterMetaData();
		int count = metaData.getParameterCount();
		for(int i = 1; i <= count; i++)
		{
			statement.setObject(i, params[i-1]);
		}
		int update = statement.executeUpdate();
		close(statement,conn);
		return update;
	}
	
	/**
	 * 对数据库执行增删改操作，调用此方法一般用于执行事务
	 * @param conn			数据库连接
	 * @param sql			SQL语句
	 * @param params		SQL语句中的参数值
	 * @return				影响行
	 * @throws SQLException	
	 */
	public static int update(Connection conn,String sql,Object...params ) throws SQLException
	{
		PreparedStatement statement = conn.prepareStatement(sql);
		ParameterMetaData metaData = statement.getParameterMetaData();
		int count = metaData.getParameterCount();
		for(int i = 1; i <= count; i++)
		{
			statement.setObject(i, params[i-1]);
		}
		int update = statement.executeUpdate();
		close(statement,conn);
		return update;
	}
	
	/**
	 * 从数据库中查询数据的方法
	 * @param sql			SQL语句
	 * @param rsh			处理查询语句得到的结果集的对象，该对象需要实现ResultSetHanlder接口，该接口中定义了处理结果集的方法
	 * @param params		SQL语句中的参数个数
	 * @return				结果集处理方法处理之后的类型
	 * @throws SQLException
	 */
	public static <T> T query(String sql,ResultSetHanlder<T> rsh,Object...params) throws SQLException
	{
		Connection conn = getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ParameterMetaData metaData = statement.getParameterMetaData();
		int count = metaData.getParameterCount();
		for(int i = 1; i <= count; i++)
		{
			statement.setObject(i, params[i-1]);
		}
		ResultSet resultSet = statement.executeQuery();
		T resultSet2 = rsh.hanldResultSet(resultSet);
		close(resultSet,statement,conn);
		return resultSet2;
	}
	public static List<Map<String, Object>> queryToMapList(String sql,Object...params) throws SQLException
	{
		Connection conn = getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ParameterMetaData metaData = statement.getParameterMetaData();
		int count = metaData.getParameterCount();
		for(int i = 1; i <= count; i++)
		{
			statement.setObject(i, params[i-1]);
		}
		ResultSet resultSet = statement.executeQuery();
		List<Map<String, Object>> list = new MapListHanlder().hanldResultSet(resultSet);
		close(resultSet,statement,conn);
		return list;
	}
	
	public static interface ResultSetHanlder<T>{
		public T hanldResultSet(ResultSet rs) throws SQLException;
	}
	
	private static class MapListHanlder implements ResultSetHanlder<Object>{

		@Override
		public List<Map<String,Object>> hanldResultSet(ResultSet rs) throws SQLException {
			
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			for(int i = 1; i <= columnCount; i++)
			{
				Map<String,Object> map = new HashMap<String,Object>();
				map.put(metaData.getColumnName(i), rs.getObject(i));
				list.add(map);
			}
			return list;
		}
	}
}
