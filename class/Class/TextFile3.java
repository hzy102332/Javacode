package Class;

import java.io.File;

public class TextFile3 {
	public static void main(String[]args) {
	File f=new File("G:/ͼƬ/");
	String[] flist =f.list();
	for (String a :flist) {
		System.out.println(a);
	}
}}
