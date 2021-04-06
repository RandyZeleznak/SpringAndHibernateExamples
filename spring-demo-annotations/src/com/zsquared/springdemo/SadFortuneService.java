package com.zsquared.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// 
		return "Today is SAD day";
	}

}
