package _2021._02._0207._02;

import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/7 12:59 下午
 * @description 130. 被围绕的区域
 */
public class Solution {
    private static int[][] next = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static int row;
    private static int col;

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if (board[i][col - 1] == 'O') {
                dfs(i, col - 1, board);
            }
        }
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if (board[row - 1][i] == 'O') {
                dfs(row - 1, i, board);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //这两个顺序不能颠倒，否则，-产生的O也会被弄成X
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(int x, int y, char[][] nums) {
        nums[x][y] = '-';
        for (int i = 0; i < 4; i++) {
            int nx = x + next[i][0];
            int ny = y + next[i][1];
            if (nx < 0 || nx >= row || ny < 0 || ny >= col || nums[nx][ny] == '-'
                    || nums[nx][ny] == 'X') {
                continue;
            }
            dfs(nx, ny, nums);
        }
    }

    public static void main(String[] args) {
        char[][] nums = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
//        char[][] nums = {{'O', 'O'}, {'O', 'O'}};
//        char[][] nums = {
//                {'O', 'X', 'X', 'O', 'X'},
//                {'X', 'O', 'O', 'X', 'O'},
//                {'X', 'O', 'X', 'O', 'X'},
//                {'O', 'X', 'O', 'O', 'O'},
//                {'X', 'X', 'O', 'X', 'O'}
//        };
        solve(nums);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
