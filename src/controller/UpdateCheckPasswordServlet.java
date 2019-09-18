package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;


@WebServlet("/UpdateCheckPasswordServlet")
public class UpdateCheckPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String password = request.getParameter("password");
		try{
			boolean flag=BoardDao.getInstance().checkPassword(no, password);
			
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("update_checkpass_result.jsp").forward(request, response);
		}catch(Exception e){
			
		}	
		
	}

}
