package gear;


public class BasicWeapon implements Weapon {
    private final String name;
    private final int ergonomics;
    private final int recoil;

    public BasicWeapon(String name, int ergonomics, int recoil) {
        this.name = name;
        this.ergonomics = ergonomics;
        this.recoil = recoil;
    }

    @Override public String getName() { return name; }
    @Override public int getErgonomics() { return ergonomics; }
    @Override public int getRecoil() { return recoil; }
}
