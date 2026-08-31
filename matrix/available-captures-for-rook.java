class Solution {
    public int numRookCaptures(char[][] board) {
        int r = -1, c = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break;
                }
            }
            if (r != -1) break;
        }
        int count = 0;
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'p') {
                count++;
                break;
            } else if (board[i][c] == 'B') {
                break;
            }
        }
        for (int i = r + 1; i < 8; i++) {
            if (board[i][c] == 'p') {
                count++;
                break;
            } else if (board[i][c] == 'B') {
                break;
            }
        }
        for (int j = c - 1; j >= 0; j--) {
            if (board[r][j] == 'p') {
                count++;
                break;
            } else if (board[r][j] == 'B') {
                break;
            }
        }
        for (int j = c + 1; j < 8; j++) {
            if (board[r][j] == 'p') {
                count++;
                break;
            } else if (board[r][j] == 'B') {
                break;
            }
        }
        return count;
    }
}
