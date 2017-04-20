package util;

import annotation.Transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import java.sql.PreparedStatement;
import util.Constant;

public class DataProvider {
	private static Connection cnn;
	private static PreparedStatement st;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String nameServer = Constant.getDBConnection();
	
        @Transaction
	public static void open()
	{
		try {
			Class.forName(driver);
			Properties pro = new Properties();
			pro.put("user", Constant.getDBUsername());
			pro.put("password", Constant.getDBPassword());
			
			if(cnn != null && !cnn.isClosed()){
				cnn.close();
			}
			
			cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" 
			+ nameServer + "?useUnicode=true&characterEncoding=utf-8",pro);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
        @Transaction
	public static ResultSet query(String sql, Object... params){
		ResultSet rs = null;
		try {
			st = (PreparedStatement) cnn.prepareStatement(sql);
			if(params.length != 0){
				for(int i = 0; i < params.length; i++){
					st.setObject(i + 1, params[i]);
				}
			}
			
			rs = st.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static int executeNonQuery(String sql, Object... params){
		int count = 0;
		try {
			st = (PreparedStatement) cnn.prepareStatement(sql);
			if(params.length != 0){
				for(int i = 0; i < params.length; i++){
					st.setObject(i + 1, params[i]);
				}
			}
			
			return st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
        
        @Transaction
	public static int insertGetAutoKey(String sql, Object... params){
		int generateKey = 0;
		try {
			st = (PreparedStatement) cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if(params.length != 0){
				for(int i = 0; i < params.length; i++){
					st.setObject(i + 1, params[i]);
				}
			}
			
			st.executeUpdate();
			
			ResultSet resultSet = st.getGeneratedKeys();
			
			while(resultSet.next()){
				generateKey = resultSet.getInt(1);
			}
			
			return generateKey;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return generateKey;
	}
	
	
        @Transaction
	public static void close()
	{
		try {
			cnn.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the cnn
	 */
	public static Connection getConnection() {
		return cnn;
	}
}
