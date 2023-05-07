package org.example;

public class TemperatureConversion {

    public static double fahrenheitToCelsius(double fahrenheit) {

        double fahrToCels = (fahrenheit - 32) * 5/9;
        return fahrToCels;
    }

    public static double celsiusToFahrenheit(double celsius) {

        double celsToFahr = celsius * 9/5 + 32;
        return celsToFahr;
    }
}
