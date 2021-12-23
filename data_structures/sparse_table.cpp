#include <bits/stdc++.h>

using namespace std;

// ADD BELOW LINE WHILE SUBMITING IN RUNNING CONTEST FOR NOT GETTING PLAGIARIZED

// Source - https://github.com/CodeChefLDCE/CodeChef_LDCE_CP/tree/main/data_structures
template<typename T>
struct SparseTable {
    int n,lg;
    vector<int> logs;
    vector<vector<T>> sptable;
private:
    T merge(const T& value1,const T& value2) {
        T ans;
        #warning // comment this line if set properly
        // write your own merge function depending on problem
        // currently it performs addition
        ans=value1+value2;
        return ans;
    }
    // Time Complexity - O( N * log(N) * (complexity of merge function) )
    void build(const vector<T>& arr) {
        for(int j=0;j<=lg;j++) {
            int x=1<<j;
            for(int i=0;(i+x)<=n;i++) {
                if(j==0) sptable[i][j]=arr[i];
                else sptable[i][j]=merge(sptable[i][j-1],sptable[i+(x/2)][j-1]);
            }
        }
    }
    void build(const T arr[]) {
        for(int j=0;j<=lg;j++) {
            int x=1<<j;
            for(int i=0;(i+x)<=n;i++) {
                if(j==0) sptable[i][j]=arr[i];
                else sptable[i][j]=merge(sptable[i][j-1],sptable[i+(x/2)][j-1]);
            }
        }
    }
public:
    // constructor for global sparse table
    // take max value of constraint over n
    // @param - (max_size)
    SparseTable(const int maxn) {
        n=maxn,lg=__lg(n+5);
        sptable=vector<vector<T>> (n+5,vector<T> (lg+5));
        logs=vector<int> (n+5);
        logs[0]=-1; // invalid
        for(int i=1;i<=n;i++) logs[i]=logs[i/2]+1;
    }
    // constructor for local sparse table with building 
    // first parameter is size of array and second is the array
    // @param - (size_of_array,array)
    SparseTable(const int sz,const vector<T>& arr) {
        n=sz,lg=__lg(n+5);
        sptable=vector<vector<T>> (n+5,vector<T> (lg+5));
        logs=vector<int> (n+5);
        logs[0]=-1; // invalid
        for(int i=1;i<=n;i++) logs[i]=logs[i/2]+1;
        build(arr);
    }
    SparseTable(const int sz,const T arr[]) {
        n=sz,lg=__lg(n+5);
        sptable=vector<vector<T>> (n+5,vector<T> (lg+5));
        logs=vector<int> (n+5);
        logs[0]=-1; // invalid
        for(int i=1;i<=n;i++) logs[i]=logs[i/2]+1;
        build(arr);
    }
    // in case of global sparse table  
    // @param - (size_of_array,array)
    void rebuild(const int sz,const vector<T>& arr) {
        n=sz,lg=__lg(n+5);
        build(arr);
    }
    void rebuild(const int sz,const T arr[]) {
        n=sz,lg=__lg(n+5);
        build(arr);
    }
    // here the query should be of type [l,r] (both inclusive)
    // Time Compelxity - O ( log(r-l+1) * (complexity of merge function) )
    // @param - (left_index,right_index)
    T query(int l,int r) {
        // intialize the ans variable with default value
        // like in case of addition - 0, multiplication - 1, gcd - 0
        // currently set for addition;
        #warning // comment this line if set properly
        T ans=0;
        for(int j=logs[r-l+1];j>-1;j--) {
            int x=1<<j;
            if((r-l+1)&x) {
                ans=merge(ans,sptable[l][j]);
                l+=x;
            }
        }
        return ans;
    }
    // should be used in case when the query over some [l,k] and [r-k+1,r] is merged 
    // and the answer doesn't change e.g. gcd,lcm
    // O ( 1 * (complexity of merge function) )
    // @param - (left_index,right_index)
    T Idempotent_query(int l,int r) {
        int j=logs[r-l+1],x=1<<j;
        T ans=merge(sptable[l][j],sptable[r-(x)+1][j]);
        return ans;
    }
    // YOU CAN IMPLEMENT DESTRUCTOR HERE BUT I DON'T KNOW MUCH ABOUT IT 
    // Happy Coding...
};

int main() {
    ios :: sync_with_stdio(0); 
    cin.tie(0); cout.tie(nullptr);
    // Code goes here
    return 0;
}
