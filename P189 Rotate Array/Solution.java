class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
          int temp = nums[start];
          nums[start] = nums[end];
          nums[end] = temp;
          start++;
          end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            result[(i+n+k)%n] = nums[i];
        }
        for(int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }
}