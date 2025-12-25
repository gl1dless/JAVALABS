package gear;


public class FaceCover implements GearItem {
    private final String name;
    public FaceCover(String name) { this.name = name; }
    @Override public String getName() { return name; }
}
