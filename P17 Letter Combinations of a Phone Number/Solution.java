class Solution {
    // Time: O(2^n), where n is the length of digits
    // Space: O(n)
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()) {
            return result;
        }
        result.add("");
        String[] letterSets = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};     
        for(char c: digits.toCharArray()) {
            result = getCombinations(letterSets[Character.getNumericValue(c)], result);
        }
        return result;
    }
    
    private List<String> getCombinations(String possibleLetters, List<String> currentResult) {
            List<String> result = new ArrayList<String>();
            for (int i = 0; i < possibleLetters.length(); i++)  {
                for (String s : currentResult)  {
                    result.add(s + possibleLetters.charAt(i));
                }
            }
            return result;
        }
}