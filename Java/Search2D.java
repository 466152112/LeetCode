// one pass, treat it as sorted one dimension array, adjust the matrix indices
public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return false;
    int m = matrix.length;
    int n = matrix[0].length;
    int left = 0, right = m * n - 1;
    while (left <= right) {
        int mid = (left + right)/2;
        int row = mid / n;
        int column = mid % n;
        if (matrix[row][column] == target)
            return true;
        else if (matrix[row][column] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }
    return false;
}
