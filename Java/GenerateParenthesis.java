// DP, f(n) = (f_0)f_n-1, (f_1)f_n-2... (f_n-1)f_0
public ArrayList<String> generateParenthesis(int n) {
    ArrayList<ArrayList<String>> allResult = new ArrayList<ArrayList<String>> ();
    ArrayList<String> zero = new ArrayList<String> ();
    zero.add("");
    allResult.add(zero);
    
    for (int i = 1; i <= n; i++) {
        ArrayList<String> result = new ArrayList<String> ();
        for (int j = 0; j < i; j++) {
            for (String first:allResult.get(j)) {
                for (String second:allResult.get(i - 1 - j)) {
                    result.add("(" + first + ")" + second);
                }
            }
        }
        allResult.add(result);            
    }
    return allResult.get(n);
}
