public class Solution {
    public int addDigits(int num) {
       return (int)(num-9* Math.floor((num-1)/9));
    }
}