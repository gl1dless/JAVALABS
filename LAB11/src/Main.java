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

            int c = Integer.parseInt(sc.nextLine().trim());

            switch (c) {

                case 1: {
                    Weapon w = (Weapon) MenuHelper.chooseItemForSlot(sc, GearSlot.WEAPON, "Оружие:");
                    runCommand(new SetSlotCommand<>("Установлено оружие", p.getBuild()::setWeapon, w), p);
                    break;
                }

                case 2: {
                    Helmet h = (Helmet) MenuHelper.chooseItemForSlot(sc, GearSlot.HELMET, "Шлем:");
                    runCommand(new SetSlotCommand<>("Установлен шлем", p.getBuild()::setHelmet, h), p);
                    break;
                }

                case 3: {
                    runCommand(chooseBodySystem(sc, p), p);
                    break;
                }

                case 4: {
                    Headset hs = (Headset) MenuHelper.chooseItemForSlot(sc, GearSlot.HEADSET, "Наушники:");
                    runCommand(new SetSlotCommand<>("Установлены наушники", p.getBuild()::setHeadset, hs), p);
                    break;
                }

                case 5: {
                    FaceCover fc = (FaceCover) MenuHelper.chooseItemForSlot(sc, GearSlot.FACECOVER, "Одежда на лицо:");
                    runCommand(new SetSlotCommand<>("Установлена маска", p.getBuild()::setFaceCover, fc), p);
                    break;
                }

                case 6: {
                    Backpack bp = (Backpack) MenuHelper.chooseItemForSlot(sc, GearSlot.BACKPACK, "Рюкзак:");
                    runCommand(new SetSlotCommand<>("Установлен рюкзак", p.getBuild()::setBackpack, bp), p);
                    break;
                }

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
            }
        }
    }

    private static void runCommand(Command cmd, Player p) {
        cmd.execute();
        System.out.println("Выполнено: " + cmd.description());
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


}