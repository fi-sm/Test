package com.py.run;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;

/**
 * Servlet implementation class PythonScriptRun
 */
@WebServlet("/runPythonScript")
public class PythonScriptRun extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PythonScriptRun() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: GET ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String param1=request.getParameter("param1");
		String param2=request.getParameter("param1");
		String param3=request.getParameter("param3");
		String param4=request.getParameter("param4");
		String param5=request.getParameter("param5");
		StringBuilder sb=new StringBuilder();
		if(null!=param1 && ! "".equals(param1))
		{
			sb.append(" "+param1);
		}
		if(null!=param2 && ! "".equals(param2))
		{
			sb.append(" "+param2);
		}
		if(null!=param3 && ! "".equals(param3))
		{
			sb.append(" "+param3);
		}
		if(null!=param4 && ! "".equals(param4))
		{
			sb.append(" "+param4);
		}
		if(null!=param5 && ! "".equals(param5))
		{
			sb.append(" "+param5);
		}
		
		File f=new File("/home/pyscript.py");
		response.getWriter().append(f.getAbsolutePath());
		
		Process p = Runtime.getRuntime().exec("C:/home/pyscript.py"+sb.toString());
		response.getWriter().append("Command Executed, Run Another Command:"+p).append(request.getContextPath());
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	}

}
