#include <bits/stdc++.h> 
using namespace std;
int a[1000000];
int main()
{
	// freopen("plants.in", "r", stdin);    
	// freopen('output.txt', 'w', stdout);
	ios::sync_with_stdio(0);// Input and output clearance
	cin.tie(0);
	int n;
	cin>>n;
	int a[n],b[n];
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
	}
	for(int i=0;i<n;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(a[i]>a[j])
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
	for(int i=0;i<n;i++)
	{
		cout<<a[i]<<" ";
	}
}

