class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if(board[j][i] != '.' && !column.add(board[j][i])) {
                    return false;
                }
                int boxRowIndex = 3*(i/3) + j/3;
                int boxColumnIndex = 3*(i%3) + j%3;
                if(board[boxRowIndex][boxColumnIndex] != '.' && !box.add(board[boxRowIndex][boxColumnIndex])) {
                    return false;
                }
            }
        }
        return true;
    }
}