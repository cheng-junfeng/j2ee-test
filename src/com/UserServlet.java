package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.model.User;
import core.service.UserService;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		request.setCharacterEncoding("utf-8");  	
	    String username = getHeaderStr(request, "username");  
	    String password = getHeaderStr(request, "password");
	    System.out.println("username1:"+username+":"+password);
	    response.setContentType("text/html;charset=utf-8");
		List<User> allUser = new UserService().getUsers();
		boolean isLogin = false;
		for(User user: allUser){
			System.out.println("[DB]username:"+user.getName()+":"+user.getPwd());
			if(user.getPwd().equals(password)){
				isLogin = true;
				break;
			}
		}
		PrintWriter out = response.getWriter();
		if(isLogin){
			response.setStatus(HttpServletResponse.SC_OK);
		}else{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.print("    password error");
			out.println("  </BODY>");
			out.println("</HTML>");
		}
		out.flush();
		out.close();
	}
	
	private String getHeaderStr(HttpServletRequest request, String key) {
        Enumeration<String> e = request.getHeaders(key);//得到的头值
        String result = "";
        while(e.hasMoreElements()){
        	result = e.nextElement();
            System.out.println(result);
        }
        return result;
    }
	
	private String bodyReader(HttpServletRequest request) {
		BufferedReader br;
		String result = "";
		try {
			br = request.getReader();
			String str = "";
			while((str = br.readLine()) != null){
				result += str;
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
