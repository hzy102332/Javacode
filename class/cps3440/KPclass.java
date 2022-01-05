package cps3440;

import java.util.Arrays;

public class KPclass {

    public int nbItems; 
    public int capcaity; 
    public int [] weights; 
    public int [] profits; 
    
   public KPclass(int nbItems, int capacity) {
	 this.nbItems = nbItems; 
	 this.capcaity=capacity; 
	 this.weights = new int[nbItems]; 
	 this.profits = new int [nbItems];
   }
   public void printProblem() {
	 System.out.println(" Number of Items = "+this.nbItems);
	 System.out.println(" Knapsack Capcity = "+this.capcaity);
	 System.out.println(" Weights of Items = "+Arrays.toString(this.weights));
	 System.out.println(" Profits of Items = "+Arrays.toString(this.profits));
   }
}
