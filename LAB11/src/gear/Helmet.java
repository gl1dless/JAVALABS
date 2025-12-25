package gear;

public class Helmet implements GearItem {
    private final String name;
    private final int armorClass;

    public Helmet(String name, int armorClass) {
        this.name = name;
        this.armorClass = armorClass;
    }

    @Override public String getName() { return name + " (Class " + armorClass + ")"; }
    public int getArmorClass() { return armorClass; }
}