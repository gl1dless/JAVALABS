package gear;

public class Headset implements GearItem {
    private final String name;
    public Headset(String name) { this.name = name; }
    @Override public String getName() { return name; }
}