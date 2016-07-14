/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target) {
    // it's kind hard for me to implement hashmap in C so...I will do it one day lol
    int i,j;
    static int result[2];
    for(i=0; i<numsSize;i++) {
        for(j=i+1;j<numsSize;j++) {
            if (nums[j] == target - nums[i]) {
                result[0] = i;
    	        result[1] = j;
    	        return result;
            }
        }
    }
    return -1;
}