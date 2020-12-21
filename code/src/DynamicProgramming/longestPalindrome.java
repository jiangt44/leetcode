package DynamicProgramming;

public class longestPalindrome {
    /**
     * leetcode 第五题 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 解法1，每个字符都可以作为中心点，向左右扩展
     * 时间复杂度：O(n2)
     * 空间复杂度：O（1）
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int l1, l2, l3;
        int st = 0, ed = 0;
        for (int i = 0; i < s.length(); i++) {
            l1 = getPalindromeLength(s, i, i); //以i为中心点，奇数长度
            l2 = getPalindromeLength(s, i, i + 1); //偶数长度
            l3 = l1 > l2 ? l1 : l2;
            if (ed - st < l3) {
                st = i - (l3 - 1) / 2;
                ed = i + l3 / 2;
            }
        }
        return s.substring(st, ed + 1);
    }

    private int getPalindromeLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
