package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MedicimeMS.Dao.StaffDao;

import net.sf.json.JSONArray;

public class getAllStaffServ extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out=response.getWriter();
		 int staffid=Integer.parseInt(request.getParameter("id"));
         int userid=Integer.parseInt(request.getParameter("userid"));
         if(userid==0){
		     JSONArray arrayHos=new StaffDao().getStaffById(staffid);
		     out.print(arrayHos);
         }
         else{
        	 JSONArray arrayHos2=new StaffDao().getStaffById2(staffid,userid);
        	 out.print(arrayHos2);
         }
		
		 
	    
	     out.flush();
		 out.close();
	}

}
