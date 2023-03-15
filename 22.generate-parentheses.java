class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return new ArrayList<String>();
        Map<String, Pair<Integer, Integer>> result = new HashMap<>();
        result.put("(", new Pair<Integer, Integer>(1, 0));
        int loopCount = 0;
        while (loopCount < n*2) {
            Map<String, Pair<Integer, Integer>> newMap = new HashMap<>();
            result.forEach((key, val) -> {
                if (val.getKey() > val.getValue()) {
                    newMap.put(key+")", new Pair<>(val.getKey(), val.getValue()+1));
                }
                if (val.getKey() < n) {
                    newMap.put(key+"(", new Pair<>(val.getKey()+1, val.getValue()));
                }
            });
            if (!newMap.isEmpty()) result = newMap;
            loopCount++;
        }
        return result.keySet().stream().collect(Collectors.toList());
    }
}