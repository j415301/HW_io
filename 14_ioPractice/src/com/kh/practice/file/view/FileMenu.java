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
			System.out.println("1. ��Ʈ ���� �����");
			System.out.println("2. ��Ʈ ����");
			System.out.println("3. ��Ʈ ��� �����ϱ�");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			int cho = sc.nextInt();
			switch (cho) {
				case 1: fileSave(); break;
				case 2: fileOpen(); break;
				case 3: fileEdit(); break;
				case 9: System.out.println("���α׷��� �����մϴ�."); return;
				default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void fileSave() {
		sc.nextLine();
		StringBuilder sb = new StringBuilder();
		System.out.println("���Ͽ� ������ ������ �Է��ϼ���.");
		System.out.println("ex��it �̶�� �Է��ϸ� ����˴ϴ�.");
		boolean flag = true;
		do {
			System.out.print("���� : ");
			String content = sc.nextLine();
			if (!content.equals("ex��it")) {
				sb.append(content+"\n");
			} else {
				flag = false;
			}
		} while (flag);
		while (true) {
			System.out.print("������ ���� ���� �Է����ּ���(ex. myFile.txt) : ");
			/*String*/ this.fileName = sc.nextLine();
			File f = new File(fileName);
			if (!f.exists()) {
				fc.fileSave(fileName, sb); break;
			} else {
				System.out.println("�̹� �����ϴ� �����Դϴ�. ����ðڽ��ϱ�?(y/n)");
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
		System.out.print("�� ���ϸ�: ");
		boolean flag = fc.checkName(sc.nextLine());
		if (flag) {
			System.out.println(fc.fileOpen(this.fileName));
		} else {
			System.out.println("���� �����Դϴ�."); return;
		}
	}
	
	public void fileEdit() {
		sc.nextLine();
		System.out.print("������ ���ϸ�: ");
		String name = sc.nextLine();
		if (fc.checkName(name)) {
			StringBuilder sb = new StringBuilder();
			System.out.println("���Ͽ� ������ ������ �Է��ϼ���.");
			System.out.println("ex��it �̶�� �Է��ϸ� ����˴ϴ�.");
			boolean flag = true;
			do {
				System.out.print("���� : ");
				String content = sc.nextLine();
				if (!content.equals("ex��it")) {
					sb.append(content+"\n");
				} else {
					flag = false;
				}
			} while (flag);
			fc.fileEdit(name, sb);
		} else {
			System.out.println("���� �����Դϴ�."); return;
		}
	}

}
