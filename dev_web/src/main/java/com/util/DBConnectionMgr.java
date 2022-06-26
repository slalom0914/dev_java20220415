package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionMgr {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
	public static final String user = "scott";
	public static final String pw = "tiger";
	public Connection getConnection()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void freeConnection(ResultSet rs, PreparedStatement pstmt, Connection con){
		try {
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void freeConnection(PreparedStatement pstmt, Connection con){
		try {
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
