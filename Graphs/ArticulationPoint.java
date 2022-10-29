package Graph;

import java.io.*;
import java.util.*;

public class ArticulationPoint {

	public static void main(String[] args) {

		
	}
	
	static void printArticulation(ArrayList<ArrayList<Integer>> adj, int n) {
		
		boolean vis[] = new boolean[n];
		int tin[] = new int[n];
		int low[] = new int[n];
		
		int isArticulation[] = new int[n];
		
		int timer = 0;
		
		for(int i = 0; i<n; i++) {
			if(vis[i]==false) {
				dfs(i,-1,vis,tin,low,adj,timer,isArticulation);
			}
		}
	}
	
	static void dfs(int node, int parent,boolean vis[],int tin[],int low[],ArrayList<ArrayList<Integer>> adj,int timer, int isArticulation[]) {
		
		vis[node] = true;
		tin[node] = low[node] = timer++;
		int child = 0;
		
		for(int e : adj.get(node)) {
			
			if(e==parent) {
				continue;
			}
			
			if(vis[e]==false) {
				dfs(e,node,vis,tin,low,adj,timer,isArticulation);
				low[node] = Math.min(low[node],low[e]);
				
				if(low[e]>=tin[node] && parent!=-1) {
					isArticulation[node] = 1;
				}
				child++;
			}
			else {
				low[node] = Math.min(low[node], tin[e]);
			}
		}
		
		if(parent==-1 && child>1) {
			isArticulation[node] = 1;
		}
	}

}
