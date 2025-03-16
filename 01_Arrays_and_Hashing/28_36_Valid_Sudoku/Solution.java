class Pair {
    int r;
    int c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Pair p = (Pair) obj;
        return p.r == this.r && p.c == this.c;
    }

    @Override
    public int hashCode() {
        return 31 * r + c;
    }

}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Pair, HashSet<Character>> squares = new HashMap<>();

         for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                char num = board[i][j];
                Pair squareKey = new Pair(i / 3, j / 3);

                squares.putIfAbsent(squareKey, new HashSet<>());

                if (rows.get(i).contains(num) ||
                        cols.get(j).contains(num) ||
                        squares.get(squareKey).contains(num)) {
                    return false;
                }
                rows.get(i).add(num);
                cols.get(j).add(num);
                squares.get(squareKey).add(num);
            }
        }
        return true;

    }
}
