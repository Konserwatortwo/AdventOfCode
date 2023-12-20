package AoC2023.Day20;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class CommunicationCenter {

    Map<String, Module> modules;

    public static CommunicationCenter of(List<String> inputLines) {
        Map<String, Module> modules = inputLines.stream()
                .map(line -> switch (line.charAt(0)) {
                    case '%' -> new FlipFlopModule(line);
                    case '&' -> new ConjunctionModule(line);
                    default -> new Module(line);
                })
                .collect(Collectors.toMap(Module::getName, x -> x));
        for (Module module : modules.values()) {
            if (module instanceof ConjunctionModule) {
                ((ConjunctionModule) module).addInputModules(modules.values().stream()
                        .filter(inputModule -> inputModule.getOutputs().contains(module.getName()))
                        .map(Module::getName)
                        .collect(Collectors.toList())
                );
            }
        }
        return new CommunicationCenter(modules);
    }

    public long count1000Signals() {
        long countHighSignals = 0;
        long countLowSignals = 0;
        for (int i = 0; i < 1000; i++) {
            List<Signal> signalsToPrecede = new ArrayList<>();
            signalsToPrecede.add(Signal.of(false, null, "broadcaster"));
            while (!signalsToPrecede.isEmpty()) {
                long currentHighSignals = signalsToPrecede.stream()
                        .filter(Signal::isHigh)
                        .count();
                countHighSignals += currentHighSignals;
                countLowSignals += signalsToPrecede.size() - currentHighSignals;
                signalsToPrecede = processSignals(signalsToPrecede);
            }
        }
        return countHighSignals * countLowSignals;
    }

    private List<Signal> processSignals(List<Signal> signalsToPrecede) {
        return signalsToPrecede.stream()
                .map(signal -> Optional.ofNullable(modules.get(signal.getTo()))
                        .map(module -> module.receiveSignal(signal))
                        .orElse(List.of())
                )
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public long countSignalsToRX() {
        List<ConjunctionModule> cycleModules = modules.values().stream()
                .filter(module -> module instanceof ConjunctionModule)
                .map(module -> (ConjunctionModule) module)
                .filter(module -> module.lastSignalFromInput.keySet().stream()
                        .anyMatch(input -> modules.get(input) instanceof FlipFlopModule))
                .collect(Collectors.toList());
        int index = 0;
        Map<String, Long> cycleLengths = new HashMap<>();
        while (index++ < Integer.MAX_VALUE && !cycleModules.stream().allMatch(x -> cycleLengths.containsKey(x.getName()))) {
            List<Signal> signalsToPrecede = new ArrayList<>();
            signalsToPrecede.add(Signal.of(false, null, "broadcaster"));
            while (!signalsToPrecede.isEmpty()) {
                long buttonPressed = index;
                cycleModules.stream()
                        .filter(ConjunctionModule::isFull)
                        .filter(cycle -> !cycleLengths.containsKey(cycle.getName()))
                        .forEach(cycle -> cycleLengths.put(cycle.getName(), buttonPressed));
                signalsToPrecede = processSignals(signalsToPrecede);
            }
        }
        return leastCommonMultiple(new ArrayList<>(cycleLengths.values()));
    }

    private static long leastCommonMultiple(List<Long> values) {
        long currentResult = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            currentResult = leastCommonMultiple(currentResult, values.get(i));
        }
        return currentResult;
    }

    private static long leastCommonMultiple(long first, long second) {
        if (first == 0 || second == 0) {
            return 0;
        }
        long absNumber1 = Math.abs(first);
        long absNumber2 = Math.abs(second);
        long absHigherNumber = Math.max(absNumber1, absNumber2);
        long absLowerNumber = Math.min(absNumber1, absNumber2);
        long lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }
}
