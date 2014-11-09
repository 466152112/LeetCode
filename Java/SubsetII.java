public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (S == null || S.length == 0)
        return result;
    ArrayList<Integer> oneList = new ArrayList<Integer>();
    Arrays.sort(S);
    helper(result, oneList, S, 0);
    return result;
}
private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> oneList, int[] S, int start) {
    result.add(new ArrayList<Integer>(oneList));
    for (int i = start; i < S.length; i++) {
        // skip i == start, because it always need to be added to the set
        // check whether this one is the same with former one
        if (i != start && S[i] == S[i - 1])
            continue;
        oneList.add(S[i]);
        helper(result, oneList, S, i + 1);
        oneList.remove(oneList.size() - 1);
    }
}
