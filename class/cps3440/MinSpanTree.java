package cps3440;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Edges {
	int weight;
	int v1;
	int v2;
	public Edges(int weight, int v1, int v2) {
		this.weight = weight;
		this.v1 = v1;
		this.v2 = v2;
	}
}

public class MinSpanTree {
	//custom comparison 
	static Comparator<Edges> EDGE = new Comparator<Edges>() {
		public int compare(Edges n1, Edges n2) {
			if (n1.weight != n2.weight)
				return n1.weight - n2.weight;
			else 
				return n1.v1 - n2.v1;
		}
	};

	public static void main(String[]args) {
		
		int N;//size of generated graph
		int S;//sparseness
		int maxedges;//max number of edges
		long start, end, Ptime, Ktime;
		
		Scanner s = new Scanner(System.in);
		System.out.print(" N: ");
		N = s.nextInt();
//		System.out.print(" S(should in range(" +(N-1)+"-" +N*(N-1)/2 +")): ");
//		S = s.nextInt();
		
		int step = 2;
		maxedges = N * (N - 1) / 2;
		int [][] result = new int [(maxedges-N+1)/step+1][4];
		int outputline = 0;
		for (S = N-1; S < maxedges; S += step) {
			
			result[outputline][1] = S;
			result[outputline][0] = N;
			outputline ++;	
		
			//give the vertex name from 26 letter
			String [] vertex = new String [N];
			for (int i = 0; i < N; i++) {
				char temp = (char) (65 + i);
				vertex[i] = String.valueOf(temp);
			}
			
			int weight, index;
			int [][] matrix = new int[N][N];
			//the rank of weights with vertex
			Queue<Edges> weights = new PriorityQueue<>(EDGE);
			//initialize the graph
			for (int i = 0; i < S; i++) {
				index = i%N;
				weight = (int)(Math.random()*9 + 1);
				while (true) {
					int index2 = (int)(Math.random()*N);
					if (index2 != index && matrix[index][index2] == 0 && matrix[index2][index] == 0) {
						matrix[index][index2] = weight;
						matrix[index2][index] = weight;
						Edges node = new Edges(weight, index, index2);
						weights.add(node);
						break;
					}
				}
			}
			//show the graph in matrix way
			for (int i = 0; i < N; i++) {
				System.out.print("  "+vertex[i]);
			}
			System.out.println();
			for (int i = 0; i < N; i++) {
				System.out.println(vertex[i]+Arrays.toString(matrix[i]));
			}

			
			int [][] Tree = new int [N][N]; 
			start = System.nanoTime();
			Prim(Tree, matrix);
			end = System.nanoTime();
			Ptime = end - start;
			result[outputline-1][2] = (int)Ptime;
			System.out.println(outputline+"Ptime: "+ Ptime);
			// show the result from Prim algorithm
	//		System.out.println("The Prim algorithm output:");
	//		for (int i = 0; i < N; i++) {
	//			System.out.print("  "+vertex[i]);
	//		}
	//		System.out.println();
	//		for (int i = 0; i < N; i++) {
	//			System.out.println(vertex[i]+Arrays.toString(Tree[i]));
	//		}
			
			//initialize Forest, E(sorted edges) and A("safe edges")
			ArrayList<String> Forest = new ArrayList<String>();
			int [][] A = new int [N][N];
			for (int i =0; i < vertex.length; i++) {
				Forest.add(vertex[i]);
			}
			int [][] E = new int [S][3];
			for (int i = 0; i < S; i++) {
				Edges n = weights.poll();
				E[i][0] = n.weight;
				E[i][1] = n.v1;
				E[i][2] = n.v2;
			}
			start = System.nanoTime();
			Kruskal(E, Forest, A);
			end = System.nanoTime();
			Ktime = end - start;
			result[outputline-1][3] = (int)Ktime;
			System.out.println("Ktime: "+ Ktime);
			// show the result from Kruskal algorithm
	//		System.out.println("The Kruskal algorithm output:");
	//		for (int i = 0; i < N; i++) {
	//			System.out.print("  "+vertex[i]);
	//		}
	//		System.out.println();
	//		for (int i = 0; i < N; i++) {
	//			System.out.println(vertex[i]+Arrays.toString(Tree[i]));
	//		}
		}
		writeArrayToExcel(result, "G:\\MST.xls");
	}
	
	static void Prim(int [][] tree, int [][] matrix) {
		Queue<Edges> P = new PriorityQueue<>(EDGE);
		//initialize, put the first vertex to be the root
		//with 0 weight, and no parent
		Edges e = new Edges(0, 0, 0);
		P.add(e);
		while(!P.isEmpty()) {
			e = P.poll();
			matrix[e.v1][e.v2] = 0;
			matrix[e.v2][e.v1] = 0;
			tree[e.v1][e.v2] = e.weight;
			int line = e.v1;
			for (int i = 0; i < matrix[line].length; i++) {
				if (matrix[line][i] != 0) {
					//put the closest vertex into priority queue 
					//and delete the info from matrix
					Edges e2 = new Edges(matrix[line][i], i, line);
					matrix[e2.v1][e2.v2] = 0;
					matrix[e2.v2][e2.v1] = 0;
					P = addtoP(P, e2);
				}
			}
		}
	}
	//insert new element n into priority queue
	static Queue<Edges> addtoP(Queue<Edges> P, Edges n) {
		Edges e;
		boolean exist = false;
		int size = P.size();
		Queue<Edges> P1 = new PriorityQueue<>(EDGE);
		if (size == 0) {
			P1.add(n);
		}else {
			//search if has similar element 
			for (int i = 0; i < size; i++) {
				e = P.poll();
				if (e.v1 == n.v1) {
					exist = true;
					if (e.weight > n.weight) 
						P1.add(n);
					else
						P1.add(e);
				}else 
					P1.add(e);
			}
			if (!exist)
				P1.add(n);
		}
		return P1;
	}
	
	static void Kruskal(int [][]E, ArrayList<String> Forest, int[][]A) {
		int index = 0;
		//add the shortest edge to graph
		merge(Forest, E[index][1], E[index][2]);
		A[E[index][1]][E[index][2]] = E[index][0];
		
		while (Forest.size() != 1) {
			//while more than one set remains
			index ++;
			String v1 = String.valueOf((char) (65 + E[index][1]));
			String v2 = String.valueOf((char) (65 + E[index][2]));
			
			if (checkandmerge(Forest, v1, v2)) {
				A[E[index][1]][E[index][2]] = E[index][0];
			}			
		}
	}
	
	//if two vertex belong to different sets then merge then to the graph
	//and return true, else return false
	static boolean checkandmerge (ArrayList<String> Forest, String v1, String v2) {
		int v1p = -1;
		int v2p = -1;
		//find the position of v1 and v2
		for (int i = 0; i < Forest.size(); i++) {
			String temp = Forest.get(i);
			if (temp.length() > 1) {	
				//if v1 and v2 is in the graph 
					if (temp.contains(v1))
						v1p = i;
					if (temp.contains(v2))
						v2p = i;
			}else {
				if (temp.equals(v1)) 
					v1p = i;
				else if (temp.equals(v2)) 
					v2p = i;
			}
		}
		
		if (v1p != v2p) {
			//if v1 and v2 have different position, merge them together
				merge(Forest, v1p, v2p);
				return true;
		}else 
				return false;
	}
	//merge the sets at nth and mth position of Forest
	static void merge (ArrayList<String> Forest, int n, int m) {
		String temp = Forest.get(n);
		String temp2 = Forest.get(m);
		if (n > m) {
			Forest.remove(n);
			Forest.remove(m);
		}else {
			Forest.remove(m);
			Forest.remove(n);
		}
		Forest.add(temp+temp2);
	}
	
	public static void writeArrayToExcel(int[][] data, String string) {
		int rowNum = data.length;
		int columnNum = data[0].length;
	
		try {
			FileWriter fw = new FileWriter(string);
			fw.write("vertex"+"\t");
			fw.write("edge number"+"\t");
			fw.write("Prim_time"+"\t");
			fw.write("Kruskal_time"+"\n");
			
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
