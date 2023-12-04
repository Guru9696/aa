import java.util.Observable;

class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

class WeatherObserver implements java.util.Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            float temperature = weatherData.getTemperature();
            float humidity = weatherData.getHumidity();
            float pressure = weatherData.getPressure();
            
            System.out.println("Temperature: " + temperature + "°C");
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("Pressure: " + pressure + "hPa");
        }
    }
}

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        WeatherObserver weatherObserver = new WeatherObserver();

        weatherData.addObserver(weatherObserver);

        // Simulate weather changes
        weatherData.setMeasurements(25.5f, 60.0f, 1013.2f);
        weatherData.setMeasurements(26.0f, 55.5f, 1012.5f);
    }
}

