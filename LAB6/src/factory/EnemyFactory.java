
package factory;

public class EnemyFactory {

    public Enemy createEnemy(String type) {
        if ("zombie".equalsIgnoreCase(type)) {
            return new Zombie();
        } else if ("skeleton".equalsIgnoreCase(type)) {
            return new Skeleton();
        }
        throw new IllegalArgumentException("Unknown enemy type: " + type);
    }
}
