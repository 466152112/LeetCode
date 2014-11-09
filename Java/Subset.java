// same module with permutation, combination (more similar with combination)
public ArrayList<ArrayList<Integer>> subsets(int[] S) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      if (S == null || S.length == 0)
          return result;
      ArrayList<Integer> oneList = new ArrayList<Integer>();
      Arrays.sort(S);
      helper(result, oneList, S, 0);
      return result;
  }
  private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> oneList, int[] S, int start) {
  // bacause we should add null as a subset
      result.add(new ArrayList<Integer>(oneList));
      for (int i = start; i < S.length; i++) {
          oneList.add(S[i]);
          helper(result, oneList, S, i + 1);
          oneList.remove(oneList.size() - 1);
      }
  }
