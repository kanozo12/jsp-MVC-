package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;


@WebServlet("/UpdateViewServlet")
public class UpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 수정하고자 하는 글의 no를 받아와서
		 * no에 해당하는 BoardVO를 하나 리턴받아야 한다.
		 * bvo를 바인딩
		 * update.jsp로 페이지 연결...
		 */
		int no = Integer.parseInt(request.getParameter("no"));
		try{
			BoardVO vo=BoardDao.getInstance().getPostingByNo(no);
			
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}catch(Exception e){
			
		}
	}
}
