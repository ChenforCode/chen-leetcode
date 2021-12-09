package leetcode.editor.cn;

//给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。 
//
// 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。 
//
// 以下是井字游戏的规则： 
//
// 
// 玩家轮流将字符放入空位（' '）中。 
// 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。 
// 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。 
// 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。 
// 当所有位置非空时，也算为游戏结束。 
// 如果游戏结束，玩家不允许再放置字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = ["O  ","   ","   "]
//输出：false
//解释：玩家 1 总是放字符 "X" 。
// 
//
// 示例 2： 
//
// 
//输入：board = ["XOX"," X ","   "]
//输出：false
//解释：玩家应该轮流放字符。 
//
// 示例 3： 
//
// 
//输入：board = ["XXX","   ","OOO"]
//输出：false
// 
//
// Example 4: 
//
// 
//输入：board = ["XOX","O O","XOX"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// board.length == 3 
// board[i].length == 3 
// board[i][j] 为 'X'、'O' 或 ' ' 
// 
// Related Topics 数组 字符串 👍 61 👎 0
// 题意是要判断当前的棋盘是否合法，就是说能不能通过正常的符合规则下棋下成当前的状态
// 一个简单的模拟，看注释即可明白。

class ValidTicTacToeState {
    public static void main(String[] args) {
        Solution solution = new ValidTicTacToeState().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String[] b;

        public boolean validTicTacToe(String[] board) {
            b = board;
            //如果x获得胜利，那么x必定比o多一个
            int x = count('X');
            int o = count('O');
            //同时赢不可能，并且排除了二者个数相等的情况
            if (isWin('X') && isWin('O')) {
                return false;
            }
            //x赢必须比o多一个
            if (isWin('X') && (x - o) == 1) {
                return true;
            }
            //o赢必须和x一样（先判断同时赢的情况就是为了避免这里出错，同时赢，在此处也是可以通过的，但是非法，需要先把同时赢排除掉）
            if (isWin('O') && (x == o)) {
                return true;
            }
            //在大家都没有赢的情况下，必须x和o的差值保持在0和1中
            if (((x - o) == 0 || (x - o) == 1) && !isWin('X') && !isWin('O')) {
                return true;
            }
            return false;
        }

        //统计当前棋盘符号个数
        public int count(char c) {
            int cnt = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (b[i].charAt(j) == c) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        //判断是否获得胜利。
        public boolean isWin(char c) {
            //三条横线完全连成一排
            for (int i = 0; i < 3; i++) {
                if (b[i].charAt(0) == c && b[i].charAt(1) == c && b[i].charAt(2) == c) {
                    return true;
                }
            }
            //三条竖线排成一排
            for (int i = 0; i < 3; i++) {
                if (b[0].charAt(i) == c && b[1].charAt(i) == c && b[2].charAt(i) == c) {
                    return true;
                }
            }
            //y=-x对角线排成一排
            if (b[0].charAt(0) == c && b[1].charAt(1) == c && b[2].charAt(2) == c) {
                return true;
            }
            //y=-x对角线排成一排
            if (b[0].charAt(2) == c && b[1].charAt(1) == c && b[2].charAt(0) == c) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}