class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        if len(moves) < 5:
            return "Pending"
        arr = 9 * [None]
        for i in range(len(moves)):
            if i % 2 == 0:
                arr[3 * moves[i][0] + moves[i][1]] = "A"
            else:
                arr[3 * moves[i][0] + moves[i][1]] = "B"
                
        if self.hasWinner(arr, 0, 1, 2) or self.hasWinner(arr, 0, 3, 6) or self.hasWinner(arr, 0, 4, 8):
            return arr[0]
        elif self.hasWinner(arr, 1, 4, 7):
            return arr[1]
        elif self.hasWinner(arr, 2, 5, 8) or self.hasWinner(arr, 2, 4, 6):
            return arr[2]
        elif self.hasWinner(arr, 3, 4, 5):
            return arr[3]
        elif self.hasWinner(arr, 6, 7, 8):
            return arr[6]
        return "Draw" if len(moves) == 9 else "Pending"

    def hasWinner(self, arr, i, j, k):
        if arr[i] and arr[i] == arr[j] and arr[j] == arr[k]:
            return True
        return False