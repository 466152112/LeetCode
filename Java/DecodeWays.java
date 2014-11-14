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

