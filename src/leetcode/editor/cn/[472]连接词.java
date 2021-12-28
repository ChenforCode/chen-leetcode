package leetcode.editor.cn;

//给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。 
//
// 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses",
//"rat","ratcatdogcat"]
//输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
//解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成; 
//     "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成; 
//     "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
// 
//
// 示例 2： 
//
// 
//输入：words = ["cat","dog","catdog"]
//输出：["catdog"] 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁴ 
// 0 <= words[i].length <= 1000 
// words[i] 仅由小写字母组成 
// 0 <= sum(words[i].length) <= 10⁵ 
// 
// Related Topics 深度优先搜索 字典树 数组 字符串 动态规划 👍 168 👎 0

/**
 * 这道题目就是利用一个字典树存储所有的单词。对于一个单词，如果是一个连接词，就返回结果
 * 如果不是连接词，即一个正常的词把他加入到字典树里。
 * <p>
 * 判断是一个连接词：对于一个词word1word2，在字典树中搜索，如果搜索结束到了一个词word1，那么就从
 * word1之后的词语继续搜索，来递归判断后半部分word2是否是一个词语，如果最终正常搜索完了，就说明word1word2
 * 是一个连接词。
 * <p>
 * 不是连接词的情况：1、搜索到null了，word1判断完毕是一个单词，但是递归判断word2的时候发现不是，2、那么整体就不是
 * <p>
 * 字典树：
 * class Trie {
 * boolean isEnd;
 * Trie[] next;
 * <p>
 * public Trie() {
 * isEnd = false;
 * next = new Trie[26];
 * }
 * }
 * 每个节点是不存储值的，真正的存储值的是在next里，对应的索引不是null，就代表有一个值
 * 例如存储a字符---》Node1(false, next[0]->) --> Node2(true, null)
 * 例如存储ac字符---》Node1(false, next[0]->) --> Node2(false, next[2]->) --> Node3(true, null)
 * <p>
 * 因此所有对节点的操作都是对next操作的。
 * 例如在创建abc的时候，最终创建完毕c之后，倒数第二个节点是Node(false, next[2]->)。此时还应该有最后一个节点是一个'
 * 空节点，啥都没有，但是会被next[2]指着
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class ConcatenatedWords {
    public static void main(String[] args) {
        Solution solution = new ConcatenatedWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Trie tree = new Trie();
        List<String> res = new ArrayList<>();

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            Arrays.sort(words, (a, b) -> a.length() - b.length());
            for (String word : words) {
                if (word.length() == 0) {
                    continue;
                }
                if (dfs(word, 0)) {
                    res.add(word);
                } else {
                    insert(word);
                }
            }
            return res;
        }

        public boolean dfs(String str, int start) {
            if (str.length() == start) {
                return true;
            }
            Trie node = tree;
            for (int i = start; i < str.length(); i++) {
                if (node.next[str.charAt(i) - 'a'] == null) {
                    return false;
                }
                if (node.next[str.charAt(i) - 'a'].isEnd) {
                    if (dfs(str, i + 1)) {
                        return true;
                    }
                }
                node = node.next[str.charAt(i) - 'a'];
            }
            return false;
        }

        public void insert(String str) {
            Trie node = tree;
            for (int i = 0; i < str.length(); i++) {
                if (node.next[str.charAt(i) - 'a'] == null) {
                    node.next[str.charAt(i) - 'a'] = new Trie();
                }
                node = node.next[str.charAt(i) - 'a'];
            }
            node.isEnd = true;
        }

        class Trie {
            boolean isEnd;
            Trie[] next;

            public Trie() {
                isEnd = false;
                next = new Trie[26];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}