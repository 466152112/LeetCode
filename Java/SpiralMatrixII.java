// similar DP recursive, but more efficient coding
public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];        
    if (n < 1)
        return result;
    int value = 1;
    helper(result, 0, n - 1, value);
    return result;
}

private void helper(int[][] result, int start, int end, int value) {
    // start is the up-left index, end is the down-right index
    if (start > end);
    // only one element in the sub matrix
    else if (start == end)
        result[start][end] = value;
    else {
        // set first row
        for (int i = start; i < end; i++)
            result[start][i] = value++;
        // set last column
        for (int i = start; i < end; i++)
            result[i][end] = value++;         
        // set last row
        for (int i = end; i > start; i--)
            result[end][i] = value++;      
        // set first column
        for (int i = end; i > start; i--)
            result[i][start] = value++; 
        // recursive adding sub matrix
        helper(result, start + 1, end - 1, value);   
    }
}
