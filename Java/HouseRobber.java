// DP, DP[i] = Math.max(DP[i - 1], DP[i -2] + num[i])
public int rob(int[] num) {
    if (num.length < 2)
        return num.length == 0? 0 : num[0];
    int[] DP = new int[num.length];
    DP[0] = num[0];
    DP[1] = num[0] > num[1] ? num[0] : num[1];
    for (int i = 2; i < num.length; i++) {
        DP[i] = DP[i - 2] + num[i];
        DP[i] = Math.max(DP[i], DP[i - 1]);
    }
    return DP[num.length - 1];
}
