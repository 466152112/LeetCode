// prove by contradiction
public int maxArea(int[] height) {
    if (height == null)
        return 0;
    int result = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
        result = Math.max(Math.min(height[left], height[right])*(right - left), result);
        if (height[left] > height[right])
            right--;
        else
            left++;
    }
    return result;
}
