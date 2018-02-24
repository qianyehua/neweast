package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MedicimeMS.Dao.HospitalDao;
import com.MedicimeMS.Dao.ReportDao;
import com.MedicimeMS.Dao.StaffDao;
import com.MedicimeMS.Tool.PageNationUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class getDayReportServ extends HttpServlet {

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
		 int uid=Integer.parseInt(request.getParameter("uid"));
		 int hospitalid=Integer.parseInt(request.getParameter("hospitalid"));
		 
		 String sdate=request.getParameter("startdate");
		 String edate=request.getParameter("enddate");
		 
		 int amount=0;
		 JSONArray arr=new JSONArray();
		 JSONObject o=new JSONObject();
		 JSONArray arrpage=new JSONArray();
		
		 JSONArray arrStaff=new JSONArray();
		 
		 if(uid!=0){
			   arrStaff=new StaffDao().getStaffById(uid);
		 }
		 else{
		 
		    arrStaff=new StaffDao().getStaffByHospitalId(hospitalid);
			 
		 }

		 for(int i=1;i<arrStaff.size();i++){
			 JSONArray arrHos=new JSONArray();
			 if(hospitalid==0){
		     	arrHos=new HospitalDao().getHospitalByUserId(arrStaff.getJSONObject(i).getInt("id"));
			 
			 }
			 else{
		    	arrHos=new HospitalDao().getHospitalByHospitalId(hospitalid);
			 
			 }
			 if(arrStaff.size()>1){
			  for(int j=1;j<arrHos.size();j++){
				 if(arrHos.size()>1){
				  amount=new ReportDao().getUHReportBy(arrStaff.getJSONObject(i).getInt("id"),arrHos.getJSONObject(j).getInt("id"), sdate, edate);			                       		 
				  JSONObject ob=new JSONObject();
				  ob.put("staffname", arrStaff.getJSONObject(i).getString("text"));
				  ob.put("hospital", arrHos.getJSONObject(j).getString("text"));
				  ob.put("amount", amount);
				  arr.add(ob);
				 }
			  }
			 }
		 }

		 
		 arrpage= new PageNationUtil().getContent(arr, pagenumber, pagesize);
		 
			 o.put("total",arr.size());
			 o.put("rows", arrpage);
	    
		
		 PrintWriter out=response.getWriter();
	 
	     out.print(o);
	     out.flush();
		 out.close();
		 
		 
	}

}
