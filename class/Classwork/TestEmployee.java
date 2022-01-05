package Classwork;

public class TestEmployee {
	public static void main(String[]args) {
		EmployeeDetail e1=new EmployeeDetail();
		EmployeeDetail e2=new EmployeeDetail();
		EmployeeDetail e3=new EmployeeDetail();
		e1.getlinfo("Samuel", 400, 5);
		e2.getlinfo("Sheena", 600, 7);
		e3.getlinfo("Bob", 360, 8);
		int s1=e1.Addsal(e1.salary)+e1.AddWork(e1.hrs)+e1.salary;
		int s2=e2.Addsal(e2.salary)+e2.AddWork(e1.hrs)+e2.salary;
		int s3=e3.Addsal(e3.salary)+e3.AddWork(e1.hrs)+e3.salary;
		System.out.println("Sample Output: "+"\n\nEmployeeDtails\n\n"+e1.name+" "+e1.hrs+"  $"+s1);
		System.out.println(e2.name+" "+e2.hrs+"  $"+s2);
		System.out.println(e3.name+"    "+e3.hrs+"  $"+s3);
		
		System.out.println();
		System.out.println("Assume original data as: ");
		System.out.printf("%-7s%-5s%-7s","Name","hrs","salary");
		System.out.printf("\n%-7s%-5s%-7s",e1.name,e1.hrs,e1.salary);
		System.out.printf("\n%-7s%-5s%-7s",e2.name,e2.hrs,e2.salary);
		System.out.printf("\n%-7s%-5s%-7s",e3.name,e3.hrs,e3.salary);
	}

}
