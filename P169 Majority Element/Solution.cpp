class Solution {
public:
    int majorityElement(vector<int>& nums) {
        if (nums.size() == 1) {
		    return nums[0];
	    }
	    sort(nums.begin(),nums.end());
	    return nums[nums.size() / 2];
    }
};