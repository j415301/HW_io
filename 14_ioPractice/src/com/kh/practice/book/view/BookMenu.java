package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {
	
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private Book[] bArr;
	
	public BookMenu() {
		// TODO Auto-generated constructor stub
		bc.makeFile();
		bArr = bc.fileRead();
	}
	
	public void mainMenu() {
		while (true) {
			System.out.println("1. ���� �߰� ����");
			System.out.println("2. ���� ���� ���");
			System.out.println("9. ���α׷� ������");
			System.out.print("�޴� ��ȣ : ");
			switch (sc.nextInt()) {
				case 1: fileSave(); break;
				case 2: fileRead(); break;
				case 9: System.out.println("���α׷� ����"); return;
				default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void fileSave() {
		
		Calendar c = Calendar.getInstance();
		
		
		sc.nextLine();
		System.out.print("������ : ");
		String title = sc.nextLine();
		System.out.print("���ڸ� : ");
		String author = sc.nextLine();
		System.out.print("���� ���� : ");
		int price = sc.nextInt();
		System.out.print("���� ��¥(yyyy-mm-dd) : ");
		String[] cArr = sc.next().split("-");
		c.set(Integer.parseInt(cArr[0]), Integer.parseInt(cArr[1])-1, Integer.parseInt(cArr[2]));
		//b.setDate(c);
		System.out.print("������ : ");
		double discount = sc.nextDouble();
		Book b = new Book(title, author, price, c, discount);
		
		
//		System.out.println(b);
		System.out.println(bArr.length);
		for (int i=0 ; i<bArr.length ; i++) {
			if (bArr[i]==null) {
				bArr[i] = new Book();
				bArr[i] = b;
				
			}
		}
		bc.fileSave(bArr);
	}
	
	public void fileRead() {
		bArr = bc.fileRead();
		System.out.println(bArr[0]);
		System.out.println(bArr[1]);
//		for (int i=0 ; i<bArr.length ; i++) {
//			
//			bArr[i] = new Book();
//			if (bArr[i]!=null) {
//				System.out.println(bArr[i]);
//			}
			
			
//		}
	}

}