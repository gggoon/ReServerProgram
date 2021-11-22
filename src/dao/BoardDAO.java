package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BoardDTO;
import dto.ReplyDTO;
import mybatis.config.DBService;

public class BoardDAO {

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
   
   
   public List<BoardDTO> boardList() {
      SqlSession ss = factory.openSession();
      List<BoardDTO> list = ss.selectList("dao.board.boardList");
      ss.close();
      return list;
   }
   
   
   public int boardInsert(BoardDTO board) {
      SqlSession ss = factory.openSession(false);
      int result = ss.insert("dao.board.boardInsert", board);
      if (result > 0) {
         ss.commit();
      }
      ss.close();
      return result;
   }
   
   public BoardDTO boardselect(Long no) {
      SqlSession ss = factory.openSession();
      BoardDTO board = ss.selectOne("dao.board.boardselect", no);
      ss.close();
      return board;
   }
   
   public int insertReply(ReplyDTO reply) {
      SqlSession ss = factory.openSession(false);
      int result = ss.insert("dao.board.insertReply", reply);
      if (result > 0) {
         ss.commit();
      }
      ss.close();
      return result;
   }
   
   public int deleteBoard(Long no) {
      SqlSession ss = factory.openSession(false);
      int result = ss.delete("dao.board.deleteBoard", no);
      if (result > 0) {
         ss.commit();
      }
      ss.close();
      return result;
   }
   
   public List<BoardDTO> selectTop() {
      SqlSession ss = factory.openSession();
      List<BoardDTO> top = ss.selectList("dao.board.selectTop");
      ss.close();
      return top;
   }
   
   public List<ReplyDTO> selectReplyList(Long no) {
      SqlSession ss = factory.openSession();
      List<ReplyDTO> list = ss.selectList("dao.board.selectReplyList", no);
      ss.close();
      return list;
   }
   public BoardDTO selectBoardByMaxHit() {
	   SqlSession ss = factory.openSession();
	   BoardDTO dto = ss.selectOne("dao.board.selectBoardByMaxHit");
	   ss.close();
	   return dto;
   }
   
}