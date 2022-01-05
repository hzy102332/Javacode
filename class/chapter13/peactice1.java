package chapter13;

public class peactice1 {
public static void main(String []args) {
	practice obj=new practice2();
	System.out.println("m:"+obj.m(4, 7));
	System.out.println("m2:"+obj.m2(4,7,2 ));
}
}
interface practice{
	abstract int m(int i ,int j);
	int m2(int i,int j,int k);
}
class practice2 implements practice {
	public int m(int i,int j) {
		return i*j;
	}
	public int m2(int i, int j, int k) {
		return i*j*k;
	}
}