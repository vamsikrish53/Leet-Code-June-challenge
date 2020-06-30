// https://leetcode.com/problems/word-search-ii/

class Solution {
    public List < String > findWords(char[][] board, String[] words) {
        List < String > result = new ArrayList < > ();
        Trie root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, result, i, j);
            }
        }
        return result;
    }

    private void dfs(char[][] board, Trie curr, List < String > result, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || curr.child[board[i][j] - 'a'] == null)
            return;
        char c = board[i][j];
        curr = curr.child[c - 'a'];
        if (curr.word != null) {
            result.add(curr.word);
            curr.word = null;
        }
        board[i][j] = '#';
        dfs(board, curr, result, i + 1, j);
        dfs(board, curr, result, i - 1, j);
        dfs(board, curr, result, i, j + 1);
        dfs(board, curr, result, i, j - 1);
        board[i][j] = c;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word: words) {
            Trie curr = root;
            for (Character ch: word.toCharArray()) {
                if (curr.child[ch - 'a'] == null)
                    curr.child[ch - 'a'] = new Trie();

                curr = curr.child[ch - 'a'];
            }
            curr.word = word;
        }
        return root;
    }

    class Trie {
        Trie child[] = new Trie[26];
        String word;
    }
}
