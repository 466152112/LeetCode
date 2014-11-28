// duplicates in candidates, but only use element once
public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (candidates == null || candidates.length == 0)
        return result;
    ArrayList<Integer> one = new ArrayList<Integer>();
    Arrays.sort(candidates);
    helper(candidates, target, result, one, 0);
    return result;
}

private void helper(int[] candidates, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> one, int start) {
    if (target == 0) {
        result.add(new ArrayList<Integer>(one));
        return;
    }
    int previous = -1;
    for (int i = start; i < candidates.length; i++) {
        // target positive and no duplicates
        if (previous != candidates[i] && target >= 0) {
            previous = candidates[i];
            one.add(candidates[i]);
            helper(candidates, target - candidates[i], result, one, i + 1);
            one.remove(one.size() - 1);
        }
    }
}
