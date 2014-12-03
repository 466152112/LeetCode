//Given: s1 = "aabcc", s2 = "dbbca", When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
// DP recursive is very simple, but TLE
// build your own DP state table, iteratively
public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)   // reach the end of all string
        return true;
    if (s1.length() + s2.length() != s3.length())   // length different
        return false;
    if (s1.length() == 0)   // one string is done
        return s2.equals(s3);
    if (s2.length() == 0)
        return s1.equals(s3);
    if (s1.charAt(0) != s3.charAt(0) && s2.charAt(0) != s3.charAt(0))   // no one match
        return false;
    if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0))   // both match
        return isInterleave(s1.substring(1), s2, s3.substring(1)) 
                || isInterleave(s1, s2.substring(1), s3.substring(1));
    if (s1.charAt(0) == s3.charAt(0))
        return isInterleave(s1.substring(1), s2, s3.substring(1));  // only s1 match
    else
        return isInterleave(s1, s2.substring(1), s3.substring(1));  // only s2 match
}
