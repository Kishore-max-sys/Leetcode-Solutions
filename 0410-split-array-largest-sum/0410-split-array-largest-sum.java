class Solution {
    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int low = max;
        int high = sum;
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 1;
            int s = 0;
            for (int num : nums) {
                if (s + num > mid) {
                    count++;
                    s = num;
                } else {
                    s += num;
                }
            }
            if (count <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}