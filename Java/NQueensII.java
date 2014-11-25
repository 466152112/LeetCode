// same with NQueen I, instead adding the the result arraylist, adding a global variable by 1
private int result;
public int totalNQueens(int n) {
    result = 0;
    if (n < 1)
        return result;
    search(new ArrayList<Integer>(), n);
    return result;
}

private void search(ArrayList<Integer> cols, int n) {
    if (!isValidBoard(cols))
        return;
    if (cols.size() == n) {
        result++;
        return;
    }
    for (int i = 0; i < n; i++) {
        if (cols.contains(i))
            continue;
        cols.add(i);
        search(cols, n);
        cols.remove(cols.size() - 1);
    }
}

private boolean isValidBoard(ArrayList<Integer> cols) {
    for (int i = 0; i < cols.size() - 1; i++) {
        for (int j = i + 1; j < cols.size(); j++) {
            if (cols.get(j) == cols.get(i) + j - i || cols.get(j) == cols.get(i) - j + i)
                return false;
        }
    }
    return true;
}
