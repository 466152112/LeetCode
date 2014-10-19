// reverse number, no extra space
public boolean isPalindrome(int x) {
    if(x < 0) {
        return false;
    }
    return x == reverse(x);    
}

public int reverse(int x) {
    int rst = 0;
    while(x != 0) {
        rst = rst * 10 + x % 10;
        x = x / 10;
    }
    return rst;
}

// string, easy, extra space
public boolean isPalindrome(int x) {
    if (x<0)
        return false;
    String str = Integer.toString(x);
    char[] c = str.toCharArray();
    for (int i=0; i < c.length/2; i++) {
        if (c[i] != c[c.length - i -1])
            return false;
    }
    return true;
}
