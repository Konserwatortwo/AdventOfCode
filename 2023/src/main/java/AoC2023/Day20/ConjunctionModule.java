package AoC2023.Day20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ConjunctionModule extends Module {

    Map<String, Boolean> lastSignalFromInput;

    public ConjunctionModule(String inputLine) {
        super(inputLine);
        this.lastSignalFromInput = new HashMap<>();
    }

    public void addInputModules(List<String> inputModules) {
        inputModules.forEach(module -> lastSignalFromInput.put(module, false));
    }

    @Override
    public List<Signal> receiveSignal(Signal signal) {
        lastSignalFromInput.put(signal.getFrom(), signal.isHigh());
        return proceedThroughOutput(!isFull());
    }

    public boolean isFull() {
        return lastSignalFromInput.values().stream().allMatch(x -> x);
    }
}
