package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;

public class BoardController {
	
	private ServletContext application;
	private BoardService boardService;

	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(boardService == null) {
			application = request.getServletContext();
			boardService = (BoardService) application.getAttribute("boardService");
			
			if(boardService == null){   // application 범위에 boardService가 없을 때
				boardService = new BoardService();
				application.setAttribute("boardService", boardService);
			}
		}
		
		
		
		String action = request.getParameter("action");
		switch(action) {
			case "list" : list(request, response); break;
			case "writeForm" : writeForm(request, response); break;
	
		}	
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardController");
		
		List<Board> list = boardService.getPage(1, 10);
		
		request.setAttribute("list", list);
		
		Board board = list.get(0);
		request.getSession().setAttribute("board", board);
	//	request.setAttribute("board", board);
		
		RequestDispatcher rd = request.getRequestDispatcher("/exam03/list.jsp");
		rd.forward(request, response);
		
	}
	
	
	private void writeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
		RequestDispatcher rd = request.getRequestDispatcher("/exam03/write_form.jsp");
		rd.forward(request, response);

	}
}
