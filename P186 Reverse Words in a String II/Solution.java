import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        char[] input = "zpetg pufmmdf l onwmwpsyr qlke vuijr yrr sndp txvcv x hgkczoo cfuadsza prz e sucs".toCharArray();
        char[] output2 = reverseWords2(input);
        // should print "sucs e prz cfuadsza hgkczoo x txvcv sndp yrr vuijr qlke onwmwpsyr l pufmmdf zpetg"
        System.out.println(output2);
        System.out.println(reverseWords(input));
    }


    /**
     * Method 1
     * @param str: a string
     * @return: return a string
     */
    public static char[] reverseWords(char[] str) {
        // write your code here
        int n = str.length, pre = 0;
        for (int i = 0; i <= n; ++i) {
            if (i == n || str[i] == ' ') {
                Swap(str, pre, i - 1);
                pre = i + 1;
            }
        }
        Swap(str, 0, n - 1);
        return str;
    }

    public static void Swap(char[] str, int l, int r) {
        for (int i = l; i <= (l + r) / 2; ++i) {
            char tmp = str[i];
            str[i] = str[l + r - i];
            str[l + r - i] = tmp;
        }
    }

    // My method
    public static char[] reverseWords2(char[] str) {
        // write your code here
        Stack stack = new Stack();
        StringBuilder stringBuilder = new StringBuilder();
        int stackCount = 0;
        for(char c: str) {
            if(c != ' ') {
                stringBuilder.append(c);
            } else {
                stackCount++;
                stack.push(stringBuilder.toString());
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        if(stringBuilder.length() != 0) {
            stackCount++;
            stack.push(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        }
        while(stackCount != 0) {
            stringBuilder.append(stack.pop());
            stackCount--;
            if(stackCount != 0) {
                stringBuilder.append(' ');
            }
        }
        return stringBuilder.toString().toCharArray();
    }
}