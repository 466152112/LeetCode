// think in the the histogram way, build the table
public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return 0;
    int[][] lenTable = new int[matrix.length + 1][matrix[0].length]; // first row zeros for convenient
    int max = 0;
    // initialize the table
    for (int i = 1; i <= matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i - 1][j] == '1')
                lenTable[i][j] = lenTable[i - 1][j] + 1;
        }
    }
    // call the maxHist for each row
    for (int i = 1; i <= matrix.length; i++) {
        max = Math.max(max, maxHist(lenTable[i]));
    }
    return max;
}
//
private int maxHist(int[] hist) {
    Stack<Integer> stack = new Stack<Integer>();
    int max = 0;
    for (int i = 0; i <= hist.length; i++) {
        int rightBound = i == hist.length? -1:hist[i];
        if (stack.isEmpty() || rightBound >= hist[stack.peek()])
            stack.push(i);
        else if (!stack.isEmpty()){
            int h = hist[stack.pop()];
            int w = stack.isEmpty()? i : i - stack.peek() - 1;
            max = Math.max(max, h*w);
            i--;
        }
    }
    return max;
}
