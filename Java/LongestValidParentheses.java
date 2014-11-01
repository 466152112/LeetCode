// DP without Stack, time limit exceeded
public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2)
            return 0;
        int len = s.length();
        boolean[][] flag = new boolean[len][len];
        boolean one = false;
        int max = 0;
        // set single one to false, actually, default value of flag is false
        for (int j = 1; j < len; j = j + 2) {
            for (int i = 0; i < len - j; i++) {
                one = false;
                // check : ()
                if (j == 1) {
                    if (s.charAt(i) == '(' && s.charAt(i + j) == ')')
                        one = true;
                    else
                        continue;
                }
                // check: ............()
                else if (flag[i][i + j - 2] && s.charAt(i + j - 1) == '(' && s.charAt(i + j) == ')')
                    one = true;
                // check: (...........)
                else if (flag[i + 1][i + j - 1] && s.charAt(i) == '(' && s.charAt(i + j) == ')')
                    one = true;
                // check: ()............
                else if (flag[i + 2][i + j] && s.charAt(i) == '(' && s.charAt(i + 1) == ')')
                    one = true;
                if (one) {
                    flag[i][i + j] = true;
                    if (j + 1 > max)
                        max = j + 1;
                }
            }
        }
        return max;
    }
    
    // stack: check ")", keep track of current matched and max matched
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2)
            return 0;
        int len = s.length();
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        int currentLen = 0, currentMax = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                if (stack.isEmpty()) {
                    currentMax = 0;
                }
                else {
                    currentLen = i - stack.pop() + 1;
                    if (!stack.isEmpty()) {
                        currentLen = i - stack.peek();
                    }
                    else {
                        currentMax += currentLen;
                    }
                    max = Math.max(max, currentLen);
                    max = Math.max(max, currentMax);
                }
            }
        }
        return max;
    }
