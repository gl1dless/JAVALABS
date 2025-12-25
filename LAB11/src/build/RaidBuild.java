package build;

import gear.*;


public class RaidBuild {
    private Weapon weapon;
    private Helmet helmet;
    private Armor armor;
    private Rig rig;
    private ArmoredRig armoredRig;
    private Headset headset;
    private FaceCover faceCover;
    private Backpack backpack;

    public Weapon getWeapon() { return weapon; }
    public Helmet getHelmet() { return helmet; }
    public Armor getArmor() { return armor; }
    public Rig getRig() { return rig; }
    public ArmoredRig getArmoredRig() { return armoredRig; }
    public Headset getHeadset() { return headset; }
    public FaceCover getFaceCover() { return faceCover; }
    public Backpack getBackpack() { return backpack; }

    public void setWeapon(Weapon weapon) { this.weapon = weapon; }
    public void setHelmet(Helmet helmet) { this.helmet = helmet; }
    public void setArmor(Armor armor) { this.armor = armor; }
    public void setRig(Rig rig) { this.rig = rig; }
    public void setArmoredRig(ArmoredRig armoredRig) { this.armoredRig = armoredRig; }
    public void setHeadset(Headset headset) { this.headset = headset; }
    public void setFaceCover(FaceCover faceCover) { this.faceCover = faceCover; }
    public void setBackpack(Backpack backpack) { this.backpack = backpack; }

    @Override
    public String toString() {
        return "RaidBuild: " +
                "weapon=" + (weapon == null ? "none" : weapon.getName()) +
                ", helmet=" + (helmet == null ? "none" : helmet.getName()) +
                ", armor=" + (armor == null ? "none" : armor.getName()) +
                ", rig=" + (rig == null ? "none" : rig.getName()) +
                ", armoredRig=" + (armoredRig == null ? "none" : armoredRig.getName()) +
                ", headset=" + (headset == null ? "none" : headset.getName()) +
                ", faceCover=" + (faceCover == null ? "none" : faceCover.getName()) +
                ", backpack=" + (backpack == null ? "none" : backpack.getName());
    }

    public static class Builder {
        private final RaidBuild b = new RaidBuild();

        public Builder weapon(Weapon w) { b.setWeapon(w); return this; }
        public Builder helmet(Helmet h) { b.setHelmet(h); return this; }
        public Builder armor(Armor a) { b.setArmor(a); return this; }
        public Builder rig(Rig r) { b.setRig(r); return this; }
        public Builder armoredRig(ArmoredRig ar) { b.setArmoredRig(ar); return this; }
        public Builder headset(Headset hs) { b.setHeadset(hs); return this; }
        public Builder faceCover(FaceCover fc) { b.setFaceCover(fc); return this; }
        public Builder backpack(Backpack bp) { b.setBackpack(bp); return this; }


        public RaidBuild buildUnsafe() {
            return b;
        }
    }
}