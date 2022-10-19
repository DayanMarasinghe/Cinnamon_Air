<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "cinnamon_air";
String userid="root";
String password="qwerty";
try{
	Class.forName(driver);
}catch(ClassNotFoundException e){
	e.printStackTrace();
}
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cinnamon Air Revenue System</title>
</head>
<body>

<div>
	<form>
		<div>
			<label>Flight Name:</label>
			<select id="fname" name="flname">
           <%
		try{
			con=DriverManager.getConnection(connectionUrl+database,userid,password);
			stmt=con.createStatement();
			String sql = "select flight_name from flight_info";
			rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
	
		%>
       		<option><%=rs.getString("flight_name") %></option>
       		<%
       		
       	
    }
	con.close();
	}catch (Exception e){
		e.printStackTrace();
	}
       		%>
       		
			</select>
		</div>
		<div>
			<label>Date:</label>
			<input type="date" name="date" required="">
		</div>
		<div>
			<label>Initial Revenue:</label>
			<input type="text" name="irev" required="">
		</div>
		<div>
			<label>Promo Code:</label>
			<select id="pcode" name="pcode">
			<%
		try{
			con=DriverManager.getConnection(connectionUrl+database,userid,password);
			stmt=con.createStatement();
			String sql = "select promo_code from promortional_info";
			rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
	
		%>
       		<option><%=rs.getString("promo_code") %></option>
       		<%
       		
       	
    }
	con.close();
	}catch (Exception e){
		e.printStackTrace();
	}
       		%>
			</select>
		</div>
		<div>
			<label>Total Revenue:</label>
			<input type="text" name="tot" readonly>
		</div>
		
		<input type="submit" name="submit" value="Submit">
		
	</form>



</div>
</body>
</html>