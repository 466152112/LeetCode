// why am i miss one day push? because i just push once yesteday?
// naive DP recurive way to take advantage of former result, TLE, think about how to avoid TLE?
public int numDecodings(String s) {
    if (s == null || s.length() == 0)
        return 0;
    if (s.length() == 1 && s != "0")
        return 1;            
    else if (s.length() == 2) {
        int now = Integer.parseInt(s);            
        if (now/10 == 0 || now %10 == 0)
            return 1;
        else if (now > 26)
            return 2;
        else
            return 3;
    }
    else {
        int flag = Integer.parseInt(s.substring(0,2));
        if (flag > 10 && flag < 20 || flag > 20 && flag <27) {
            return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
        }
        else 
            return numDecodings(s.substring(1));
    }
}

// one more thing, if there continues 0s, no need to skip them, just return 0, because is invalid code
// use extra memeroy to store the former result
public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
        return 0;
    }
    int[] nums = new int[s.length() + 1];
    nums[0] = 1;
    nums[1] = s.charAt(0) != '0' ? 1 : 0;
    for (int i = 2; i <= s.length(); i++) {
        // if in range (1,9), add former result
        // if == 0. check 10 or 20, other wise == 00, return 0
        if (s.charAt(i - 1) != '0') {
            nums[i] += nums[i - 1];
        }
        
        int twoDigits = Integer.parseInt(s.substring(i -2, i));
        if (twoDigits >= 10 && twoDigits <= 26) {
            nums[i] += nums[i - 2];
        }
    }
    return nums[s.length()];
}
