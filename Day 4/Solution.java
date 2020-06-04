// https://leetcode.com/problems/reverse-string/

class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        char temp;
        for(i = 0; i < s.length/2; i++) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
    }
}
