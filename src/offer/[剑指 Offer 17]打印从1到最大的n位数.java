package offer;

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 102 👎 0

class DaYinCong1daoZuiDaDeNweiShuLcof {
    public static void main(String[] args) {

        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
        solution.printNumbers(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private StringBuilder curNum = new StringBuilder();
        private String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        private int[] res;
        private int n;
        private int index = 0;
        public int[] printNumbers(int n) {
            this.n = n;
            //用来定义存储最后结果的int数组
            res = new int[(int)Math.pow(10, n) - 1];
            //从第一位开始定位。
            dfs(1);
            return res;
        }

        private void dfs(int step) {
            //如果一共定位n位，那么到了n+1应该已经结束了，并且已经定位完毕。这时就需要判0，然后删除头部的0
            //加入最后的结果
            if (step == n + 1) {
                String num = curNum.toString();
                boolean isZero = true;
                for (int i = 0; i < num.length(); i++) {
                    if (num.charAt(i) != '0') {
                        isZero = false;
                        break;
                    }
                }
                if (isZero) {
                    return;
                }
                int i = 0;
                while (num.charAt(i) == '0') {
                    i++;
                }
                String numWithoutZero = num.substring(i);
                res[index++] = Integer.parseInt(numWithoutZero);
                return;
            }
            //开始定位step位置，从0试探到9
            for (int i = 0; i <= 9; i++) {
                //在当前位置上放入1-9
                curNum.append(num[i]);
                dfs(step + 1);
                //尝试放完1之后，需要把1删除，然后循环尝试放2，以此类推
                curNum.deleteCharAt(step - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}