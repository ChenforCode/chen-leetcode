package leetcode.editor.cn;

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 二分查找 分治 矩阵 👍 508 👎 0

/* 从右上角开始，往左走变小，往右走变大，所以以此为起点，小于target，行数加一，大于target，列数减一
 * 意思是如果，(i,j)已经比target大了，那么他下边的都比target大，这个时候只能往左走缩小
 * 如果，(i,j)比target小，那么他他左边的都比target小，只能往下走增大
 */

class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int i = 0, j = matrix[0].length - 1;
            while (i < matrix.length && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] < target) {
                    i++;
                } else if (matrix[i][j] > target) {
                    j--;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}