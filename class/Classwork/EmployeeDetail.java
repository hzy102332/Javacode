package Classwork;

public class EmployeeDetail {
	String name;
	int salary,hrs;
	public void getlinfo(String name,int salary,int hrs) {
		this.name=name;
		this.hrs=hrs;
		this.salary=salary;
	}
	public int Addsal(int sal) {
		if(sal<500)
			return 10;
		return 0;
	}
	public int AddWork(int hour) {
		if(hour>6)
			return 5;
		return 0;
	}
}
