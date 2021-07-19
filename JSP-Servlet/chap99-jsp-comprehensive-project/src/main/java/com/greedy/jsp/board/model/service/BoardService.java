package com.greedy.jsp.board.model.service;

import static com.greedy.jsp.common.jdbc.JDBCTemplate.close;
import static com.greedy.jsp.common.jdbc.JDBCTemplate.commit;
import static com.greedy.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.greedy.jsp.board.model.dao.BoardDAO;
import com.greedy.jsp.board.model.dto.AttachmentDTO;
import com.greedy.jsp.board.model.dto.BoardDTO;
import com.greedy.jsp.board.model.dto.PageInfoDTO;

public class BoardService {

	private final BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	/**
	 * 페이징 처리를 위한 전체 게시물 수 조회용 메소드
	 * @return
	 */
	public int selectTotalCount() {
		
		Connection con = getConnection();
		
		int totalCount = boardDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}

	/**
	 * 게시물 전체 조회용 메소드
	 * @param pageInfo
	 * @return
	 */
	public List<BoardDTO> selectBoardList(PageInfoDTO pageInfo) {
	
		Connection con = getConnection();
		
		List<BoardDTO> boardList = boardDAO.selectBoardList(con, pageInfo);
		
		close(con);
		
		return boardList;
	}

	/**
	 * 게시물 추가용 메소드
	 * @param newBoard
	 * @return
	 */
	public int insertBoard(BoardDTO newBoard) {
		
		Connection con = getConnection();
		
		int result = boardDAO.insertBoard(con, newBoard);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	/**
	 * Thumbnail 추가용 메소드
	 * @param thumbnail
	 * @return
	 */
	public int insertThumbnail(BoardDTO thumbnail) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* 최종적으로 반환할 result 선언 */
		int result = 0;
		
		/* 먼저 board 테이블부터 thumbnail 내용부터 insert 한다. */
		int boardResult = boardDAO.insertThumbnailContent(con, thumbnail);
		
		/* 방금 insert 한 board 테이블의 sequence를 조회한다. */
		int boardNo = boardDAO.selectThumbnailSequence(con);
		
		/* Attachment 리스트를 불러온다. */
		List<AttachmentDTO> fileList = thumbnail.getAttachmentList();
		
		/* fileList에 boardNo값을 넣는다. */
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setRefBoardNo(boardNo);
		}
		
		/* Attachment 테이블에 list size만큼 insert 한다. */
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachmentResult += boardDAO.insertAttachment(con, fileList.get(i));
		}
		
		/* 모든 결과가 성공이면 트랜젝션을 완료한다. */
		if(boardResult > 0 && attachmentResult == fileList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		/* Connection을 닫는다. */
		close(con);
		
		/* 수행 결과를 리턴한다. */
		return result;
	}
	
	/**
	 * Thumbnail 게시판 조회용 메소드
	 * @return
	 */
	public List<BoardDTO> selectThumbnailList() {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* List 조회 */
		List<BoardDTO> thumbnailList = boardDAO.selectThumbnailList(con);
		
		/* Connection 닫기 */
		close(con);
		
		/* 조회 결과 반환 */
		return thumbnailList;
	}
	
	
	/**
	 * 게시판 검색 결과 갯수 조회용 메소드
	 * @param condition 검색조건
	 * @param value 값
	 * @return
	 */
	public int searchBoardCount(String condition, String value) {
		
		/* Connection 생성 */
		Connection con = getConnection();
		
		int totalCount = boardDAO.searchBoardCount(con, condition, value);
		
		close(con);
		
		return totalCount;
	}
	
	/**
	 * 게시판 검색 결과 조회용 메소드(페이징처리)
	 * @param condition 검색조건
	 * @param value 검색값
	 * @param pageInfo 페이지정보
	 * @return
	 */
	public List<BoardDTO> searchBoardList(String condition, String value, PageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<BoardDTO> boardList = boardDAO.searchBoardList(con, pageInfo, condition, value);
		
		close(con);
		
		return boardList;
	}
	
	/**
	 * Thumbnail 상세보기
	 * @param no
	 * @return
	 */
	public BoardDTO selectOneThumbnailBoard(int no) {
		
		Connection con = getConnection();
		
		BoardDTO thumbnail= null;
		
		int result = boardDAO.incrementBoardCount(con, no);
		
		if(result > 0) {
			thumbnail = boardDAO.selectOneThumbnailBoard(con, no);
			
			if(thumbnail != null) {
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		}
		
		close(con);
		
		return thumbnail;
		
	}
}
