//
public String minWindow(String S, String T) {
    if (S == null || T == null || S.length() == 0 || T.length() == 0 || T.length() > S.length())
        return "";
    // tCount, count the frequency of char in string T
    HashMap<Character, Integer> tCount = new HashMap<Character, Integer>();
    // sCount, count the frequency of char in string S already find matched T
    HashMap<Character, Integer> sCount = new HashMap<Character, Integer>();
    int leftBound = 0;  // left bound for the window
    int rightBound = 0; // right bound for the window
    char[] s = S.toCharArray();
    char[] t = T.toCharArray();
    // initial tCount
    for (char c:t) {
        if (tCount.containsKey(c))
            tCount.put(c, tCount.get(c) + 1);
        else
            tCount.put(c, 1);
    }
    // find the windows
    String minWindow = "";
    int count = 0;
    for (int i = 0; i < s.length; i++) {
        if (!tCount.containsKey(s[i]))
            continue;
        if (sCount.containsKey(s[i]))
            sCount.put(s[i], sCount.get(s[i]) + 1);
        else
            sCount.put(s[i], 1);
        if (sCount.get(s[i]) <= tCount.get(s[i]))
            count++;
        if (count == t.length) {
            while (leftBound <= i) {
                if (!tCount.containsKey(s[leftBound])) {
                    leftBound++;
                    continue;
                }
                if (sCount.get(s[leftBound]) - 1 >= tCount.get(s[leftBound])) {
                    sCount.put(s[leftBound], sCount.get(s[leftBound]) - 1);
                    leftBound++;
                    continue;
                }
                break;
            }
            if (minWindow == "" || i - leftBound + 1 < minWindow.length() ) {
                minWindow = S.substring(leftBound, i + 1);
                // these 3 lines below if very tricky, you can keep them 3 together here
                // or, delete them together
                // they are two totally different way to handle mulitple windows
                // keep them 3 is more efficient, since is cut the branch explicitly
                sCount.put(s[leftBound], sCount.get(s[leftBound]) - 1);
                leftBound++;
                count--;
            }
        }
    }
    return minWindow;
}
