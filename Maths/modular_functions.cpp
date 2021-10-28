template<typename T> T getmod(T x, T m)
{
    T z = x % m;

    if(z >= 0) return z;
    return (z + m);
}

long long mod_add(long long a, long long b, long long m)
{
    a = getmod(a, m);
    b = getmod(b, m);
    return (((a + b) % m) + m) % m;
}

long long mod_mul(long long a, long long b, long long m)
{
    a = getmod(a, m);
    b = getmod(b, m);
    return (((a * b) % m) + m) % m;
}

long long mod_sub(long long a, long long b, long long m)
{
    a = getmod(a, m);
    b = getmod(b, m);
    return (((a - b) % m) + m) % m;
}
