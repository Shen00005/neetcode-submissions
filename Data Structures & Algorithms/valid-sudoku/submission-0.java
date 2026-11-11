class Solution {
    
    public int getBox(int i, int j) {
        int x = i/3; 
        int y = j/3;
        return x*3+y;
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
            
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;


                boolean unvalid_col, unvalid_row, unvalid_box;
                unvalid_col = cols[j].contains(board[i][j]);
                unvalid_row = rows[i].contains(board[i][j]);
                unvalid_box = boxes[getBox(i,j)].contains(board[i][j]);

                if (unvalid_col || unvalid_row || unvalid_box) {
                    return false;
                } else {
                    cols[j].add(board[i][j]);
                    rows[i].add(board[i][j]);
                    boxes[getBox(i,j)].add(board[i][j]);
                }
            }
        }

        return true;
    }
}
