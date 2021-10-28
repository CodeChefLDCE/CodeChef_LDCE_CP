#include <iostream>
#include <bits/stdc++.h> 
using namespace std;
#define ll long long 

void swap(int arr[],int i,int j)
{
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}
int partition(int arr[],int l,int r)
{
    int pivot=arr[r];
    int i=l-1;
    for(int j=l;j<r;j++){
        if(arr[j]<pivot)
        {
            i++;
            swap(arr,i,j);
        }
    }
    swap(arr,i+1,r);
    return i+1;
}
void QuickSort(int arr[],int l,int r){
    if(l<r)
    {
        int i=partition(arr,l,r);
        QuickSort(arr,l,i-1);
        QuickSort(arr,i+1,r);
    }
}

int main()
{
//   freopen('input.txt', 'r', stdin);
//   freopen('output.txt', 'w', stdout);
    ios::sync_with_stdio(0);
    cin.tie(0);
    ll t,n;
    int arr[5]={5,4,3,2,1};
    QuickSort(arr,0,4);
    for(ll i=0;i<5;i++)
    {
        cout<<arr[i]<<" ";
    }
    
   return 0;
}
