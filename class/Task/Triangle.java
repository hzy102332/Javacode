package Task;

import java.util.Scanner;

public class Triangle extends GeometricObject {
	double side1;
	double side2;
	double side3;
	double area;
	double perimeter;
	public void setArea(double a,double b,double c) {
		side1=a;
		side2=b;
		side3=c;
		double s=(a+b+c)/2;
		double q=(s-a)*(s-b)*(s-c);
		area=Math.sqrt(s*q);
		perimeter=a+b+c;
	}
	public void setPerimeter(double a,double b,double c) {
		perimeter=a+b+c;
	}
	public double getArea() {
		return area;
	}
	public double getPerimeter() {
		return perimeter;
	}
	public String toString() {
		return "Triangle:side1= "+ side1+"\n         side2= "+side2+"\n         side3= "+side3;
	}
	public static void main(String[]args) {
		Triangle obj=new Triangle();
		Scanner in=new Scanner(System.in);
		obj.color();
		System.out.print("Please enter three number of triangle:");
		double obj1=in.nextDouble();
		double obj2=in.nextDouble();
		double obj3=in.nextDouble();
		obj.setArea(obj1, obj2, obj3);
		obj.setPerimeter(obj1,obj2,obj3);
		System.out.println("The area of triangle is: "+obj.getArea()+"The perimeter of triangle is: "+obj.getPerimeter());
		System.out.println(obj.toString()+"\nIf this triangle has color: ");
		System.out.println(obj.Boolean());
		
	}
	
}
