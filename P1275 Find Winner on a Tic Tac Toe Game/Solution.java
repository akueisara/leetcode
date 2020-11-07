class Solution {
    public String tictactoe(int[][] moves) {
        if(moves.length < 5) {
            return "Pending";
        }
        String[] arr = new String[9];
        for(int i = 0; i < moves.length; i++) {
            if(i % 2 == 0) {
                arr[3 * moves[i][0] + moves[i][1]] = "A";
            } else {
                arr[3 * moves[i][0] + moves[i][1]] = "B";
            }
        }
        if(hasWinner(arr, 0, 1, 2) || hasWinner(arr, 0, 3, 6) || hasWinner(arr, 0, 4, 8)) {
            return arr[0];
        } else if(hasWinner(arr, 1, 4, 7)) {
            return arr[1];
        } else if(hasWinner(arr, 2, 5, 8) || hasWinner(arr, 2, 4, 6)) {
            return arr[2];
        } else if(hasWinner(arr, 3, 4, 5)) {
            return arr[3];
        } else if(hasWinner(arr, 6, 7, 8)) {
            return arr[6];
        }
        if(moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
    }
    
    boolean hasWinner(String[] arr, int i, int j, int k) {
        if(arr[i] != null && arr[i] == arr[j] && arr[j] == arr[k]) {
            return true;
        }
        return false;
    }
}