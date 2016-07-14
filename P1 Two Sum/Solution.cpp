class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> hashmap;
        vector<int> result;
        for(int i=0; i<nums.size();i++){
            int diff = target - nums[i];
            if(hashmap.find(diff)!= hashmap.end()) {
                result.push_back(hashmap[target - nums[i]]);
                result.push_back(i);
                return result;
            }
            hashmap[nums[i]] = i;
        }
        result.push_back(-1);
        result.push_back(-1);
        return result;
    }
};