package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;


@WebServlet("/ShowContentHits")
public class ShowContentHits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		int hits = Integer.parseInt(request.getParameter("hits"));
		try{
			BoardDao.getInstance().updateHits(no, hits);
			BoardVO rvo = BoardDao.getInstance().getPostingByNo(no);
			
			request.setAttribute("vo", rvo);
			request.getRequestDispatcher("show_content.jsp").forward(request, response);
		}catch(Exception e){
			
		}
	}

}
