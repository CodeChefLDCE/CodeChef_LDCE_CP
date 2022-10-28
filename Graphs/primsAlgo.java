package Graph;

import java.io.*;
import java.util.*;

public class primsAlgo {

	static class node implements Comparator<node>{ 
		
		int v;
		int weight;
		
		public node(int v , int weight) {
			this.v = v;
			this.weight = weight;
		}
		
		node(){}
		
		
		public int compare(node a, node b) {
			return Integer.compare(a.weight, b.weight);
		}
	}
	
	public static void main(String[] args) {

		
		int n = 5;
        ArrayList<ArrayList<node> > adj = new ArrayList<ArrayList<node> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<node>());
			
		adj.get(0).add(new node(1, 2));
		adj.get(1).add(new node(0, 2));
		
		adj.get(1).add(new node(2, 3));
		adj.get(2).add(new node(1, 3));
	
		adj.get(0).add(new node(3, 6));
		adj.get(3).add(new node(0, 6));
		
		adj.get(1).add(new node(3, 8));
		adj.get(3).add(new node(1, 8));
		
		adj.get(1).add(new node(4, 5));
		adj.get(4).add(new node(1, 5));
		
		adj.get(2).add(new node(4, 7));
		adj.get(4).add(new node(2, 7));
		
		Solution s = new Solution();
		s.prims(adj, n);
	}
	
  static class Solution{
		
		void prims(ArrayList<ArrayList<node>> adj, int n) {
			
			int key[] = new int[n];
			int parent[] = new int[n];
			boolean mstSet[] = new boolean[n];
			
			Arrays.fill(key, Integer.MAX_VALUE);
			
			PriorityQueue<node> pq = new PriorityQueue<node>(n, new node());
			
			key[0] = 0;
			parent[0] = -1;
			pq.add(new node(key[0],0));
			
			while(!pq.isEmpty()) {
				
				int u = pq.poll().v;
				mstSet[u] = true;
				
				for(node e : adj.get(u)) {
					
					if(mstSet[e.v]==false && e.weight<key[e.v]) {
						parent[e.v] = u;
						key[e.v] = e.weight;
						pq.add(new node(e.v,key	[e.v]));
					}
				}
			}
			
			for(int  i =1; i<n; i++) {
				System.out.println(parent[i]+"->"+i);
			}
		}
	}
  
  

}
