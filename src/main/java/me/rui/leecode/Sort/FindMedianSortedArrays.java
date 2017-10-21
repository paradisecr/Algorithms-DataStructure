package me.rui.leecode.Sort;

/**
 * Created by caorui on 2017/9/3.
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[]nums2 = new int[] {1,1};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length + nums2.length ==1) {
            return nums1.length == 1 ? nums1[0] : nums2[0];
        }
        int leftIndex = (nums1.length + nums2.length) /2;
        int left = 0, right = 0;
        int cur = -1, p1 = -1, p2 = -1;
        int tmp;
        while (cur <= leftIndex && (p1 < nums1.length-1 || p2<nums2.length-1)) {
            if (p1 == nums1.length - 1 && p2 < nums2.length) {
                p2++;
                tmp = nums2[p2];
            } else if (p1 < nums1.length  && p2 == nums2.length-1) {
                p1++;
                tmp = nums1[p1];
            } else {
                if (nums1[p1 +1] <= nums2[p2+1]) {
                    p1++;
                    tmp = nums1[p1];
                } else {
                    p2++;
                    tmp = nums2[p2];
                }
            }
            cur++;
            if (cur == leftIndex-1) left = tmp;
            if (cur == leftIndex) right = tmp;
        }
        if ((nums1.length + nums2.length)%2 == 0) {
            return ((double)left + (double) right) /2;
        } else {
            return right;
        }
    }
}
