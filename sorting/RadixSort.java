package Algorithms;

import java.util.*;

public class RadixSort {

	//Radix Sort takes O(d*(n+b)) time where b is the base for representing numbers, for example,
	//for the decimal system, b is 10. What is the value of d? If k is the maximum possible value, 
	//then d would be O(logb(k)). So overall time complexity is O((n+b) * logb(k)).
	
	// what is the reason we used counting sort ? because it is a stable sort
	// it keeps an element last in the sorted array which was last in the given array
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {789,56,42,9632,1,6,10000};
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i<a.length; i++) {
			max = Math.max(max,a[i]);
		}
		
		int dig = (int)Math.log10((double)max)+1;
		
		int exp = 1;
		
		for(int i = 0; i<dig; i++) {
			countingSort(a,exp);
			exp = exp*10;
		}
		
		for(int e : a) {
			System.out.print(e+" ");
		}
	}
	
	static void countingSort(int a[] , int exp) {
		
		int freq[] = new int[10];
		int n = a.length;
		for(int i = 0; i<n; i++) {
			freq[(a[i]/exp)%10]++;
		}
		
		int pre[] = new int[10];
		pre[0] = freq[0];
		
		for(int i =1; i<10; i++) {
			pre[i] = pre[i-1]+freq[i];
		}
		
		int ans[]  = new int[n];
		
		for(int i = n-1; i>=0; i--) {
			int ind = pre[(a[i]/exp)%10]-1;
			ans[ind] = a[i];
			pre[(a[i]/exp)%10]--;
		}
		
		for(int i = 0; i<n; i++) {
			a[i] = ans[i];
		}
	}

}
