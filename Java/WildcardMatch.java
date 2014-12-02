// backtracking, back to the last safe location
public boolean isMatch(String s, String p) {
    if (s == null || p == null)
        return false;
    char[] a = s.toCharArray();
    char[] b = p.toCharArray();
    int i = 0, j = 0;
    boolean foundStar = false;  // found * or not
    int safeLocationI = 0;  // save the safe index in string s, which is right after *
                            // and will increase when every backtracking
    int safeLocationJ = 0;  // save the safe index in patten, which is right after *
    while (i < a.length) {
        // j reach b.length before i meet a.length is also a mismatch
        if (j < b.length && (a[i] == b[j] || b[j] == '?')) {
            i++;
            j++;
        }
        else if (j < b.length && b[j] == '*') {
            foundStar = true; // update safteLocation for new star
            safeLocationI = i + 1;
            safeLocationJ = j + 1;
            j++;
        }
        else if (foundStar) {
            i = safeLocationI++;    // saftI increase when backtracking
            j = safeLocationJ;
        }            
        else
            return false;
    }
    // deal with the remain * in patten
    while (j < b.length) {
        if (b[j] != '*')
            return false;
        j++;
    }
    return true;
}

// recurive, similar with the regular expression solutuon, TLE
public boolean isMatch(String s, String p) {
    if (s == null || p == null)
        return false;
    char[] a = s.toCharArray();
    char[] b = p.toCharArray();
    return helpMatch(a, 0, b, 0);
}

private boolean helpMatch(char[] a, int a_start, char[] b, int b_start) {
    // matched til the end of each string
    if (a_start == a.length && b_start == b.length)
        return true;
    // b is *, keep scan a
    if (b_start < b.length && b[b_start] == '*') {
        while (a_start <= a.length) {
            // keep scaning a, until true, or a reached end
            if (helpMatch(a, a_start, b, b_start + 1))
                return true;
            else
                a_start++;
        }
        return false;
    }
    // normal case, move one step ahead
    else if (a_start < a.length && b_start < b.length && (a[a_start] == b[b_start] || b[b_start] == '?')) {
        return helpMatch(a, a_start + 1, b, b_start + 1);
    }
    else
        return false;
}
