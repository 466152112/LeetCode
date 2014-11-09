// naive DP, check whether the end is continued with the maxEnd, handle different case using the former result
public class Solution {
    private int maxValue, maxEnd;
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0)
            return Integer.MIN_VALUE;
        maxValue = Integer.MIN_VALUE;
        maxEnd = -1;
        helper(A, A.length - 1);
        return maxValue;
    }
    private void helper(int[] A, int end) {
        if (end == 0 && A[0] > maxValue) {
            maxValue = A[0];
            maxEnd = 0;
        }
        else {
            helper(A, end - 1);
            if (maxEnd == end - 1 && maxValue*A[end] > maxValue) {
                maxValue = maxValue*A[end];
                maxEnd = end;
            }
            else if (maxEnd != end - 1) {
                int temp = 1;
                for (int i = end; i >= 0; i--) {
                    temp *= A[i];
                    if (temp > maxValue) {
                        maxValue = temp;
                        maxEnd = end;
                    }
                }
            }
        }
    }
}
