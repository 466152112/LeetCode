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
