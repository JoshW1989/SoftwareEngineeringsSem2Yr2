package Calculation;

// interface for all business rates
public interface Rates {
	
	double cropModifier(String crop);
	double zoneMax(int zone);
	
}