package Algorithms;
import java.util.*;


// In some scenarios where the distribution of data is quite uniform buckets sort can help us get a better time complexity
// It can be said that bucket sort kind of puts a limitation on the data set to improve performance
// The bucket sort algorithm works slightly based on the divide and conquer approach

//  new explain the approach
// also mention that you can neither form too many buckets because it costs space and on the other hand we can not form 
// just a few buckets because then each bucket would have many elements in it


//The average time complexity for Bucket Sort is O(n + k). The worst time complexity is O(n²).
//The space complexity for Bucket Sort is O(n+k).


public class BucketSort {

	public static void main(String[] args) {
		
		int a[] = {11,9,21,8,17,19,13,1,24,12,21,22};
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int n = a.length;
		
		for(int i = 0; i<a.length; i++) {
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}
		
		int range = max-min;
		int numOfBuckets = (int)Math.ceil((double)(n/range));
		
		
		LinkedList<Integer>[] buckets = new LinkedList[numOfBuckets];
		
		for(int i = 0; i<numOfBuckets; i++) {
			buckets[i] = new LinkedList<>();
		}
		
		
		for(int e : a) {
			buckets[hash(e,numOfBuckets,range)].add(e);
		}
		
		for(LinkedList<Integer> cur : buckets) {
			Collections.sort(cur);
		}
		
		int ind = 0;
		int sortedArray[] = new int[a.length];
		
		for(LinkedList<Integer> cur : buckets) {
			for(int num : cur) {
				sortedArray[ind] = num;
				ind++;
			}
		}
	}


	static int hash(int e, int numOfBuckets, int range) {
		return 0;
	}
}

