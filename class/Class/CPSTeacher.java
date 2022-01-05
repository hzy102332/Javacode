package Class;
public class CPSTeacher extends Teacher {
	String Subject="java Programming";
	public static void main(String[]args) {
		CPSTeacher obj=new CPSTeacher ();
		System.out.println(obj.Designation);
		System.out.println(obj.School);
		System.out.println(obj.Subject);
		obj.Dose();
	}
}
