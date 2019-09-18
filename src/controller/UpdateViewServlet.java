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
		 * �����ϰ��� �ϴ� ���� no�� �޾ƿͼ�
		 * no�� �ش��ϴ� BoardVO�� �ϳ� ���Ϲ޾ƾ� �Ѵ�.
		 * bvo�� ���ε�
		 * update.jsp�� ������ ����...
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
