bool isAnagram(char* s, char* t) {
     if (strlen(s) == 0 && strlen(t) == 0 ) return true;
        else if (strlen(s) != 0 && strlen(t) != 0){
            if (strlen(s) == strlen(t)){
                int letters[26] = {};
                //vector<int> letters(26, 0);
                for (int i=0; i<strlen(t);i++)
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