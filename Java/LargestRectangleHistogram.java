// use my own stack to store the left bound index
public int largestRectangleArea(int[] height) {
    if (height == null || height.length == 0)
        return 0;
    Stack<Integer> indexStack = new Stack<Integer>();
    int maxArea = 0;
    for (int i = 0; i < height.length; i++) {
        // larger than former one, push into stack
        if (indexStack.isEmpty() || height[i] >= height[indexStack.peek()])
            indexStack.push(i);
        else {
            // found a smaller one, it's the right bound
            // go to stack.peek() find the left bound, time the weight with the min height below
            int minIndex = indexStack.pop();
            maxArea = Math.max(maxArea, height[minIndex]*(indexStack.isEmpty() ? i : i - indexStack.peek() - 1));
            i--;
        }
    }
    // got the end, go back finish all area
    while (!indexStack.isEmpty()) {
        int minIndex = indexStack.pop();
        maxArea = Math.max(maxArea, height[minIndex]*(indexStack.isEmpty() ? height.length : height.length - indexStack.peek() - 1));
    }
    return maxArea;
}
// naive recursive, TLE
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
