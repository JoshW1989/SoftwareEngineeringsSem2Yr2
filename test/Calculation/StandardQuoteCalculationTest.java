package Calculation;



import org.junit.Assert;
import org.junit.Test;

import Quotation.SupervisorState;

public class StandardQuoteCalculationTest {

	@Test
	public void StandardCheckAssignment() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "barley", 50.00, 0.05);
		
		String expected = "barley";
		
		Assert.assertEquals(expected, testCalc.getCrop());
	}
	
	@Test
	public void StandardCheckRateType() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "barley", 50.00, 0.05);
		
		Assert.assertTrue(testCalc.getRateType() instanceof StandardCropRates);
	}
	
	@Test
	public void StandardCheckTotalCalc() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "wheat", 591.00, 0.05);
		
		double expected = 230490.00;
		
		Assert.assertEquals(expected, testCalc.getTotalVal(), 0);
	}

	@Test
	public void StandardCheckMax() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "wheat", 8000000.00, 0.05);
		
		double expected = 4000000;
		
		Assert.assertEquals(expected, testCalc.getTotalVal(), 0);
	}
	
	@Test
	public void StandardCheckIncorrectZone() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(8998, "wheat", 8000000.00, 0.05);
		
		double expected = 4000000;
		
		Assert.assertEquals(expected, testCalc.getTotalVal(), 0);
	}
	
	@Test
	public void StandardCheckMonthlyCalc() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "barley", 50.00, 0.05);
		
		double expected = 2125;
		
		Assert.assertEquals(expected, testCalc.getMonthlyCost(), 0);
	}
	
	@Test
	public void StandardCheckCommissionCalc() {
		QuoteCalculation testCalc = new StandardQuoteCalculation(1, "wheat", 8000000.00, 0.05);
		
		double expected = 200000;
		
		Assert.assertEquals(expected, testCalc.getCommission(), 0);
	}
	

}
