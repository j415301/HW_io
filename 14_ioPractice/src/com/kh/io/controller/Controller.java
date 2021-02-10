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
	메뉴
	1. 파일 생성: 파일명을 client에게 입력받아 생성
	2. 디렉토리 생성: 폴더명도 client에 입력받아 생성(root 경로는 프로젝트 경로)
	3. 파일에 문자열 저장: 사용자가 입력하는 내용 전부 저장(사용자가 입력 중단할 때까지 입력받기)
	4. 파일에 저장된 문자열 출력: 파일에 저장된 내용 가져와 출력
	*/
	
	//-> 선생님 코드 확인하기
			
			public void mainMenu() {
				while (true) {
					System.out.println("======== 파일 입출력 프로그램 ========");
					System.out.println("1. 디렉토리 생성");
					System.out.println("2. 하위 파일 생성");
					System.out.println("3. 파일에 문자열 저장");
					System.out.println("4. 파일에 저장된 문자열 출력");
					System.out.println("9. 종료");
					System.out.print("기능 선택 : ");
					int cho = sc.nextInt();
					sc.nextLine();
					switch (cho) {
						case 1: createDirectory(); break;
						case 2: createFile(); break;
						case 3: saveStr(); break;
						case 4: printStr(); break;
						case 9: System.out.println("종료되었습니다."); return;
					}
				}
			}
			public void createDirectory() {
				path = Controller.class.getResource("/").getPath();
				path = path.substring(0,path.lastIndexOf("bin"));
				System.out.print("디렉토리명 : ");
				dirName = sc.nextLine();
				File dir = new File(path+dirName);
				dir.mkdir();
				return;
			}
			
			public void createFile() {
				System.out.print("파일명(.txt) : ");
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
						System.out.print("입력할 문자열 : ");
						fw.write(sc.nextLine());
						System.out.println("계속 입력하시겠습니까? (Y/N)");
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
					while ((data = fr.read()) != -1) {//read는 한 글자(2byte)씩 읽는데 if를 돌리면 한번 읽고 끝나잖니^^ while을 돌려야 -1이 나오기 전까지 다 읽지^^!
						sb.append((char)data);
					}
					System.out.println(sb);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}

}
