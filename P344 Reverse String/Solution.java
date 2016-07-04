import java.util.*;

public class Solution {
    public String reverseString(String s) {
        StringBuilder result = new StringBuilder();
        int len = s.length();
        for (int i = len-1; i>=0; --i){
            result.append(s.substring(i,i+1));
        }     
        return result.toString();
    }
}