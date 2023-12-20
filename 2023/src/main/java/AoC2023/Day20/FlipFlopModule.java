package AoC2023.Day20;

import java.util.List;

class FlipFlopModule extends Module {

    boolean isOn;

    public FlipFlopModule(String inputLine) {
        super(inputLine);
        this.isOn = false;
    }

    @Override
    public List<Signal> receiveSignal(Signal signal) {
        if (signal.isHigh()) {
            return List.of();
        }
        isOn = !isOn;
        return proceedThroughOutput(isOn);
    }
}
