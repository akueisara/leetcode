class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int i = 0;
        int result = 0;
        if (s.length() == 0) {
            return 0;
        }
        while(i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }
        
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                if(sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            result = result * 10 + (s.charAt(i++) - '0');
        }
        return sign * result;
    }
}