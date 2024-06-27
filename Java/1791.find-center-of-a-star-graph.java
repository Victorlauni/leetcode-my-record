class Solution {
    public int findCenter(int[][] edges) {
        int[] first = edges[0];
        int[] second = edges[1];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (first[i] == second[j])
                    return first[i];
            }
        }

        return -1;
    }
}