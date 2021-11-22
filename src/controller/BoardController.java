package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.BoardService;
import model.DeleteBoardService;
import model.InsertBoardService;
import model.InsertReplyService;
import model.SelectBoardByNoService;
import model.SelectBoardListService;
import model.UpdateBoardHitService;


@WebServlet("*.do") 

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String[] arr = request.getRequestURI().split("/");
		String command = arr[arr.length - 1];
		
		ModelAndView mav = null;
		BoardService service = null;

		switch (command) {
		case "selectBoardList.do":
		      service = new SelectBoardListService();
 		      break;
		case "selectBoardByNo.do":
	          service = new SelectBoardByNoService();
		      break;
		case "insertBoardForm.do":
			  mav = new ModelAndView("view/insertBoard.jsp",false);
			  break;
		case "insertBoard.do":
			  service = new InsertBoardService();
			  break;
		case "deleteBoard.do":
			  service = new DeleteBoardService();
			  break;
		case "updateBoardHit.do":
			  service = new UpdateBoardHitService();
			  break;
		case "insertReply.do":
			  service = new InsertReplyService();
			  break;
		}
		
		if (service != null) {
				try {
					mav = service.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (mav != null) {
				if (mav.isRedirect()) {
					response.sendRedirect(mav.getView());
				} else {
					request.getRequestDispatcher(mav.getView()).forward(request, response);
				}
			}
			
		}
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
	}