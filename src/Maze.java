public class Maze {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int solveEscapeMaze(char[][] maze, int[] startPos) {
        int rows = maze.length;
        int cols = maze[0].length;

        int startRow = startPos[0], startCol = startPos[1];

        // Create a visited array to keep track of visited cells
        boolean[][] visited = new boolean[rows][cols];

        // Use BFS to find the shortest path to any border
        CellQueue queue = new CellQueue();
        queue.enqueue(new Cell(startRow, startCol, 0));
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Cell current = queue.dequeue();

            // Check if current cell is at the border
            if (current.getRow() == 0 || current.getRow() == rows - 1 ||
                    current.getCol() == 0 || current.getCol() == cols - 1) {
                if (maze[current.getRow()][current.getCol()] == '1') {
                    return current.getDistance();
                }
            }

            // Try all four directions
            for (int[] dir : DIRECTIONS) {
                int newRow = current.getRow() + dir[0];
                int newCol = current.getCol() + dir[1];

                // Check if new position is valid and not visited
                if (isValid(newRow, newCol, rows, cols) &&
                        !visited[newRow][newCol] &&
                        (maze[newRow][newCol] == '1' || maze[newRow][newCol] == 'P')) {

                    queue.enqueue(new Cell(newRow, newCol, current.getDistance() + 1));
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
