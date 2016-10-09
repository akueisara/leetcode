class Solution {
public:
    string addStrings(string num1, string num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        string res = "";
        while(len1>=0 || len2>=0 || carry == 1){
            long sum = 0;
            if(len1 >= 0){
                sum += (num1[len1] - '0');
                len1--;
            }
            if(len2 >= 0){
                sum += (num2[len2] - '0');
                len2--;
            }
            sum += carry; 
            carry = (int) sum / 10;
            sum = sum % 10;
            res = to_string(sum) + res;
        }
        return res;
    }
};