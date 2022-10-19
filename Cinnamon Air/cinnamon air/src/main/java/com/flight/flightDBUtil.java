package com.flight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class flightDBUtil {

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	public static boolean isSuccess;
	
	public static boolean insertInfo(String revenue_date,Double initial_revenue,Double total_revenue,String promo_code,String flight_name/*,int flight_no,int promo_no*/) {
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "insert into revenue_info values(0,'"+revenue_date+"','"+initial_revenue+"','"+total_revenue+"','"+flight_no+"''"+promo_no+"')";
		    int rs = stmt.executeUpdate(sql);
		    
		    if(rs>0) 
		    	isSuccess=true;
		    else
		    	isSuccess=false;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
}
