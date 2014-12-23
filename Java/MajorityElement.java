public class Solution {
    // Moore Voting
    public int majorityElement(int[] num) {
        if (num == null || num.length == 0)
            return null;
        int maj = num[0];
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (maj == num[i])
                count++;
            else if (count > 1)
                count--;
            else {
                maj = num[i];
            }
        }
        return maj;
    }
}
