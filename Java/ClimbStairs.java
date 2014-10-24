// it's like Fibonacci
// recursive
public int climbStairs(int n) {
    if (n < 1)
        return 0;
    else if (n == 1)
        return 1;
    else if (n == 2)
        return 2;
    else
        // will calculate some number multiple time
        return climbStairs(n-1) + climbStairs(n-2);
}

// loop, much more efficient
public int climbStairs(int n) {
    if (n < 1)
        return 0;
    else if (n == 1)
        return 1;
    else if (n == 2)
        return 2;
    int[] result = new int[n];
    result[0] = 1;
    result[1] = 2;
    for (int i = 2; i < n; i++)
        result[i] = result[i-1] + result[i-2];
    return result[n-1];
}
