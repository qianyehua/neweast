package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MedicimeMS.Dao.StaffDao;
import com.MedicimeMS.Tool.PageNationUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class getStaffMonthReportServ extends HttpServlet {

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
	    

		 int pagesize= Integer.parseInt(request.getParameter("pagesize"));
		 int pagenumber= Integer.parseInt(request.getParameter("pagenumber"));
		 
		 int staffid=Integer.parseInt(request.getParameter("uid"));
		 
		 String year=request.getParameter("year");
		  
		  
		 JSONArray arrayStaff=new StaffDao().getStaffById(staffid);
		 JSONArray array=new JSONArray();
		 
		 for(int i=1;i<arrayStaff.size();i++){
			 array.add(new StaffDao().getVisitAmountByUserId(arrayStaff.getJSONObject(i).getInt("id"),year,arrayStaff.getJSONObject(i).getString("text")));
		 } 
		 JSONArray arrpage=new PageNationUtil().getContent(array, pagenumber, pagesize);
	    
		 JSONObject o=new JSONObject();
		  o.put("total",array.size());
		  o.put("rows", arrpage);
	      PrintWriter out=response.getWriter();
		 
		     out.print(o);
		     out.flush();
			 out.close();
	   
	}

}
