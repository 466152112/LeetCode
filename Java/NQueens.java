// Back-tracking, keep searching solutions, if not work, go back to the latest safe state, so called add, search, remove
// use a columns array to represent the queen in the rows
public ArrayList<String[]> solveNQueens(int n) {
	ArrayList<String[]> result = new ArrayList<String[]>();
	if (n < 1)
		return result;
	ArrayList<Integer> cols = new ArrayList<Integer>();
	search(result, cols, n);
	return result;
}

private void search(ArrayList<String[]> result, ArrayList<Integer> cols,
		int n) {
	// not valid, go back to last safe state
	if (!isValidBoard(cols))
		return;
	// valid and full complete, add to result
	if (cols.size() == n) {
		result.add(getBoard(cols));
		return;
	}
	for (int i = 0; i < n; i++) {
		// avoid checking the queens in the same column
		if (cols.contains(i))
			continue;
		cols.add(i);
		search(result, cols, n);
		cols.remove(cols.size() - 1);
	}
}

private String[] getBoard(ArrayList<Integer> cols) {
	String[] result = new String[cols.size()];
	char[] dots = new char[cols.size()];
	for (int i = 0; i < cols.size(); i++) {
		// fill with dot
		Arrays.fill(dots, '.');
		dots[cols.get(i)] = 'Q';
		result[i] = new String(dots);
	}
	return result;
}

private boolean isValidBoard(ArrayList<Integer> cols) {
	// only check the left-to-bottem and right-to-bottem
	// since no queens in the same row and column is guaranteed.
	for (int i = 0; i < cols.size() - 1; i++) {
		for (int j = i + 1; j < cols.size(); j++) {
			if (cols.get(j) == cols.get(i) + j - i
					|| cols.get(j) == cols.get(i) - j + i)
				return false;
		}
	}
	return true;
}
