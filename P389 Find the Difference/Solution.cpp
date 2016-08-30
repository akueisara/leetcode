class Solution {
public:
    char findTheDifference(string s, string t) {
        vector<int> v(26, 0);  
        for (int i = 0; i < s.length(); ++i)  
            ++v[s[i]-97];  
  
        for (int i = 0; i < t.length(); ++i)  
        {  
            --v[t[i]-97];  
            if (v[t[i]-97] < 0)  
                return t[i];  
        }//for  
        return ' ';    
    }
};