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
			System.out.println("1. ���� ����");
			System.out.println("2. ���� ���");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			switch (sc.nextInt()) {
				case 1: saveScore(); break;
				case 2: readScore(); break;
				case 9: System.out.println("���α׷��� �����մϴ�."); return;
				default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void saveScore() {
		do {
			num++;
			System.out.println(num+"��° �л� ���� ���");
			System.out.print("�̸� : ");
			String name = sc.next();
			System.out.print("���� ���� : ");
			int kor = sc.nextInt();
			System.out.print("���� ���� : ");
			int eng = sc.nextInt();
			System.out.print("���� ���� : ");
			int math = sc.nextInt();
			int sum = kor+eng+math;
			double avg = sum/3.0;
			scr.saveScore(name, kor, eng, math, sum, avg);
			System.out.print("�׸� �Է��Ͻ÷��� N �Ǵ� n �Է�, ��� �Ͻ÷��� �ƹ� Ű�� �Է��ϼ��� : ");
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
		System.out.println("���� Ƚ��\t��ü �հ�\t��ü ���");
		System.out.println(count+"\t"+sumAll+"\t"+avgAll);
		
	}
	
}