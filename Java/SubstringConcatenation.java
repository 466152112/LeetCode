// no need to build the Permuation of L, take advantage of the same length of string in L
// and use that as step to move two pointer
// tried continue LABEL and the other way to control the double loop
public ArrayList<Integer> findSubstring(String S, String[] L) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (S == null || L == null || S.length() == 0 || L.length == 0)
        return result;
    int lenS = S.length();
    int lenL = L.length;
    int lenWord = L[0].length();
    // create the frequency count HashMap
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (String s:L) {
        if (map.containsKey(s))
            map.put(s, map.get(s) + 1);
        else
            map.put(s, 1);
    }
    MOVE_S: // label for double break loop
    for (int i = 0; i <= lenS - lenL*lenWord; i++) {
        // create a new HashMap for current index
        HashMap<String, Integer> temp = new HashMap<String, Integer>(map);
        for (int j = i; j < lenL*lenWord + i; j += lenWord) {
            String sub = S.substring(j, j + lenWord);
            if (temp.containsKey(sub) && temp.get(sub) > 0)
                temp.put(sub, temp.get(sub) - 1);
            else
                continue MOVE_S; // not a concatenation, jump out to move index of S
        }
        result.add(i);
    }
    
    /* here is another way to control the loop
    for (int i = 0; i <= lenS - lenL*lenWord; i++) {
        // create a new HashMap for current index
        HashMap<String, Integer> temp = new HashMap<String, Integer>(map);
        for (int j = i; j < lenL*lenWord + i; j += lenWord) {
            String sub = S.substring(j, j + lenWord);
            if (!temp.containsKey(sub))
                break;
            // deal with duplicates
            else if (temp.get(sub) > 1)
                temp.put(sub, temp.get(sub) - 1);
            // deal with only one left
            else
                temp.remove(sub);
        }
        if (temp.isEmpty())
            result.add(i);
    }    
    */
    return result;
}
