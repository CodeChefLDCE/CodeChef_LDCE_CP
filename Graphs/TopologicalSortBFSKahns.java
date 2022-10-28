


package Graph;

import java.io.*;
import java.util.*;

public class TopologicalSortBFSKahns {

	public static void main(String[] args) {

		
	}
	
	static class Solution {
		
		static int[] topoSort(int V , ArrayList<ArrayList<Integer>> adj) {
			
			int topo[] = new int[V];
			int indegree[] = new int[V];
			
			for(int i = 0; i<V; i++) {
				
				for(int e : adj.get(i)) {
					indegree[e]++;
				}
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			for(int i =0; i<V; i++) {
				if(indegree[i]==0) {
					q.add(i);
				}
			}
			
			int ind = 0;
			
			while(!q.isEmpty()) {
				
				int cur = q.poll();
				topo[ind] = cur;
				ind++;
				
					for(int e : adj.get(cur)) {
						indegree[e]--;
						
						if(indegree[e]==0) {
							q.add(e);
						}
					}
			}
			
			return topo;
		}
	}

}
