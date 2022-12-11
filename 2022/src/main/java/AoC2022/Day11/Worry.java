package AoC2022.Day11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Worry {

    int value;
    Map<Integer, Integer> restFromDivision;

    public Worry(int startValue, List<Integer> possibleDivisions) {
        this.restFromDivision = new HashMap<>();
        for (Integer possibleDivision : possibleDivisions) {
            restFromDivision.put(possibleDivision, startValue % possibleDivision);
        }
        value = startValue;
    }

    public void performOperation(Function<Integer, Integer> operation) {
        value = operation.apply(value);
        for (Integer key : restFromDivision.keySet()) {
            int newValueForKey = operation.apply(restFromDivision.get(key));
            restFromDivision.put(key, newValueForKey % key);
        }
    }

    public boolean checkIfDivisible(Integer division) {
        return restFromDivision.get(division) == 0;
    }

    @Override
    public String toString() {
        return "Worry " + value;
    }
}
