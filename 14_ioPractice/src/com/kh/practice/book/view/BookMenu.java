package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {
	
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private Book[] bArr = new Book[10];
//	private int count = 0;
	
	public BookMenu() {
		// TODO Auto-generated constructor stub
		bc.makeFile();
		if (bc.fileRead()!=null) {
			bArr = bc.fileRead();
		}
//		bArr = bc.fileRead();
	}
	
	public void mainMenu() {
		while (true) {
			System.out.println("1. 도서 추가 저장");
			System.out.println("2. 저장 도서 출력");
			System.out.println("9. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			switch (sc.nextInt()) {
				case 1: fileSave(); break;
				case 2: fileRead(); break;
				case 9: System.out.println("프로그램 종료"); return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void fileSave() {
//		bArr = new Book[10];
		Calendar c = Calendar.getInstance();
		sc.nextLine();
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		System.out.print("저자명 : ");
		String author = sc.nextLine();
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		System.out.print("출판 날짜(yyyy-mm-dd) : ");
		String[] cArr = sc.next().split("-");
		c.set(Integer.parseInt(cArr[0]), Integer.parseInt(cArr[1])-1, Integer.parseInt(cArr[2]));
		System.out.print("할인율 : ");
		double discount = sc.nextDouble();
//		int num = 0;
//		System.out.println(bArr.length);
		for (int i=0 ; i<this.bArr.length ; i++) {
			if (bArr[i]==null) {
				bArr[i] = new Book(title, author, price, c, discount);
//				System.out.println(bArr[i]);
				break;
			}
		}
		System.out.println(bArr[0]);
		System.out.println(bArr[1]);
		
		
		/*
		 * for(int i=0 ; i<bArr.length ; i++) {
		 * 
		 * if(bArr[i]==null) { num = i; break; } }
		 */
			
		//bArr[num] = new Book(title, author, price, c, discount);
		
//		System.out.println(b);
//		System.out.println(bArr.length);
//		for (int i=0 ; i<bArr.length ; i++) {
//			if (bArr[i]==null) {
//				bArr[i] = new Book(title, author, price, c, discount);
//				System.out.println(bArr[i]);
//			}
//		}
//		bArr = new Book[] (title, author, price, c, discount});
//		System.out.println(bArr[count]);
//		System.out.println(count);
//		count++;
//		System.out.println(count);
		bc.fileSave(bArr);
	}
	
	public void fileRead() {
		bArr = bc.fileRead();
		for (Book b : bArr) {
			if(b!=null) {
				System.out.println(b);
			}
		}
	}

}