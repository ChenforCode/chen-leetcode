package offer;

import java.util.TreeMap;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/3/11 11:02 上午
 * @description 剑指 Offer 12. 矩阵中的路径
 *
 * 这道题的思路是，在矩阵中找到一个abcd串，因此需要从所有的a处开始找，如果上下左右有b，则进入b
 * 然后往后接着找，当递归深度达到了4，就说明已经找到了。
 *
 * 这道题需要用一个标志位标志已经走的路，例如进入a，a的标志位需要置1，代表走过，进入b，b也置1，
 * 这个时候如果b返回（说明ab往下接着走没有c了），b的标志位需要置0，因为还有可能有其他的路径走
 * 这个b
 *
 *
 * 什么时候不用恢复标志位？当是染色问题，求连通量的就不用恢复，染色的目的是快速走完所有能走的
 */
class Exist {
    private int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int row, col;
    private char[] chars;
    private boolean flag = false;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        chars = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == chars[0]) {
                    //确定走这个点，就标志
                    board[i][j] = '/';
                    dfs(board, 0, i, j);
                    if (flag) {
                        return flag;
                    }
                    //以改点往后的搜索结束了，仍然没找到，因此这个点没有用了，清0，让别的路径走
                    board[i][j] = chars[0];
                }
            }
        }
        return flag;
    }

    public void dfs(char[][] board, int step, int x, int y) {
        if (flag) {
            return;
        }
        if (step == chars.length - 1) {
            flag = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + next[i][0];
            int ny = y + next[i][1];
            if (nx < 0 || nx >= row || ny < 0 || ny >= col || board[nx][ny] == '/') {
                continue;
            }
            if (board[nx][ny] == chars[step + 1]) {
                //这个地方同理，确定走就置1
                board[nx][ny] = '/';
                dfs(board, step + 1, nx, ny);
                //否则就恢复这个点，继续寻找
                board[nx][ny] = chars[step + 1];
            }
        }
    }
}
