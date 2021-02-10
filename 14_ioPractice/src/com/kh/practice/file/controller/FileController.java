package com.kh.practice.file.controller;

import com.kh.practice.file.model.dao.FileDAO;

public class FileController {
	
	private FileDAO fd = new FileDAO();
	
	
	public boolean checkName(String file) {
		boolean flag = fd.checkName(file);
		return flag;
	}
	
	public void fileSave(String file, StringBuilder sb) {
		String strSb = new String(sb);
		fd.fileSave(file, strSb);
	}
	
	public StringBuilder fileOpen(String file) {
		StringBuilder sb = fd.fileOpen(file);
		return sb;
	}
	
	public void fileEdit(String file, StringBuilder sb) {
		String modifiedStr = new String(sb);
		fd.fileEdit(file, modifiedStr);
	}

}
