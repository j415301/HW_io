package com.kh.io.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
	
	private String fileName="";
	private String dirName="";
	private String path="";
	
	Scanner sc = new Scanner(System.in);
	
	/*
	�޴�
	1. ���� ����: ���ϸ��� client���� �Է¹޾� ����
	2. ���丮 ����: ������ client�� �Է¹޾� ����(root ��δ� ������Ʈ ���)
	3. ���Ͽ� ���ڿ� ����: ����ڰ� �Է��ϴ� ���� ���� ����(����ڰ� �Է� �ߴ��� ������ �Է¹ޱ�)
	4. ���Ͽ� ����� ���ڿ� ���: ���Ͽ� ����� ���� ������ ���
	*/
	
	//-> ������ �ڵ� Ȯ���ϱ�
			
			public void mainMenu() {
				while (true) {
					System.out.println("======== ���� ����� ���α׷� ========");
					System.out.println("1. ���丮 ����");
					System.out.println("2. ���� ���� ����");
					System.out.println("3. ���Ͽ� ���ڿ� ����");
					System.out.println("4. ���Ͽ� ����� ���ڿ� ���");
					System.out.println("9. ����");
					System.out.print("��� ���� : ");
					int cho = sc.nextInt();
					sc.nextLine();
					switch (cho) {
						case 1: createDirectory(); break;
						case 2: createFile(); break;
						case 3: saveStr(); break;
						case 4: printStr(); break;
						case 9: System.out.println("����Ǿ����ϴ�."); return;
					}
				}
			}
			public void createDirectory() {
				path = Controller.class.getResource("/").getPath();
				path = path.substring(0,path.lastIndexOf("bin"));
				System.out.print("���丮�� : ");
				dirName = sc.nextLine();
				File dir = new File(path+dirName);
				dir.mkdir();
				return;
			}
			
			public void createFile() {
				System.out.print("���ϸ�(.txt) : ");
				fileName = sc.nextLine();
				File f = new File(path+dirName+"/"+fileName);
				try {
					f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			
			
			public void saveStr() {
				try (FileWriter fw = new FileWriter(dirName+"/"+fileName);){
					while (true) {
						System.out.print("�Է��� ���ڿ� : ");
						fw.write(sc.nextLine());
						System.out.println("��� �Է��Ͻðڽ��ϱ�? (Y/N)");
						char cho = sc.next().charAt(0);
						sc.nextLine();
						if (cho=='Y') continue;
						else break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			
			public void printStr() {
				try (FileReader fr = new FileReader(dirName+"/"+fileName);){
					StringBuffer sb = new StringBuffer();
					int data = -1;
					while ((data = fr.read()) != -1) {//read�� �� ����(2byte)�� �дµ� if�� ������ �ѹ� �а� �����ݴ�^^ while�� ������ -1�� ������ ������ �� ����^^!
						sb.append((char)data);
					}
					System.out.println(sb);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}

}
