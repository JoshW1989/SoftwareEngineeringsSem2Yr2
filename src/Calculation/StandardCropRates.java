package Calculation;

public class StandardCropRates implements Rates {

	@Override
	public double cropModifier(String crop) {
	
		double mod = 0;
		
		if (crop == "barley" ) {
			mod = 1.0;
		} else if (crop == "wheat") {
			mod = 1.3;
		} else if (crop == "blackcurrant") {
			mod = 1.4;
		} else if (crop == "raspberries") {
			mod = 1.5;
		}
		
		return mod;
	}
	
	
	@Override
	public double zoneMax(int zone) {
		
		double max;
		
		if (zone == 1 ) {
			max = 4000000;
		} else if (zone == 2) {
			max = 7000000;
		} else if (zone == 3) {
			max = 7000000;
		} else {
			max = 4000000; // Default value
		}
		
		return max;
	}
}
