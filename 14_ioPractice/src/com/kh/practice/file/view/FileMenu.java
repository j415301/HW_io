package com.kh.practice.file.view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	private String fileName;
	
	public void mainMenu() {
		while (true) {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int cho = sc.nextInt();
			switch (cho) {
				case 1: fileSave(); break;
				case 2: fileOpen(); break;
				case 3: fileEdit(); break;
				case 9: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void fileSave() {
		sc.nextLine();
		StringBuilder sb = new StringBuilder();
		System.out.println("파일에 저장할 내용을 입력하세요.");
		System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
		boolean flag = true;
		do {
			System.out.print("내용 : ");
			String content = sc.nextLine();
			if (!content.equals("ex끝it")) {
				sb.append(content+"\n");
			} else {
				flag = false;
			}
		} while (flag);
		while (true) {
			System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
			/*String*/ this.fileName = sc.nextLine();
			File f = new File(fileName);
			if (!f.exists()) {
				fc.fileSave(fileName, sb); break;
			} else {
				System.out.println("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n)");
				if (sc.next().toLowerCase().charAt(0)=='y') {
					fc.fileSave(fileName, sb); break;
				} else {
					sc.nextLine();
				}
			}
		} return;
	}
	
	public void fileOpen() {
		sc.nextLine();
		System.out.print("열 파일명: ");
		boolean flag = fc.checkName(sc.nextLine());
		if (flag) {
			System.out.println(fc.fileOpen(this.fileName));
		} else {
			System.out.println("없는 파일입니다."); return;
		}
	}
	
	public void fileEdit() {
		sc.nextLine();
		System.out.print("수정할 파일명: ");
		String name = sc.nextLine();
		if (fc.checkName(name)) {
			StringBuilder sb = new StringBuilder();
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			boolean flag = true;
			do {
				System.out.print("내용 : ");
				String content = sc.nextLine();
				if (!content.equals("ex끝it")) {
					sb.append(content+"\n");
				} else {
					flag = false;
				}
			} while (flag);
			fc.fileEdit(name, sb);
		} else {
			System.out.println("없는 파일입니다."); return;
		}
	}

}
