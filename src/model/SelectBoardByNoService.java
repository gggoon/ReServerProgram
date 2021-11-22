package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;

public class SelectBoardByNoService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long no = Long.parseLong(request.getSession());
		HttpSession session = request.getSession();
		if (session.getAttribute("open") == null) {
			BoardDAO.getInstance().updateBoardHit(no);
			session.setAttribute("open", true);
		}
		request.setAttribute("boardDTO", BoardDAO.getInstance().selectBoardByNo(no));
		request.setAttribute("replyList", BoardDAO.getInstance().selectReplyList(no));
        
		return new ModelAndView("views/viewBoard.jsp",false);
	}

}
