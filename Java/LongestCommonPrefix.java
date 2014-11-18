// scan whole array, find one common char, rescan to find the second common char
public String longestCommonPrefix(String[] strs) {
    int len = strs.length;
    if (len == 0)
        return "";
    else if (len == 1)
        return strs[0];
    StringBuilder sb = new StringBuilder();
    int j = 0;
    while (true) {
        for (int i = 0; i < len - 1; i++) {
            if (j == strs[i].length() || j == strs[i+1].length())
                return sb.toString();
            if (strs[i].charAt(j) != strs[i+1].charAt(j))
                return sb.toString();
        }
        sb.append(strs[0].charAt(j++));
    }
}

// optimize by keeping other strings compared with string[0]
public String longestCommonPrefix(String[] strs) {
    int len = strs.length;
    if (len == 0)
        return "";
    else if (len == 1)
        return strs[0];
    StringBuilder sb = new StringBuilder();
    int j = 0;
    String first = strs[0];
    while (true) {
        for (int i = 1; i < len; i++) {
            if (j == first.length() || j == strs[i].length() || first.charAt(j) != strs[i].charAt(j))
                return sb.toString();
        }
        sb.append(first.charAt(j++));
    }
}

// find the longest common prefix between 1st and 2st string, then find the prefix with 3th and 4th ....
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
        return "";
    }
    String prefix = strs[0];
    for(int i = 1; i < strs.length; i++) {
        int j = 0;
        while( j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
            j++;
        }
        if( j == 0) {
            return "";
        }
        prefix = prefix.substring(0, j);
    }
    return prefix;
}
