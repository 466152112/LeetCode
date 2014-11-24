// take care of - and /
// stack store String or Integer? which one is better? think about it
public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<Integer>();
    for (String s:tokens) {
        switch(s){
            case "+":
                stack.push(stack.pop() + stack.pop());
                break;
            case "-":
                stack.push(-stack.pop() + stack.pop());                   
                break;
            case "*":
                stack.push(stack.pop() * stack.pop());                   
                break;
            case "/":
                int down = stack.pop();
                int up = stack.pop();
                stack.push(up / down);                    
                break;
            default:
                stack.push(Integer.parseInt(s));
                break;
        }
    }
    return stack.pop();
}
