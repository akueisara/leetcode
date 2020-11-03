public class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        int time = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            num += time * (s.charAt(i) - 64);
            time *= 26;
        }
        return num;
    }

    public int titleToNumber2(String s) {
       if (s == null || s.length()==0) return 0;
       HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
       char c = 'A';
       for(int i=1; i<=26; i++){
           hashMap.put(c, i);
           c += 1; 
       }
       int result = 0;
       for(int i=0;i<s.length();i++)
       {
           result = result + hashMap.get(s.charAt(i)) * (int) Math.pow(26, s.length()-1-i); 
       }
       return result;
    }
}