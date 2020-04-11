class Solution {
    fun isHappy(n: Int): Boolean {
        var num = n
        val uniqueNumberSet = hashSetOf<Int>()
        while(uniqueNumberSet.add(num)) {
            var value = 0
            while(num > 0) {
                value += Math.pow(1.0 * num % 10, 2.0).toInt()
                num /= 10
            }
            num = value
        }
        return num == 1
    }
}