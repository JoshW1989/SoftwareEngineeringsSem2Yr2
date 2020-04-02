package Calculation;



import org.junit.Assert;
import org.junit.Test;

import Quotation.SupervisorState;

public class StandardQuoteCalculationTest {

	// checks crop is correctly assigned
	@Test
	public void StandardCheckAssignment() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "barley", 50.00, 0.05);
		
		String expected = "barley";
		
		Assert.assertEquals(expected, testCalc.getCrop());
	}
	
	// check class assigns correct class that implements Rates
	@Test
	public void StandardCheckRateType() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "barley", 50.00, 0.05);
		
		Assert.assertTrue(testCalc.getRateType() instanceof StandardCropRates);
	}
	
	// tests class total calculation
	@Test
	public void StandardCheckTotalCalc() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "wheat", 591.00, 0.05);
		
		double expected = 230490.00;
		
		Assert.assertEquals(expected, testCalc.getTotalVal(), 0);
	}

	// checks calculation assigns the max if exceeded
	@Test
	public void StandardCheckMax() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "wheat", 8000000.00, 0.05);
		
		double expected = 4000000;
		
		Assert.assertEquals(expected, testCalc.getTotalVal(), 0);
	}
	
	// checks rogue zone is assigned to the default
	@Test
	public void StandardCheckIncorrectZone() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(8998, "wheat", 8000000.00, 0.05);
		
		double expected = 4000000;
		
		Assert.assertEquals(expected, testCalc.getTotalVal(), 0);
	}
	
	// checks the monthly cost figure generates correctly
	@Test
	public void StandardCheckMonthlyCalc() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "barley", 50.00, 0.05);
		
		double expected = 2125;
		
		Assert.assertEquals(expected, testCalc.getMonthlyCost(), 0);
	}
	
	// checks that the commission calculates correctly
	@Test
	public void StandardCheckCommissionCalc() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "wheat", 8000000.00, 0.05);
		
		double expected = 200000;
		
		Assert.assertEquals(expected, testCalc.getCommission(), 0);
	}
	

}
