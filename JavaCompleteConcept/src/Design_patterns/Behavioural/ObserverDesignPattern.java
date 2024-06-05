package Design_patterns.Behavioural;


/**
 * The Observer design pattern establishes a one-to-many dependency between objects, where one object (the subject) maintains
 * a list of its dependents (observers) and notifies them of state changes, typically by calling one of their methods. It's
 * used to achieve loose coupling between objects, allowing for changes in one object to trigger actions in other objects
 * without them being tightly coupled. This pattern is valuable in scenarios where multiple objects need to react to changes
 * in a single object, such as in event handling systems or UI frameworks
 */


import java.util.ArrayList;
import java.util.List;


// Observer interface
interface WeatherObserver {
    void update(int temperature);
}

// Subject interface
interface WeatherStation {
    void addObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();
}

// Concrete subject class
class WeatherData implements WeatherStation {
    private int temperature;
    private List<WeatherObserver> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

// Concrete observer class
class Display implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Display: Temperature is now " + temperature);
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Display display = new Display();

        weatherData.addObserver(display);
        weatherData.setTemperature(25); // Output: Display: Temperature is now 25

        weatherData.removeObserver(display);
        weatherData.setTemperature(30); // No output, as the observer is removed
    }
}
