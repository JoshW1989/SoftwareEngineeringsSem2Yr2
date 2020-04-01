package Calculation;

public class StandardCropRates implements Rates {

	@Override
	public double cropModifier(String crop) {
	
		double mod = 0;
		
		switch(crop) {
			case "barley":
				mod = 1.0;
			case "wheat":
				mod = 1.3;
			case "blackcurrant":
				mod = 1.4;
			case "raspberries":
				mod = 1.5;
			}
		
		return mod;
	}
	
	
	@Override
	public double zoneMax(int zone) {
		
		double max = 0;
		
		switch(zone) {
			case 1:
				max = 4000000;
			case 2:
				max = 7000000;
			case 3:
				max = 7000000;
			case 0:
				max = 4000000;
			}
		
		return max;
	}
}
