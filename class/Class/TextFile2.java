package Class;

import java.io.File;

public class TextFile2 {
	public static void main(String[]args) {
		try {
		File f=new File ("F:\\newFile.txt");
		System.out.println(f.canRead());
		System.out.println(f.canWrite());
		System.out.println(f.createNewFile());
		System.out.println(f.delete());
		System.out.println(f.exists());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.isDirectory());
		System.out.println(f.isHidden());
		System.out.println(f.list());
		}
	catch (Exception e) {
	}
}
}
