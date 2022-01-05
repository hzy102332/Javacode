package Exercise;

public class CollageStaffStudentAdress {
}
class Address{
	int streetNum;
	String city;
	String state;
	String country;
	Address(int street, String c, String st, String coun){
	this.streetNum=street;
	this.city =c;
	this.state = st;
	this.country = coun;
	}
}
class StudentClass{
	int rollNum;
	String studentName;
//Creating HAS-A relationship with Address class
	Address studentAddr;
	StudentClass(int roll, String name, Address addr){
		this.rollNum=roll;
		this.studentName=name;
		this.studentAddr = addr;
}
	public static void main(String[]args) {
		StudentClass s =new StudentClass(1234,"Nico",55,'Wenzhou,ouhai,China');
	}
}
class College{
	String collegeName;
	//Creating HAS-A relationship with Address class
	Address collegeAddr;
	College(String name, Address addr){
		this.collegeName = name;
		this.collegeAddr = addr;
}
	
}
class Staff{
	String employeeName;
//Creating HAS-A relationship with Address class
	Address employeeAddr;
	Staff(String name, Address addr){
		this.employeeName = name;
		this.employeeAddr = addr;
}
	
}