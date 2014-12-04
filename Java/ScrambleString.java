/*
For example, given "great" and "rgate", the splits are
("great") vs. ("rgate")
("g", "reat") vs. ("r", "gate") or ("rgat", "e")
("gr", "eat") vs. ("rg", "ate") or ("te", "rga")
("gre", "at") vs. ("rga", "te") or ("ate", "rg")
("grea", "t") vs. ("rgat", "e") or ("gate", "r")
*/
// DP using 3D table, O(N^4)


// recursive O(2^N) exponential, BUT trim lots of unnecessary recursion
public boolean isScramble(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length())
        return false;
    if (s1.equals(s2))
        return true;
    if (!sort(s1).equals(sort(s2))) // this could trim lots of uncessary recursion
        return false;
    for (int i = 1; i < s1.length(); i++) {
        String s1l = s1.substring(0, i);
        String s1r = s1.substring(i);
        String s2l = s2.substring(0, i);
        String s2r = s2.substring(i);
        if (isScramble(s1l, s2l) && isScramble(s1r, s2r))
            return true;
        s2l = s2.substring(0, s2.length() - i);
        s2r = s2.substring(s2.length() - i);
        if (isScramble(s1l, s2r) && isScramble(s1r, s2l))
            return true; 
    }
    return false;
}

private String sort(String s) {
    char[] a = s.toCharArray();
    Arrays.sort(a);
    return new String(a);
}
