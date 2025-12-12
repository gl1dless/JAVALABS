
package flyweight;

import java.util.HashMap;
import java.util.Map;

public class EnemyFactoryFlyweight {

    private static final Map<String, EnemyType> types = new HashMap<>();

    public static EnemyType getEnemyType(String typeName) {
        EnemyType type = types.get(typeName);

        if (type == null) {
            switch (typeName.toLowerCase()) {
                case "zombie":
                    type = new EnemyType("Zombie", 100, "zombie_model");
                    break;
                case "skeleton":
                    type = new EnemyType("Skeleton", 80, "skeleton_model");
                    break;
                default:
                    type = new EnemyType(typeName, 50, "default_model");
            }
            types.put(typeName, type);
            System.out.println("Created new EnemyType: " + typeName);
        }
        return type;
    }
}