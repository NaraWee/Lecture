package com.greedy.section01.advice.xmlconfig;

public class Passion {

	private int score;
	
	public Passion(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Passion [score=" + score + "]";
	}
	
}
