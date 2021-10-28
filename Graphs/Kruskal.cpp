#include <iostream>
#include <bits/stdc++.h> 
using namespace std;

const int N = 1e5 +6;
vector<int> parent(N);
vector<int> size(N);
void make_set(int v)
{
    parent[v]=v;
    size[v]=1;
}
int find_set(int v)
{
    if(v==parent[v])
    {
        return v;
    }
    return parent[v]= find_set(parent[v]);
}
void union_set(int a, int b)
{
    a=find_set(a);
    b=find_set(b);
    if(a!=b)
    {
        if(size[a]<size[b])
        {
            swap(a,b);
        }
        parent[b]=a;
        size[a]+=size[b];
    }
}




/////////////////////////////////////////////////////////////////////////////////////////
int main()
{


    ios::sync_with_stdio(0);
    cin.tie(0);


    for(int i=0;i<N;i++)
    {
        make_set(i);
    }
    int n,m;
    cin>>n>>m;
    vector<vector<int>> edges,fin;
    for(int i=0;i<m;i++)
    {
        int u,v,w;
        cin>>u>>v>>w;
        edges.push_back({w,u,v});
       
    }
    sort(edges.begin(),edges.end());
    cout<<"node node weight\n";
    for(auto i :edges)
    {
        int u=i[1];
        int v=i[2];
        int x=find_set(u);
        int y=find_set(v);
        if(x!=y){
            union_set(u,v);
            fin.push_back({i[1],i[2],i[0]});
            cout<<i[1]<<" "<<i[2]<<" "<<i[0]<<"\n";
        }
    }
    
   return 0;
}
