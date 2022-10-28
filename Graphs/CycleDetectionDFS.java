package Graph;

import java.io.*;
import java.util.*;

public class CycleDetectionDFS {

	public static void main(String[] args) {

	
		solution s = new  solution();
		
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> zero = new ArrayList<>();
		zero.add(1);
		
		ArrayList<Integer> one = new ArrayList<>();
		one.add(0);
		one.add(4);
		one.add(2);
		
		ArrayList<Integer> two = new ArrayList<>();
		two.add(1);
		two.add(3);
		
		ArrayList<Integer> three = new ArrayList<>();
		three.add(2);
		three.add(4);
		
		ArrayList<Integer> four = new ArrayList<>();
		four.add(1);
		four.add(3);
		
		ArrayList<ArrayList<Integer>> adj = new  ArrayList<ArrayList<Integer>>();
		
		adj.add(zero);
		adj.add(one);
		adj.add(two);
		adj.add(three);
		adj.add(four);
		
		 System.out.println(s.isCycle(5, adj));
		
		
		
	}
	
	static class solution{
		
		
		public boolean isCycle(int V , ArrayList<ArrayList<Integer>> adj) {
			
			boolean vis[] = new boolean[V];
			
			for(int i = 0; i<V; i++) {
				
				if(vis[i]==false) {
					if(hasCycle(i,-1, adj,vis)) {
						return true;
					}
				}
			}
			
			return false;
		}
		
		static boolean hasCycle(int cur,int parent , ArrayList<ArrayList<Integer>> adj, boolean vis[]) {
			
			vis[cur]=true;
			
				for(int nei : adj.get(cur)) {
					
					if(vis[nei]==false) {
						if(hasCycle(nei,cur,adj,vis)) {
							return true;
						}
					}
					else if(nei!=parent) {
						return true;
					}
				}
				
				return false;
		}
	}
	

}
