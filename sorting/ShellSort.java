 package Algorithms;

import java.util.*;


// Shell sort is an improved version of the straight Insertion Sort algorithm.

//In insertion sort, we move elements only one position ahead. When an element has to be moved far
//ahead, many movements are involved. The idea of shellSort is to allow exchange of far items. In 
//shellSort, we make the array h-sorted for a large value of h. We keep reducing the value of h until 
//it becomes 1. An array is said to be h-sorted if all sublists of every h’th element is sorted.

//Following is the implementation of ShellSort.


//Time Complexity : 

// Best case : O(nlogn)  already sorted
// avg. vase : O(nlogn)	random
// worst case : O(n^2)	reversely sorted

// Space complexity : O(1)
	
public class ShellSort {

	
	public static void main(String[] args) {

		int a[] = {12,34,54,2,3};
		
		int n = a.length;
		
		for(int gap = n/2; gap>=1; gap=gap/2) {
			
			for(int i = gap; i<n; i++) {
				
				int cur = a[i];
				int j;
				for(j = i; j>=gap && a[j-gap]>a[j]; j-=gap) {
					a[j] = a[j-gap];
				}
				a[j] = cur;
			}
		}
		
	}
	
	


}
