package _2021._02._0222;

import java.util.Map;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/22 8:56 上午
 * @description 766. 托普利茨矩阵
 */
public class Solution {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 3, 4},{5, 1, 2, 3},{9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(matrix));
    }
}
