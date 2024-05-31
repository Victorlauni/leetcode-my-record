import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        int result = Arrays.asList(String.valueOf(num).split("")).stream()
            .map(s -> Integer.parseInt(s))
            .reduce((arr, curr) -> arr + curr)
            .get();
        if (result >= 10) return addDigits(result);
        else return result;
    }
}
// @lc code=end

