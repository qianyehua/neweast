package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Dao.PlaFinDao;
import com.MedicimeMS.Dao.VisFinDao;

public class PlaFinServ extends HttpServlet {

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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String role=(String)request.getParameter("roleid");
		String user=request.getParameter("userid");
		String value=(String)request.getParameter("value");
		String staffid=request.getParameter("other1");
		String hosid=request.getParameter("other2");
//		String type=(String)request.getParameter("type");
        String page=request.getParameter("page");
        String sdate=request.getParameter("startdate");
	    String edate=request.getParameter("enddate");
	    int roleid=Integer.parseInt(role);
	    int userid=Integer.parseInt(user);
		int pag=Integer.parseInt(page);
		int other1=Integer.parseInt(staffid);
		int other2=Integer.parseInt(hosid);
		
		JSONObject ob=null;
		JSONArray arry= new JSONArray();
		PlaFinDao  a= new PlaFinDao();
//		 System.out.println(value);
//		 System.out.println(type);
		if(roleid==11||roleid==24||roleid==12||roleid==13){
		try {
			arry=a.findplan2(pag,other1,other2,value,sdate,edate);
			
			ob=new JSONObject();
	    	 ob.put("total",a.findplan(other1,other2,value,sdate,edate).size());
	    	 ob.put("rows", arry);
//	    	 System.out.println(ob);
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
		else{
			try {
				arry=a.findplanB2(pag,userid, other2, value, sdate, edate);
				ob=new JSONObject();
		    	 ob.put("total",a.findplanB(userid,other2,value,sdate,edate).size());
		    	 ob.put("rows", arry);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		 try {
			 PrintWriter out = response.getWriter();
		        out.print(ob);
		        out.flush();
			    out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		 
		
	
	}

}
