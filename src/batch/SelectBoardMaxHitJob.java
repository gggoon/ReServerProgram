package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.BoardDAO;
import dto.BoardDTO;


public class SelectBoardMaxHitJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

	List<BoardDTO> list = BoardDAO.getInstance().selectBoardMaxHitJob();
	
	File file = new File("MaxhitJob.txt");
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
	   for (BoardDTO board : list) {
		   System.out.println("====최대 초회수 게시글====");
		   bw.write(board.getNo() + ",");
		   bw.append(board.getTitle() + ",");
		   bw.append(board.getContent() + ",");
		   bw.append(board.getHit() + "\n");
	   }
	   System.out.println("MaxhitJob.txt 생성 완료");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
