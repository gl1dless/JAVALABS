
package flyweight;

public class EnemyType {
    private final String typeName;
    private final int baseHealth;
    private final String model;

    public EnemyType(String typeName, int baseHealth, String model) {
        this.typeName = typeName;
        this.baseHealth = baseHealth;
        this.model = model;
    }

    public void render(int x, int y) {
        System.out.println("Rendering " + typeName +
                " (model=" + model + ", health=" + baseHealth + ")" +
                " at position (" + x + ", " + y + ")");
    }
}