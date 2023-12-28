package solutions;

import java.util.*;

public class Problem200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    explore(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    private void explore(char[][] grid, int i, int j) {
        Queue<Coordinate> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Coordinate(i, j));

        while (!bfsQueue.isEmpty()) {
            Coordinate coordinate = bfsQueue.poll();
            if (coordinate.i >= 0
                && coordinate.i < grid.length
                && coordinate.j >= 0
                && coordinate.j < grid[0].length
                && grid[coordinate.i][coordinate.j] == '1') {
                grid[coordinate.i][coordinate.j] = 'x';
                bfsQueue.add(new Coordinate(coordinate.i - 1, coordinate.j));
                bfsQueue.add(new Coordinate(coordinate.i + 1, coordinate.j));
                bfsQueue.add(new Coordinate(coordinate.i, coordinate.j + 1));
                bfsQueue.add(new Coordinate(coordinate.i, coordinate.j - 1));
            }
        }
    }

    private static class Coordinate {
        int i;
        int j;

        Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
