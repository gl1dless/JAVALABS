package mvc;

import java.util.*;

public class WeaponStoreMVC {

    //model begin
    public static class Weapon {
        private final String name;
        private final int damage;

        public Weapon(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public String getName() { return name; }
        public int getDamage() { return damage; }

        @Override
        public String toString() {
            return name + " (damage=" + damage + ")";
        }
    }

    public static class WeaponStoreModel {
        private final List<Weapon> weapons = new ArrayList<>();

        public List<Weapon> getWeapons() {
            return Collections.unmodifiableList(weapons);
        }

        public void addWeapon(Weapon w) {
            weapons.add(w);
        }

        public boolean removeWeapon(String name) {
            return weapons.removeIf(w -> w.getName().equalsIgnoreCase(name));
        }
    }

    //view begin
    public static class WeaponStoreView {
        public void render(List<Weapon> weapons) {
            System.out.println("\nWEAPONS IN STOCK");
            if (weapons.isEmpty()) {
                System.out.println("(empty)");
                return;
            }
            for (Weapon w : weapons) {
                System.out.println("- " + w);
            }
        }
    }

    //contrroller begin
    public static class WeaponStoreController {
        private final WeaponStoreModel model;
        private final WeaponStoreView view;

        public WeaponStoreController(WeaponStoreModel model, WeaponStoreView view) {
            this.model = model;
            this.view = view;
        }

        public void add(String name, int damage) {
            model.addWeapon(new Weapon(name, damage));
            update();
        }

        public void remove(String name) {
            model.removeWeapon(name);
            update();
        }

        public void update() {
            view.render(model.getWeapons());
        }
    }
}