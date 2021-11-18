package model;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dao.NoticeDao;
import dao.ReplyDao;
import dto.Reply;
import dto.ReplyDTO;

public class BoardDeleteService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        Long No = Long.parseLong(request.getParameter("No"));
        
        List<ReplyDTO> replyList = ReplyDAO.getInstance().selectReplyList(No);
        PrintWriter out = response.getWriter();
        
        if (replyList.size() == 0) {
        int result = BoardDAO.getInstance().deleteNotice(No);
        
        if (result > 0) { 
        	out.println("<script>");
        	out.println("alert('게시글이 삭제되었습니다.');");
        	out.println("location.href='list.listBoard'");  
        	out.println("</script>");
        	out.close();
        } else {
        	out.println("<script>");
        	out.println("alert('게시글이 삭제되지않았습니다.');");
        	out.println("history.back()");
        	out.println("</script>");
        	out.close();
        }     
	} else {  
		out.println("<script>");
    	out.println("alert('댓글이 달린 게시글은 삭제할 수 없습니다.');");
    	out.println("history.back()"); 
    	out.println("</script>");
    	out.close();
	}
    return null;
  } 
	
}


