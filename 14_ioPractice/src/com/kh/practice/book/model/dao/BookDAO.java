package com.kh.practice.book.model.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.practice.book.model.vo.Book;

public class BookDAO {
	
	private Book[] bArr1 = new Book[10];
	
	public void fileSave(Book[] bArr) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Book3.txt"))){
//			for (Book b : bArr) {
//				oos.writeObject(b);
//				System.out.println(b);
//			}
			oos.writeObject(bArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Book[] fileRead() {
		Object o = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Book3.txt"))){
			
			try {
				o = ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			bArr = (Book[])ois.readObject();
//			System.out.println(bArr);
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (Book[])o;
	}
	
//	public void storeCount() {
//		try (FileOutputStream fos = new FileOutputStream(new File("count.txt"))){
//			fos.write(count);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
