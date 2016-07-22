class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        std::unordered_map<int, int> map;  
        vector<int> result;
        for(int i : nums1)
            map[i]++;
        for(int j : nums2) {  
            if (map[j] > 0) {  
                map[j]--;  
                result.push_back(j);  
            }  
        }  
        return result;        
    }
};