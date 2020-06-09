// https://leetcode.com/problems/is-subsequence/

class Solution {
    public booleahttps://leetcode.com/problems/is-subsequence/n isSubsequence(String s, String t) {
        int s_i = 0;
        
        if(s.length() == 0)
            return true;
        
        for(int t_i = 0; t_i < t.length(); t_i++) {
            if(s.charAt(s_i) == t.charAt(t_i))
                s_i++;
            
            if(s_i == s.length())
                return true;
        }      
        
        return false;
    }
}
