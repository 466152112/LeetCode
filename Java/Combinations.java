// combination is different from permutation,
// permutation care about the order, so any one can be add to the front
// combination is no order, so the front should be from the "start"
public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n < 1 || k < 1 || n < k)
            return result;
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, n, k, 1);
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (list.contains(i))
                continue;
            list.add(i);
            helper(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
