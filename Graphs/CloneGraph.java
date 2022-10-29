package Graph;

import java.io.*;
import java.util.*;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
		
		class Node {
		    public int val;
		    public List<Node> neighbors;
		    public Node() {
		        val = 0;
		        neighbors = new ArrayList<Node>();
		    }
		    public Node(int _val) {
		        val = _val;
		        neighbors = new ArrayList<Node>();
		    }
		    public Node(int _val, ArrayList<Node> _neighbors) {
		        val = _val;
		        neighbors = _neighbors;
		    }
		}
		
	    public Node cloneGraph(Node node) {
	        
	            if(node==null){
	                    return null;
	            }
		    	
		    		HashMap<Node,Node> hm = new HashMap<>();
		    		Stack<Node> st  = new Stack<>();
		    		
		    			st.add(node);
		    			hm.put(node, new Node(node.val,new ArrayList<Node>()));
		    			
		    				while(!st.isEmpty()) {
		    					
		    					Node cur = st.pop();
		    					
		    						for(Node nei : cur.neighbors) {
		    							
		    							if(!hm.containsKey(nei)) {
		    								hm.put(nei,new Node(nei.val,new ArrayList<>()));
		    								st.add(nei);
		    							}
		    							
		    							hm.get(cur).neighbors.add(hm.get(nei));
		    						}
		    				}
		    				
		    				return hm.get(node);
	    }
	}

}
