// move one by one, O(k*n)
public void rotate(int[] nums, int k) {
    for (int i = 0; i < k; i++) {
        int temp = nums[nums.length-1];
        for (int j = nums.length - 1; j > 0; j--)
            nums[j] = nums[j - 1];
        nums[0] = temp;
    }
}

// trick, 3 times reverse
public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}
private void reverse(int[] nums, int i, int j) {
    while (i < j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
        j--;
    }
}
