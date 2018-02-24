package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Dao.MesFinDao;
import com.MedicimeMS.Dao.PlaFinDao;

public class MesFinServ extends HttpServlet {

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
		String staffid=request.getParameter("other1");
		String hosid=request.getParameter("other2");
		String type=(String)request.getParameter("other3");
        String page=request.getParameter("page");
        String sdate=request.getParameter("startdate");
	    String edate=request.getParameter("enddate");
	    int roleid=Integer.parseInt(role);
	    int userid=Integer.parseInt(user);
		int pag=Integer.parseInt(page);
		int other1=Integer.parseInt(staffid);
		int other2=Integer.parseInt(hosid);
		int other3=Integer.parseInt(type);
		
		JSONObject ob=null;
		JSONArray arry= new JSONArray();
		MesFinDao  a= new MesFinDao();
//		 System.out.println(value);
//		 System.out.println(type);
//		System.out.println(sdate);
//		System.out.println(edate);
		if(roleid==11||roleid==24){
			try {
				arry=a.findmess2(pag,other1,other2,other3,sdate,edate);
	//			System.out.println(arry);
				ob=new JSONObject();
		    	 ob.put("total",a.findmess(other1,other2,other3,sdate,edate).size());
		    	 ob.put("rows", arry);
	//	    	 System.out.println(ob);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else{
			try {
				arry=a.findmessB2(pag,userid,other2,other3,sdate,edate);
	//			System.out.println(arry);
				ob=new JSONObject();
		    	 ob.put("total",a.findmessB(userid,other2,other3,sdate,edate).size());
		    	 ob.put("rows", arry);
	//	    	 System.out.println(ob);
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
