package gear;

public class ArmoredRig implements GearItem {
    private final String name;
    private final int armorClass;
    private final int slots;

    public ArmoredRig(String name, int armorClass, int slots) {
        this.name = name;
        this.armorClass = armorClass;
        this.slots = slots;
    }

    @Override public String getName() {
        return name + " (ArmoredRig Class " + armorClass + ", Slots " + slots + ")";
    }

    public int getArmorClass() { return armorClass; }
    public int getSlots() { return slots; }
}