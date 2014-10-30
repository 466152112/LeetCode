// O(N^2), using extra O(N^2) space for flags
// DP, S(i,j) = S(i+1,j -1) && s[i] == s[j]
public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return null;
        int len = s.length();
        boolean[][] flag = new boolean[len][len];
        for (int i = 0; i < len; i++)
            flag[i][i] = true;
        int max = 1;
        String result = s.substring(0,1);
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < len - j; i++) {
                if (j == 1)
                    flag[i][i + j] = s.charAt(i) == s.charAt(i + j);
                else
                    flag[i][i + j] = s.charAt(i) == s.charAt(i + j) && flag[i + 1][i + j - 1];
                if (flag[i][i + j] && j + 1 > max) {
                    max = j + 1;
                    result = s.substring(i,i + j + 1);
                }
            }
        }
        return result;
    }
