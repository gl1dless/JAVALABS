package command;

import build.RaidBuild;

public class ResetBuildCommand implements Command {
    private final RaidBuild build;

    public ResetBuildCommand(RaidBuild build) {
        this.build = build;
    }

    @Override
    public void execute() {
        build.setWeapon(null);
        build.setHelmet(null);
        build.setArmor(null);
        build.setRig(null);
        build.setArmoredRig(null);
        build.setHeadset(null);
        build.setFaceCover(null);
        build.setBackpack(null);
    }

    @Override
    public String description() {
        return "Сброс";
    }
}
