package chapter13;


public class practiceclone implements Cloneable{
	int id;
	String name;
	int age; 
	practiceclone(int id,String name, int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	public static void main(String[]args) {
		try {
			practiceclone s=new practiceclone(1001,"AAA",21);
			practiceclone s2=(practiceclone)s.clone();
			System.out.println(s.id+" "+s.name+" "+s.age);
			System.out.println(s2.id+" "+s2.name+" "+s2.age);
		}
		catch (CloneNotSupportedException e) {
			
		}
	}
public Object clone() throws CloneNotSupportedException{
	return super.clone();
}
}