package AoC2022.Day19;

import java.util.HashMap;
import java.util.Map;

public class Cost {
    private final Map<Type, Integer> components;

    public Cost(String oreCost) {
        this.components = new HashMap<>();
        this.components.put(Type.ORE, Integer.parseInt(oreCost));
    }

    public void addComponent(Type mineralType, String mineralCost) {
        components.put(mineralType, Integer.parseInt(mineralCost));
    }

    public boolean containsComponent(Type type) {
        return components.containsKey(type);
    }

    public int getComponent(Type type) {
        return components.get(type);
    }

    public Map<Type, Integer> getComponents() {
        return components;
    }
}
