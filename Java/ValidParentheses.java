// Generic not support primitives
// use functions to check ( and ), or use hash maps

public boolean isValid(String s) {
    HashMap<Character,Boolean> flag = new HashMap<Character,Boolean>(){{
        put('(',true);
        put('[',true);
        put('{',true);
        put(')',false);
        put(']',false);
        put('}',false);
    }};
    HashMap<Character,Character> dic = new HashMap<Character,Character>(){{
        put(')','(');
        put(']','[');
        put('}','{');
    }};
    Stack<Character> stack = new Stack<Character>();
    char[] c = s.toCharArray();
    for (int i = 0; i < c.length; i++) {
        if (flag.get(c[i]))
            stack.push(c[i]);
        else if (stack.isEmpty() || stack.pop() != dic.get(c[i]))
            return false;
    }
    return stack.isEmpty();
}
