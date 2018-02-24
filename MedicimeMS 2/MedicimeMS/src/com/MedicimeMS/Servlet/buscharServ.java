package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Dao.buscharDao;
import com.MedicimeMS.Dao.customDao;

public class buscharServ extends HttpServlet {

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
        String page=request.getParameter("page");
		int pag=Integer.parseInt(page);
		
		JSONObject ob=null;
		JSONArray arry= new JSONArray();
		buscharDao  a= new buscharDao();
//		 System.out.println(value);
//		 System.out.println(type);
		
		int row=1 ;
		try {
			arry=a.custom2(pag);
//			System.out.println(value);
			ob=new JSONObject();
	    	 ob.put("total",a.custom().size());
	    	 ob.put("rows", arry);
//	    	 System.out.println(ob);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		 try {
//			 System.out.println(ob);
			 PrintWriter out = response.getWriter();
		        out.print(ob);
		        out.flush();
			    out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		 
		
	
	}

}

