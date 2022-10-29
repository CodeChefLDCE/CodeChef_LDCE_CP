package Graph;
import java.util.*;

public class shortestPathUsingTopoSort {

	static class edge{
		int v;
		int w;
		
		public edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	public static void main(String[] args) {
		
		List<List<edge>> adj = new ArrayList<>();
		
		for(int i = 0; i<8; i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(0).add(new edge(1,3));
		adj.get(0).add(new edge(2,6));
		
		adj.get(1).add(new edge(2,4));
		adj.get(1).add(new edge(3,4));
		adj.get(1).add(new edge(4,11));
		
		adj.get(2).add(new edge(3,8));
		adj.get(2).add(new edge(6,11));
		
		adj.get(3).add(new edge(4,-4));
		adj.get(3).add(new edge(5,5));
		adj.get(3).add(new edge(6,2));
		
		adj.get(4).add(new edge(7,9));
		
		adj.get(5).add(new edge(7,1));
		
		adj.get(6).add(new edge(7,2));
		
		List<Integer> topo = topoSort(adj);
		
		Integer ans[] = shortestPath(3, adj, topo);
		
		for(int i =0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
		
	}
	
	static List<Integer> topoSort(List<List<edge>> adj){

		
		int n = adj.size();
		int in[] = new int[n];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<adj.get(i).size(); j++) {
				in[adj.get(i).get(j).v]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i<n; i++) {
			if(in[i]==0) {
				q.add(i);
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			ans.add(cur);
			
			for(edge nei : adj.get(cur)) {
				in[nei.v]--;
				if(in[nei.v]==0) {
					q.add(nei.v);
				}
			}
		}
		
		return ans;
	}

	static Integer[] shortestPath(int start,List<List<edge>> adj, List<Integer> topo) {
		
		int n = adj.size();
		Integer dist[] = new Integer[n];
		
		dist[start] = 0;
		
		for(int i = 0; i<n; i++) {
			
			if(dist[i]!=null) {
				
				for(edge nei : adj.get(i)) {
					
					if(dist[nei.v]==null) {
						dist[nei.v] = dist[i]+nei.w;
					}
					else {
						dist[nei.v] = Math.min(dist[nei.v], dist[i]+nei.w);
					}
				}
			}
		}
		
		return dist;
	}
}
