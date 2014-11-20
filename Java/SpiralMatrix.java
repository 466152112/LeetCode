// DP recursive
public ArrayList<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> result = new ArrayList<Integer> ();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return result;
    helper(matrix, result, 0, 0, matrix.length - 1, matrix[0].length - 1);
    return result;
}

private void helper(int[][] matrix, ArrayList<Integer> result, int i_start, int j_start, int i_end, int j_end) {
    // stop situation
    if (i_start > i_end || j_start > j_end)
        return;
    // only one element in the sub matrix
    if (i_start == i_end && j_start == j_end) {
        result.add(matrix[i_start][j_start]);
        return;
    }
    // only one row in the sub matrix
    if (i_start == i_end) {
        // add this row
        for (int j = j_start; j <= j_end; j++)
            result.add(matrix[i_start][j]);
        return;
    }
    // only one column in the sub matrix
    if (j_start == j_end) {
        // add this column
        for (int i = i_start; i <= i_end; i++)
            result.add(matrix[i][j_start]);            
        return;
    }
    // other cases, recursive adding all
    // add first row
    for (int j = j_start; j < j_end; j++)
        result.add(matrix[i_start][j]);
    // add last column
    for (int i = i_start; i < i_end; i++)
        result.add(matrix[i][j_end]);            
    // add last row
    for (int j = j_end; j > j_start; j--)
        result.add(matrix[i_end][j]);        
    // add first column
    for (int i = i_end; i > i_start; i--)
        result.add(matrix[i][j_start]);
    // recursive adding sub matrix
    helper(matrix, result, i_start + 1, j_start + 1, i_end - 1, j_end - 1);
}
