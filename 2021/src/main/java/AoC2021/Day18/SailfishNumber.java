package AoC2021.Day18;

import java.math.BigInteger;

import static AoC2021.Day18.SailfishNumberUtils.*;

public class SailfishNumber {

    enum Position {
        NONE, LEFT, RIGHT
    }

    private SailfishNumber parent;
    private Position position;
    private int depth;

    private SailfishNumber leftSailfishNumber;
    private SailfishNumber rightSailfishNumber;
    private Integer leftValue;
    private Integer rightValue;

    public SailfishNumber(SailfishNumber parent, Position position) {
        this.depth = null == parent ? 0 : parent.getDepth() + 1;
        this.parent = parent;
        this.position = position;
    }

    public SailfishNumber(SailfishNumber parent, Position position, Integer leftValue, Integer rightValue) {
        this(parent, position);
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public SailfishNumber(SailfishNumber leftSailfishNumber, SailfishNumber rightSailfishNumber) {
        this(null, Position.NONE);
        setSailfishNumberOnPosition(leftSailfishNumber, Position.LEFT);
        setSailfishNumberOnPosition(rightSailfishNumber, Position.RIGHT);
    }

    public SailfishNumber(SailfishNumber parent, Position position, String inputLine) {
        this(parent, position);

        String[] elements = splitSailfishNumberToElements(inputLine);
        if (elements[0].startsWith("[")) {
            this.leftSailfishNumber = new SailfishNumber(this, Position.LEFT, elements[0]);
        } else {
            this.leftValue = Integer.valueOf(elements[0]);
        }
        if (elements[1].startsWith("[")) {
            this.rightSailfishNumber = new SailfishNumber(this, Position.RIGHT, elements[1]);
        } else {
            this.rightValue = Integer.valueOf(elements[1]);
        }
    }

    public SailfishNumber(String inputLine) {
        this(null, Position.NONE, inputLine);
    }

    public SailfishNumber getParent() {
        return parent;
    }

    public void setParent(SailfishNumber parent) {
        this.parent = parent;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depthToAssign) {
        this.depth = depthToAssign + 1;
        if (null != leftSailfishNumber) {
            leftSailfishNumber.setDepth(depth);
        }
        if (null != rightSailfishNumber) {
            rightSailfishNumber.setDepth(depth);
        }
    }

    public void setSailfishNumberOnPosition(SailfishNumber sailfishNumber, Position position) {
        if (position == Position.LEFT) {
            this.leftValue = null;
            this.leftSailfishNumber = sailfishNumber;
        } else {
            this.rightValue = null;
            this.rightSailfishNumber = sailfishNumber;
        }

        sailfishNumber.setParent(this);
        sailfishNumber.setDepth(getDepth());
        sailfishNumber.setPosition(position);
    }

    public SailfishNumber getSailfishNumberFromPosition(Position position) {
        return switch (position) {
            case NONE -> throw new IllegalStateException();
            case LEFT -> this.leftSailfishNumber;
            case RIGHT -> this.rightSailfishNumber;
        };
    }

    public void setValueOnPosition(Integer value, Position position) {
        if (position == Position.LEFT) {
            this.leftSailfishNumber = null;
            this.leftValue = value;
        } else {
            this.rightSailfishNumber = null;
            this.rightValue = value;
        }
    }

    public Integer getValueFromPosition(Position position) {
        return switch (position) {
            case NONE -> throw new IllegalStateException();
            case LEFT -> this.leftValue;
            case RIGHT -> this.rightValue;
        };
    }

    public void addValueOnPosition(Integer value, Position position) {
        if (position == Position.LEFT) {
            this.leftValue += value;
        } else {
            this.rightValue += value;
        }
    }

    public boolean isPosition(Position position) {
        return this.position == position;
    }

    public boolean isValueOnPosition(Position position) {
        return position == Position.LEFT && null != leftValue || position == Position.RIGHT && null != rightValue;
    }

    @Override
    public String toString() {
        String leftElement = null == leftSailfishNumber ? leftValue + "" : leftSailfishNumber.toString();
        String rightElement = null == rightSailfishNumber ? rightValue + "" : rightSailfishNumber.toString();
        return "[" + leftElement + "," + rightElement + "]";
    }

    public void reduce() {
        boolean performedInStep = true;
        while (performedInStep) {
            performedInStep = explode();
            if (!performedInStep) {
                performedInStep = split();
            }
        }
    }

    private boolean explode() {
        boolean explosionPerformed = false;
        if (isLeftValue() && isRightValue() && depth > 3) {
            performExplosion(this);
            explosionPerformed = true;
        } else {
            if (!isValueOnPosition(Position.LEFT)) {
                explosionPerformed = leftSailfishNumber.explode();
            }
            if (!explosionPerformed && !isValueOnPosition(Position.RIGHT)) {
                explosionPerformed = rightSailfishNumber.explode();
            }
        }
        return explosionPerformed;
    }

    private boolean split() {
        boolean splitPerformed = false;
        if (isLeftValue()) {
            if (leftValue > 9) {
                performSplit(this, Position.LEFT);
                splitPerformed = true;
            }
        } else {
            splitPerformed = leftSailfishNumber.split();
        }

        if (!splitPerformed) {
            if (isRightValue()) {
                if (rightValue > 9) {
                    performSplit(this, Position.RIGHT);
                    splitPerformed = true;
                }
            } else {
                splitPerformed = rightSailfishNumber.split();
            }
        }
        return splitPerformed;
    }

    private boolean isLeftValue() {
        return null != leftValue;
    }

    private boolean isRightValue() {
        return null != rightValue;
    }

    public BigInteger getMagnitude() {
        BigInteger left = isLeftValue() ? BigInteger.valueOf(leftValue) : leftSailfishNumber.getMagnitude();
        BigInteger right = isRightValue() ? BigInteger.valueOf(rightValue) : rightSailfishNumber.getMagnitude();
        left = left.multiply(BigInteger.valueOf(3));
        right = right.multiply(BigInteger.valueOf(2));
        return left.add(right);
    }
}
