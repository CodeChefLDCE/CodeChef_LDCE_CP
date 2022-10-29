package Graph;

import java.io.*;
import java.util.*;

public class BridgesInGraph {

	public static void main(String[] args) {


		
	}
	
	static void printBridges(ArrayList<ArrayList<Integer>> adj, int n) {
		
		boolean vis[] = new boolean[n];
		int tin[] = new int[n]; // tin : Time of insertion
		int low[] = new int[n];
		
		int timer = 0;
		
		for(int i = 0; i<n; i++) {
			if(vis[i]==false) {
				dfs(i,-1,vis,tin,low,adj,timer);
			}
		}
	}
	
	static void dfs(int node, int parent, boolean vis[], int tin[], int low[], ArrayList<ArrayList<Integer>> adj, int timer) {
		
		vis[node] = true;
		tin[node] = low[node] = timer++;
		
		for(int e : adj.get(node)) {
			if(e==parent) {
				continue;
			}
			
			if(vis[e]==false) {
				dfs(e,node,vis,tin,low,adj,timer);
				low[node] = Math.min(low[node], low[e]);
				
				if(low[e]>tin[node]) {
					System.out.println(e+" "+node);
				}
			}
			else {
				low[node] = Math.min(low[node], tin[e]);
			}
		}
	}

}
