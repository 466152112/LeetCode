// from Wenyi Liu, range loop from the larger end
private static long gcd(long a, long b)
{
    while (b > 0)
    {
        long temp = b; // keep the smaller one
        b = a % b; // % is remainder
        a = temp; // update the smaller
    }
    return a;
}

for i in range(b,1,-1):
    if a%i == 0:
      return i
