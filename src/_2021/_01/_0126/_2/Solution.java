package _2021._01._0126._2;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/1/26 11:16 上午
 * @description 461.汉明距离
 */
public class Solution {
    public static int hammingDistance(int x, int y) {
        int result = x ^ y;
        int dis = 0;
        //相与计算
//        while (result != 0) {
//            //每做一次该操作，都消除了一个1
//            result = (result & (result - 1));
//            dis++;
//        }
        //移位计算
        while (result != 0) {
            if (result % 2 == 1) {
                dis++;
            }
            result = result >> 1;
        }
        return dis;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
