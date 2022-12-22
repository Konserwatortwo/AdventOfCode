package AoC2022.Day22;

import java.util.HashMap;
import java.util.Map;

public enum TileType {
    EMPTY(' '),
    FREE('.'),
    OCCUPIED('#');

    private final char sign;

    TileType(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

    private static final Map<Character, TileType> typeMapping = new HashMap<>();

    static {
        for (TileType type : TileType.values()) {
            typeMapping.put(type.getSign(), type);
        }
    }

    public static TileType determineType(char sign) {
        return typeMapping.get(sign);
    }
}
