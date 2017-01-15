class Solution {
public:
    int findComplement(int num) {
        long int mask = 1, temp = num;
        while(temp > 0) {
            mask = mask << 1;
            temp = temp >> 1;
        }
        return num^(mask-1);
    }
};