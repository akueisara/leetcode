int majorityElement(int* nums, int numsSize) {
    // Linear Time Majority Vote Algorithm
    int result, count = 0;
    for(int i = 0; i<numsSize; i++) {
        if(count == 0){
            result = nums[i];
            count = 1;
        }
        else{
           result == nums[i] ? count++: count--;
        }
    }
    return result;
}