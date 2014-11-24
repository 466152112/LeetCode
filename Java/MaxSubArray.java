// DP, O(N)
public int maxSubArray(int[] A) {
    int result = Integer.MIN_VALUE;        
    if (A == null || A.length == 0)
        return result;
    // one pass, no need to store former sums in the array
    int maxSum = 0;
    for (int i = 0; i < A.length; i++) {
        maxSum = Math.max(A[i], A[i] + maxSum);
        result = Math.max(result, maxSum);
    }
    return result;
}
