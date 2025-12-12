
package observer;

public class ConsoleStockObserver implements StockObserver {

    private final String name;

    public ConsoleStockObserver(String name) {
        this.name = name;
    }

    @Override
    public void onPriceChanged(String stock, float price) {
        System.out.println(name + " notified: " + stock + " new price = " + price);
    }
}
