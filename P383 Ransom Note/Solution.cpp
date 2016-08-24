class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int count[26];
        for (int i = 0; i < 26; i++)
            count[i] = 0;
        for (int i = 0; i < magazine.length(); i++) 
            count[magazine.at(i) - 97]++;
        for (int i = 0; i < ransomNote.length(); i++) 
            if (--count[ransomNote.at(i) - 97] < 0) 
                return false;
        return true;        
    }
};