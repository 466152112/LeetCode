// ArrayList: constructor ArrayList(int i) i is the capacity of the array
// when you know the capacity, you can use set(int index, int value) to set the value, instead of add()
// Use this way to initialize with values : ArrayList<Integer> one = new ArrayList<Integer>(){{add(1);}};
// array.size() is the row number in Pascal Triangle
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


public ArrayList<ArrayList<Integer>> generate(int numRows) {
    ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    if (numRows == 0) {
        return rst;
    }

    ArrayList<Integer> first = new ArrayList<Integer>();
    first.add(0, 1);
    rst.add(first);

    for (int i = 1; i < numRows; i++) {
        ArrayList<Integer> tmp = new ArrayList<Integer>(i + 1);
        for (int j = 0; j < i + 1; j++){
            tmp.add(-1);
        }
        ArrayList<Integer> prev = rst.get(i - 1);
        tmp.set(0, prev.get(0));
        tmp.set(i, prev.get(i - 1));
        for (int j = 1; j < i; j++){
            tmp.set(j, prev.get(j - 1)+prev.get(j));
        }
        rst.add(tmp);
    }
    return rst;
}
