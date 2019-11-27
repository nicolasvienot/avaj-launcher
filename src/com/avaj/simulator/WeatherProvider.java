package com.avaj.simulator;

import java.io.PrintWriter;
import java.io.*;

public class WeatherProvider {
    private static WeatherProvider _weatherProvider;
    private static String _weather[] = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider() {
        _weatherProvider = this;
    }

    public static WeatherProvider getProvider() {
        new WeatherProvider();
        return (_weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return (_weather[(int) (Math.random() * ((3 - 0) + 1)) + 0]);
    }
}