package AoC2022.Day14;

public enum Content {
    ROCK("#"),
    SAND("o"),
    AIR("."),
    SOURCE_OF_SAND("+"),
    TRACE_OF_SAND("~");

    private final String sign;

    Content(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
