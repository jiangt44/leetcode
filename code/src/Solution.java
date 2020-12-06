import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * 两数之和,从数组中找出和为目标值的两个数字并且输出下标
     * 解决方案：利用Map，Key与Value的映射关系，Key存储与当前值与目标值的差值，value存当前下标；
     *
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }
}
