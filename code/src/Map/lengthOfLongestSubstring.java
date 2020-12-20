package Map;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {

    /**
     * leetcode 第三题 最长不重复子字符串
     * 滑动窗口
     * 解题思路：利用Map，key存值，value存下标
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Integer pre; //同一数据的前下标
        int sIndex = 0; //字串开始节点
        int max = 0;
        int length;
        for (int i = 0; i < s.length(); i++) {
            pre = map.put(s.charAt(i), i);
            if (pre != null && pre >= sIndex) {
                length = i - sIndex;
                sIndex = pre + 1;  //字串起始节点由上一个重复节点的后一位
                max = max > length ? max : length;
            }
        }
        length = s.length() - sIndex;
        return max > length ? max : length;
    }
}
