package com.flight;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/revenueInsertServlet")
public class revenueInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String revenue_date = request.getParameter("date");
		Double initial_revenue = Double.parseDouble(request.getParameter("irev"));
		Double total_revenue = Double.parseDouble(request.getParameter("tot"));
		String flname = request.getParameter("flname");
		String pcode = request.getParameter("pcode");
		
		boolean isTrue;
		
		isTrue = flightDBUtil.insertInfo(revenue_date, initial_revenue, total_revenue, flname, pcode);
		
		if(isTrue==true) {
			RequestDispatcher dis = request.getRequestDispatcher("#");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("#");
			dis.forward(request, response);
		}
		
	}

}
