package menu;
import factory.*;
import gear.GearItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuHelper {

    public static GearItem chooseItemForSlot(Scanner sc, GearSlot slot, String title) {

        // 1) Собрали список всех GearType, которые относятся к этому слоту
        List<GearType> options = new ArrayList<>();
        for (GearType t : GearType.values()) {
            if (t.slot() == slot) {
                options.add(t);
            }
        }

        System.out.println("\n" + title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }

        int choice;
        while (true) {
            System.out.print("Выбор (1-" + options.size() + "): ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= 1 && choice <= options.size()) {
                    break;
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Некорректный ввод.");
        }

        // 4) Создали предмет через фабрику и вернули
        GearType selectedType = options.get(choice - 1);
        return GearFactory.create(selectedType);
    }
}
