package leetcode.editor.cn;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 881 👎 0

class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int []nums2 = {2, 5, 6};
//        int n = 3;

        int[] nums1 = {1};
        int m = 1;
        int []nums2 = {};
        int n = 0;

        solution.merge(nums1, m, nums2, n);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int newArr[] = new int[m + n];
            int p1 = 0, p2 = 0, index = 0;
            while (p1 < m || p2 < n) {
                //这两种条件执行的代码和下边虽然一致，但是必须提前判断
                //如下判断 p2 == n || nums1[p1] <= nums2[p2]
                //以及p1 == m || nums1[p1] > nums2[p2]
                //如果p1到了边界，但还是有可能走不到第二条判断，可能会被p2==n || nums1[p1] <= nums2[p2]
                //给截断掉
                if (p2 == n) {
                    newArr[index++] = nums1[p1++];
                } else if (p1 == m) {
                    newArr[index++] = nums2[p2++];
                } else if (nums1[p1] <= nums2[p2]) {
                    newArr[index++] = nums1[p1++];
                } else if (nums1[p1] > nums2[p2]) {
                    newArr[index++] = nums2[p2++];
                }
            }
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = newArr[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}