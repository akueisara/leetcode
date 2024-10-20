class Solution {
    // Time: O(N)
    // Space: O(N)
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false
        val bracketMap = mapOf('(' to ')', '[' to ']', '{' to '}')
        val endBracketStack = ArrayDeque<Char>()
        s.asSequence()
            .forEach { c ->
                bracketMap[c]?.let { 
                    endBracketStack.addLast(it)
                } ?: run {
                    if (endBracketStack.isEmpty() || endBracketStack.removeLast() != c) return false
                }
            }
        return endBracketStack.isEmpty()
    }
}