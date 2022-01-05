package tech2920;

public class sumsoddvaluesfrom1to39 {
	public static void main (String[]args) {
		
		String result = "";
		for (int i = 1;i<=39;i++) {
			if(i%2==0)
				continue;
			for (int j = i;j>0; j-=2) {
				if (result == "") {
					result = j + result;
				}
				else result = j + "+" + result;
			}
			System.out.println(result);
			result = "";
		}
	}
}
