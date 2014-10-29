/**
* D(i,j) = min(D(i-1,j) + 1; D(i,j-1) + 1; D(i-1,j-1) + 0 or 1, depends on a[len -1] equal with b[len -1] or not)
*
*/

// matrix

// recursive
public int minDistance(String word1, String word2) {
    int len1 = word1.length(), len2 = word2.length();
    if (len1 == 0 || len2 == 0)
        return Math.max(len1,len2);
    int value = 0;
    if (word1.charAt(len1 -1) != word2.charAt(len2 - 1))
        value = 1;
    return Math.min(minDistance(word1.substring(0, len1 - 1), word2),Math.min(
                    minDistance(word1, word2.substring(0,len2 - 1)),
                    minDistance(word1.substring(0, len1 - 1), word2.substring(0,len2 - 1)) + value));
}
