public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> intersect = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i])+1);
            }
            else{
                map.put(nums1[i], 1);
            }
        }
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i])>1){
                    map.put(nums2[i], map.get(nums2[i])-1);
                }
                else{
                    map.remove(nums2[i]);
                }
            intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}