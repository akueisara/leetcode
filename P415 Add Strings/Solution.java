public class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        String res = "";
        while(len1>=0 || len2>=0 || carry == 1){
            long sum = 0;
            if(len1 >= 0){
                sum += (num1.charAt(len1) - '0');
                len1--;
            }
            if(len2 >= 0){
                sum += (num2.charAt(len2) - '0');
                len2--;
            }
            sum += carry; 
            carry = (int) sum / 10;
            sum = sum % 10;
            res = String.valueOf(sum) + res;
        }
        return res;
    }
}