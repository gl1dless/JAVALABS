
package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockMarket {

    private Map<String, Float> prices = new HashMap<>();
    private List<StockObserver> observers = new ArrayList<>();

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void addStock(String stock) {
        if (!prices.containsKey(stock)) {
            prices.put(stock, 0.0f);
        }
    }

    public void updateStock(String stock, float price) {
        if (!prices.containsKey(stock)) {
            addStock(stock);
        }
        prices.put(stock, price);
        notifyObservers(stock, price);
    }

    private void notifyObservers(String stock, float price) {
        for (StockObserver observer : observers) {
            observer.onPriceChanged(stock, price);
        }
    }
}
