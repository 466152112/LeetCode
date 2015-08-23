// combination is different from permutation,
// permutation care about the order, so any one can be add to the front
// combination is no order, so the front should be from the "start"
// combination is just a specitial case for subset problem, combinations are a small subset of the results of subset problem
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
        // use start to get rid of the digits that have been visited
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
