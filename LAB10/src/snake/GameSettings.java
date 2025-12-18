package snake;

public class GameSettings {

    private static GameSettings instance;

    public final int cellSize = 20;
    public final int fieldWidth = 20;
    public final int fieldHeight = 20;
    public final int delay = 200;

    private GameSettings() {}

    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }
}
