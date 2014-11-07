// cheating, using the formular f = C(2n,n)/(n+1)
public int numTrees(int n) {
        float result = 1.0f;
        for (int i = 1; i <= n; i++) {
            result *= (float)(n + i) / i;
        }
        return (int)(result/(1 + n));
}
