public class Solution {
    public int ClimbStairs(int n) {
        if (n == 1 || n == 0) return 1;
        if (n < 0) return 0;
        int prev = 1;
        int prevprev = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = prev + prevprev;
            prevprev = prev;
            prev = tmp;
        }
        return prev;
    }
}