package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.ReplyDTO;

public class InsertReplyService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		Long boardNo = Long.parseLong(request.getParameter("boardNo"));
		ReplyDTO dto = new ReplyDTO();
		dto.setAuthor(author);
		dto.setContent(content);
		dto.setIp(ip);
		dto.setBoardNo(boardNo);
		int result = BoardDAO.getInstance().insertReply(dto);
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 등록되었습니다.')");
			out.println("location.href='selectBoardByNo.do?=" + boardNo + "'");
			out.println("</script>");
		} else { 
			out.println("<script>");
			out.println("alert('게시글이 등록되지 않았습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return null;
	}

}

