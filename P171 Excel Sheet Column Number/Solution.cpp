class Solution {
public:
    int titleToNumber(string s) {
        if (s.empty() || s.size() == 0 ) return 0;
        int result = 0;
        for(int i=0;i<s.size();i++)
        {
            result = result + (s.at(i)-'A'+1) * (int) pow(26, s.size()-1-i);  
        }
        return result;
    }
};