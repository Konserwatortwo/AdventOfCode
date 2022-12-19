package AoC2022.Day19;

import AoC2022.AdventTask;

import java.util.List;
import java.util.stream.Collectors;

public class Task19A extends AdventTask {

    public Task19A() {
        super("Day19", "Task19A");
    }

    @Override
    public List<String> perform(List<String> input) {
        List<Blueprint> blueprints = input.stream()
                .map(Blueprint::new)
                .collect(Collectors.toList());

        int sum = 0;
        for (Blueprint blueprint : blueprints) {
            Factory factoryForBlueprint = new Factory(blueprint, 24);
            factoryForBlueprint.run();
            sum += factoryForBlueprint.retrieveBestPlanValue() * blueprint.getId();
        }
        return List.of(sum + "");
    }
}
