package AoC2022.Day12;

import AoC2022.AdventTask;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task12B extends AdventTask {

    private final Map<String, List<String>> neighborhoods;

    public Task12B() {
        super("Day12", "Task12B");
        neighborhoods = new HashMap<>();
    }

    @Override
    public List<String> perform(List<String> input) {
        for (String line : input) {
            String[] elements = line.split("-");
            neighborhoods.computeIfAbsent(elements[0], k -> new ArrayList<>()).add(elements[1]);
            neighborhoods.computeIfAbsent(elements[1], k -> new ArrayList<>()).add(elements[0]);
        }

        List<String> paths = discoverNeighborhoods("start", "", false);

        return List.of(paths.size() + "");
    }

    private List<String> discoverNeighborhoods(String node, String prefix, boolean isSmallVisitedTwice) {
        if (node.equals("end")) {
            return List.of(prefix + "end");
        }
        if (prefix.contains(node) && StringUtils.isAllLowerCase(node)) {
            if(isSmallVisitedTwice || node.equals("start")) {
                return new ArrayList<>();
            } else {
                isSmallVisitedTwice = true;
            }
        }
        List<String> paths = new ArrayList<>();
        prefix += node + ",";
        for (String neighborhood : neighborhoods.get(node)) {
            paths.addAll(discoverNeighborhoods(neighborhood, prefix, isSmallVisitedTwice));
        }
        return paths;
    }
}
