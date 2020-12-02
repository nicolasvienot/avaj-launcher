package com.avaj.simulator.coordinates;

public class Coordinates {
    private int _longitude;
    private int _latitude;
    private int _height;

    public Coordinates(int longitude, int latitude, int height) {
        _longitude = longitude;
        _latitude = latitude;
        if (height < 0)
            _height = 0;
        else if (height > 100)
            _height = 100;
        else
            _height = height;
    }

    public int getLongitude() {
        return (_longitude);
    }

    public int getLatitude() {
        return (_latitude);
    }

    public int getHeight() {
        return (_height);
    }
}