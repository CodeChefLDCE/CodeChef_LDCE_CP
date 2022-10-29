package Graph;

import java.io.*;
import java.util.*;

// I Think this code is for the case when the source has indegree 0
// That is all the edges of the source point outwards
// Some people say it as Node this is unreachable from other nodes
// because all it edges point outwards.

// Still GO And Check for which case this algo works for 
// This is specially stated as Shortest path in a DAG

public class ShortestPathInDAG {

	static class pair{
		
		int node;
		int wei;
		
			public pair(int node, int wei) {
				this.node = node;
				this.wei = wei;
			}
	}
	
	
	public static void main(String[] args) {

		
	}
	
	static void shortestPath(int s, ArrayList<ArrayList<pair>> adj, int n) {
		
		// At first we need the topological sort of this graph
		
		// Topological sort starts
		
		Stack<Integer> st = new Stack<>();
		
			boolean vis[] = new boolean[n];
			
				for(int i = 0; i<n; i++) {
					if(!vis[i]) {
						topoSort(i,vis,st,adj);
					}
				}
				
				// Topological sort Ends
				
				int dist[] = new int[n];
				
				Arrays.fill(dist, Integer.MAX_VALUE);
				dist[s] =0;
				
					while(!st.isEmpty()) {
						
						int cur = st.pop();
						
							if(dist[cur]!=Integer.MAX_VALUE) { // If this node has been previously visited.
								
								for(pair e : adj.get(cur)) {
									
									if(dist[cur]+e.wei<dist[e.node]) {
										dist[e.node] = dist[cur]+e.wei;
									}
								}
							}
					}
					
					for(int i = 0; i<n; i++) {
						
						if(dist[i]==Integer.MAX_VALUE) {
							System.out.print("INF ");
						}
						else {
							System.out.print(dist[i]+" ");
						}
					}
	}
	
	static void topoSort(int node, boolean vis[], Stack<Integer> st , ArrayList<ArrayList<pair>> adj) {
		
		vis[node] = true;
		
			for(pair e : adj.get(node)) {
				if(!vis[e.node]) {
					topoSort(e.node,vis,st,adj);
				}
			}
			
			st.add(node);
	}

}
