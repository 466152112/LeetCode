// DP, use former break or not to decide whether current word can help break the string
public boolean wordBreak(String s, Set<String> dict) {
    if (s == null || s.length() == 0)
        return false;
    // create a boolean array to keep track whether current location can break or not
    // flag[0] is initial start point, flag[end] is the final result
    boolean[] flag = new boolean[s.length() + 1];
    flag[0] = true;
    for (int i = 0; i < s.length(); i++) {
        for (int j = i + 1; j <= s.length(); j++) {
            if (dict.contains(s.substring(i, j)) && flag[i] == true) {
                flag[j] = true;
            }
        }
    }
    return flag[s.length()];
}
