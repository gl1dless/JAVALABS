
package command;

public class SummonMonsterCommand implements Command {

    private final RitualContext context;

    public SummonMonsterCommand(RitualContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.summonMonster();
    }
}