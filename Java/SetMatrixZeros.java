// space O(m + n)
// one pass, go through matrix twice, 1, get the indice, 2, set the indices
public void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return;
    HashSet<Integer> rows = new HashSet<Integer> ();
    HashSet<Integer> columns = new HashSet<Integer> ();
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                rows.add(i);
                columns.add(j);
            }
        }
    }
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (rows.contains(i) || columns.contains(j))
                matrix[i][j] = 0;
        }
    }
}

// use the matrix space to store the zero indices
public void setZeroes(int[][] matrix) {
    int rowTemp = -1;   // select a row to store the column indices for the zero element
    int colTemp = -1;   // select a column to store the row indices for the zero element
    
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                // find the first zero element
                if (rowTemp == -1) {
                    rowTemp = i;
                    colTemp = j;
                }
                // update indice in the row and column temp
                else {
                    matrix[rowTemp][j] = 0;
                    matrix[i][colTemp] = 0;
                }
            }
        }
    }
    // no zero in the matrix
    if (rowTemp == -1)
        return;
    // set rows to zero
    for (int i = 0; i < matrix.length; i++) {
        if (i == rowTemp)   // skip the temp row
            continue;
        if (matrix[i][colTemp] == 0) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = 0;
        }
    }
    // set columns to zero
    for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[rowTemp][j] == 0) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][j] = 0;
        }
    }
    // set the final temp row to zero
    for (int j = 0; j < matrix[0].length; j++)
        matrix[rowTemp][j] = 0;
}
