public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        return helper(height, 0, height.length - 1);
    }
    
    // recursively get the max area
    private int helper(int[] h, int start, int end) {
        if (start > end)
            return 0;
        int partition = start;
        int lowerst = h[start];
        for (int i = start + 1; i <= end; i++) {
            if (h[i] <= lowerst) {
                lowerst = h[i];
                partition = i;
            }
        }
        return Math.max(lowerst*(end - start + 1), 
            Math.max(helper(h, start, partition - 1), helper(h, partition + 1, end)));
    }
}
