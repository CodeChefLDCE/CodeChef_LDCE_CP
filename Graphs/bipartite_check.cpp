int col[200005];
vector<vector<int>> a(2e5 + 2);

bool bip(int x, int cc)
{
    col[x] = cc;

    for(auto it : a[x])
    {
        if(col[it] == -1)
        {
            if(!bip(it, 1 - cc))
                return 0;

        }

        else if(col[it] == cc)
            return 0;

    }

    return 1;

}
