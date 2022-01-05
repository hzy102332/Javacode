package chapter13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
class Student implements Comparable<Student>{
	int id;
	String name;
	int age;
	Student(int id,String name, int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	public int compareTo(Student a) {
		if (age==a.age)
			return 0;
		else if(age>a.age)return -1;
		else return 1;
	}
}
public class Testcompare {
	public static void main(String[]args) {
		ArrayList<Student> al=new ArrayList<Student>();
		al.add(new Student(1001,"ABC",24));
		al.add(new Student(1004,"XYZ",18));
		al.add(new Student(1007,"PQR",21));
		Collections.sort(al);
		for (Student a:al) {
			System.out.println(a.id+" "+a.name+" "+a.age);
		}
	}
}
