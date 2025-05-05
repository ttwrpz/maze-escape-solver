import java.util.Scanner;

public class MazeSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        if (rows < 3 || cols < 3) {
            System.out.println("The minimum size of the maze is 3x3!");
            return;
        }

        int playerCount = 0;
        int[] startPos = {-1, -1};
        char[][] maze = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = scanner.next().charAt(0);
                maze[i][j] = c;

                if (Character.toUpperCase(c) == 'P') {
                    if (playerCount > 1) {
                        continue;
                    }

                    startPos[0] = i;
                    startPos[1] = j;
                    playerCount++;
                }
            }
        }

        if (startPos[0] == -1) {
            System.out.println("No player in the maze!");
            return;
        }

        if (playerCount > 1) {
            System.out.println("There is more than 1 player in the maze!");
            return;
        }

        int minMoves = Maze.solveEscapeMaze(maze, startPos);

        if (minMoves == -1) {
            System.out.println("No escape path found from the maze!");
        } else {
            System.out.println("Minimum moves needed to escape: " + minMoves);
        }
    }
}