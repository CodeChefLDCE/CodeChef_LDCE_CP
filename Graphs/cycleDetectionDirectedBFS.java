package Graph;

import java.io.*;
import java.util.*;

public class cycleDetectionDirectedBFS {

	public static void main(String[] args) {

		
		//This algo below uses the fact that Topological sort is possible for only Directed Acyclic Graph
		// So we dont have a concrete solution which is solely for detecting a cycle
		//
		// So we get asked in an interview that "Detect at cycle in a directed graph"
		// then give the DFS Solution first
		
	}
	
	static boolean hascycle(int V , ArrayList<ArrayList<Integer>> adj) {
		
	
		int indegree[] = new int[V];
			
			for(int i = 0; i<V; i++) {
				
				for(int e : adj.get(i)) {
					indegree[e]++;
				}
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			for(int i = 0; i<V; i++) {
				if(indegree[i]==0) {
					q.add(i);
				}
			}
			
			int cnt = 0;
			
				while(!q.isEmpty()) {
					
					int cur = q.poll();
					cnt++;
					
						for(int e : adj.get(cur)) {
							indegree[e]--;
							
							if(indegree[e]==0) {
								q.add(e);
							}
						}
					
				}
				
				if(cnt==V) {
					return false; // no there is no cycle in the graph
				}
				return true;
	}

}
