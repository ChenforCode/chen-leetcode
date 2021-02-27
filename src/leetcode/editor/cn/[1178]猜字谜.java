package leetcode.editor.cn;

//外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。 
//
// 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底： 
//
// 
// 单词 word 中包含谜面 puzzle 的第一个字母。 
// 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。 
// 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"
//（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。 
// 
//
// 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜
//底的单词数目。 
//
// 
//
// 示例： 
//
// 
//输入：
//words = ["aaaa","asas","able","ability","actt","actor","access"], 
//puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
//输出：[1,1,3,2,4,0]
//解释：
//1 个单词可以作为 "aboveyz" 的谜底 : "aaaa" 
//1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
//3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
//2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
//4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
//没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10^5 
// 4 <= words[i].length <= 50 
// 1 <= puzzles.length <= 10^4 
// puzzles[i].length == 7 
// words[i][j], puzzles[i][j] 都是小写英文字母。 
// 每个 puzzles[i] 所包含的字符都不重复。 
// 
// Related Topics 位运算 哈希表 
// 👍 154 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NumberOfValidWordsForEachPuzzle {
    public static void main(String[] args) {
        Solution solution = new NumberOfValidWordsForEachPuzzle().new Solution(); 
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findNumOfValidWords(String[] ws, String[] ps) {
        // 转用 「哈希表」来统计出所有的 word 所对应的二进制数值
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : ws) {
            int t = getBin(w);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        // 判定每个 puzzles 有多少个谜底
        List<Integer> ans = new ArrayList<>();
        for (String p : ps) ans.add(getCnt(map, p));
        return ans;
    }
    int getCnt(Map<Integer, Integer> map, String str) {
        int ans = 0;
        int m = str.length();
        char[] cs = str.toCharArray();
        // 当前 puzzles 的首个字符在二进制数值中的位置
        int first = cs[0] - 'a';
        // 枚举「除首个字母」以外的所有组合
        for (int i = 0; i < (1 << (m - 1)); i++) {
            // 先将首字母提取出来
            int u = 1 << first;
            // 枚举「除首个字母」之后的每一位，结合上面的首个字母
            // 其实就是枚举以 str 首字母开头的字符有多少种
            for (int j = 1; j < m; j++) {
                if (((i >> (j - 1)) & 1) != 0) u += 1 << (cs[j] - 'a');
            }
            // 查询这样的字符是否出现在 `words` 中，出现了多少次
            if (map.containsKey(u)) ans += map.get(u);
        }
        return ans;
    }
    // 将 str 所包含的字母用二进制标识
    // 如果 str = abz 则对应的二进制为 100...011 (共 26 位，从右往左是 a - z)
    int getBin(String str) {
        int t = 0;
        char[] cs = str.toCharArray();
        for (char c : cs) {
            // 每一位字符所对应二进制数字中哪一位
            int u = c - 'a';
            // 如果当前位置为 0，代表还没记录过，则进行记录 (不重复记录)
            if ((t >> u & 1) == 0) t += 1 << u;
        }
        return t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}