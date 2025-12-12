
package command;

public class StartRitualCommand implements Command {

    private final RitualContext context;

    public StartRitualCommand(RitualContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.start();
    }
}