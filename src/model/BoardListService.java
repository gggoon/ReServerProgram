package model;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardDTO> list = dao.selectBoardList();
		
		int totalCount = dao.getTotalCount();
		
		request.setAttribute("list", list);
		request.setAttribute("totalCount", totalCount);
		
		return new ModelAndView("views/listBoard.jsp" , false);
		
	}

}
