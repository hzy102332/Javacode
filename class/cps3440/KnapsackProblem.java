package cps3440;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class KnapsackProblem {
	
	static int cp;// current total profit
	static int cw;// current total weight
	static int Capacity;// capacity
	static int max;// max profit
	static int number;// number of elements
	
	public static void main (String []args) {	
		
		long start, end;
		long dptime, bftime; 
		int result[][] = new int [10000][4];
		result [0][0] = 0;
//		"f5_l-d_kp_15_375",
		String[] name = {
				"low-dimensional/f4_l-d_kp_4_11", 
				"low-dimensional/f9_l-d_kp_5_80",
				"low-dimensional/f7_l-d_kp_7_50",
				"low-dimensional/f6_l-d_kp_10_60",
				"low-dimensional/f1_l-d_kp_10_269",
				"low-dimensional/f2_l-d_kp_20_878",
				"low-dimensional/f10_l-d_kp_20_879",
				"low-dimensional/f8_l-d_kp_23_10000",
				"large_scale/knapPI_1_100_1000_1",
				"large_scale/knapPI_1_100_1000_1",
				"large_scale/knapPI_1_1000_1000_1",
				"large_scale/knapPI_1_200_1000_1", 
				"large_scale/knapPI_1_2000_1000_1", 
				"large_scale/knapPI_1_500_1000_1", 
				"large_scale/knapPI_1_5000_1000_1", 
				"large_scale/knapPI_2_100_1000_1",
				"large_scale/knapPI_2_1000_1000_1",  
				"large_scale/knapPI_2_200_1000_1", 
				"large_scale/knapPI_2_2000_1000_1", 
				"large_scale/knapPI_2_500_1000_1", 
				"large_scale/knapPI_2_5000_1000_1", 
				"large_scale/knapPI_3_100_1000_1", 
				"large_scale/knapPI_3_1000_1000_1",  
				"large_scale/knapPI_3_200_1000_1", 
				"large_scale/knapPI_3_2000_1000_1", 
				"large_scale/knapPI_3_500_1000_1", 
				"large_scale/knapPI_3_5000_1000_1",
				};
		//large_scale/knapPI_1_100_1000_1
		//low-dimensional/f1_l-d_kp_10_269
		for (int a = 1; a < 9 ; a++) {
		String instanceName = "instances_01_KP/" + name[a-1];
		KPclass kp = readData(instanceName);
		kp.printProblem();
		number = kp.nbItems;
		Capacity = kp.capcaity;
		
		result[a][0] = number;
		result[a][1] = Capacity;
		
		int [] weight = kp.weights;
		int [] profit = kp.profits;
	
		int [] bs = new int [number]; //store the best scheme
		int cs [] = new int [number]; //store the current scheme
		for (int i = 0; i< number; i ++) {
			bs[i] = 0;
			cs[i] = 0;
		}
		start = System.currentTimeMillis();
		Dynamicprogramming(weight, profit);
		end = System.currentTimeMillis();
		dptime = end - start;
		result[a][2] = (int) dptime;
		
		start = System.currentTimeMillis();
		BruteForce (0, bs, cs,weight, profit);
		end = System.currentTimeMillis();
		bftime = end - start;
		result[a][3] = (int) bftime;
		
		System.out.println(a + "the time of dp: " + dptime+"\n the time of bf: " + bftime + "\n--------------");
		}
		writeArrayToExcel(result, "G:\\KP.xls");
	}
	
	
	static String Dynamicprogramming (int [] weight, int [] profit) {
		//dynamic programming array list
		int dp[][] = new int [number + 1][Capacity + 1];
		
		for(int i = 1; i < number + 1; i++) {
			for (int j = 1; j< Capacity + 1; j++) {
				//if the ith item weighs more than capacity j,
				//then compare the capacity of the next backpack
				if (weight[i-1] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+profit[i-1]);
				}
			}
		}
		//the max profit the bag of Capacity; 
		max = dp[number][Capacity];
		
		int c = Capacity;
		String scheme = ""; //store the items which is included in bag
		for(int i = number; i > 0; i--) {
			//if dp[i][j] > dp[i-1][j], this means ith item is include in the bag
			if (dp[i][c] > dp[i-1][c]) {
				scheme = 1 + " " + scheme;
				c = c - weight[i-1];
			}else {
				scheme = 0 + " " + scheme;
			}
			if (c == 0) 
				break;
		}
		return scheme + "\n " + max;
	}
		
// enumerate all possible solution and return the maximum profit
	static int BruteForce (int i, int [] bs, int cs[], int [] weight, int [] profit) {
		//if i larger than number of items
		if(i>number-1)
	    {
	        if(max < cp && cw <= Capacity)
	        {
	            for(int k=0;k<number;k++)
	                 bs[k] = cs[k];
	            max = cp;
	        }
	        return max;
	    }
	    cw = cw + weight[i];
	    cp = cp + profit[i];
	    cs[i] = 1;//insert to bag
	    BruteForce(i+1,  bs, cs, weight, profit);
	    cw = cw - weight[i];
	    cp = cp - profit[i];
	    cs[i] = 0;//remove from bag
	    BruteForce(i+1,  bs, cs, weight, profit);
	    return max;
	}
	
//	Construct a knapsack problem instance from a file 
    public static KPclass readData(String fileName) {
		 KPclass kp = null;
		 try {
		     File myObj = new File(fileName);
		     Scanner myReader = new Scanner(myObj);
		     int nbLine = 0;
		     int totaln = 0;
		     while (myReader.hasNextLine()) {
		    	 if (totaln < nbLine) break;
				 String dataStr = myReader.nextLine();
				 String dataArr[] = dataStr.split("\\s+");
				 int v0 = Integer.parseInt(dataArr[0]);
				 int v1 = Integer.parseInt(dataArr[1]);
				 if (nbLine == 0) {
				     kp = new KPclass(v0, v1);
				     totaln = v0;
				 } else {
				     kp.profits[nbLine-1] = v0;
				     kp.weights[nbLine-1] = v1;
				 }
				 nbLine++;
			 }
		     myReader.close();
		 } catch (FileNotFoundException e) {
		     System.out.println("An error occurred.");
		     e.printStackTrace();
		 }
	
	 	return kp;
    }
    
    public static void writeArrayToExcel(int[][] data, String string) {
		int rowNum = data.length;
		int columnNum = data[0].length;
	
		try {
			FileWriter fw = new FileWriter(string);
			fw.write("number"+"\t");
			fw.write("Capacity"+"\t");
			fw.write("DynamicPrograming_time"+"\t");
			fw.write("BruteForce_time"+"\n");
			
			for (int i = 0; i < rowNum; i++) {
				
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






