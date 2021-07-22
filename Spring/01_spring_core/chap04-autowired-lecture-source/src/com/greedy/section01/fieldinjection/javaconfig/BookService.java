package com.greedy.section01.fieldinjection.javaconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	/* BookDAO "타입"의 빈으로 생성된 객체를 이 프로퍼티에 자동으로 연결해준다. */
	@Autowired
	private BookDAO bookDAO;
	
	public BookService() {}
	
	public BookService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	// 도서 정보 전체 조회용 메소드
	public List<BookDTO> selectAllBooks() {
		return bookDAO.selectBookList();
	}
	
	// 도서번호로 도서 검색용 메소드
	public BookDTO searchBookBySequence(int sequence) {
		return bookDAO.selectOneBook(sequence);
	}
	
}
