package com.kh.practice.book.model.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3263108558787335168L;
	private String title;
	private String author;
	private int price;
	private Calendar date;
	private double discount;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, int price, Calendar date, double discount) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.date = date;
		this.discount = discount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String dayStr = sdf.format(date.getTime());//getTime(): Calendar을 Date로 바꿈
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", date=" + dayStr + ", discount="
				+ discount + "]";
	}

}
