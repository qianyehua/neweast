package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MedicimeMS.Dao.DeptDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class getDeptServ extends HttpServlet {

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
	    
        String pag=request.getParameter("page"); 
        int page=Integer.parseInt(pag);
         JSONObject ob=new JSONObject();
	     JSONArray arry=new JSONArray();
	     DeptDao a=new DeptDao();
	     
	     try {
				arry=a.getDeptByUId2(page);
				
				ob=new JSONObject();
		    	 ob.put("total",a.getDeptByUId().size());
		    	 ob.put("rows", arry);
//		    	 System.out.println(ob);
			} catch (Exception e) {
				// TODO: handle exception
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
