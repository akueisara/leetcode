class Solution {
public:
    bool isAnagram(string s, string t) {
       if (s.size() == 0 && t.size() == 0 ) return true;
        else if (s.size() != 0 && t.size() != 0){
            if (s.size() == t.size()){
                int letters[26] = {};
                //vector<int> letters(26, 0);
                for (int i=0; i<t.size();i++)
               {
                   letters[s[i] - 'a'] += 1;
                   letters[t[i] - 'a'] -= 1;
               }
               int confirm = 0;
               for (int i = 0; i < 26; i++) {
                  if (letters[i] == 0) {
                      confirm++;
                  }
               }
               if (confirm == 26) return true;
            }
        }
        return false; 
    }
};