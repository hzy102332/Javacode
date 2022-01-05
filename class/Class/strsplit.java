package Class;

public class strsplit {

	public static void main(String[] args) {
		String s=" Hazel, Kevin, jason, Irving";
		String []arr=s.split(",");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		String []arr1=s.split(",",3);
		for(int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
	}
		
		String []arr2=s.split("\\s");
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
	}	
		
}
}
