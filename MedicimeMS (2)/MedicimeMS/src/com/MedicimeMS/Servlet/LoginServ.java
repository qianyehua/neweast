package com.MedicimeMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MedicimeMS.Dao.LoginDao;
import com.MedicimeMS.Dao.getFunConDao;



public class LoginServ extends HttpServlet {

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
	    
	    HttpSession session=request.getSession();
	   
       String uname=request.getParameter("uname");
       String upwd=request.getParameter("upwd");
       String code=request.getParameter("verify");
       
       if(!code.equals(session.getAttribute("rand")))
	    {
    	  response.sendRedirect("../index.jsp");
	    }   
       
       else{
    	   LoginDao l=new LoginDao();
          int flag=l.islegalBy(uname, upwd);
          int roleid=l.getRoleid(uname);
          String role=l.getRole(uname);
//          int funcon=new getFunConDao().funcon(flag);
//          String funCon=funcon+"";
          String RoleId=roleid+"";
          String flg=flag+"";
          
          if(flag>0){
        	  session.setAttribute("uname", uname);
        	  response.sendRedirect("../JSP/Main.jsp"); 
        	  session.setAttribute("roleid",RoleId);
        	  session.setAttribute("role", role);
        	  session.setAttribute("userid", flg);
          }
          else{
        	  
        	  response.sendRedirect("../index.jsp");
          }
          
       }
        
		out.flush();
		out.close();
	}

}
