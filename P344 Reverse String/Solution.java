import java.util.*;

public class Solution {

    public String reverseString(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.substring(i,i+1));
        }
        
        String reverse ="";
        while(!stack.empty()) {
            reverse = reverse + stack.pop(); 
        }
        
        return reverse;
    }
}