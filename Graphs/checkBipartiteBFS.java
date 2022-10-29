package Graph;
 
import java.io.*;
import java.util.*;

public class checkBipartiteBFS {

	public static void main(String[] args) {

		
	}
	
	// If you dont understand then watch Striver's video of this.	
	static class Solution
	{
	    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
	    {
	        // Code here
	    	
	    	int color[] = new int[V];
	    	Arrays.fill(color, -1);
	    	
	    	
	    	for(int i = 0; i<V; i++) {
	    		
	    		if(color[i]==-1) {
	    			if(!checkForBipartite(i,adj,color)) {
	    				return false;
	    			}
	    		}
	    	}
	    	
	    	return true;
	    }
	    
	    static boolean checkForBipartite(int cur, ArrayList<ArrayList<Integer>> adj, int color[]) {
	    	
	    	Queue<Integer> q = new LinkedList<>();
	    	q.add(cur);
	    	color[cur] = 1;
	    	
	    		while(!q.isEmpty()) {
	    			
	    			int current = q.poll();
	    			
	    				for(int e : adj.get(current)) {
	    					
	    					if(color[e]==-1) {
	    						color[e] = 1-color[current];
	    						q.add(e);
	    					}
	    					else {
	    						
	    						if(color[e]==color[current]) {
	    							return false;
	    						}
	    					}
	    				}
	    		}
	    		
	    		return true;
	    }
	}

}
