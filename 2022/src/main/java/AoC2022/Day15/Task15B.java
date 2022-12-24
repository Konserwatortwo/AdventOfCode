package AoC2022.Day15;

import AoC2022.AdventTask;
import AoC2022.common.Position;

import java.util.List;

public class Task15B extends AdventTask {

    public Task15B() {
        super("Day15", "Task15B");
    }

    @Override
    public List<String> perform(List<String> input) {
        return perform(input, 4000000);
    }

    public List<String> perform(List<String> input, int limit) {
        Device device = new Device(input);

        Position position = null;
        int level = 0;
        while (null == position && level < limit) {
            List<Range> ranges = device.retrieveRangeForLevelWithLimit(level, limit);
            if (ranges.size() == 2) {
                position = new Position(ranges.get(0).getMax() + 1, level);
                if (device.isPositionBeacon(position)) {
                    position = null;
                }
            }
            level++;
        }
        assert position != null;
        return List.of(calculateTuningFrequency(position)+"");
    }

    private long calculateTuningFrequency(Position position) {
        return position.getX() * 4000000L + position.getY();
    }
}
