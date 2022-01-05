package cps3440;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MFEdge {
	int v;//destination
	int c;//capacity 
	int flow; 
	
	public MFEdge(int v, int c, int flow) {
		this.v = v;
		this.c =c;
		this.flow = flow;
	}
}

public class Max_Flow_Ford_Fulkerson {

	static int N = 6;//size of generated graph
	static int sourcenode = 0;
	static int sinknode = N - 1;
	static boolean visited [] = new boolean [N];
	static MFEdge [][] matrix = new MFEdge[N][N];
	static boolean [][] dfsvisit = new boolean [N][N];//help to check if the node is visited
	static int path [] = new int [N];//store the augment path 
	static ArrayList<ArrayList<Integer>> simplegraph = new ArrayList<>();
	
	public static void main (String []args) {
		
		int S;
		int maxedges = N * (N - 1) / 2;;//max number of edges
		long start, end;
		long BFStime, DFStime;
		int step = 2;
		int outputline = 0;
		
		
		long result [][] = new long [(maxedges-N+1)/step+1][4];//store the result
		
		for (S = N+3; S < maxedges; S += step) {
			int sumflow = 0;
			result[outputline][1] = S;
			result[outputline][0] = N;
			outputline ++;	
			
			//give the vertex name from 26 letter
			String [] vertex = new String [N];
			for (int i = 0; i < N; i++) {
				char temp = (char) (65 + i);
				vertex[i] = String.valueOf(temp);
			}
			
			//initialize the graph
			int weight, index;
			for (int i = 0; i <N ;i++) {
				for (int j =0; j < N; j++) {
					matrix[i][j] = new MFEdge(0, 0, 0);
					dfsvisit[i][0] = true;
				}
			}
			for (int i = 0; i < S; i++) {
				index = i%N;
				weight = (int)(Math.random()*9 + 1);
				while (true) {
					int index2 = (int)(Math.random()*N);
					if (index2 != index && matrix[index][index2].c == 0 && matrix[index2][index].c == 0 ) {
						MFEdge node = new MFEdge(index2, weight, 0);
						matrix[index][index2] = node;
						break;
					}
				}
			}
			
//			show the graph in matrix way
			for (int i = 0; i < N; i++) {
				System.out.print("  "+vertex[i]);
			}
			System.out.println();
			for (int i = 0; i < N; i++) {
				System.out.print(vertex[i]);
				for (int j =0; j<N; j++) {
					System.out.print(" "+matrix[i][j].c +" ");
				}
				System.out.println();
			}
			
			System.out.println((S-N)/step+1 +" vertex number: " + N + " Edge number: "+ S);
			
			start = System.nanoTime();
			int f1 = Ford_Fulkerson_DFS(sourcenode, sinknode, matrix, sumflow);
			end = System.nanoTime();
			DFStime = end - start;
			result[outputline-1][2] = DFStime;
				
			sumflow = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j].flow = 0;
				}
			}
			start = System.nanoTime();
			int f2 = Edmons_Karp_BFS(sourcenode, sinknode, matrix, sumflow);
			end = System.nanoTime();	
			BFStime = end -start;
			result[outputline-1][3] = BFStime;
			
			System.out.println(" DFSflow: " + f1 + " DFStime: "+ DFStime +
					"\n"+ " BFSflow: "+ f2 +" BFStime: " + BFStime + "\nSimple Graph:");
			
			//output the simple graph
			int [][] outgraph = new int [N][N];
			for (int i =0; i <simplegraph.size(); i++) {
				int later = simplegraph.get(i).remove(0);
				int size = simplegraph.get(i).size();
				for (int j = 0; j<size; j++) {
					int pre = simplegraph.get(i).remove(0);
					outgraph[pre][later] = 1;
					later = pre;
				}
			}
			for (int i = 0; i < N; i++) {
				System.out.print("  "+vertex[i]);
			}
			System.out.println();
			for (int i = 0; i < N; i++) {
				System.out.print(vertex[i]);
				for (int j =0; j<N; j++) {
					System.out.print(" "+outgraph[i][j] +" ");
				}
				System.out.println();
			}
			System.out.println("-------------------");
			
			
		}
		writeArrayToExcel(result, "G:\\Max_Flow_Ford_Fulkerson.xls");
	}
	
	static int Ford_Fulkerson_DFS (int start,int end, MFEdge [][] graph,  int flow) {
		
		while(true) {
			path[start] = -1;
			visited[start] = true;
			for (int i =0; i<N; i++) {
				for(int j = 1; j<N; j++) {
					dfsvisit[i][j] = false;
				}
			}
			DFS(start, end);
			
			//if there is on path from source node to sinknode
			if (!visited[end])
				break;
			
			int addflow = 99999999;
			//find the min flow of the path 
			for (int i = end; path[i] >= start; i = path[i]) {
				addflow = Math.min(addflow, 
						graph[path[i]][i].c - graph[path[i]][i].flow);
			}
			
			//update the edge flow info 
			for (int i = end; path[i] >= start; i = path[i]) {
				graph[path[i]][i].flow += addflow;			
				graph[i][path[i]].c += addflow; 
			}
			//initialize 
			visited = new boolean[N];
			path = new int [N];
			flow += addflow;	
		}
		visited = new boolean[N];
		return flow;
	}
	//same with the DFS, just change the way to find the path
	static int Edmons_Karp_BFS(int start,int end, MFEdge [][] graph2,  int flow) {
		simplegraph = new ArrayList<ArrayList<Integer>>();
		
		while(true) {
			path[start] = -1;
			
			if(!BFS(start, end)) {
				
				break;
			}
			
			ArrayList<Integer> sgraph = new ArrayList();
			int addflow = 99999999;
			//find the min flow of the path 
			for (int i = end; path[i] >= start; i = path[i]) {
				sgraph.add(i);
				addflow = Math.min(addflow, 
						graph2[path[i]][i].c - graph2[path[i]][i].flow);
				
			}
			sgraph.add(start);
			simplegraph.add(sgraph);
			
			//update the edge flow info 
			for (int i = end; path[i] >= start; i = path[i]) {
				graph2[path[i]][i].flow += addflow;				
				graph2[i][path[i]].c += addflow;  
			}
			visited = new boolean[N];//initialize 
			flow += addflow;
		}
		return flow;
	}
	
	private static void DFS(int source, int dest) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(source);
		
		while(!stack.isEmpty()) {
			int ifadd = 0;// check if there is any adj node
			int current = stack.peek();		
			//if reach the sinknode
			if (current == dest) {
				int size = stack.size()-1;
				int recent = stack.pop();
				for (int i = 0; i < size; i++) {
					int pre = stack.pop();
					path[recent] = pre;
					recent = pre;
				}			
				break;
			}else {
				//check the adj node 
				for (int i = 0; i < N; i++) {
					if (!dfsvisit[current][i] && !visited[i] && (matrix[current][i].c - matrix[current][i].flow > 0)) {				
						stack.push(i);
						visited[i] = true;
						dfsvisit[current][i] = true;
						ifadd = 1;
						break;
					}
				}
				// if there is no adj node or whole node is visited
				if (ifadd == 0) {
					for (int i = 1; i<N; i++) {
						dfsvisit[current][i]=false;
					}
					stack.pop();
				}
			}	
		}
	}
	
	private static boolean BFS(int source, int dest) {
		Queue<String> q = new LinkedList<>();
		q.add(String.valueOf(source));
		visited [source] = true;
		
		while(!q.isEmpty()) {
			
			String p = q.poll();
			String [] pathsplit = p.split("-");
			//get the last vertex in the path
			int ver = Integer.parseInt(pathsplit[pathsplit.length-1]);
			
			if (ver == dest) {
				//write the path to the path array
				for (int i = 0; i < pathsplit.length - 1; i++) {
					int pre = Integer.parseInt(pathsplit[pathsplit.length-2-i]);
					int recent = Integer.parseInt(pathsplit[pathsplit.length-1-i]);
					path [recent] = pre;
				}
				visited[dest] =  true;
				break;
			}
			
			visited [ver] = true;
			for(int i =0 ; i < N; i++ ) {
				if(!visited[i] && (matrix[ver][i].c - matrix[ver][i].flow > 0)) {
					//create new path
					String newp = p + "-"+i;
					q.add(newp);
				}
			}
			
		}
		return visited[dest];
	}
	
	public static void writeArrayToExcel(long[][] data, String string) {
		int rowNum = data.length;
		int columnNum = data[0].length;
	
		try {
			FileWriter fw = new FileWriter(string);
			fw.write("vertex"+"\t");
			fw.write("edge number"+"\t");
			fw.write("DFS_time"+"\t");
			fw.write("BFS_time"+"\n");
			
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
