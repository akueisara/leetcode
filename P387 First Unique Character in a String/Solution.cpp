class Solution {
public:
    int firstUniqChar(string s) {
        vector<int> freq(26);
        for(int i = 0;i < s.size();i++) {
            freq[s[i] - 'a']++;
        }
        for(int i = 0;i < s.length();i++) {
            if(freq[s[i] - 'a'] == 1)
                return s.find(s[i]);
        }
        return -1;
    }
};