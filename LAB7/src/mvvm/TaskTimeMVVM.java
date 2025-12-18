package mvvm;

import java.util.ArrayList;
import java.util.List;

public class TaskTimeMVVM {

    //model begin
    public static class Task {
        String title;
        int duration;   // план (мин)
        int spent;      // факт (мин)

        public Task(String title, int duration) {
            this.title = title;
            this.duration = duration;
            this.spent = 0;
        }
    }

    //view  model begin
    public static class TaskViewModel {
        private final Task task;

        public TaskViewModel(Task task) {
            this.task = task;
        }

        public String getTitle() { return task.title; }
        public int getDuration() { return task.duration; }
        public int getSpent() { return task.spent; }

        public int getProgress() {
            return (int)Math.round(task.spent * 100.0 / task.duration);
        }

        public boolean isDone() {
            return task.spent >= task.duration;
        }

        // действие через VM
        public void spend(int minutes) {
            task.spent += minutes;
            if (task.spent > task.duration) task.spent = task.duration;
        }
    }

    public static class TaskListViewModel {
        private final List<TaskViewModel> tasks = new ArrayList<>();

        public List<TaskViewModel> getTasks() {
            return tasks;
        }

        public TaskViewModel addTask(String title, int duration) {
            TaskViewModel vm = new TaskViewModel(new Task(title, duration));
            tasks.add(vm);
            return vm;
        }
    }

    //view begin
    public static class ConsoleView {
        public void render(TaskListViewModel listVm) {
            System.out.println("\nTASKS:");
            int i = 1;
            for (TaskViewModel t : listVm.getTasks()) {
                System.out.println(
                        i + ") " +
                                t.getTitle() +
                                " spent=" + t.getSpent() +
                                " of " + t.getDuration() +
                                (t.isDone() ? " DONE" : "")
                );
                i++;
            }
        }
    }
}
