public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for(int j=0;res<g.length && j<s.length;j++) {
	        if(g[res]<=s[j]) res++;
        }
        return res;
    }
}