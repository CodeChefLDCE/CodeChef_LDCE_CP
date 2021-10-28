#include<bits/stdc++.h>
using namespace std;


struct FenwickTree {
	// This tree works for function which are inversible like (xor, sum, sub, mult) etc.. not on (AND OR)
	ll n;
	// N is the size of FenwickTree
	// Take note that N is not included in FenwicTree
	vll bst;
	void init(ll x) {
		// X is the required size
		n = x;
		// Initialized with 0 change if you want...
		bst.assign(n, 0);
	}
	ll func(ll k) {
		// O(logN)
		// Find the prefix value of function till k
		ll s = 0;
		while (k >= 1 && k < n) {
			s += bst[k];
			k -= (k & (-k));
		}
		return s;
	}
	void add(ll k, ll x) {
		// O(logN)
		// Add value x to index k
		while (k < n) {
			bst[k] += x;
			k += (k & (-k));
		}
	}
};


int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	return 0;
}