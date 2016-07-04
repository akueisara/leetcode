public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0 ) return true;
        else if (s.length() != 0 && t.length() != 0){
            if (s.length() == t.length()){
                int[] letters = new int[26];
                for (int i=0; i<t.length();i++)
               {
                   letters[s.charAt(i) - 'a'] += 1;
                   letters[t.charAt(i) - 'a'] -= 1;
               }
               int confirm = 0;
               for (int i = 0; i < 26; i++) {
                  if (letters[i] == 0) {
                      confirm++;
                  }
               }
               if (confirm == 26) return true;
            }
        }
        return false;
    }
}