package leetcode.editor.cn;

//已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums
//[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,
//2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 targ
//et ，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,5,6,0,0,1,2], target = 0
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,5,6,0,0,1,2], target = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -104 <= target <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 353 👎 0

class SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            //将后边会影响二段性的值全部删掉，并不影响结果。也是 11121111这样的，把2全部删掉也不影响
            while (left < right && nums[0] == nums[right]) {
                right--;
            }
            //找到最小值，也就是旋转点。
            int cyclePoint = findMin(nums, right);
            //利用旋转点将数组分为两个部分，右侧和左侧，分别对右侧和左侧进行二分查找。
            if (cyclePoint == 0 || (target <= nums[right]) && target >= nums[cyclePoint]) {
                //右侧二分
                int i = cyclePoint, j = right;
                while (i <= j) {
                    int mid = (i + j) / 2;
                    if (nums[mid] < target) {
                        i = mid + 1;
                    } else if (nums[mid] > target) {
                        j = mid - 1;
                    } else if (nums[mid] == target) {
                        return true;
                    }
                }
            } else {
                //左侧二分
                int i = 0, j = cyclePoint - 1;
                while (i <= j) {
                    int mid = (i + j) / 2;
                    if (nums[mid] < target) {
                        i = mid + 1;
                    } else if (nums[mid] > target) {
                        j = mid - 1;
                    } else if (nums[mid] == target) {
                        return true;
                    }
                }
            }
            return false;
        }

        //根据确定的右边界，找到nums里边的最小值，也就是旋转点。
        public int findMin(int[] nums, int right) {
            int left = 0;
            //数组本身是一个左大右小的状态
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[right]) {
                    //如果mid比right大，那么结果只能在右侧，并且mid本身不会是最小值
                    //mid本身已经比一个值大，不可能是最小值了
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    //如果mid比right小，那么最小值应该在左侧，并且mid有可能是最小值。
                    right = mid;
                } else if (nums[mid] == nums[right]) {
                    //如果二者相等，仅将右值缩小，减小搜索范围。判断不了0在左还是右
                    //1 0 1 1 1 和 1 1 1 0 1
                    right--;
                }
            }
            //这个地方是出现这种情况 0 0 0 1 2 3，可能会搜索到第三个0，这个时候要将坐标移到最左侧
            int min = nums[left];
            while (left != -1 && nums[left] == min) {
                left--;
            }
            //挪过头，再恢复一位
            left += 1;
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}