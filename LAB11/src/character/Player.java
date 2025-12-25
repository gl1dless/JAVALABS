package character;

import build.RaidBuild;

public class Player {
    private static volatile Player instance;

    private String nickname;
    private int level;
    private final RaidBuild build = new RaidBuild();

    private Player() {}

    public static Player getInstance() {
        if (instance == null) {
            synchronized (Player.class) {
                if (instance == null) instance = new Player();
            }
        }
        return instance;
    }

    public String getNickname() { return nickname; }
    public int getLevel() { return level; }
    public RaidBuild getBuild() { return build; }

    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setLevel(int level) { this.level = level; }

    public String shortInfo() {
        return "Player{nickname='" + nickname + "', level=" + level + "}";
    }
}
