package leetcode.editor.cn;

//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 设计 队列 单调队列 👍 298 👎 0

/**
 *
 * 这道题的理解上有一点巧妙，先说思路吧。
 * 首先用一个正常的队列来存储数据，这个没什么问题，一个queue
 * 然后利用一个deque来记录maxValue，具体是，queue入一个val，deque判断
 * 如果val < deque的末尾，deque直接入val。
 * 如果val > deque的末尾，就把deque的末尾出队，继续循环判断，直到val < deque入队
 *
 * 出队，queue正常出队val，如果deque的头部和val相等，则deque也一起入队。否则不动
 *
 * max_value，就直接peek deque即可
 *
 * 这道题的抽象理解类似于这样
 *
 * 入队顺序 5 3 2 4 1
 * deque会变成  5 -> 53 -> 532 -> 54 -> 541
 * 怎么理解，5入队，deque为5，代表在5出队之前，即队列5的最大值都一定是5
 * 3入队，deque为53，代表在5出队之前，最大值是5，但是5出队之后，3出队之前，最大值为3
 * 532同样这样理解。
 * 54代表，对于队列5324，代表在5出队前，最大值是5，在5出队之后，4出队之前，最大值为4
 *
 * deque的含义像是记录了一个区间内的最大值，即在5出队之前最大值是5，
 * 5出队后到4出队前的这个区间，最大值是4.
 * 此时如果又进来一个6，那么deque就会变成6，意思是在6出队之前，队列的最大值都只可能为6
 *
 * 然后是出队，queue就正常出队。然后判断出队的元素是否是deque的头，如果是把deque也出队
 * 这个比较好理解，意思是5出队了，那么接下来的最大值就由4来接管了。
 *
 * 另外入队的时候，判断条件是。while (!max.isEmpty() && max.peekLast() < value)
 * 意思是会提前出队比val小的元素，意思是相等的元素会留下。这个主要是为了保留最值可能不止一个
 * 例如入队533，那么deque应该是533，假如只存了53，那么在queue53出队了。deque就空了
 * deque就没元素了，但此时的queue的最大值应该还是3.所以相等的元素也要在deque中保存
 *
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class DuiLieDeZuiDaZhiLcof {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class MaxQueue {

        Deque<Integer> max;
        Queue<Integer> queue;

        public MaxQueue() {
            max = new LinkedList<>();
            queue = new LinkedList<>();
        }

        public int max_value() {
            return max.isEmpty() ? -1 : max.peekFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (!max.isEmpty() && max.peekLast() < value) {
                max.pollLast();
            }
            max.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int res = queue.poll();
            if (!max.isEmpty() && max.peekFirst() == res) {
                max.pollFirst();
            }
            return res;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}