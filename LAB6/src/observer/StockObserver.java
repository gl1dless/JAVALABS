
package observer;

public interface StockObserver {
    void onPriceChanged(String stock, float price);
}
