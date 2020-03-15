package Zones;

import java.util.Dictionary;

public abstract class Zone {

    private int maxHectare;
    private Dictionary<String, Double> maxValue;

    public int getMaxHectare() { return maxHectare;}
    public void setMaxHectare(int newVal) {maxHectare = newVal;}

    public Double readMaxValue(String crop) { return maxValue.get(crop); }
    public void addMaxValue(String crop, Double value) { maxValue.put(crop, value); }

}
