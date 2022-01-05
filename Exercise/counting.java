package Exercise;

import java.text.DecimalFormat;

public class counting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=7;
		int b=3;
		float n= a/(float)b;
		 DecimalFormat f = new DecimalFormat("0.0000");
		System.out.print(f.format(n));
	}

}
