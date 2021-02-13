package com.kh.practice.score.controller;

import java.io.FileNotFoundException;

import com.kh.practice.score.model.dao.ScoreDAO;

public class ScoreController {
	
	private ScoreDAO sd = new ScoreDAO();
//	public int temp=sd.getTemp();
	
	
	public void saveScore(String name, int kor, int eng, int math, int sum, double avg) {
		sd.saveScore(name, kor, eng, math, sum, avg);
	}
	
	public void readScore() throws FileNotFoundException{
		sd.readScore();
		//System.out.println(temp);
	}

}