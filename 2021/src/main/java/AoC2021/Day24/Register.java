package AoC2021.Day24;

import AoC2021.Day24.enums.Symbol;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Register {

    private final Map<Symbol, Long> memory;

    public Register() {
        memory = new HashMap<>();
        for (Symbol symbol : Symbol.values()) {
            memory.put(symbol, 0L);
        }
    }

    public Register(Register otherRegister) {
        this.memory = new HashMap<>(otherRegister.memory);
    }

    public long getValueForSymbol(Symbol symbol) {
        return memory.get(symbol);
    }

    public void setValueForSymbol(Symbol symbol, long value) {
        memory.put(symbol, value);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" - ");
        for (Symbol symbol : Symbol.values()) {
            joiner.add(memory.get(symbol) + "");
        }
        return joiner.toString();
    }
}
