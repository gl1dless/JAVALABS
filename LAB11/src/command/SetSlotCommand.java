package command;

import java.util.function.Consumer;

public class SetSlotCommand<T> implements Command {
    private final Consumer<T> setter;
    private final T newValue;
    private final String desc;

    public SetSlotCommand(String desc, Consumer<T> setter, T newValue) {
        this.desc = desc;
        this.setter = setter;
        this.newValue = newValue;
    }

    @Override
    public void execute() {
        setter.accept(newValue);
    }

    @Override
    public String description() {
        return desc;
    }
}
