package gear;

public class Armor implements GearItem {
    private final String name;
    private final int armorClass;

    public Armor(String name, int armorClass) {
        this.name = name;
        this.armorClass = armorClass;
    }

    @Override public String getName() { return name + " (Class " + armorClass + ")"; }
    public int getArmorClass() { return armorClass; }
}
