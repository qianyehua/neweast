package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Dao.photoDao;

public class getPhotoServ extends HttpServlet {

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

		JSONObject ob=null;
		JSONArray arry= new JSONArray();
		photoDao a =new photoDao();
//		int id;
//		String sdate,edate;
		String role=(String)request.getParameter("roleid");
		String user=request.getParameter("userid");
	     String sdate=request.getParameter("startdate");
	     String edate=request.getParameter("enddate");
		 int userid=Integer.parseInt(user);
	     int id=Integer.parseInt(request.getParameter("other1"));
	     int page=Integer.parseInt(request.getParameter("page"));
 
	     if(role.equals("管理员")||role.equals("部门经理")){
		     try {
		    	   arry=a.getPhotoInfoById2(page,id,sdate,edate);
	//				System.out.println(value);
					ob=new JSONObject();
			    	 ob.put("total",a.getPhotoInfoById(id,sdate,edate).size());
			    	 ob.put("rows", arry);
				} catch (Exception e) {
					// TODO: handle exception
				}
	     }
	     else{
	    	 try {
		    	   arry=a.getPhotoInfoByIdB2(userid,page,id,sdate,edate);
	//				System.out.println(value);
					ob=new JSONObject();
			    	 ob.put("total",a.getPhotoInfoByIdB(userid,id,sdate,edate).size());
			    	 ob.put("rows", arry);
				} catch (Exception e) {
					// TODO: handle exception
				}
	     }
			 try {
//				 System.out.println(ob);
				 PrintWriter out = response.getWriter();
			        out.print(ob);
			        out.flush();
				    out.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
	    
		
	}

}
