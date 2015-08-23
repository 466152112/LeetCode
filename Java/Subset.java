// same module with permutation, combination (more similar with combination)
// combination is different from permutation,
// permutation care about the order, so any one can be add to the front
// combination is no order, so the front should be from the "start"
// combination is just a specitial case for subset problem, combinations are a small subset of the results of subset problem
public ArrayList<ArrayList<Integer>> subsets(int[] S) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      // actually, no need to check lengt == 0
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
      // biggest difference is : start and check duplicate with the permucation problem
      for (int i = start; i < S.length; i++) {
          oneList.add(S[i]);
          helper(result, oneList, S, i + 1);
          oneList.remove(oneList.size() - 1);
      }
  }


// DP
public ArrayList<ArrayList<Integer>> subsets(int[] S) {
  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
  Arrays.sort(S);
  result = helper(S, S.length - 1);
  // add empty set into the result
  result.add(new ArrayList<Integer>());            
  return result;
}

private ArrayList<ArrayList<Integer>> helper(int[] S, int end) {
  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
  // this if and else can be optimized, think about it
  if (end < 0) {
      return result;
  }
  else {
      ArrayList<Integer> one = new ArrayList<Integer>();
      one.add(S[end]);
      // add current number
      result.add(one);
      ArrayList<ArrayList<Integer>> temp = helper(S, end - 1);
      for (ArrayList<Integer> i:temp) {
        	// add former subsets
          result.add(new ArrayList<Integer>(i));
          // add current number to former subsets
          i.add(S[end]);
          // result.add(i) is enough, because i is no longer used by other objects
          result.add(new ArrayList<Integer>(i));
      }
  }
  return result;
}
