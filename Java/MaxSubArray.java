// DP, O(N)
public int maxSubArray(int[] A) {
    int result = Integer.MIN_VALUE;        
    if (A == null || A.length == 0)
        return result;
    int[] maxSums = new int[A.length + 1];
    maxSums[0] = 0;
    for (int i = 0; i < A.length; i++) {
        maxSums[i + 1] = Math.max(A[i], A[i] + maxSums[i]);
        result = Math.max(result, maxSums[i + 1]);
    }
    return result;
}
