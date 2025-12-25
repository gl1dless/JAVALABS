package menu;
import factory.*;
import gear.GearItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuHelper {

    public static GearType chooseTypeForSlot(Scanner sc, GearSlot slot, String title) {
        List<GearType> options = typesBySlot(slot);

        System.out.println("\n" + title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }

        int c = readBounded(sc, 1, options.size());
        return options.get(c - 1);
    }

    public static GearItem chooseItemForSlot(Scanner sc, GearSlot slot, String title) {
        GearType type = chooseTypeForSlot(sc, slot, title);
        return GearFactory.create(type);
    }

    private static List<GearType> typesBySlot(GearSlot slot) {
        List<GearType> list = new ArrayList<>();
        for (GearType t : GearType.values()) {
            if (t.slot() == slot) list.add(t);
        }
        return list;
    }

    private static int readBounded(Scanner sc, int min, int max) {
        while (true) {
            System.out.print("Введите " + min + "-" + max + ": ");
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= min && v <= max) return v;
            } catch (NumberFormatException ignored) {}
            System.out.println("Некорректный ввод.");
        }
    }
}
