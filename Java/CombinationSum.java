// no duplicates in candidates, but can reuse many times
// modify combinations, stop cursor until target < 0
public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (candidates == null || candidates.length == 0)
        return result;
    Arrays.sort(candidates);
    ArrayList<Integer> one = new ArrayList<Integer>();
    helper(candidates, target, result, one, 0);
    return result;
}

private void helper(int[] candidates, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> one, int start) {
    if (target == 0) {
        result.add(new ArrayList<Integer>(one));
        return;
    }
    for (int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                one.add(candidates[i]);
                helper(candidates, target - candidates[i], result, one, i); // not helper(... i + 1)
                one.remove(one.size() - 1);
            }
            else
                break;
    }
}
