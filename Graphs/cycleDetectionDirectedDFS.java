package Graph;

import java.io.*;
import java.util.*;

public class cycleDetectionDirectedDFS {

	public static void main(String[] args) {

		
	}
	
	// If you dont understand this code
	// watch Striver's video of this question.
	
	static class Solution {
	    // Function to detect cycle in a directed graph.
	    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
	        // code here
	    	
	    	int vis[] = new int[V];
	    	int dfsvis[] = new int[V];
	    	
	    	for(int i  =0; i<V; i++) {
	    		
	    		if(vis[i]==0) {
	    			
	    			if(hasCycle(i,adj,vis,dfsvis)) {
	    				return true;
	    			}
	    		}
	    	}
	    	
	    	return false;
	    }
	    
	    static boolean hasCycle(int cur , ArrayList<ArrayList<Integer>>adj, int vis[] ,int dfsvis[]) {
	    	
	    	vis[cur] =1;
	    	dfsvis[cur] = 1;
	    	
	    	for(int e : adj.get(cur)) {
	    		
	    		if(vis[e]==0) {
	    			
	    			if(hasCycle(e,adj,vis,dfsvis)) {
	    				return true;
	    			}
	    		}
	    		else {
	    			if(dfsvis[e]==1) {
	    				return true;
	    			}
	    		}
	    	}
	    	
	    	dfsvis[cur] = 0;
	    	return false;
	    }
	}

}
