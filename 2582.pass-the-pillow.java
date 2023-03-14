/*
 * @lc app=leetcode id=2582 lang=java
 *
 * [2582] Pass the Pillow
 */

// @lc code=start
class Solution {
    public int passThePillow(int n, int time) {
        int dir = ((time)/(n-1))%2; // 0 or 1
        int pos = ((time)%(n-1))+1;
        if (dir == 0) return pos;
        else return n-pos+1;
    }
}
// @lc code=end

