package com.MedicimeMS.Tool;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class getVerifyCode extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public getVerifyCode() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


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

		 HttpSession session=request.getSession();
		  
		 //����ҳ�治����
		  response.setHeader("Pragma","no-cache");
		  response.setHeader("Cache-Control","no-cache");
		  response.setDateHeader("Expires",0);
		  //���ڴ��д�������
		  int width=100,height=30;
		  BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		  //��ȡͼ��������
		  Graphics g=image.getGraphics();
		  //���������
		  Random random =new Random();
		  //�趨����ɫ
		  g.setColor(getRandColor(200,250));
		  g.fillRect(0,0,width,height);
		  //�趨����
		  g.setFont(new Font("Times New Roman",Font.PLAIN,18));
		  //���߿�
		  //g.setColor(new Color());
		  //g.drawRect(0,0,width-1,height-1);
		  //�������155�������ߣ���ͼ���е���֤�벻�ױ���������̽�⵽
		  g.setColor(getRandColor(160,200));
		  for(int i=0;i<155;i++)
		  {
		  	int x=random.nextInt(width);
		  	int y=random.nextInt(height);
		  	int x1=random.nextInt(12);
		  	int y1=random.nextInt(12);
		  	g.drawLine(x,y,x+x1,y+y1);
		  }
		  //ȡ�����������֤�루4λ����
		  String sRand="";
		  for(int i=0;i<4;i++){
		  	String rand=String.valueOf(random.nextInt(10));
		  	sRand+=rand;
		  	//����֤����ʾ��ͼ����
		  	g.setColor(new Color(20+random.nextInt(110),40+random.nextInt(110),20+random.nextInt(110)));
		  	g.drawString(rand,13*i+6,20);
		  }
		  //����֤�����session��
		  session.setAttribute("rand", sRand);
		  //ͼ����Ч
		  g.dispose();
		  //���ͼ��ҳ��
		  ImageIO.write(image,"JPEG",response.getOutputStream());
		
		
	}

	   private Color getRandColor(int fc, int bc) {
				Random random=new Random();
				if(fc>255) fc=255;
				if(bc>255) bc=255;
				int r=fc+random.nextInt(bc-fc);
				int g=fc+random.nextInt(bc-fc);
				int b=fc+random.nextInt(bc-fc);
				return new Color(r,g,b);
		
		}
	   
		/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
		public void init() throws ServletException {
			// Put your code here
		}

	}
