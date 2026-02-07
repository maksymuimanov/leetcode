package hard;

public class MedianOfTwoSortedArrays {
    // O(m + n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = merge(nums1, nums2);
        int middleIndex = nums.length / 2;
        return nums.length % 2 == 0
                ? (nums[middleIndex - 1] + nums[middleIndex]) / 2.0
                : nums[middleIndex];
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        int index = 0, left = 0, right = 0;
        while (left < nums1.length || right < nums2.length) {
            if (left == nums1.length) nums[index++] = nums2[right++];
            else if (right == nums2.length) nums[index++] = nums1[left++];
            else if (nums1[left] < nums2[right]) nums[index++] = nums1[left++];
            else nums[index++] = nums2[right++];
        }

        return nums;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 1}));
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(solution.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }
}
