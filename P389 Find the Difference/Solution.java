public class Solution {
    public char findTheDifference(String s, String t) {
        int [] v = new int[26];
        for (int i = 0; i < s.length(); ++i)  
            ++v[s.charAt(i)-'a'];  
  
        for (int i = 0; i < t.length(); ++i)  
        {  
            --v[t.charAt(i)-'a'];  
            if (v[t.charAt(i)-'a'] < 0)  
                return t.charAt(i);  
        }//for  
        return ' ';    
    }
}