// DP keep minSum bottem up
public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0)
        return 0;
    int len = triangle.size();
    int[][] minSum = new int[len][len];
    // set the last row to the initial minSum
    for (int i = 0; i < len; i++) {
        minSum[len -1][i] = triangle.get(len - 1).get(i);
    }
    // pass the minSum up to [0][0]
    for (int i = len - 2; i >= 0; i--) {
        for (int j = 0; j <= i; j++) {
            minSum[i][j] = triangle.get(i).get(j) + 
                            Math.min(minSum[i + 1][j], minSum[i + 1][j + 1]);
        }
    }
    return minSum[0][0];
}

// recursive
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int len = triangle.size();
        int[][] minSum = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            minSum[len -1][i] = triangle.get(len - 1).get(i);
        }
        return helper(triangle, minSum, 0, 0);
    }
    
    private int helper(List<List<Integer>> triangle, int[][] minSum, int i, int j) {
        if (i == triangle.size() - 1)
            return minSum[i][j];
        return Math.min(helper(triangle, minSum, i+1, j), helper(triangle, minSum, i + 1, j + 1))
                    + triangle.get(i).get(j);
    }
