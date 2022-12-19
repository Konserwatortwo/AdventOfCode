package AoC2022.Day19;

import AoC2022.AdventTask;

import java.util.List;
import java.util.stream.Collectors;

public class Task19B extends AdventTask {

    public Task19B() {
        super("Day19", "Task19B");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Blueprint> blueprints = input.stream()
                .map(Blueprint::new)
                .collect(Collectors.toList());

        int multiply = 1;
        for (Blueprint blueprint : blueprints) {
            Factory factoryForBlueprint = new Factory(blueprint, 32);
            factoryForBlueprint.run();
            multiply *= factoryForBlueprint.retrieveBestPlanValue();
        }
        return List.of(multiply + "");
    }
}
