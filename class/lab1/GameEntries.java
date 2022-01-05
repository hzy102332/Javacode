package lab1;

import java.util.Scanner;

public class GameEntries {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String []name= {"A","B","C","D","E","F"};
		int []s = {65,80,70,85,55,60};
		System.out.println("Before Ranking the player names and their scores:");
		System.out.println(name[0]+"  "+s[0]+"\n"+name[1]+"  "+s[1]+"\n"+name[2]+"  "+s[2]+"\n"+
		                   name[3]+"  "+s[3]+"\n"+name[4]+"  "+s[4]+"\n"+name[5]+"  "+s[5]+"\n");
		for (int j=name.length;j>0;j--) {
		for (int i = name.length-1;i>0;i--) {
			if (s[i]>s[i-1]) {
				int temp = s[i-1];
				s[i-1]=s[i];
				s[i]=temp;
				String temp1 = name[i-1];
				name[i-1]=name[i];
				name[i]=temp1;
			}
		}}
		System.out.println("The Scoreboard:");
		System.out.println(name[0]+"  "+s[0]+"\n"+name[1]+"  "+s[1]+"\n"+name[2]+"  "+s[2]);
		System.out.print("Please enter the name and the score:");
		String name1 = sc.nextLine();
		int s1 = sc.nextInt();
		for (int i = 0; i<name.length; i++) {
			if (s1>s[i]) {
				s[i] = s1;
				name[i] = name1;
				break;
			}
		}
		
		System.out.println("After input the Scoreboard is:");
		System.out.println(name[0]+"   "+s[0]+"\n"+name[1]+"   "+s[1]+"\n"+name[2]+"   "+s[2]);
	}

}
