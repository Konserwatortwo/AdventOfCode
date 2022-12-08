package AoC2022.Day8;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private final int value;

    private Boolean isVisible;

    public Tree(int value) {
        this.value = value;
        this.isVisible = Boolean.FALSE;
    }

    public void setAsVisible() {
        isVisible = Boolean.TRUE;
    }

    public Boolean isVisible() {
        return isVisible;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "value=" + value +
                ", isVisible=" + isVisible +
                '}';
    }
}
