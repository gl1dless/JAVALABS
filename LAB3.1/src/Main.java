import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("...........................................");
        System.out.println("          СИСТЕМА ТЕЛЕПРОГРАММЫ            ");
        System.out.println("...........................................");

//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        Show show1 = new Show("Иваныч", "НОВОСТИ НОВОЙ ЛИГИ В ПОЕ",
                "СЕГОДНЯ ЛИГА В ПОЕ", 1);

        Show show2 = new Show("Петрович", "РАЗВЛЕКУХА",
                "Поле Чудес", 1);

        Show show3 = new Show("Анна", "ГОТОВИМ",
                "Повар спрашивает повара", 2);

        Show show4 = new Show("Саныч", "ДОКУМЕНТАЛКА",
                "ВВС про океан", 3);

        Show show5 = new Show("Малышева", "ПЕРЕДАЧА ДЛЯ БАБУЛЕК",
                "Здорово жить", 2);

//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        System.out.println("\n...........................................");
        System.out.println("ПЕРЕДАЧА 2:");


//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        System.out.println("\n" + show2);

        Show[] initialShows = {show1, show2, show3};

        GroupShow tvProgram = new GroupShow(101, initialShows);

        System.out.println("\n...........................................");
        System.out.println("ВЫВОД ГУППЫ:");

        tvProgram.displayAllShows();


        //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        System.out.println("\n...........................................");
        System.out.println("ДОБАВЛЕНИЕ");

        tvProgram.addShowByName(show4);
        tvProgram.addShowByName(show5);


        System.out.println("Теперь в группе: " + tvProgram.getShowsCount() + " передач");
        tvProgram.displayAllShows();

//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        System.out.println("\n...........................................");
        System.out.println("СОРТИРОВКА ПО НАЗВАНИЮ:");


        tvProgram.sortByName();
        tvProgram.displayAllShows();

        //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        System.out.println("\n...........................................");
        System.out.println("УДАЛЕНИЕ ПЕРЕДАЧИ:");


        System.out.print("введите название передачи для удаления: ");
        String showToRemove = scanner.nextLine();

        boolean removed = tvProgram.removeShowByName(showToRemove);
        if (removed) {
            System.out.println("Передача '" + showToRemove + "'  удалена!гг");
        } else {
            System.out.println("вероятно вы ошиблись, передачи с номером '" + showToRemove + "' нет)).");
        }

        System.out.println("Осталось передач: " + tvProgram.getShowsCount());

        //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        System.out.println("\n...........................................");
        System.out.println("меняю одну передачу:");


        if (tvProgram.getShowsCount() > 0) {
            Show firstShow = tvProgram.getShow(0);
            if (firstShow != null) {
                System.out.println("Первая передача в списке:");
                System.out.println(firstShow);

                // Изменяем данные передачи
                firstShow.setDescription("ОБНОВЛЕНО");
                firstShow.setPeriodType(2);

                System.out.println("переназначенная передача:");
                System.out.println(firstShow);
            }
        }
//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        System.out.println("\n...........................................");
        System.out.println("СОЗДАЕМ ВТОРУЮ ГРУППУ ПЕРЕДАЧ:");


        Show show6 = new Show("Михаилыч", "СПОРТ",
                "СПИДРАН АКТОВ", 2);
        Show show7 = new Show("Ольга", "КИНО",
                "ЗАКРЫВАЮ УБЕРОВ ЧЕРЕЗ 7 ЧАСОВ СО СТАРТА", 3);

        Show[] secondGroupShows = {show6, show7};
        GroupShow secondGroup = new GroupShow(202, secondGroupShows);
        secondGroup.displayAllShows();

        //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        System.out.println("\n...........................................");
        System.out.println("ПОИСК ПЕРЕДАЧИ В ПЕРВОЙ ГРУППЕ:");


        System.out.print("Введите название передачи для поиска: ");
        String showToFind = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < tvProgram.getShowsCount(); i++) {
            Show show = tvProgram.getShow(i);
            if (show != null && show.getName().equalsIgnoreCase(showToFind)) {
                System.out.println("Найдена передача:");
                System.out.println(show);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("нет такой передачи((");
        }
//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        System.out.println("\n...........................................");
        System.out.println("СТАТА :");

        System.out.println("Группа #" + tvProgram.getUniqueId() + ": " + tvProgram.getShowsCount() + " передач");
        System.out.println("Группа #" + secondGroup.getUniqueId() + ": " + secondGroup.getShowsCount() + " передач");

        int totalShows = tvProgram.getShowsCount() + secondGroup.getShowsCount();
        System.out.println("Всего передач в системе: " + totalShows);


        scanner.close();
    }
}