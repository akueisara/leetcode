private typealias Num = Int
private typealias Index = Int

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val visitedNumMap = mutableMapOf<Num, Index>()
        nums.forEachIndexed { index, num ->
            val diff = target - num
            visitedNumMap[diff]?.let { foundDiffIndex ->
                return intArrayOf(index, foundDiffIndex)
            }
            visitedNumMap[num] = index
        }
        return intArrayOf()
    }   
}