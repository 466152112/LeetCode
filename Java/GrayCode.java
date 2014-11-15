// DP, find patten
public ArrayList<Integer> grayCode(int n) {
    ArrayList<Integer> result = new ArrayList<Integer> ();
    if (n == 0)
        // ask the interviewee about zero case, null or 0
        result.add(0);
    else if (n == 1) {
        result.add(0);
        result.add(1);
    }
    else {
        ArrayList<Integer> temp = grayCode(n - 1);
        for (int i = 0; i < temp.size(); i++) {
            result.add(temp.get(i));
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i) + (int)Math.pow(2, n - 1));
        }
    }
    return result;
}
