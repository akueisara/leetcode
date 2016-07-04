int titleToNumber(char* s) {
     if (s[0]=='\0' || strlen(s) == 0 ) return 0;
        int result = 0;
        for(int i=0;i<strlen(s);i++)
        {
            result = result + (s[i]-'A'+1) * (int) pow(26, strlen(s)-1-i);  
        }
        return result;
}