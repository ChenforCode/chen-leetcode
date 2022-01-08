package leetcode.editor.cn;

//给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。 
//
// 输入为三个整数：day、month 和 year，分别表示日、月、年。 
//
// 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", 
//"Friday", "Saturday"}。 
//
// 
//
// 示例 1： 
//
// 输入：day = 31, month = 8, year = 2019
//输出："Saturday"
// 
//
// 示例 2： 
//
// 输入：day = 18, month = 7, year = 1999
//输出："Sunday"
// 
//
// 示例 3： 
//
// 输入：day = 15, month = 8, year = 1993
//输出："Sunday"
// 
//
// 
//
// 提示： 
//
// 
// 给出的日期一定是在 1971 到 2100 年之间的有效日期。 
// 
// Related Topics 数学 👍 84 👎 0

class DayOfTheWeek {
    public static void main(String[] args) {
        Solution solution = new DayOfTheWeek().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String dayOfTheWeek(int day, int month, int year) {
            String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
            /* 输入年份之前的年份的天数贡献 */
            int days = 365 * (year - 1971) + (year - 1969) / 4;
            /* 输入年份中，输入月份之前的月份的天数贡献 */
            for (int i = 0; i < month - 1; ++i) {
                days += monthDays[i];
            }
            if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
                days += 1;
            }
            /* 输入月份中的天数贡献 */
            days += day;
            return week[(days + 3) % 7];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}