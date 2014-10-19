public class Solution {
    public int reverse(int x) {
        // NO need to check negative, only in python, the negtive mod is different
        int neg = 1;
        if (x < 0) {
            neg = -1;
            x = -x;
        }
        int result = 0, remainder = 0;
        //quotient = x
        while (x !=0) {
            remainder = x%10;
            x = x/10;
            result = 10*result + remainder;
        }
        return result*neg;
    }
}
