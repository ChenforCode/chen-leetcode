package leetcode.editor.cn;

//在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认
//为是建筑物。 
//
// 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的
//外部轮廓。 请看下面的例子。 
//
// 建筑物高度可以增加的最大总和是多少？ 
//
// 
//例子：
//输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
//输出： 35
//解释： 
//The grid is:
//[ [3, 0, 8, 4], 
//  [2, 4, 5, 7],
//  [9, 2, 6, 3],
//  [0, 3, 1, 0] ]
//
//从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
//从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
//
//在不影响天际线的情况下对建筑物进行增高后，新数组如下：
//
//gridNew = [ [8, 4, 8, 7],
//            [7, 4, 7, 7],
//            [9, 4, 8, 7],
//            [3, 3, 3, 3] ]
// 
//
// 说明: 
//
// 
// 1 < grid.length = grid[0].length <= 50。 
// grid[i][j] 的高度范围是： [0, 100]。 
// 一座建筑物占据一个grid[i][j]：换言之，它们是 1 x 1 x grid[i][j] 的长方体。 
// 
// Related Topics 贪心 数组 矩阵 👍 149 👎 0

/**
 *
 * 左右方向和上下方向看见的最大值是以当前col和row的最大值决定的，因此只要每个数据最高
 * 升到最大值，是不会影响天际线的，但是必须只能升到col和row中的最小值。
 * 因此需要提前预处理出来每行和每列的最大值，然后Math.min(row[i],col[j]) - grid[i][j]
 * 就是这个格子能够提升的最大高度，求和即可
 **/
class MaxIncreaseToKeepCitySkyline {
    public static void main(String[] args) {
        Solution solution = new MaxIncreaseToKeepCitySkyline().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] colMax = new int[n];
            int[] rowMax = new int[m];
            for (int i = 0; i < m; i++) {
                int curRowMax = 0;
                for (int j = 0; j < n; j++) {
                    curRowMax = Math.max(curRowMax, grid[i][j]);
                }
                rowMax[i] = curRowMax;
            }
            for (int i = 0; i < n; i++) {
                int curColMax = 0;
                for (int j = 0; j < m; j++) {
                    curColMax = Math.max(curColMax, grid[j][i]);
                }
                colMax[i] = curColMax;
            }

            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int canAdd = Math.min(colMax[j], rowMax[i]) - grid[i][j];
                    res += canAdd;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}