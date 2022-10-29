package Graph;

import java.io.*;
import java.util.*;

public class KruskalsAlgorithm {

	static class Node{
		
		int u;
		int v;
		int wei;
		
			public Node(int u , int v, int wei) {
				this.u =u;
				this.v =v; 
				this.wei  =wei;
			}
			
			Node(){}
	}
	
	public static void main(String[] args) {

		ArrayList<Node> adj= new ArrayList<KruskalsAlgorithm.Node>();
		
		adj.add(new Node(0,2,1));
		adj.add(new Node(0,1,5));
		adj.add(new Node(2,0,1));
		adj.add(new Node(2,1,3));
		adj.add(new Node(1,2,3));
		adj.add(new Node(1,0,5));
		
		System.out.println(kruskalsAlgo(adj, 3));
	}
	
	static int kruskalsAlgo(ArrayList<Node> adj, int n) {
	
		Collections.sort(adj, new Comparator<Node>() {
			
			public int compare(Node a , Node b) {
				
				return Integer.compare(a.wei, b.wei);
			}
		});
		
		int parent[] = new int[n+1];
		int rank[] = new int[n+1];
		
			for(int i = 0; i<=n; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
			
			int minCost = 0;
			
				for(Node e : adj) {
					
					if(findParent(e.u, parent) != findParent(e.v, parent)) {
						minCost += e.wei;
						union(e.u, e.v, parent, rank);
					}
				}
				
				return minCost;
	}
	
	static int findParent(int node, int parent[]) {
		
		if(node == parent[node]) {
			return node;
		}
		
		return parent[node] = findParent(parent[node], parent);
	}
	
	static void union(int a , int b, int parent[], int rank[]) {
		
		a = findParent(a, parent);
		b = findParent(b, parent);

		if(rank[a]>rank[b]) {
			parent[b] = a;
		}
		else if(rank[b]>rank[a]) {
			parent[a] = b;
		}
		else {
			parent[b] = a;
			rank[a]++;
		}
	}

}
