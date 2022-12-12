package AoC2022.Day12;

import java.util.HashSet;
import java.util.Set;

public class Step {

    private final Tile tile;
    private final Set<Tile> visited;

    public Step(Tile tile) {
        this.tile = tile;
        this.visited = new HashSet<>();
    }

    public Step(Tile tile, Step other) {
        tile.visitTile();
        this.tile = tile;
        this.visited = new HashSet<>(other.visited);
        this.visited.add(other.getTile());
    }

    public Tile getTile() {
        return tile;
    }

    public int getNumberOfVisited() {
        return visited.size();
    }

    public boolean canMoveOnTile(Tile newTile) {
        return newTile.canMoveTileUp(tile) && !visited.contains(tile);
    }

    public boolean canMoveOnTileBackwards(Tile newTile) {
        return newTile.canMoveTileDown(tile) && !visited.contains(tile);
    }
}
