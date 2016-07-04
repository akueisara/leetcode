void moveZeroes(int* nums, int numsSize) {
    int j =0;
    for(int i = 0;i < numsSize; i++)
    {
        if(nums[i] !=0)
        {
            int temp = nums[j]; 
            nums[j] = nums[i];
            nums[i]= temp;
            j++;
        }
    }
}