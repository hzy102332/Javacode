package Exercise;

import java.util.Scanner;

public class Rectangle2D {;
	double x,y;
	double width,height;
	Rectangle2D() {
	x=0;
	y=0;
	width=1;
	height=1;
}
	Rectangle2D(double x, double y,double width,double height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
public double getPrimeter() {
	return 2*(width*height);
}
public double getarea(){
	return width*height;
}
	}