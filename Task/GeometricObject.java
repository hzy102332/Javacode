package Task;

import java.util.Scanner;

public class GeometricObject {
	String color;
	public void color() {
		System.out.print("Please choose a color for triangle: ");
		Scanner in=new Scanner(System.in);
		color=in.nextLine();
	}
	boolean Boolean () {
		if (color.length()>0)
			return true;
		else
			return false;
	}
}
