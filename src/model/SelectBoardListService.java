package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;

public class SelectBoardListService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("open") != null) {
			session.removeAttribute("open");
		}
		request.setAttribute("list", BoardDAO.getInstance().selectBoardList());
		request.setAttribute("totalRecord", BoardDAO.getInstance().getTotalBoardCount());
		return new ModelAndView("views/listBoard.jsp", false);
		
	}

}
