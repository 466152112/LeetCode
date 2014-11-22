// create the flag table, update the min cut value using DP
public int minCut(String s) {
    if (s.length() == 0 || s.length() == 1)
        return 0;
    int len = s.length();
    boolean[][] flag = new boolean[len][len];
    int[] minArray = new int[len + 1];
    minArray[0] = -1;
    setFlag(flag, s);
    for (int i = 0; i < len; i++) {
        minArray[i + 1] = Integer.MAX_VALUE;
        for (int j = 0; j <= i; j++) {
            if (flag[i][j]) {
                minArray[i + 1] = Math.min(minArray[j] + 1, minArray[i + 1]);
            }
        }
    }
    return minArray[len];
}

private void setFlag(boolean[][] flag, String s) {
    for (int i = 0; i < s.length(); i++)
        flag[i][i] = true;
    for (int i = 1; i < s.length(); i++) {
        flag[i][i - 1] = s.charAt(i) == s.charAt(i - 1);
    }            
    for (int i = 2; i < s.length(); i++) {
        for (int j = 0; j < i - 1; j++) {
            flag[i][j]
                = flag[i - 1][j + 1] && s.charAt(i) == s.charAt(j);
        }
    }
}
