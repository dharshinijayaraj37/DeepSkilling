import java.util.*;

// Observer Interface
interface Observer {
    void update(String stockName, double price);
}

// Subject Interface
interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public void setStockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.stockPrice = price;
        notifyObservers(); // Notify all observers on change
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }
}

// Concrete Observer 1
class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    public void update(String stockName, double price) {
        System.out.println("[MobileApp - " + name + "] " +
            stockName + " stock updated to $" + price);
    }
}

// Concrete Observer 2
class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    public void update(String stockName, double price) {
        System.out.println("[WebApp - " + name + "] " +
            stockName + " stock updated to $" + price);
    }
}

// Test Class
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create stock market (subject)
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobile1 = new MobileApp("Client A");
        Observer web1 = new WebApp("Client B");

        // Register observers
        stockMarket.registerObserver(mobile1);
        stockMarket.registerObserver(web1);

        // Simulate stock updates
        stockMarket.setStockPrice("TATA", 1250.75);
        System.out.println("------------------------");
        stockMarket.setStockPrice("INFY", 1450.10);

        // Remove one observer and update again
        stockMarket.removeObserver(web1);
        System.out.println("------------------------");
        stockMarket.setStockPrice("RELIANCE", 2300.60);
    }
}
