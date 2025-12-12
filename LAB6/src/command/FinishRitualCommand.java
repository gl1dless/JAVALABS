
package command;

public class FinishRitualCommand implements Command {

    private final RitualContext context;

    public FinishRitualCommand(RitualContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.finish();
    }
}