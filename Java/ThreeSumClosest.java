public class Solution {
    // return the closest sum to the target
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3)
            return -1;
        Arrays.sort(num);
        int result = -1, distance = Integer.MAX_VALUE;
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1, right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum > target) {
                    right--;
                }
                else if (sum < target) {
                    left++;
                }
                else
                    return sum;
                if (Math.abs(sum - target) < distance) {
                    distance = Math.abs(sum - target);
                    result = sum;
                }
            }
        }
        return result;
    }
}
