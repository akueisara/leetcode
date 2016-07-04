char* reverseString(char* s) {
    int len = strlen(s);
    char * result;
    int i;
    int j =0;
    for(i = len-1;i>=0;i--) {
        result[j] = s[i];
        j++;
    }
    result[j] = '\0';
    return result;
}