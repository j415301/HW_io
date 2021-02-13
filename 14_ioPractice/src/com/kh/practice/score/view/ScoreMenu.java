package com.kh.practice.score.view;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.kh.practice.score.controller.ScoreController;
import com.kh.practice.score.model.dao.ScoreDAO;

public class ScoreMenu {
	
	private Scanner sc = new Scanner(System.in);
	private ScoreController scr = new ScoreController();
	public int num = 0;
	private ScoreDAO sd = new ScoreDAO(); 
	
	public void mainMenu() {
		while (true) {
			System.out.println("1. 성적 저장");
			System.out.println("2. 성적 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			switch (sc.nextInt()) {
				case 1: saveScore(); break;
				case 2: readScore(); break;
				case 9: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void saveScore() {
		do {
			num++;
			System.out.println(num+"번째 학생 정보 기록");
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("국어 점수 : ");
			int kor = sc.nextInt();
			System.out.print("영어 점수 : ");
			int eng = sc.nextInt();
			System.out.print("수학 점수 : ");
			int math = sc.nextInt();
			int sum = kor+eng+math;
			double avg = sum/3.0;
			scr.saveScore(name, kor, eng, math, sum, avg);
			System.out.print("그만 입력하시려면 N 또는 n 입력, 계속 하시려면 아무 키나 입력하세요 : ");
		} while (sc.next().toUpperCase().charAt(0)!='N');
		                   //compareToIgnore~~.
		return;
	}
	
	public void readScore() {
		int count = sd.loadCount();
//		int sumAll = ScoreDAO.sumAll;
//		System.out.println(ScoreDAO.sumAll);
//		double avgAll = sumAll/3.0;
		try {
			scr.readScore();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sumAll = ScoreDAO.sumAll;
		double avgAll = sumAll/(3.0*count);
		System.out.println("읽은 횟수\t전체 합계\t전체 평균");
		System.out.println(count+"\t"+sumAll+"\t"+avgAll);
		
	}
	
}