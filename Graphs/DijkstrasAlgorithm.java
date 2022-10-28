package Graph;

import java.io.*;

import java.util.*;


public class DijkstrasAlgorithm {

	// This Algorithm finds the Shortest Path  in an Undirected Graph which has different weights on different edges
	
	// This algorithm at last would return an array with shortest dist. from source to every node.
	
	static class pair{
		
		int node;
		int dist;
		
			public pair(int node, int dist) {
				this.node = node;
				this.dist = dist;
			}
	}
	
	public static void main(String[] args) {

		int n = 5;
        ArrayList<ArrayList<pair> > adj = new ArrayList<ArrayList<pair> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<pair>());
			
		adj.get(0).add(new pair(1, 2));
		adj.get(1).add(new pair(0, 2));
		
		adj.get(1).add(new pair(2, 3));
		adj.get(2).add(new pair(1, 3));
	
		adj.get(0).add(new pair(3, 6));
		adj.get(3).add(new pair(0, 6));
		
		adj.get(1).add(new pair(3, 8));
		adj.get(3).add(new pair(1, 8));
		
		adj.get(1).add(new pair(4, 5));
		adj.get(4).add(new pair(1, 5));
		
		adj.get(2).add(new pair(4, 7));
		adj.get(4).add(new pair(2, 7));
		
		shortestPath(0,adj,n);
	}
	
	static void shortestPath(int src, ArrayList<ArrayList<pair>> adj, int n) {
		
		int dist[] = new int[n];
		
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[src] = 0;
			
			PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<pair>() {
				
				public int compare(pair a, pair b) {
					
					if(a.dist==b.dist) {
						return Integer.compare(a.node, b.node);
					}
					
					return Integer.compare(a.dist, b.dist);
				}
			});
			
			pq.add(new pair(src,0));
			
				while(!pq.isEmpty()) {
					
					pair cur  = pq.poll();
					
						for(pair e : adj.get(cur.node)) {
							
							if(dist[cur.node]+e.dist<dist[e.node]) {
								dist[e.node] = dist[cur.node]+e.dist;
								pq.add(new pair(e.node, dist[e.node]));
							}
						}
				}
				
				for(int i = 0; i<n; i++) {
					System.out.print(dist[i]+" ");
				}
	}

}
