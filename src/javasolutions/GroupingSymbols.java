package javasolutions;

import java.util.Stack;

public class GroupingSymbols {
    
    /* Determine if grouping symbols is valid
     * {([{}])} = true
     * (){}[] = true
     * ())(}{ = false */
    
    public static void main(String[] args){
        GroupingSymbols t = new GroupingSymbols();
        System.out.println(t.isGroupingValidNonRecursive("({]]})"));
    }
    
    public boolean isGroupingValidNonRecursive(String str){
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }
            else if (str.charAt(i) == ']' || str.charAt(i) == '}' || str.charAt(i) == ')'){
                if (stack.pop() != reverseGrouping(str.charAt(i))){
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
    
    private char reverseGrouping(char grouping){
        if (grouping == '{')
            return '}';
        else if (grouping == '}')
            return '{';
        else if (grouping == '(')
            return ')';
        else if (grouping == ')')
            return '(';
        else if (grouping == '[')
            return ']';
        else if (grouping == ']')
            return '[';
        else
            return ' ';
    }

}
