class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int res = 0;
        for(int j=0;res<g.size() && j<s.size();j++) {
	        if(g[res]<=s[j]) res++;
        }
        return res;
    }
};