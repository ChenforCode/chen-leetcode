package leetcode.editor.cn;

//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
//
// 
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 
//
// 
//
// 示例： 
//
// 
//给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设矩阵不可变。 
// 会多次调用 sumRegion 方法。 
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。 
// 
// Related Topics 动态规划 
// 👍 225 👎 0

/**
 * // 二维前缀和解法
 * // 1. 定义二维前缀和 preNums[i, j]: 第i行第j列格子左上部分所有元素之和(包含第i行第j列格子元素)
 * // 2. 前缀和计算公式 preNums[i][j] = preNums[i - 1][j] + preNums[i][j - 1] - preNums[i - 1][j - 1] + preNums[i][j]
 * // 3. 以(x1, y1)为左上角, (x2, y2)为右下角的子矩阵的和为：
 * // preNums[x2, y2] - preNums[x1 - 1, y2] - preNums[x2, y1 - 1] + preNums[x1 - 1, y1 - 1]
 **/
class RangeSumQuery2dImmutable {
    public static void main(String[] args) {
//        Solution solution = new RangeSumQuery2dImmutable().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        int[][] preSum;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            preSum = new int[row + 1][col + 1];
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}