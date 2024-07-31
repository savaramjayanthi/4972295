
import java.util.ArrayList;
import java.util.List;
public class ObserverPatternExample {

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice("AAPL", 150.00);
        stockMarket.setStockPrice("GOOGL", 2800.00);
        
        stockMarket.removeObserver(webApp);

        stockMarket.setStockPrice("AAPL", 155.00);
    }
}

interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers;
    private double aaplPrice;
    private double googlPrice;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(aaplPrice, googlPrice);
        }
    }

    public void setStockPrice(String stock, double price) {
        if (stock.equals("AAPL")) {
            this.aaplPrice = price;
        } else if (stock.equals("GOOGL")) {
            this.googlPrice = price;
        }
        notifyObservers();
    }
}

interface Observer {
    void update(double aaplPrice, double googlPrice);
}

class MobileApp implements Observer {
    public void update(double aaplPrice, double googlPrice) {
        System.out.println("MobileApp - AAPL: $" + aaplPrice + ", GOOGL: $" + googlPrice);
    }
}

class WebApp implements Observer {
    public void update(double aaplPrice, double googlPrice) {
        System.out.println("WebApp - AAPL: $" + aaplPrice + ", GOOGL: $" + googlPrice);
    }
}
