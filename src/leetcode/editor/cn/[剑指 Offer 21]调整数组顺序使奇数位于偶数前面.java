package leetcode.editor.cn;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 108 👎 0
/**
 *
 * 第一种思路是头尾指针，一个往左搜，一个往右搜，如果左边遇到偶数，右边遇到奇数，就交换，知道二者碰头。
 * 第二种思路是双头指针，一起往右搜索，一个遇到奇数，一个遇到偶数，但是偶数必须靠右，才交换，否则，奇数指针继续搜索。。这种的边界
 * 条件好多，如下
 **/

class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        solution.exchange(new int[]{1, 2, 3, 4, 5 ,6});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public int[] exchange(int[] nums) {
//            int slow = 0, fast = 0;
//            while (fast < nums.length && slow < nums.length) {
//                while (fast < nums.length && (nums[fast] & 1) != 1) {
//                    fast++;
//                }
//                while (slow < nums.length && (nums[slow] & 1) != 0) {
//                    slow++;
//                }
//                if (slow < fast) {
//                    if (slow < nums.length && fast < nums.length) {
//                        int temp = nums[fast];
//                        nums[fast] = nums[slow];
//                        nums[slow] = temp;
//                    }
//                } else {
//                    fast++;
//                }
//            }
//            return nums;
//        }

        public int[] exchange(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                //这个地方可以采用if，每次++就continue，让外层的while去判断条件是否满足。否则有可能两个while算完
                //得到的left和right根本不符合要求，还要在下边判断，浪费时间。
                while (left <= right && (nums[left] & 1) == 1) {
                    left++;
                }
                while (left <= right && (nums[right] & 1) == 0) {
                    right--;
                }
                if (left <= right) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                }
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}