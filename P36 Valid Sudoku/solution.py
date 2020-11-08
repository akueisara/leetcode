class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            row = set()
            column = set()
            box = set()
            for j in range(9):
                if board[i][j] != '.':
                    if board[i][j] not in row:
                        row.add(board[i][j])
                    else:
                        return False
                if board[j][i] != '.':
                    if board[j][i] not in column:
                        column.add(board[j][i])
                    else:
                        return False
                box_row_index = 3 * (i // 3) + j // 3
                box_column_index = 3 * (i % 3) + j % 3
                if board[box_row_index][box_column_index] != '.':
                    if board[box_row_index][box_column_index] not in box:
                        box.add(board[box_row_index][box_column_index])
                    else:
                        return False
        return True  