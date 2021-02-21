package _2021._02._0221._02;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/2/21 11:36 上午
 * @description 比赛
 */
public class Solution {
    public static String mergeAlternately(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        char[] newChar = new char[len1 + len2];
        int index = 0;
        while (index < len1 && index < len2) {
            newChar[index * 2] = chars1[index];
            newChar[index * 2 + 1] = chars2[index];
            index++;
        }
        if (index ==  len1) {
            while (index < len2) {
                newChar[index + len1] = chars2[index];
                index++;
            }
        } else if (index == len2) {
            while (index < len1) {
                newChar[index + len2] = chars1[index];
                index++;
            }
        }
        return String.valueOf(newChar);
    }

    public static void main(String[] args) {
        String word1 = "abcd", word2 = "pq";
        String s = mergeAlternately(word1, word2);
        System.out.println(s);
    }
}
