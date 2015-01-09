// DFS, queue, brute force based
// substing is slower than toCharArray for modify one character in the string
// UPDATE: StringBuilder is more efficinet when modify one char
// since substring will go scaning the string 3 times, while toCharArray only once
public int ladderLength(String start, String end, Set<String> dict) {
    if (start == null || end == null || dict == null || start.equals(end))
        return 0;
    Queue<String> queue = new LinkedList<String>();
    queue.offer(start); // start from the start string
    dict.remove(start); // remove already visited, cut unnecessary tree branches
    int length = 1; // default length, the start itself
    while (!queue.isEmpty()) {
        length++;   // new level, add one
        int size = queue.size();    // move size value to an int size, not put queue.size in the loop!
        // O(M*N*S), M is size of queue, N is size of string, S is size of 26
        for (int i = 0; i < size; i++) {
            String s = queue.poll();
            for (int j = 0; j < s.length(); j++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == s.charAt(j))
                        continue;
                    String temp = s.substring(0,j) + c + s.substring(j + 1); // requare more space, memory limit error
                    //String tmp = replace(s, j, c); // space efficent, passed OJ, why?
                    if (temp.equals(end))
                        return length;  // found, return
                    if (dict.contains(temp)) {
                        queue.offer(temp);
                        dict.remove(temp);
                    }
                }
            }
        }
    }
    return 0;
}

private String replace(String s, int index, char c) {
    char[] chars = s.toCharArray();
    chars[index] = c;
    return new String(chars);
}
