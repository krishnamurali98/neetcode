/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node dfs(int n, int[][] grid, int r, int c) {
        boolean allSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[r][c] != grid[i + r][j + c]) {
                    allSame = false;
                    break;
                }
            }
        }
        if (allSame) {
            return new Node(grid[r][c] == 1, true);
        }

        n = n/2;
        Node topLeft = dfs(n, grid, r, c);
        Node topRight = dfs(n, grid, r, c+n);
        Node bottomLeft = dfs(n, grid, r+n, c);
        Node bottomRight = dfs(n, grid, r+n, c+n);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public Node construct(int[][] grid) {
        return dfs(grid.length, grid, 0, 0);
    }
}
