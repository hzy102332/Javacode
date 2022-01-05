package Class;

import java.io.File;

public class Filerename {
	public static void main(String[]args) {
		File oldfile= new File ("F:\\abc.txt");
		File newfile=new File ("F:\\newabc.txt");
		boolean f=oldfile.renameTo(newfile);
		if (f) {
			System.out.println("File renamed successfully");
		}
		else {
			System.out.println("operation Rename failed!");
		}
	}
}
