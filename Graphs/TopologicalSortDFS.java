package Graph;

import java.io.*;
import java.util.*;

public class TopologicalSortDFS {

	public static void main(String[] args) {

		
	}
	

static class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
    	
    	Stack<Integer> st = new Stack<>();
    	
    	boolean vis[] = new boolean[V];
    		
    		for(int i = 0; i<V; i++) {
    			
    			if(vis[i]==false) {
    				dfsTopoSort(i, adj, vis, st);
    			}
    		}
    		
    		int res[] = new int[V];
    		
    		for(int i = 0; i<V; i++) {
    			res[i] = st.pop();
    		}
    		
    		return res;
    }
    
    static void dfsTopoSort(int cur, ArrayList<ArrayList<Integer>> adj , boolean vis[] , Stack<Integer> st) {
    	
    	vis[cur] = true;
    		
    		for(int e : adj.get(cur)) {
    			
    			if(vis[e]==false) {
    				dfsTopoSort(e,adj,vis,st);
    			}
    		}
    		
    		st.add(cur);
    }
}
 

}
