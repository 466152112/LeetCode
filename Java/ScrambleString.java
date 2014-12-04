/*
For example, given "great" and "rgate", the splits are
("great") vs. ("rgate")
("g", "reat") vs. ("r", "gate") or ("rgat", "e")
("gr", "eat") vs. ("rg", "ate") or ("te", "rga")
("gre", "at") vs. ("rga", "te") or ("ate", "rg")
("grea", "t") vs. ("rgat", "e") or ("gate", "r")
*/
// DP using 3D table, O(N^4)
// table[i][j][k] iff s2.substring(j,j+k+1) is a scambled string of s1.substring(i,i+k+1)
public boolean isScramble(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length())
        return false;
    if (s1.equals(s2)) return true; 
    int len = s1.length();
    boolean[][][] table = new boolean[len][len][len];
    // initial DP table
    for (int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++)
            table[i][j][0] = s1.charAt(i) == s2.charAt(j);
    }
    // check from k = 1, sicne s1 != s2
    for (int k = 1; k < len; k++) {
        for (int i = 0; i < len - k; i++) { // i upper bound len - k, since we'll compare s1.substring(i,i + k + 1)
            for (int j = 0; j < len - k; j++) {
                for (int p = 0; p < k; p++) { // split substring into [0..p][p+1...k]
                    if ((table[i][j][p] && table[i+p+1][j+p+1][k-p-1]) || (table[i][j+k-p][p] && table[i+p+1][j][k-p-1])) {
                        table[i][j][k] = true;
                        break;
                    }
                }
            }
        }            
    }
    return table[0][0][len - 1];
}

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
