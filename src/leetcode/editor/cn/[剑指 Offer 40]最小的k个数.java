package leetcode.editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 337 👎 0

/**
 *
 * 就是一个排序，然后取排序完的前几个数即可。排序的话用快排
 * 主要的规则是：找到当前左边界作为哨兵，从右边界开始找到一个小数，然后从左边界找到一个大数，二者交换
 * 直到左右相遇，则交换左和哨兵，此时哨兵的左边都是小于哨兵的，右边都是大于哨兵的。然后左右分别递归。
 *
 * 为什么一定要从右边找小数？因为这样从右边开始找一定可以先找到一个小数。然后把它换到左哨兵是没问题的
 * 如果从左边开始找会找到一个大数，把它和左哨兵交换是不可以的。
 * 如果要从左边开始找，那么哨兵需要换成右边界。
 *
 * 如果是降序排序，则右边找大数，左边找小数即可
 **/

class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        int[] leastNumbers = solution.getLeastNumbers(new int[]{1, 2, 3}, 2);
        System.out.println(leastNumbers[0] + " " + leastNumbers[1]);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            quickSort(0, arr.length-1, arr);

            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }
            return res;
        }

        public void quickSort(int l, int r, int[] arr) {
            if (l >= r) {
                return;
            }

            int i = l, j = r;
            while (i < j) {
                while (i < j && arr[j] >= arr[l]) {
                    j--;
                }
                while (i < j && arr[i] <= arr[l]) {
                    i++;
                }
                swap(i, j, arr);
            }
            swap(l, i, arr);
            quickSort(l, i - 1, arr);
            quickSort(i + 1, r, arr);
        }

        public void swap(int i, int j, int[] arr) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}