// naive way, 3 for loop, check each valid or not
public ArrayList<String> restoreIpAddresses(String s) {
    ArrayList<String> result = new ArrayList<String> ();
    if (s == null || s.length() < 4 || s.length() > 12)
        return result;
    int len = s.length();
    for (int i = 1; i < len - 2; i++ ) {
        for (int j = i + 1; j < len - 1; j++) {
            for (int k = j + 1; k < len; k++) {
                int a, b, c, d;
                a = Integer.parseInt(s.substring(0,i));
                b = Integer.parseInt(s.substring(i,j));
                c = Integer.parseInt(s.substring(j,k));
                d = Integer.parseInt(s.substring(k,len));
                if ((a < 0 || a > 255 || (i != 1 && s.substring(0,i).charAt(0) == '0')) || (b < 0 || b > 255 || (j != i + 1 && s.substring(i,j).charAt(0) == '0')) || (c < 0 || c > 255 || (k != j + 1 && s.substring(j,k).charAt(0) == '0')) || (d < 0 || d > 255 || (len != k + 1 && s.substring(k,len).charAt(0) == '0')))
                    continue;
                else {
                    result.add(s.substring(0,i) + "." + s.substring(i,j) + "." + s.substring(j,k) + "." + s.substring(k,len));
                }
            }
        }
    }
    return result;
}

// more compact and efficent
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String> ();
        if (s == null || s.length() < 4 || s.length() > 12)
            return result;
        int len = s.length();
        for (int i = 1; i < len - 2; i++ ) {
            if (!isValid(s.substring(0,i)))
                continue;
            for (int j = i + 1; j < len - 1; j++) {
                if (!isValid(s.substring(i,j)))
                    continue;                    
                for (int k = j + 1; k < len; k++) {
                    if (!isValid(s.substring(j,k)) || !isValid(s.substring(k)))
                        continue;
                    result.add(s.substring(0,i) + "." + s.substring(i,j) + "." + s.substring(j,k) + "." + s.substring(k,len));
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String s) {
        if (s.charAt(0) == '0' && s.length() > 1)
            return false;
        int x = Integer.parseInt(s);
        return x >= 0 && x <= 255;
    }
}
