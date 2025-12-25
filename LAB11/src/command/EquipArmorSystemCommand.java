package command;

import build.RaidBuild;
import gear.Armor;
import gear.ArmoredRig;
import gear.Rig;

public class EquipArmorSystemCommand implements Command {
    private final RaidBuild build;
    private final Armor armor;
    private final Rig rig;
    private final ArmoredRig armoredRig;
    private final String desc;

    // armor + rig
    public static EquipArmorSystemCommand armorAndRig(RaidBuild build, Armor armor, Rig rig) {
        return new EquipArmorSystemCommand(build, armor, rig, null, "Выбраны броня + разгрузка");
    }

    // armored rig
    public static EquipArmorSystemCommand armoredRig(RaidBuild build, ArmoredRig armoredRig) {
        return new EquipArmorSystemCommand(build, null, null, armoredRig, "Выбрана бронеразгрузка");
    }

    private EquipArmorSystemCommand(RaidBuild build, Armor armor, Rig rig, ArmoredRig armoredRig, String desc) {
        this.build = build;
        this.armor = armor;
        this.rig = rig;
        this.armoredRig = armoredRig;
        this.desc = desc;
    }

    @Override
    public void execute() {
        if (armoredRig != null) {
            build.setArmor(null);
            build.setRig(null);
            build.setArmoredRig(armoredRig);
        } else {
            build.setArmoredRig(null);
            build.setArmor(armor);
            build.setRig(rig);
        }
    }

    @Override
    public String description() {
        return desc;
    }
}
