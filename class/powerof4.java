
public class powerof4 {
	public static void main(String []args) {
	double sum = 0;
	for (int i = 1; i<= 30; i++) {
		sum += (1/(Math.pow(i, 4)));
		System.out.println(1/(Math.pow(i, 4)));
	}
	
	System.out.print(sum);
	
}
}