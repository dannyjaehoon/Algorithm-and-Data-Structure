package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {
    public static class Coord {
        public int row;
        public int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Coord add(Coord coord) {
            return new Coord(row + coord.row, col + coord.col);
        }
    }

    public static List<Coord> directions = List.of(new Coord(0, 1), new Coord(1, 0), new Coord(0, -1), new Coord(-1, 0));

    public static List<List<Integer>> mapGetDistances(List<List<Integer>> dungeonMap) {
        Queue<Coord> queue = new LinkedList<>();
        int n = dungeonMap.size();
        int m = dungeonMap.get(0).size();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dungeonMap.get(i).get(j) == 0) {
                    queue.add(new Coord(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Coord coord = queue.poll();
            for(Coord coordDirection : directions) {
                Coord newPos = coord.add(coordDirection);
                if(newPos.row >= 0 && newPos.row < n && newPos.col >= 0 && newPos.col < m) {
                    if(dungeonMap.get(newPos.row).get(newPos.col) == Integer.MAX_VALUE) {
                        dungeonMap.get(newPos.row).set(newPos.col, 1 + dungeonMap.get(coord.row).get(coord.col));
                        queue.offer(newPos);
                    }
                }
            }
        }
        return dungeonMap;
    }
}
