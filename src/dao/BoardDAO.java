package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BoardDTO;
import mybatis.config.DBService;

public class BoardDAO {

	/* StudentDao의 모든 메소드는 factory에서 SqlSession을 얻어 낸다. */
	private SqlSessionFactory factory;
	
	private static BoardDAO instance;
	private BoardDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	// 글 목록
	public List<BoardDTO> selectBoardList() {
		SqlSession ss = factory.openSession();
		List<BoardDTO> list = ss.selectList("dao.board.selectBoardList");
		ss.close();
		return list;
	}
	
	// 전체 게시글 
    public int getTotalCount() {
		SqlSession ss = factory.openSession();
		int totalCount = ss.selectOne("dao.board.getTotalCount");
		ss.close();
		return totalCount;
   }
    // 게시글 삭제
    public int deleteNotice(Long No) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.notice.deleteBoard", No);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
    
	// BoardMaxHit
	public List<BoardDTO> selectBoardMaxHitJob() {
		SqlSession ss = factory.openSession();
		List<BoardDTO> top3List = ss.selectList("dao.board.SelectBoardMaxHitJob");
		ss.close();
		return top3List;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}