package Graph;

import java.io.*;
import java.util.*;

public class CycleDetectionBFS {

	public static void main(String[] args) {
		
		
	}
	
	static class Solution {
	    
	    static class pair{
	        
	        int node;
	        int parent;
	        
	        public pair(int node , int parent){
	            this.node = node;
	            this.parent = parent;
	        }
	    }
	    
	    // Function to detect cycle in an undirected graph.
	    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
	        // Code here
	        
	        boolean vis[] = new boolean[V];
	        Arrays.fill(vis,false);
	        
	        for(int i = 0; i<V; i++){
	            
	            if(vis[i]==false){
	                if(hasCycle(i,adj,vis)){
	                    return true;
	                }
	            }
	        }
	        
	        return false;
	    }
	    
	    static boolean hasCycle(int cur, ArrayList<ArrayList<Integer>> adj, boolean vis[]){
	        
	        Queue<pair> q = new LinkedList<>();
	        
	        q.add(new pair(cur, -1));
	        vis[cur] = true;
	        
	            while(!q.isEmpty()){
	                
	                pair current = q.poll();
	                
	                
	                    for(int nei : adj.get(current.node)){
	                        
	                        if(vis[nei]==false){
	                            q.add(new pair(nei,current.node));
	                            vis[nei] = true;
	                        }
	                        else if(nei != current.parent){
	                            return true;
	                        }
	                    }
	            }
	            
	            return false;
	    }
	}

}
