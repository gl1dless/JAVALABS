import build.*;
import factory.*;
import gear.*;
import build.*;
import character.*;
import command.*;
import menu.MenuHelper;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Player p = Player.getInstance();
        p.setNickname("ErrorI00");
        p.setLevel(31);

        boolean run = true;
        while (run) {
            System.out.println("\nСОБИРАЙСЯ В РЕЙД С УМОМ!");
            System.out.println("1) Оружие");
            System.out.println("2) Шлем");
            System.out.println("3) Корпус (броня/разгрузка/бронеразгрузка/ничего)");
            System.out.println("4) Наушники");
            System.out.println("5) Одежда на лицо");
            System.out.println("6) Рюкзак");
            System.out.println("7) Показать билд");
            System.out.println("8) Сбросить билд");
            System.out.println("9) Завершить (без проверок)");
            System.out.print("Выбор: ");

            int c = readInt(sc);

            switch (c) {
                case 1:
                    runCommand(chooseWeapon(sc, p), p);
                    break;

                case 2:
                    runCommand(chooseHelmet(sc, p), p);
                    break;

                case 3:
                    runCommand(chooseBodySystem(sc, p), p);
                    break;

                case 4:
                    runCommand(chooseHeadset(sc, p), p);
                    break;

                case 5:
                    runCommand(chooseFaceCover(sc, p), p);
                    break;

                case 6:
                    runCommand(chooseBackpack(sc, p), p);
                    break;

                case 7:
                    System.out.println(p.getBuild());
                    break;

                case 8:
                    runCommand(new ResetBuildCommand(p.getBuild()), p);
                    break;

                case 9:
                    System.out.println("\n🏁 Финальный билд:\n" + p.getBuild());
                    run = false;
                    break;

                default:
                    System.out.println("Неизвестный пункт.");
                    break;
            }
        }
    }

    private static void runCommand(Command cmd, Player p) {
        cmd.execute();
        System.out.println("Выполнено: " + cmd.description());
    }

    private static Command chooseWeapon(Scanner sc, Player p) {
        Weapon w = (Weapon) MenuHelper.chooseItemForSlot(sc, GearSlot.WEAPON, "Оружие:");
        return new SetSlotCommand<>("Установить оружие: " + (w == null ? "Нет" : w.getName()),
                p.getBuild()::setWeapon, w);
    }

    private static Command chooseHelmet(Scanner sc, Player p) {
        Helmet h = (Helmet) MenuHelper.chooseItemForSlot(sc, GearSlot.HELMET, "Шлем:");
        return new SetSlotCommand<>("Установить шлем: " + (h == null ? "Нет" : h.getName()),
                p.getBuild()::setHelmet, h);
    }


    private static Command chooseBodySystem(Scanner sc, Player p) {
        System.out.println("\nКорпус:");
        System.out.println("1) Броня + разгрузка");
        System.out.println("2) Бронеразгрузка");
        int mode = Integer.parseInt(sc.nextLine());


        if (mode == 1) {
            Armor armor = (Armor) MenuHelper.chooseItemForSlot(sc, GearSlot.ARMOR, "Броня:");
            Rig rig = (Rig) MenuHelper.chooseItemForSlot(sc, GearSlot.RIG, "Разгрузка:");
            return EquipArmorSystemCommand.armorAndRig(p.getBuild(), armor, rig);
        } else {
            ArmoredRig ar = (ArmoredRig) MenuHelper.chooseItemForSlot(sc, GearSlot.ARMORED_RIG, "Бронеразгрузка:");
            return EquipArmorSystemCommand.armoredRig(p.getBuild(), ar);
        }
    }

    private static Command chooseHeadset(Scanner sc, Player p) {
        Headset hs = (Headset) MenuHelper.chooseItemForSlot(sc, GearSlot.HEADSET, "Наушники:");
        return new SetSlotCommand<>("Установить наушники: " + (hs == null ? "Нет" : hs.getName()),
                p.getBuild()::setHeadset, hs);
    }

    private static Command chooseFaceCover(Scanner sc, Player p) {
        FaceCover fc = (FaceCover) MenuHelper.chooseItemForSlot(sc, GearSlot.FACECOVER, "Одежда на лицо:");
        return new SetSlotCommand<>("Установить одежду на лицо: " + (fc == null ? "Нет" : fc.getName()),
                p.getBuild()::setFaceCover, fc);
    }

    private static Command chooseBackpack(Scanner sc, Player p) {
        Backpack bp = (Backpack) MenuHelper.chooseItemForSlot(sc, GearSlot.BACKPACK, "Рюкзак:");
        return new SetSlotCommand<>("Установить рюкзак: " + (bp == null ? "Нет" : bp.getName()),
                p.getBuild()::setBackpack, bp);
    }

    // ====== Ввод ======

    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Некорректный ввод!");
            }
        }
    }

    private static int readBounded(Scanner sc, int min, int max) {
        while (true) {
            System.out.print("Введите " + min + "-" + max + ": ");
            int v = readInt(sc);
            if (v >= min && v <= max) return v;
            System.out.println("Вне диапазона.");
        }
    }
}