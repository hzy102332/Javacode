package lab4;

import java.util.Scanner;

public class anagrams {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		System.out.print("Please enter two words(using ,):");
		String words=s.nextLine();
		String [] word = new String [1];
		word = words.split(",");
		String[] w1 =word[0].split("");
		String[] w2 =word[1].split("");
		boolean check=false;
		if(w1.length!=w2.length) {
			System.out.println("These two words are not anagrams of each other.");
			
		}
		else {
			for(int i =0; i<w1.length;i++) {
				check=false;
				for(int j=0;j<w2.length;j++) {
					if(w1[i].equals(w2[j])) {
						check=true;
						break;
					}
				}
				if(!check) {
					System.out.println("These two words are not anagrams of each other.");
					break;
				}
			}
			if (check) {
				System.out.println("These two words are anagrams of each other.");
			}
			
			
		}
			
	}

}
