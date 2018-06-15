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
 * ���ݿ⹤���࣬�����������ݿ⣬ִ��SQL��䣬�ر����ݿ����ӵȡ�
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
	 * ����һ�����ݿ�����Ӷ����Ӧ��
	 * @return
	 */
	public static Connection getConnection(){
		 Connection dbConn=null;
		 try
		{
			Class.forName(driverName);
			//System.out.println("���������ɹ���");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
		try{
			dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
				//System.out.println("�������ݿ�ɹ���");
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("SQL Server����ʧ�ܣ�");
			JOptionPane.showMessageDialog(null,"�������ݿ�ʧ�ܣ���������","����",JOptionPane.ERROR_MESSAGE);
		}
		return dbConn;	
	}
	
	/**
	 * �ر����ݿ�����Ӷ���SQL������
	 * @param state sql������
	 * @param con	���ݿ����Ӷ���
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
	 * �ر����ݿ�����Ӷ���SQL�����󣬲�ѯ���������
	 * 
	 * @param rs		���������
	 * @param state		Statement����
	 * @param con		Connection����
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
	 * �����ݿ�ִ����ɾ�Ĳ���
	 * @param sql		SQL���
	 * @param params	SQL����еĲ���ֵ
	 * @return			Ӱ����
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
	 * �����ݿ�ִ����ɾ�Ĳ��������ô˷���һ������ִ������
	 * @param conn			���ݿ�����
	 * @param sql			SQL���
	 * @param params		SQL����еĲ���ֵ
	 * @return				Ӱ����
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
	 * �����ݿ��в�ѯ���ݵķ���
	 * @param sql			SQL���
	 * @param rsh			�����ѯ���õ��Ľ�����Ķ��󣬸ö�����Ҫʵ��ResultSetHanlder�ӿڣ��ýӿ��ж����˴��������ķ���
	 * @param params		SQL����еĲ�������
	 * @return				���������������֮�������
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
