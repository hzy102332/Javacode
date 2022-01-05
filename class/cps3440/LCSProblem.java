package cps3440;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class LCSProblem {
	
	public static void main(String []args) {
		int max = 5;
		int step = 2;
		long start, end, BFtime, BUtime, TDtime;
		long [][]result = new long [max][4];
		String list = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for (int i = 3; i < max; i += step) {
			result[i][0] = i;
			//generate the random sequence X, Y
			String [] X = new String[i];
			String [] Y = new String[i];
			for (int j = 0; j < i; j++) {
				X[j] = String.valueOf(list.charAt((int)(Math.random()*26)));
				Y[j] = String.valueOf(list.charAt((int)(Math.random()*26)));
			}
			
//			String []X = {"A","D", "F"};
//			String []Y = {"B","D","C"};
			//show X and Y
			System.out.println(" Two sequences (length "+ i +"): \n X:" + Arrays.toString(X)+"\n Y:" + Arrays.toString(Y));
			
			//initialize the subarray
			String [] Xsub = new String[(int) Math.pow(2, X.length)];
			for (int a = 0; a < (int) Math.pow(2, X.length); a++) {
				Xsub [a] = "";
			}
			//number array to represent the subsequence such as "AB" of "ABC" is 110
			int [] nrsub  = new int [X.length];
			getsubsequence(X, nrsub, 0, Xsub);
			index = 0;
			
			System.out.println(" The subsequence of X:");
			for (int a =0; a < Xsub.length; a++) {
				System.out.print(" " +(a+1)+":"+ Xsub[a]);
			}
			System.out.println();
			
			start = System.nanoTime();
			int bf = BruteForce(Xsub, Y);
			end = System.nanoTime();
			BFtime = end - start;
			result[i][1] = (int)BFtime;
	        System.out.println(" Brute Force LCS length: "+bf + " | takes(nano): "+ BFtime);
			
			//initialize the table
			int dp[][] = new int [X.length+1][Y.length+1];
			int look[][] = new int [X.length+1][Y.length+1];

	        
	        start = System.nanoTime();
	        int bu = DPBottomUp(X, Y, dp);
	        end = System.nanoTime();
	        BUtime = end - start;
	        result[i][2] = (int)BUtime;
	        System.out.println(" Button Up LCS length: "+ bu + " | takes(nano): "+BUtime);
	        
	        start = System.nanoTime();
	        DPTopDown(X, X.length, Y, Y.length, look);
			end = System.nanoTime();
			TDtime = end - start;
			result[i][3] = (int)TDtime;
			System.out.println(" Top Down LCS length: " + look [X.length][Y.length] +
								" | takes(nano): "+ TDtime);
			
		}
//	        writeArrayToExcel(result, "G:\\LCS.xls");
	}
	
//	generate the subsequence
	static int index = 0;// the index of subsequence of X
	static void getsubsequence(String [] ar, int []nrsub, int i, String [] sub)
	{
		if (i >= ar.length)
		{
			
			for (int j = 0; j < ar.length; ++j)
			{
				if (nrsub[j] != 0)
				{
					sub[index] = sub[index] + ar[j];
				}
			}
		index++;
		}
		else
		{
			//include ar[i]
			nrsub[i] = 1;
			getsubsequence(ar, nrsub, i + 1, sub);
			//not include ar[i]
			nrsub[i] = 0;
			getsubsequence(ar, nrsub, i + 1, sub);
		}
	}

	static int BruteForce (String []Xsub, String []Y) {
		int lenmax = 0;// store the maximum length of LCS
		String maxsub = "";// store the maximum length subsequence
		
		for (int i = 0; i < Xsub.length; i++) {
			int count = 0;//check if the subsequence of X exists in Y
			String temp = Xsub[i];//store the subsequence of X
			for (int j = 0; j < Y.length; j++) {
				//if the subsequence exists in Y, find the next sequence
				if (temp.equals("")) {
					break;
				}
				if (Y[j].equals(String.valueOf(temp.charAt(0)))) {
					count ++;
					temp = temp.substring(1);// check the next element in temp
				}
			}
			// if all element of temp exist in Y
			if (count == Xsub[i].length() && count > lenmax) {
				lenmax = count;
				maxsub = Xsub[i];
			}
		}
		return lenmax;
	}
	
	static void DPTopDown (String[] X, int x, String[] Y,int y, int [][] look) {
		//
		if (look[x][y] == 0) {
			if (x > 1) 
				DPTopDown(X, x - 1, Y, y, look);
			if (y > 1)
				DPTopDown(X, x, Y, y - 1, look);
			if (X[x - 1].equals(Y[y - 1])) {
				look [x][y] = look [x -1][y - 1] + 1;
			}else {
				//max{look[x-1][y], look[x][y-1]}
				look[x][y] = look[x - 1][y] > look[x][y - 1] ? look[x - 1][y] : look[x][y - 1];
			}
		}
	}	

	static int DPBottomUp (String [] X, String [] Y, int [][] dp) {
		//for all elements in X
		for (int i = 1; i <= X.length; i++) {
			//for all elements in Y
			for (int j = 1; j <= Y.length; j++) {
				// generate the table value
				if (X[i-1].equals(Y[j-1]))
					dp[i][j] = dp[i - 1][j - 1] +1;
				else 
					dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
			}
		}
		//return the LCS length for X and Y
		return dp[X.length][Y.length];
	}
	
	public static void writeArrayToExcel(long[][] data, String string) {
		int rowNum = data.length;
		int columnNum = data[0].length;
	
		try {
			FileWriter fw = new FileWriter(string);
			fw.write("length of sequence"+"\t");
			fw.write("BFtime"+"\t");
			fw.write("DPBUtime"+"\t");
			fw.write("DPTDtime"+"\n");
			
			for (int i = 3; i < rowNum; i+= 2) {
					
				for (int j = 0; j < columnNum; j++)
					fw.write(data[i][j] + "\t"); // tab space
				fw.write("\n");		
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
