package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Dao.FunctionDao;

public class FunctionServ extends HttpServlet {

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

		response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		
		JSONArray Allarray=new JSONArray();
		JSONArray SArray=null;
		
		JSONArray Parray=new JSONArray();
		JSONArray Carray=new JSONArray();
		FunctionDao fs=new FunctionDao();
		
		try {
			Parray=fs.funlist();
			
		} catch (Exception e) {
			System.out.println("´íÎó1");
		}
		
		try {
			Carray=fs.funlist2();
		} catch (Exception e) {
			System.out.println("´íÎó2");
		}
		
		
		for(int i=0;i<Parray.size();i++){
			JSONObject ob1=new JSONObject();
			ob1=(JSONObject) Parray.get(i);
			 SArray=new JSONArray();
			for(int j=0;j<Carray.size();j++){
				
				
				JSONObject ob2=new JSONObject();
				
				ob2=(JSONObject) Carray.get(j);
				int Pid=ob1.getInt("pid");
				int id=ob2.getInt("pid");

				if((10*id)==Pid){
					SArray.add(ob2);
//					System.out.println("===========");
//					System.out.println(ob2);
					
				};
				
			}
			ob1.put("children", SArray);
		  Allarray.add(Parray.get(i));
		}
		
//		System.out.println("++++++++++++++++");
//		System.out.println(Allarray);
		PrintWriter out = response.getWriter();
		out.print(Allarray);
		out.flush();
		out.close();
	}

}
