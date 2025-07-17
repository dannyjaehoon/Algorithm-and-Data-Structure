package graphs;

import java.util.*;

public class KnightMinimumMoves {

    public static record Coordinate (int x, int y) {};
    public static List<Coordinate> move(Coordinate coord) {
        List<Coordinate> moves = new ArrayList<>();

        int[] rows = {-2,-2,-1,1,2,2,1,-1};
        int[] cols = {-1,1,2,2,1,-1,-2,-2};

        for(int i = 0; i < 8; i++) {
            moves.add(new Coordinate(coord.x + rows[i], coord.y + cols[i]));
        }
        return moves;
    }

    public static int getKnightShortestPath(int x, int y) {
        HashSet<Coordinate> visited = new HashSet<>();
        visited.add(new Coordinate(0, 0));
        int steps = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Coordinate current = queue.poll();
                if(current.x == x && current.y == y) return steps;

                for(Coordinate coord : move(current)) {
                    if(visited.contains(coord)) continue;
                    queue.add(coord);
                    visited.add(coord);
                }
            }
            steps++;
        }
        return 0;
    }
}
