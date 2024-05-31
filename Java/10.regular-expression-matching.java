class Solution {
    public boolean isMatch(String s, String p) {
        
        int sIndex = 0;
        if (s.length() == 0 && p.length() >= 2 && p.charAt(1) == '*')
            return isMatch(s, p.substring(2));
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() > 0 && p.length() == 0) return false;

        for (int i = 0; i < p.length(); i++) {
            if (i < p.length()-1 && p.charAt(i+1) == '*') {
                int sIndMatch = sIndex;
                boolean result = isMatch(s.substring(sIndMatch), p.substring(i+2));
                while (s.length() > sIndMatch && (s.charAt(sIndMatch) == p.charAt(i) || p.charAt(i) == '.')) {
                    result = result || isMatch(s.substring(sIndMatch+1), p.substring(i+2));
                    sIndMatch++;
                }
                return result;
            }
            else {
                if (sIndex >= s.length()) return false;
                if (s.charAt(sIndex) == p.charAt(i) || p.charAt(i) == '.') {
                    sIndex++;
                    continue;
                }
                else return false;
            }
        }
        if (sIndex != s.length()) return false;
        return true;
    }
}