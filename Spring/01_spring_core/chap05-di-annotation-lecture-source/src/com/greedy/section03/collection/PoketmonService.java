package com.greedy.section03.collection;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PoketmonService {

	/* 1. List 타입으로 주입 받기 */
	/*
	 * List 타입으로 하나의 타입인 번들을 한번에 주입할 수 있다.
	 * 순서는 bean의 클래스명 영어 알파벳 사전순이다.
	 */
//	private List<Poketmon> poketmonList;
//	
//	/* 생성자 주입을 이용하는 경우 */
//	@Autowired
//	public PoketmonService(List<Poketmon> poketmonList) {
//		this.poketmonList = poketmonList;
//	}
//
//	public void poketmonAttack() {
//		for(Poketmon poketmon : poketmonList) {
//			poketmon.attack();
//		}
//	}
	
	/* 2. Map타입으로 주입받기 */
	private Map<String,Poketmon> poketmonMap;
	
	@Autowired
	public PoketmonService(Map<String,Poketmon> poketmonMap) {
		this.poketmonMap = poketmonMap;
	}
	
	public void poketmonAttack() {
		Iterator<String> iter = poketmonMap.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println("poketmonMap의 key : " + key);
			poketmonMap.get(key).attack();
		}
	}
}
