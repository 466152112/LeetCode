public int lengthOfLastWord(String s) {
    s = s.trim();
    return s.length() - s.lastIndexOf(' ') - 1;
}

// without using trim and lastIndexOf
public int lengthOfLastWord(String s) {
    if (s == "")
        return 0;
    char[] c = s.toCharArray();
    int end = deleteLastWhite(c);
    if (end == -1)
        return 0;
    int begin = findLastWhite(c, end);
    return end - begin;
}
// find the last index of non white space, "  abc  " return 4, index of 'c', return -1 if all white
private int deleteLastWhite(char[] c) {
    int len = c.length;
    while (len > 0 && c[len -1] == ' ')
        len--;
    return len - 1;
}
// find the last index of white space, "  abc" return 1, is there no space, return -1
private int findLastWhite(char[] c, int end) {
    int index = -1;
    for (int i = 0; i < end; i++) {
        if (c[i] == ' ')
            index = i;
    }
    return index;
}
