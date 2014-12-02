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

// get the perumationII with duplicates
public ArrayList<Integer> findSubstring(String S, String[] L) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (S == null || L == null || S.length() == 0 || L.length == 0)
        return result;
    int lenS = S.length();
    int lenL = L.length;
    int lenWord = L[0].length();
    ArrayList<String> dict = new ArrayList<String>();
    Arrays.sort(L);
    int[] visited = new int[lenL];
    String one = "";
    getPermutation(dict, one, visited, L);
    // go though the string S, if containsKey in the hashmap
    for (int i = 0; i <= lenS - lenL*lenWord; i++) {
        if (dict.contains(S.substring(i, i + lenL*lenWord)))
            result.add(i);
    }
    return result;
}

// get all the possible concatenation of the words, save them in a hashmap
private void getPermutation(ArrayList<String> dict, String one, int[] visited, String[] L) {
    if (one.length() == L.length * L[0].length())
        dict.add(new String(one));
    else {
        for (int i = 0; i < L.length; i++) {
            if (visited[i] == 1 || (i != 0 && L[i].equals(L[i - 1]) && visited[i - 1] == 0))
                continue;
            visited[i] = 1;
            one = one + L[i];
            getPermutation(dict, one, visited, L);
            one = one.substring(0, one.length() - L[0].length());
            visited[i] = 0;
        }
    }
}
