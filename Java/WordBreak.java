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

// more effcient
public boolean wordBreak(String s, Set<String> dict) {
    if (s == null || s.length() == 0)
        return false;
    // create a boolean array to keep track whether current location can break or not
    // flag[0] is initial start point, flag[end] is the final result
    boolean[] flag = new boolean[s.length() + 1];
    flag[0] = true;
    for (int i = 0; i < s.length(); i++) {
        for (int j = i + 1; j <= s.length(); j++) {
            // no need to check flag[i], becaue we begin from where flag[i] == true
            if (dict.contains(s.substring(i, j))) {
                flag[j] = true;
            }
        }
        // begin from where flag[i] == true
        while (i < s.length() && flag[i + 1] != true)
            i++;
    }
    return flag[s.length()];
}
