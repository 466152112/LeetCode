public ArrayList<ArrayList<Integer>> generate(int numRows) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (numRows < 1)
        return result;
    ArrayList<Integer> one = new ArrayList<Integer>(){{add(1);}};
    result.add(one);
    while (numRows > 1) {
        result.add(helper(result.get(result.size() -1)));
        numRows--;
    }
    return result;
}
private ArrayList<Integer> helper(ArrayList<Integer> list) {
    ArrayList<Integer> result  = new ArrayList<Integer>(){{add(1);}};
    for (int i = 0; i < list.size() - 1; i++) {
        result.add(list.get(i) + list.get(i+1));
    }
    result.add(1);
    return result;
}
