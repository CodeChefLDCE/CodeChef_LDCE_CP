long long binary_expo(long long a, long long b, long long mod)
{
    long long ans = 1;

    while(b > 0)
    {
        if(b % 2 == 0)
        {
            a = ((a % mod) * 1LL * (a % mod)) % mod;
            b = (b) / 2;

        }

        else
        {
            ans = ((ans % mod) * 1LL * (a % mod)) % mod;
            b--;

        }

    }

    return ans % mod;

}
