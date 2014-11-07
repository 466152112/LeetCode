// cheating, using the formular f = C(2n,n)/(n+1)
public int numTrees(int n) {
        float result = 1.0f;
        for (int i = 1; i <= n; i++) {
            result *= (float)(n + i) / i;
        }
        return (int)(result/(1 + n));
}

// induction
//   C(4) = C(0)C(3) + C(1)C(2) + C(2)C(1) + C(3)C(0) = 14
public int numTrees(int n) {
    if (n < 2)
        return n;
    int[] results = new int[n + 1];
    results[0] = 1;
    results[1] = 1;
    for (int i = 2; i <= n; i++) {
        for (int j = 0; j < i; j++) {
            results[i] += results[j]*results[i - j - 1];
        }
    }
    return results[n];
}
