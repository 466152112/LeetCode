public int romanToInt(String s) {
    HashMap<Character,Integer> dic = new HashMap<Character,Integer>(){{
        put('I',1);
        put('V',5);
        put('X',10);
        put('L',50);
        put('C',100);
        put('D',500);
        put('M',1000);
    }};
    
    char[] c = s.toCharArray();
    if (c.length == 0)
        return 0;
    // add the last one first
    int result = dic.get(c[c.length-1]);
	
	// if current Character is less then the next one, minus it
    for (int i = c.length-2; i >= 0; i--) {
        if (dic.get(c[i]) >= dic.get(c[i+1]))
            result += dic.get(c[i]);
        else
            result -= dic.get(c[i]);
    }
    return result;
}
