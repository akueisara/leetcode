class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        std::set<int> set;
        std::set<int> intersect;

        for(int i=0;i<nums1.size();i++) {
            set.insert(nums1[i]);
        }
        for(int i=0;i<nums2.size();i++) {
            if (set.find(nums2[i]) != set.end()) {
                intersect.insert(nums2[i]);
            }
        }
        
        vector<int> result;
        std::set<int>::iterator it;
        for (it = intersect.begin(); it != intersect.end(); it++) {
            result.push_back(*it);
        }
        return result;
    }
};