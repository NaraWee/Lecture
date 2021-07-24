package com.greedy.section01.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PoketmonService {
	
	private Poketmon poketmon;
	
	@Autowired
	public PoketmonService(Poketmon poketmon) {
		this.poketmon = poketmon;
	}

	public void poketmonAttack() {
		poketmon.attack();
	}
}
