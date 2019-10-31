package hw10;

public enum Species {
    DOG(4, true, false),
    DOMESTIC_CAT(4, true,false),
    ROBO_CAT(4, false, false),
    FISH(0, false, false),
    UNKNOWN(0, false, false);

    private int numberOfLegs;
    private boolean hasFur;
    private boolean canFly;

    Species(int numberOfLegs, boolean hasFur, boolean canFly) {
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
        this.canFly = canFly;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public boolean isCanFly() {
        return canFly;
    }
}
