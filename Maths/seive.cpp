#define LIM x

bool is_prime[LIM+1];
 
void seive()
{
    is_prime[0] = is_prime[1] = 1;
 
    for (ll i = 2; (ll)(i*i)<=(LIM); i++)
    {
        if (is_prime[i]==0)
        {
            for (ll j = i * i; j <= LIM; j += i)
            {
                is_prime[j]=1;

            }

        }
 
    }
 
}
