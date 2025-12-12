
package command;

import java.util.LinkedList;
import java.util.Queue;

public class RitualExecutor {

    private Queue<Command> queue = new LinkedList<>();

    public void addCommand(Command command) {
        queue.offer(command);
    }

    public void executeAll() {
        while (!queue.isEmpty()) {
            Command c = queue.poll();
            c.execute();
        }
    }
}
