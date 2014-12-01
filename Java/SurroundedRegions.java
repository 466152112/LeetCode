// DFS recursive, stackoverflow
public void solve(char[][] board) {
    if (board == null || board.length == 0)
        return;
    // check four boundaries
    for (int i = 0; i < board[0].length; i++) {
        // first row
        if (board[0][i] == 'O')
            dfs(0, i, board);
        // last row
        if (board[board.length - 1][i] == 'O')
            dfs(board.length - 1, i, board);
    }
    // check four boundaries
    for (int i = 0; i < board.length; i++) {
        // first column
        if (board[i][0] == 'O')
            dfs(i, 0, board);
        // last column
        if (board[i][board[0].length - 1] == 'O')
            dfs(i, board[0].length - 1, board);
    }
    // set all the rest 'O' to 'X', 'B' to 'O'
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == 'B')
                board[i][j] = 'O';
            else if (board[i][j] == 'O')
                board[i][j] = 'X';
        }
    }
}

// DFS & set to 'B'
private void dfs(int i, int j, char[][] board) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
        || board[i][j] == 'X' || board[i][j] == 'B')
        return;
    board[i][j] = 'B';
    dfs(i - 1, j, board);
    dfs(i + 1, j, board);
    dfs(i, j - 1, board);
    dfs(i, j + 1, board);
}


// DFS, iterative
class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public void solve(char[][] board) {
    if (board == null || board.length == 0)
        return;
    // check four boundaries
    for (int i = 0; i < board[0].length; i++) {
        // first row
        if (board[0][i] == 'O')
            dfs(0, i, board);
        // last row
        if (board[board.length - 1][i] == 'O')
            dfs(board.length - 1, i, board);
    }
    // check four boundaries
    for (int i = 0; i < board.length; i++) {
        // first column
        if (board[i][0] == 'O')
            dfs(i, 0, board);
        // last column
        if (board[i][board[0].length - 1] == 'O')
            dfs(i, board[0].length - 1, board);
    }
    // set all the rest 'O' to 'X', 'B' to 'O'
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == 'B')
                board[i][j] = 'O';
            else if (board[i][j] == 'O')
                board[i][j] = 'X';
        }
    }
}

// DFS & set to 'B'
private void dfs(int i, int j, char[][] board) {
    Stack<Pair> stack = new Stack<Pair>();
    Pair pair = new Pair(i,j);
    stack.push(pair);
    board[i][j] = 'B';
    while (!stack.isEmpty()) {
        Pair root = stack.pop();
        int X = root.i;
        int Y = root.j;
        int x, y;
        // up
        x = X - 1;
        y = Y;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            stack.push(child);
            board[x][y] = 'B';
        }
        // down
        x = X + 1;
        y = Y;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            stack.push(child);
            board[x][y] = 'B';
        }
        // left
        x = X;
        y = Y - 1;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            stack.push(child);
            board[x][y] = 'B';
        }
        // right
        x = X;
        y = Y + 1;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            stack.push(child);
            board[x][y] = 'B';
        }
    }
}

// BFS, iterative
class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public void solve(char[][] board) {
    if (board == null || board.length == 0)
        return;
    // check four boundaries
    for (int i = 0; i < board[0].length; i++) {
        // first row
        if (board[0][i] == 'O')
            bfs(0, i, board);
        // last row
        if (board[board.length - 1][i] == 'O')
            bfs(board.length - 1, i, board);
    }
    // check four boundaries
    for (int i = 0; i < board.length; i++) {
        // first column
        if (board[i][0] == 'O')
            bfs(i, 0, board);
        // last column
        if (board[i][board[0].length - 1] == 'O')
            bfs(i, board[0].length - 1, board);
    }
    // set all the rest 'O' to 'X', 'B' to 'O'
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == 'B')
                board[i][j] = 'O';
            else if (board[i][j] == 'O')
                board[i][j] = 'X';
        }
    }
}

// DFS & set to 'B'
private void bfs(int i, int j, char[][] board) {
    Queue<Pair> queue = new LinkedList<Pair>();
    Pair pair = new Pair(i,j);
    queue.offer(pair);
    board[i][j] = 'B';
    while (!queue.isEmpty()) {
        Pair root = queue.poll();
        int X = root.i;
        int Y = root.j;
        int x, y;
        // up
        x = X - 1;
        y = Y;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            queue.offer(child);
            board[x][y] = 'B';
        }
        // down
        x = X + 1;
        y = Y;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            queue.offer(child);
            board[x][y] = 'B';
        }
        // left
        x = X;
        y = Y - 1;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            queue.offer(child);
            board[x][y] = 'B';
        }
        // right
        x = X;
        y = Y + 1;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            queue.offer(child);
            board[x][y] = 'B';
        }
    }
}

// Nine chapter, more concise, similar idea, but euqueue all the pairs of the four boundary before dequeue 
public class Solution {
    private static Queue<Integer> queue = null;
    private static char[][] board;
    private static int rows = 0;
    private static int cols = 0;

    public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (board.length == 0 || board[0].length == 0) return;
        queue = new LinkedList<Integer>();
        board = board;
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) { // **important**
            enqueue(i, 0);
            enqueue(i, cols - 1);
        }

        for (int j = 1; j < cols - 1; j++) { // **important**
            enqueue(0, j);
            enqueue(rows - 1, j);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / cols,
                y = cur % cols;

            if (board[x][y] == 'O') {
                board[x][y] = 'D';
            }

            enqueue(x - 1, y);
            enqueue(x + 1, y);
            enqueue(x, y - 1);
            enqueue(x, y + 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'D') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        queue = null;
        board = null;
        rows = 0;
        cols = 0;
    }

    public static void enqueue(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O'){  
            queue.offer(x * cols + y);
        }
    }
}
