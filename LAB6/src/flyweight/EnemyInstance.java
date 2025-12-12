
package flyweight;

public class EnemyInstance {

    private final EnemyType type;
    private int x;
    private int y;

    public EnemyInstance(EnemyType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public void render() {
        type.render(x, y);
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}