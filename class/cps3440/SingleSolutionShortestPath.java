package cps3440;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class State {
	int weight;
	int v;
	boolean t;//if this vertex is included in Shortest path
	public State(int weight, int v,boolean t) {
		this.weight = weight;
		this.v = v;
		this.t = t;
	}
}

public class SingleSolutionShortestPath {
	
	public static void main(String []args) {
		
		Long start, end;
		Long BFtime;
		long DBtime;//use binary heap 
		Long DFtime;//use Fibonacci heap
		int infi = 99999;
		int N = 70;
		int S;
		int step = 2;
		int maxedges = N * (N - 1) / 2;
		int source = 0;
		int outputline = 0;
		long result [][] = new long [(maxedges-N+1)/step+1][4];		
		
		for (S = N-1; S < maxedges; S += step) {
			
		result[outputline][1] = S;
		result[outputline][0] = N;
		outputline ++;	
		
		int [] distB = new int [N];//store the shortest path weight for BD
		int distD [] = new int [N];// store the shortest path weight for Dijkstra
		Edges edge [] = new Edges [S];// store every edge info
		Queue<State> minheap = new PriorityQueue<State>(State);// binary heap
		LinkedList<State>[] adj = new LinkedList [N];
		for (int i =0; i < N; i++) {
				adj[i] = new LinkedList<State>();
		}
		
		
		//give the vertex name from 26 letter
		String [] vertex = new String [N];
		for (int i = 0; i < N; i++) {
			char temp = (char) (65 + i);
			vertex[i] = String.valueOf(temp);
			//initialize
			distB[i] = infi;
			distD[i] = infi;	
		}
		distB[source] = 0;//set source point to 0
		distD[source] = 0;
		//initialize the graph
		int weight, index;
		int [][] matrix = new int[N][N];
		for (int i = 0; i < S; i++) {
			index = i%N;
			weight = (int)(Math.random()*9 + 1);
			while (true) {
				int index2 = (int)(Math.random()*N);
				//direct graph
				if (index2 != index && matrix[index][index2] == 0) {
					matrix[index][index2] = weight;
					edge[i] = new Edges(weight, index, index2);
					
					if (edge[i].v1 == source) {
						distB[edge[i].v2] = edge[i].weight;
						distD[edge[i].v2] = edge[i].weight;
					}
					
					State temp = new State(weight,index2,false);
					adj[index].add(temp);
					break;
				}
			}
		}
		
		//show the graph in matrix way
//		for (int i = 0; i < N; i++) {
//			System.out.print("  "+vertex[i]);
//		}
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.println(vertex[i]+Arrays.toString(matrix[i]));
//		}
		System.out.println("S = "+ S);
		
		start = System.nanoTime();
		BellmanFord(edge, distB, S, N);
		end = System.nanoTime();
		BFtime = end - start;
		result[outputline-1][2] = BFtime;
		System.out.println(" DB       result " + BFtime);		
//		System.out.println(" BF result"+Arrays.toString(distB));
		
		ArrayList<Integer> Shortest = new ArrayList<Integer>();
		start = System.nanoTime();
		Dijkstra(minheap, Shortest, adj, distD);
		end = System.nanoTime();
		DBtime = end - start;
		result[outputline-1][3] = DBtime;
		System.out.println(" Dijkstra result " + DBtime);
//		System.out.println(" Dijkstra result"+Arrays.toString(distD));
		}
		
		writeArrayToExcel(result, "G:\\ShortestPath.xls");
	}
	
	//custom comparison 
	static Comparator<State> State = new Comparator<State>() {
		public int compare(State n1, State n2) {
				return n1.weight - n2.weight;
		}
	};
	
	static void Dijkstra(Queue<State> Q, ArrayList<Integer> Shortest, LinkedList<State>[] adj, int [] distD) {
		State e = new State(0, 0,true);
		Q.add(e);
		while (!Q.isEmpty()) {
			e = Q.poll();
			e.t = true;
			Shortest.add(e.v);
			int length =adj[e.v].size();
			for (int i = 0; i < length; i++) {
				State s = adj[e.v].poll();
//				s.weight += e.weight;
				relex(e.v,s.v,s.weight,distD);	
				if (!s.t)
					Q.add(s);
			}
			
		}
	}
	
	static void BellmanFord (Edges [] edge, int [] dist, int S, int N) {
		boolean checkneg = true;
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < S; j++) 
				relex(edge[j].v1, edge[j].v2, edge[j].weight, dist);
		}
		//detect negative cycles
		for (int i =0; i < S; i++) {
			if (dist[edge[i].v2] > dist[edge[i].v1] + edge[i].weight) {
				checkneg = false;
				System.out.println("There is a negative cycle in the graph !");
				break;
			}
		}
	}
	
	static void relex (int v1, int v2, int weight,int [] dist) {
		if (dist[v2] > dist[v1] + weight)
			dist[v2] = dist[v1] + weight;
	}
	
	public static void writeArrayToExcel(long[][] data, String string) {
		int rowNum = data.length;
		int columnNum = data[0].length;
	
		try {
			FileWriter fw = new FileWriter(string);
			fw.write("vertex"+"\t");
			fw.write("edge number"+"\t");
			fw.write("Bellman_Ford"+"\t");
			fw.write("Dijkstra_time"+"\n");
			
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
