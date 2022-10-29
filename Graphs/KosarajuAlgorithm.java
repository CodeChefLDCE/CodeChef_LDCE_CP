package Graph;

import java.io.*;
import java.util.*;

public class KosarajuAlgorithm {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for(int i = 0; i<n; i++) {
				adj.add(new ArrayList<>());
			}
			for(int i = 0; i<m ;i++) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				adj.get(u).add(v);
			}
			
			// Step1  : Do a Random Order DFS of the given graph and store the nodes in a linkedlist while backtracking
			boolean vis[] = new boolean[n];
			LinkedList<Integer> stack = new LinkedList<>();
			for(int i = 0; i<n; i++) {
				if(!vis[i]) {
					dfs1(i,adj,stack,vis);
				}
			}
			
			// Step2 : Reverse all the edges in the given graph
			
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for(int i = 0; i<n; i++) {
				graph.add(new ArrayList<>());
			}
			for(int i = 0; i<n; i++) {
				for(int e : adj.get(i)) {
					graph.get(e).add(i);
				}
			}
			
			// Step3 : Do a DFS in the Stack order and increase the answer by 1 when you find a component
			
			boolean viss[] = new boolean[n];
			int ans = 0;
			while(!stack.isEmpty()) {
				int cur = stack.removeFirst();
				
					if(!viss[cur]) {
						dfs2(cur,graph,viss);
						ans++;
					}
			}
			
			System.out.println(ans);
	}
	
	static void dfs1(int src, ArrayList<ArrayList<Integer>> adj, LinkedList<Integer> stack, boolean vis[]) {
		
		vis[src] = true;
		
			for(int e : adj.get(src)) {
				if(!vis[e]) {
					dfs1(e,adj,stack,vis);
				}
			}
			
			stack.addFirst(src);
	}
	
	static void dfs2(int src, ArrayList<ArrayList<Integer>> graph, boolean viss[]) {
		
		viss[src] = true;
		// We can add a print statement here just in case we are asked to print all the elements in a strong component
			for(int e : graph.get(src)) {
				if(!viss[e]) {
					dfs2(e,graph,viss);
				}
			}
	}

}
