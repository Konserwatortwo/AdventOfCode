package AoC2022.Day21;

public class Monkey {
    private final String name;
    private final boolean isHumanDependant;
    private Long result;

    protected Monkey(String name, boolean isHumanDependant) {
        this.name = name;
        this.isHumanDependant = isHumanDependant;
    }

    public Monkey(String name, Long result) {
        this.name = name;
        this.isHumanDependant = false;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public boolean isHumanDependant() {
        return isHumanDependant;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public boolean shouldCalculateResult() {
        return null == result || isHumanDependant();
    }
}
