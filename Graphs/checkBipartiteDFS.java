package Graph;

import java.io.*;
import java.util.*;

public class checkBipartiteDFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution{
		
		public boolean isBipartite(int V ,  ArrayList<ArrayList<Integer>>adj) {
				
			int color[] = new int[V];
			Arrays.fill(color, -1);
			
			for(int i = 0; i<V; i++) {
				
				if(color[i]==-1) {
					color[i]=1;
					if(!dfscheck(i,adj,color)) {
						return false;
					}
				}
			}
			return true;
		}
		
		static boolean dfscheck(int cur , ArrayList<ArrayList<Integer>> adj, int color[]) {
			
			
				for(int e : adj.get(cur)) {
					
					if(color[e]==-1) {
						color[e]=1-color[cur];
						if(!dfscheck(e,adj,color)) {
							return false;
						}
					}
					else {
						
						if(color[e]==color[cur]) {
							return false;
						}
					}
				}
				return true;
		}
	}

}
