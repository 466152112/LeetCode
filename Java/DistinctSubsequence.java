// DP, tables
public int numDistinct(String S, String T) {
    if (S == null || T == null)
        return 0;
    int[][] num = new int[S.length() + 1][T.length() + 1];
    for (int i = 0; i < num.length; i++)
        num[i][0] = 1;
    for (int i = 1; i <= S.length(); i++) {
        for (int j = 1; j <= T.length(); j++) {
            num[i][j] = num[i - 1][j];  // at least equal to the string without S[i]
            if (S.charAt(i - 1) == T.charAt(j - 1))
                num[i][j] += num[i - 1][j - 1];  // if S[i]==T[j], remove them both, adding num[i -1][j - 1]
        }
    }
    return num[S.length()][T.length()];
}
