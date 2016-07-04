class Solution {
public:
    string reverseString(string s) {
        string result = "";
	    int len = s.length();
	    for(int i = len - 1; i >= 0; --i)
	    {
		    result += s[i];
	    }
	    return result;
    }
};