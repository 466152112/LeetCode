// Nine chaper module: add and remove
public ArrayList<ArrayList<Integer>> permute(int[] num) {
    if (num == null || num.length == 0)
        return null;
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> oneList = new ArrayList<Integer>();
    helper(num, result, oneList);
    return result;
}

private void helper(int[] num, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> oneList) {
    if (oneList.size() == num.length) {
        result.add(new ArrayList<Integer>(oneList));
        return;
    }
    for (int i = 0; i < num.length; i++) {
        if (oneList.contains(num[i]))
            continue;
        oneList.add(num[i]);
        helper(num, result, oneList);
        oneList.remove(oneList.size() -1 );
    }
}


// DP, add from location 0 to len - 1, based on former result
public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length < 1)
            return null;
        else if (num.length == 1){
            // ArrayList<Integer>(int c), c is the capacity
            ArrayList<Integer> one = new ArrayList<Integer>();
            one.add(num[0]);
            result.add(one);
        }
        else {
            ArrayList<ArrayList<Integer>> previous = permute(Arrays.copyOfRange(num,0,num.length -1));
            for (ArrayList<Integer> now:previous) {
                for (int i = 0; i < num.length; i++) {
                    now.add(i,num[num.length -1]);
                    // add, is just add the reference to the list, if we remove later, it will effect the result
                    result.add(new ArrayList<Integer>(now));
                    now.remove(i);
                }
            }
        }
        return result;
    }
