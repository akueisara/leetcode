class Solution {
public:
    int romanToInt(string s) {
        string dict[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int num[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int i=0, index=0, ret=0;
        while(i<s.size() && index<13) {
            string target = dict[index];
            string cur = s.substr(i,target.size());
            if(cur==target) {
                ret += num[index];
                i += target.size();
            }
            else {
                index++;
            }
        }
        return ret;
    }
};