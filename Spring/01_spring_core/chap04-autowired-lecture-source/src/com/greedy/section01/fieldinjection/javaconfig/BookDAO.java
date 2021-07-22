package com.greedy.section01.fieldinjection.javaconfig;

import java.util.List;

public interface BookDAO {

	/* 도서 목록 전체 조회 */
	List<BookDTO> selectBookList();
	
	/* 도서번호로 도서 조회 */
	BookDTO selectOneBook(int sequence);
}
