package com.kh.practice.book.controller;

import java.io.File;
import java.io.IOException;

import com.kh.practice.book.model.dao.BookDAO;
import com.kh.practice.book.model.vo.Book;

public class BookController {
	
	private BookDAO bd = new BookDAO();
	
	public void makeFile() {
		File f = new File("Book2.txt");
		try {
			if (!f.exists()) f.createNewFile();
			else System.out.println("이미 존재하는 파일입니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileSave(Book[] BArr) {
		bd.fileSave(BArr);
	}
	
	public Book[] fileRead() {
		return bd.fileRead();
	}

}
