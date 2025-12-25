package gear;

public class Rig implements GearItem {
    private final String name;
    private final int slots;

    public Rig(String name, int slots) {
        this.name = name;
        this.slots = slots;
    }

    @Override public String getName() { return name + " (Slots " + slots + ")"; }
    public int getSlots() { return slots; }
}
