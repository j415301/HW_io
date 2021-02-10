package com.kh.practice.file.model.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDAO {
	
	public boolean checkName(String file) {
		File f = new File(file);
		if (f.exists()) {
			return true;
		}
		return false;
	}
	
	public void fileSave (String file, String s) {
		FileOutputStream output = null;
		try (FileWriter w = new FileWriter(file)) {
			w.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public StringBuilder fileOpen(String file) {
		StringBuilder sb = new StringBuilder();
		try (FileReader fr = new FileReader(file)){
			int data = -1;
			while ((data=fr.read())!=-1) {
				sb.append((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;
	}
	
	public void fileEdit(String file, String s) {
		try (FileWriter fw = new FileWriter(file, true)) {
			fw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
