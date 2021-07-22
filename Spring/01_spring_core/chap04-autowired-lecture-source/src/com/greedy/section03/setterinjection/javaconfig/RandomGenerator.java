package com.greedy.section03.setterinjection.javaconfig;

public interface RandomGenerator {

	/* 난수 발생시키는 메소드 */
	int getRandomNumber();
	
	/* 난수 시작 값 가져오는 메소드 */
	public int getStartNum();
	
	/* 난수 범위 종료 값 가져오는 메소드 */
	public int getEndNum();
}
