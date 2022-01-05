package cps3440;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ClassScehdule {
	public static void main(String []args) {
		//extract information from the schedule file
		ArrayList<ArrayList<String>> course = new ArrayList<ArrayList<String>>();// store class name and its prereq class
		ArrayList<String> Class = new ArrayList<String>(); //store every class name 
		String name = "Course Schedule/schedule.txt";
		readdata(name, course);
		System.out.println("CLASS  PREREQCLASS");
		//print the class info 
		for (int i=0; i < course.size(); i++) {
			for (int j = 0; j < course.get(i).size(); j++) {
				if (j == 0) Class.add(course.get(i).get(j).toString()); 
				System.out.print(course.get(i).get(j).toString()+ "  ");
			}
			System.out.print("\n");
		}
		
		ArrayList<String> out = new ArrayList<String>();// sotre the class order 
		
		//build the matrix for courses
		int [][] matrix = new int [course.size()][course.size()];
		for (int i = 0; i < course.size(); i++) {
			ArrayList<String> temp = course.get(i);
			for (int j = 1; j < temp.size(); j++) {
				for (int z = 0; z <course.size(); z++) {
					if (temp.get(j).equals(course.get(z).get(0))) 
						matrix[i][z] = 1;
				}
			}
		}
		
		int [] in_degree = new int [course.size()];
		//count the in_degree of each class
		for (int i = 0; i < in_degree.length; i++) {
			int degree = 0;
			for (int j = 0; j < in_degree.length; j++) {
				if (matrix[i][j] == 1)
					degree ++;
			}
			in_degree[i] = degree;
		}
		
		long start, end , DFStime, Kahnalgotime;
		
		start = System.nanoTime();
		DFS(course, out);
		end = System.nanoTime();
		DFStime = end -start;
		System.out.println(" DFS: "+out + "\n time: " + DFStime);
		
		//reset out array
		out = new ArrayList<String>();
		start = System.nanoTime();
		Kahnalgo(Class, out, in_degree, matrix);
		end = System.nanoTime();
		Kahnalgotime = end - start;
		System.out.println(" Kahnalgo: "+ out + "\n time: " + Kahnalgotime);
		
	}

	static void DFS(ArrayList<ArrayList<String>> course, ArrayList<String> out) {
		Stack<String> stack = new Stack<String>();
		//compute the order
		for (int i = 0; i < course.size(); i++) {
			ArrayList<String> sub = course.get(i);
			//push course and its prereq class to stack
			for (int j = 0; j < sub.size(); j++) {
				stack.push(sub.get(j).toString());
			}
			//pop the class from stack 
			while(!stack.isEmpty()){
				String temp = stack.pop();
				if (out.isEmpty())
					out.add(temp);
				else {
					for (int j = 0; j < out.size(); j++) {
						//check if course already in the array
						if (temp.equals(out.get(j).toString())) {
							break;
						}else if (j == out.size() - 1) {
							out.add(temp);
						}
					}
				}
			}
			
		}
	}
	
	static void Kahnalgo (ArrayList<String> Class, ArrayList<String> out, int [] degree,int [][] matrix) {
		Queue<Integer> queue = new LinkedList<Integer>();
		//push class with 0 in_degree into queue
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0)
				queue.add(i);
		}
		//poll elements from queue and reduce the in_degree of relevant class
		//if class in_degree = 0 put it into queue
		while (!queue.isEmpty()) {
			int cnum = queue.poll();
			out.add(Class.get(cnum).toString());
			for (int i = 0; i <degree.length; i++) {
				if (matrix[i][cnum] == 1) {
					degree[i] -= 1;
					if (degree[i] == 0)
						queue.add(i);
				}
			}
		}
	}
	
	//read course information from sheet
	public static void readdata(String name, ArrayList<ArrayList<String>> course) {
		
		ArrayList<String> prereq = null;
		try {
			File obj = new File(name);
			Scanner s = new Scanner(obj);
			int nline = 0;
			int totalline = 46;
			while (nline < totalline) {
				prereq = new ArrayList<String>();
				String data = s.nextLine();
				nline ++;
				String dataarr [] = data.split(" ");
				prereq.add(dataarr[1]);
				data = s.nextLine();
				nline ++;
				while (!data.isEmpty() && nline <= totalline) {
					dataarr = data.split(" ");
					prereq.add(dataarr[3]);
					if (s.hasNext())
						data = s.nextLine();
					nline ++;
				}
					course.add(prereq);			
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}
}
