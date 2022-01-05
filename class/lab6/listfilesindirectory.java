package lab6;

import java.io.File;

public class listfilesindirectory {
	static File c = new File ("D:/");
	static String [] f =c.list(); 
	public static void main(String[] args) {
		listAll();
	}
	public static void listAll(int depth) {
		
		String name = "D:/";
		
		if (depth<f.length) {
			System.out.print("Depth:"+depth+" ");
			if (depth<f.length) {
				File ff = new File(name+f[depth]);	
				System.out.println(f[depth]+ " "+ff.length());
			}
				listAll(depth+1);
			
		}
		
	}
	public static void listAll() {
		listAll(0);
	}
	}
