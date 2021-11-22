package batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.BoardDAO;
import dto.BoardDTO;


public class SelectBoardMaxHitJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		   BoardDTO dto = BoardDAO.getInstance().selectBoardByMaxHit();
		   System.out.println("====최대 초회수 게시글====");
		   System.out.println("제목:" + dto.getTitle());
		   System.out.println("내용:" + dto.getContent());
		   System.out.println("조회수:" + dto.getHit());

	   }

}
