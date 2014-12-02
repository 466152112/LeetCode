public boolean isMatch(String s, String p) {
    if (s == null || p == null)
        return false;
    char[] a = s.toCharArray();
    char[] b = p.toCharArray();
    return helpMatch(a, 0, b, 0);
}

private boolean helpMatch(char[] a, int a_start, char[] b, int b_start) {
    // match to the end of both string
    if (a_start == a.length && b_start == b.length)
        return true;
    // if b is *
    if (b_start < b.length - 1 && b[b_start + 1] == '*') {
        // keep scan a, until matching /or a != b* /or a meet the end
        while (a_start < a.length && (a[a_start] == b[b_start] || b[b_start] == '.')) {
            if (helpMatch(a, a_start, b, b_start + 2))
                return true;
            else
                a_start++;
        }
        // * deal with zero case not match, and a_start == a.length
        return helpMatch(a, a_start, b, b_start + 2);
    }
    // normal case
    else if (a_start < a.length && b_start < b.length && (a[a_start] == b[b_start] || b[b_start] == '.')) {
        return helpMatch(a, a_start + 1, b, b_start + 1);
    }
    else
        return false;
}
