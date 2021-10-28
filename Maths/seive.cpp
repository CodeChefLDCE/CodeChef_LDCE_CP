#define LIM x

bool is_prime[LIM + 1];

void seive()
{
    is_prime[0] = is_prime[1] = 1;

    for (long long i = 2; (long long)(i * i) <= (LIM); i++)
    {
        if (is_prime[i] == 0)
        {
            for (long long j = i * i; j <= LIM; j += i)
                is_prime[j] = 1;


        }

    }

}
