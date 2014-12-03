// use my own stack to store the left bound index
// thanks to Ada's great mama http://n00tc0d3r.blogspot.ca/2013/03/largest-rectangle-in-histogram.html?view=classic
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
// a new way instead of go back and finish all
    private int maxHist(int[] hist) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= hist.length; i++) {
            int rightBound = i == hist.length? -1:hist[i];
            if (stack.isEmpty() || rightBound >= hist[stack.peek()])
                stack.push(i);
            else if (!stack.isEmpty()){
                int h = hist[stack.pop()];
                int w = stack.isEmpty()? i : i - stack.peek() - 1;
                max = Math.max(max, h*w);
                i--;
            }
        }
        return max;
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
