package gear;


public class Backpack implements GearItem {
    private final String name;
    private final int capacity;

    public Backpack(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override public String getName() { return name + " (Cap " + capacity + ")"; }
    public int getCapacity() { return capacity; }
}
