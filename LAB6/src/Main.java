
import singleton.SaveManager;
import factory.*;
import observer.*;
import command.*;
import flyweight.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //singleton test
        System.out.println("SINGLETON TEST--------------------------------------");
        SaveManager sm = SaveManager.getInstance();
        sm.set("health", 80);
        sm.set("position", "10,20");
        sm.set("coins", 42);

        sm.saveGame("savegame.txt");

        SaveManager sm2 = SaveManager.getInstance();
        sm2.loadGame("savegame.txt");

        System.out.println("health = " + sm2.get("health"));
        System.out.println("position = " + sm2.get("position"));
        System.out.println("coins = " + sm2.get("coins"));

        //factory test
        System.out.println("FACTORY TEST-------------------------------------------");
        EnemyFactory factory = new EnemyFactory();

        Enemy zombie = factory.createEnemy("zombie");
        Enemy skeleton = factory.createEnemy("skeleton");

        zombie.attack();
        skeleton.attack();

        //observer test
        System.out.println("OBSERVER TEST------------------------------------");
        StockMarket market = new StockMarket();

        StockObserver trader1 = new ConsoleStockObserver("Trader1");
        StockObserver trader2 = new ConsoleStockObserver("Trader2");

        market.addObserver(trader1);
        market.addObserver(trader2);

        market.addStock("TESLA");
        market.updateStock("TESLA", 150.25f);
        market.updateStock("TESLA", 151.75f);

        market.updateStock("GGG", 2800.5f);

        //command test
        System.out.println("COMMAND TEST-----------------------------------------");
        RitualContext context = new RitualContext();

        Command start = new StartRitualCommand(context);
        Command summon = new SummonMonsterCommand(context);
        Command finish = new FinishRitualCommand(context);

        RitualExecutor executor = new RitualExecutor();
        executor.addCommand(start);
        executor.addCommand(summon);
        executor.addCommand(finish);

        executor.executeAll();

        //flyweight test
        System.out.println("FLYWEIGHT TEST--------------------");
        List<EnemyInstance> enemies = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            EnemyType zombieType = EnemyFactoryFlyweight.getEnemyType("zombie");
            enemies.add(new EnemyInstance(zombieType, i * 10, i * 5));
        }

        for (int i = 0; i < 5; i++) {
            EnemyType skeletonType = EnemyFactoryFlyweight.getEnemyType("skeleton");
            enemies.add(new EnemyInstance(skeletonType, i * 7, i * 3));
        }

        for (EnemyInstance e : enemies) {
            e.render();
        }
    }
}
