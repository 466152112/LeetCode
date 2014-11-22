// regular expression, split, stack, special case .. empty . and ""
public String simplifyPath(String path) {
    if (path == null || path.length() == 0)
        return "";
    String result = "";
    // split by "/" or "/////"
    String[] paths = path.split("/+");
    // keep track of the return path
    Stack<String> stack = new Stack<String> ();
    for (String s:paths) {
        if (s.equals(".") || s.equals(""))
            continue;
        // go back on directory if there are parent directories
        if (s.equals("..")) {
            if (!stack.isEmpty())
                stack.pop();
        }
        else
            stack.push(s);
    }
    // root directory
    if (stack.isEmpty())
        result = "/";
    while (!stack.isEmpty())
        result = "/" + stack.pop() + result;
    return result;
}
