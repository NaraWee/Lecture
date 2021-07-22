package com.greedy.section01.fieldinjection.javaconfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDAOImpl implements BookDAO {

	private Map<Integer,BookDTO> bookList;
	
	public BookDAOImpl() {
		bookList = new HashMap<Integer, BookDTO>();
		bookList.put(1,  new BookDTO(1, 123456, "자바의정석", "남궁성", "도우출판", new java.util.Date()));
		bookList.put(2,  new BookDTO(2, 234456, "수학의정석", "햄망이", "지노소프트", new java.util.Date()));
		bookList.put(3,  new BookDTO(3, 524556, "칭찬은 고래도 춤추게한다.", "고래", "홍대클럽", new java.util.Date()));
	}
	
	@Override
	public List<BookDTO> selectBookList() {
		return new ArrayList<BookDTO>(bookList.values());
	}

	@Override
	public BookDTO selectOneBook(int sequence) {
		return bookList.get(sequence);
	}
	
	

}
