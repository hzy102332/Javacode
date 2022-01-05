package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Bigram {
	public static void main(String []args) {
		 ArrayList<String> answer = new ArrayList<String>();
		 String text = "alice is a good girl she is a good student";
		 String first = "a";
		 String second =  "good";
	     String [] list = text.split(" ");
	     String [] flist = first.split(" ");
	     String [] slist = second.split(" ");
	     for (int i = 0; i < list.length;i++) {
	    	 if (flist[0].equals(list[i]) && i<list.length-2) {
	        	if (slist[0].equals(list[i+1])) {
	        		answer.add(list[i+2]);
	        		i+=2;
	        	}
	        }
	     }

	     String [] result = new String [answer.size()];
	     for (int i = 0; i< answer.size();i++) {
	     result[i]=answer.get(i);
	      	}
		 System.out.print(Arrays.toString(result));
		 System.out.print(second.charAt(second.length()-1));
	}
}
