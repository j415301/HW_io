package com.kh.practice.score.model.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScoreDAO {
	
	private int count;
	public static int sumAll=0;//ÃÑÁ¡
//	private int s;
	
//	public void setTemp(int temp) {
//		this.sumAll = temp;
//	}
//
//	public int getTemp() {
//		return temp;
//	}
	
	public void saveScore(String name, int kor, int eng, int math, int sum, double avg) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("score.dat",true))){
			dos.writeUTF(name);
			dos.writeInt(kor);
			dos.writeInt(eng);
			dos.writeInt(math);
			dos.writeInt(sum);
			dos.writeDouble(avg);
			count++;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		saveCount();
	} 
	
	public void saveCount() {
		try (FileOutputStream fos = new FileOutputStream(new File("count.txt"))){
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int loadCount() {
		try (FileInputStream fis = new FileInputStream(new File("count.txt"))){
			//fis.read();
			DataInputStream dis = new DataInputStream(fis);
			count = dis.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public void readScore() throws FileNotFoundException{
		loadCount();
		try (DataInputStream dis = new DataInputStream(new FileInputStream("score.dat"))){
			System.out.println("ÀÌ¸§\t±¹¾î\t¿µ¾î\t¼öÇÐ\tÃÑÁ¡\tÆò±Õ");
			for(int i=0 ; i<3 ; i++) {
				String name = dis.readUTF();
				int kor = dis.readInt();
				int eng = dis.readInt();
				int math = dis.readInt();
				int sum = dis.readInt();
				double avg = dis.readDouble();
				System.out.println(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+sum+"\t"+avg);
				sumAll += sum;
				System.out.println(sumAll);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}